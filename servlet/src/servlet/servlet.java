package servlet;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

public class servlet {

	boolean canWaiter = true;
	private JFrame frame;
	ServerSocket severSock;
	Socket sock;
	DataOutputStream out;
	DataInputStream in;
	FileOutputStream fos;
	boolean canAccepter = true;
	Accepter accepter;
	Swaiter waiter;
	JTextArea textArea = new JTextArea();
	String key;
	Map<String, Socket> map = new HashMap<String, Socket>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					servlet window = new servlet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public servlet() {
		initialize();
	}

	private class Swaiter extends Thread {
		Socket s;
		OutputStream os1;
		//InputStream is1;
		DataOutputStream out1;
		//DataInputStream in1;

		public void run() {
			while (true) {
				try {
					String msg = in.readUTF();
					if (msg.startsWith("connect:")) {
						key = msg.substring(8);
						System.out.println(key);
						s = map.get(key);
						os1 = s.getOutputStream();
						//is1 = s.getInputStream();
						out1 = new DataOutputStream(os1);
						//in1 = new DataInputStream(is1);
						textArea.append(key + "已连接上\n");
					} else if (msg.equals("pictrue")) {
						int msgSize = in.readInt();

						byte[] buffer = new byte[msgSize];
						int length = 0;
						while (length < msgSize) {
							int readSize = in.read(buffer, length, msgSize - length);
							System.out.println("readSize = in.read(buffer, length, msgSize - length);");
							if (readSize > 0) {
								length = length + readSize;
							} else {
								break;
							}
						}
						System.out.println("out1.writeUTF(\"pictrue\");");
						out1.writeUTF("pictrue");
						out1.writeInt(msgSize);
						out1.write(buffer);
						out1.flush();
					} else if (msg.equals("file")) {

						String fileName = in.readUTF();
						//long fileLength = in.readLong();
						String s2 = in.readUTF();
						out1.writeUTF("file");
						out1.writeUTF(fileName);
						//out1.writeLong(fileLength);
						out1.flush();
						out1.writeUTF(s2);
						out1.flush();
						textArea.append(fileName + "\n");
					}

					else {
						textArea.append(msg + "\n");
						out1.writeUTF(msg + "\n");
					}
				} catch (Exception e) {
					
				}
			}
		}
	}

	private void Sock(Socket s) {
		OutputStream os;
		try {
			os = s.getOutputStream();
			InputStream is = s.getInputStream();
			out = new DataOutputStream(os);
			in = new DataInputStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void acceptConnect() {
		try {
			Sock(sock);
			String msg = in.readUTF();
			InetAddress addr = sock.getInetAddress();
			textArea.append(msg + "已登录\n"+addr+"\n");
			map.put(msg, sock);
			out.writeUTF(msg + "已登录\n");
			Swaiter waiter = new Swaiter();
			waiter.start();
		} catch (Exception e) {
			System.out.println("acceptConnect");
		}
	}

	private class Accepter extends Thread {
		public void run() {
			while (canAccepter) {
				try {
					sock = severSock.accept();
					acceptConnect();
				} catch (Exception e) {
					System.out.println("Accepter");
					break;
				}
			}
			try {
				severSock.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void startServer() {
		try {
			severSock = new ServerSocket(6000);
			accepter = new Accepter();
			accepter.start();
			InetAddress addr=InetAddress.getLocalHost();
			textArea.append(addr+"已启动\n");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("startServer()");
		}
	}

	private void disconnect() {
		try {
			canAccepter = false;
			out.writeUTF("serverStop");
			textArea.setText("close");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("disconnect()");
		} finally {
			try {
				severSock.close();
				in.close();
				out.close();
				sock.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u670D\u52A1\u5668");
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JButton button = new JButton("\u542F\u52A8\u670D\u52A1\u5668");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				canAccepter = true;
				startServer();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, button, 29, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u5173\u95ED\u670D\u52A1\u5668");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disconnect();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.WEST, button_1, 24, SpringLayout.EAST, button);
		frame.getContentPane().add(button_1);

		springLayout.putConstraint(SpringLayout.NORTH, textArea, 18, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 29, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 205, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 239, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textArea);
	}

}
