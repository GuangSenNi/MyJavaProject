package daytime;

import java.io.IOException;
import java.io.InputStream;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;



public class Send {
	public static void main(String[] args) {
		Send send=new Send();
		send.Init();
	}
	Socket sock;
	OutputStream os;
	InputStream is;
	DatagramPacket data;
	Cwaiter waiter;
	private void Init() {
		data=new DatagramPacket();
		data.setMsg("custom");
		connect(data.getIp(),data.getPort());
		
	}
	private class Cwaiter extends Thread {
		ObjectOutputStream ous;
		public void run() {
			//while(true) {
			System.out.println("��ʼ������Ϣ");
				try {
					ous=new ObjectOutputStream(os);
					ous.writeObject(data);
					Thread.sleep(500);
				} catch (IOException | InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
					disconnect();
				}
			//}
		}
	}
	private void connect(String m, int n) {
		try {
			sock=new Socket(m, n);
			os = sock.getOutputStream();
			is = sock.getInputStream();
			waiter = new Cwaiter();
			waiter.start();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			disconnect();
		}
	}
	void disconnect() {
		try {
			
		} catch (Exception e) {
			System.out.println("disconnect");
		} finally {
			
			try {
				is.close();
				os.close();
				sock.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
