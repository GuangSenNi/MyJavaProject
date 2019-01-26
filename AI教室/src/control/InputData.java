package control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

public class InputData extends Thread implements SerialPortEventListener{
	static CommPortIdentifier portId; // 串口通信管理类
	static Enumeration<?> portList; // 有效连接上的端口的枚举
	InputStream inputStream; // 从串口来的输入流
	static OutputStream outputStream;// 向串口输出的流
	static SerialPort serialPort; // 串口的引用
	// 堵塞队列用来存放读到的数据
	private BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>();
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		InputData inputdata=new InputData();
		inputdata.startComPort();
		inputdata.start();
	}
	@Override
	public void serialEvent(SerialPortEvent event) {
		// TODO 自动生成的方法存根
		switch (event.getEventType()) {
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:// 当有可用数据时读取数据
			byte[] readBuffer = new byte[20];
			try {
				int numBytes = -1;
				while (inputStream.available() > 0) {
					numBytes = inputStream.read(readBuffer);

					if (numBytes > 0) {
						msgQueue.add(new Date() + "真实收到的数据为：-----"
								+ new String(readBuffer));
						readBuffer = new byte[20];// 重新构造缓冲对象，否则有可能会影响接下来接收的数据
					} else {
						msgQueue.add("额------没有读到数据");
					}
				}
			} catch (IOException e) {
			}
			break;
		}

	}
	/**
	 * 
	 * 通过程序打开COM4串口，设置监听器以及相关的参数
	 * 
	 * @return 返回1 表示端口打开成功，返回 0表示端口打开失败
	 */
	public int startComPort() {
		// 通过串口通信管理类获得当前连接上的串口列表
		portList = CommPortIdentifier.getPortIdentifiers();

		while (portList.hasMoreElements()) {

			// 获取相应串口对象
			portId = (CommPortIdentifier) portList.nextElement();

			System.out.println("设备类型：--->" + portId.getPortType());
			System.out.println("设备名称：---->" + portId.getName());
			// 判断端口类型是否为串口
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				// 判断如果COM4串口存在，就打开该串口
				if (portId.getName().equals("COM4")) { 
					try {
						// 打开串口名字为COM_4(名字任意),延迟为2毫秒
						serialPort = (SerialPort) portId.open("COM_4", 2000);

					} catch (PortInUseException e) {
						e.printStackTrace();
						return 0;
					}
					// 设置当前串口的输入输出流
					try {
						inputStream = serialPort.getInputStream();
						outputStream = serialPort.getOutputStream();
					} catch (IOException e) {
						e.printStackTrace();
						return 0;
					}
					// 给当前串口添加一个监听器
					try {
						serialPort.addEventListener(this);
					} catch (TooManyListenersException e) {
						e.printStackTrace();
						return 0;
					}
					// 设置监听器生效，即：当有数据时通知
					serialPort.notifyOnDataAvailable(true);

					// 设置串口的一些读写参数
					try {
						// 比特率、数据位、停止位、奇偶校验位
						serialPort.setSerialPortParams(9600,
								SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
								SerialPort.PARITY_NONE);
					} catch (UnsupportedCommOperationException e) {
						e.printStackTrace();
						return 0;
					}

					return 1;
				}
			}
		}
		return 0;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("--------------任务处理线程运行了--------------");
			while (true) {
				// 如果堵塞队列中存在数据就将其输出
				if (msgQueue.size() > 0) {
					System.out.println(msgQueue.take());
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
