package daytime;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Receive {
	public static void main(String[] args){
		Receive recive =new Receive();
		recive.OpenPort();
	}
	ServerSocket severSock;
	Socket sock;
	Accepter accepter;
	boolean canAccepter = true;
	public void OpenPort() {
		try {
			severSock=new ServerSocket(6001);
			accepter = new Accepter();
			accepter.start();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			disconnect();
		}
	}
	private class Swaiter extends Thread {
		InputStream in;
		ObjectInputStream ois;
		
		public void run() {
			//while (true) {
				
				//if() {
					try {
						in=sock.getInputStream();
						ois=new ObjectInputStream(in);
						System.out.println("客户端发送的对象：" + ois.readObject().toString());
					} catch (IOException | ClassNotFoundException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
						disconnect();
					}
				//}
			//}
		}
		
	}

    void disconnect() {
		try {
			canAccepter = false;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("disconnect()");
		} finally {
			try {
				severSock.close();
				sock.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	private class Accepter extends Thread {
		public void run() {
			while (canAccepter) {
				try {
					System.out.println("等待接入。。。");
					sock = severSock.accept();
					//OutputStream out=sock.getOutputStream();
					Swaiter waiter = new Swaiter();
					waiter.start();
				} catch (Exception e) {
					System.out.println("Accepter");
					break;
				}
			}
			try {
				severSock.close();
			} catch (Exception e) {
				// TODO: handle exception
				disconnect();
			}
		}
	}
}
