package custom;

import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;



import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;


import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class custom {

	boolean com = true;
	private JFrame frame;
	private JTextField textField;
	Socket sock;
	DataOutputStream out;
	DataInputStream in;
	FileInputStream fis;
	DataOutputStream dos;
	boolean canWrite = true;
	String ip = "127.0.0.1";
	String id = "客户端";
	int port = 6000;
	Cwaiter waiter;
	OutputStream os;
	InputStream is;
	JTextArea textArea = new JTextArea();
	SpringLayout springLayout = new SpringLayout();
	Robot robot;
	// 要捕捉的屏幕显示范围，下面以全屏示例说明
	Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	BufferedImage bi;
	JLabel lblNewLabel = new JLabel("屏幕监控");
	ImageIcon im;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custom window = new custom();
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
	public custom() {
		initialize();
	}

	private class Cwaiter extends Thread {
		public void run() {
			while (canWrite) {
				try {
					String msg = in.readUTF();
					if (msg.equals("pictrue") && com) {
						int msgSize = in.readInt();
						byte[] buffer = new byte[msgSize];
						System.out.println(msgSize);

						int length = 0;
						while (length < msgSize) {
							int readSize = in.read(buffer, length, msgSize - length);
							System.out.println(readSize);
							if (readSize > 0) {
								length = length + readSize;
							} else {
								break;
							}
						}
						// 这是非常关键的，图片太大时一次性是读不完的，一定要使用缓冲重复读取。
						// 把字节数组还原成图片
						ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
						// ZipInputStream zis = new ZipInputStream(bis);
						// 读取压缩的数据内容。--压缩报空指针异常，没有解决，于是不采用压缩
						// zis.getNextEntry();
						bi = ImageIO.read(bis);
						im = new ImageIcon(bi);
						im.setImage(im.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT));
						lblNewLabel.setIcon(im);
					} else if (msg.equals("file")) {
						String fileName = in.readUTF();
						//long fileLength = in.readLong();
						String s2 = in.readUTF();
						FileOutputStream fos = new FileOutputStream(new File("e:/" + fileName));
						byte[] buff = s2.getBytes();
						fos.write(buff);
						fos.close();
						textArea.append(fileName + "--get\n");
					} else if (msg.startsWith("cmd;")) {
						textArea.append("cmd;");
						String cmd = msg.substring(4);
						System.out.println(cmd);
						Runtime.getRuntime().exec(cmd);
						Thread.sleep(200);
					} else {
						textArea.append(msg);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			disconnect();
		}
	}

	// 127.0.0.1 connect:1 E:\Temp\test.txt cmd;cmd /c calc
	//InetAddress addr=InetAddress.getByName("localhost");
	private void connect(String m, int n) {
		try {
			canWrite = true;
			sock = new Socket(m, n);
			os = sock.getOutputStream();
			is = sock.getInputStream();
			out = new DataOutputStream(os);
			in = new DataInputStream(is);
			out.writeUTF(id);
			textArea.append(in.readUTF());
			waiter = new Cwaiter();
			waiter.start();
		} catch (Exception e) {
			System.out.println("connect");
		}
	}

	private void disconnect() {
		try {
			out.writeUTF("disconnect");

		} catch (Exception e) {
			System.out.println("disconnect");
		} finally {
			canWrite = false;
			try {
				fis.close();
				dos.close();
				in.close();
				out.close();
				sock.close();
				textArea.setText("close\n");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private class getScreen extends Thread {
		public getScreen() {
			try {
				robot = new Robot();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("getScreen()");
			}
		}

		public void run() {
			//ZipOutputStream zos = null;
			while (com) {
				BufferedImage bm = robot.createScreenCapture(rect);
				ImageIcon image = new ImageIcon(bm);
				image.setImage(image.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT));
				lblNewLabel.setIcon(image);
				try {
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					ImageIO.write(bm, "jpg", bos);
					byte[] data = bos.toByteArray();
					/*
					 * bos.flush(); zos = new ZipOutputStream(bos);
					 * zos.setLevel(Deflater.BEST_COMPRESSION); zos.putNextEntry(new
					 * ZipEntry("ScreenCapture.jpg")); zos.write(data); zos.closeEntry();
					 */
					out.writeUTF("pictrue");
					out.writeInt(data.length);
					out.write(data);
					System.out.println("data.length" + data.length);
					out.flush();
					Thread.sleep(200);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} // 加入压缩
			}
		}
	}

	private void deliver() {
		File file = new File(textField.getText());
		String s1;
		String s2 = new String();
		try {
			fis = new FileInputStream(file);
			dos = new DataOutputStream(sock.getOutputStream());
			// 文件名和长度
			dos.writeUTF("file");
			dos.writeUTF(file.getName());
			dos.flush();
			//dos.writeLong(file.length());
			dos.flush();
			// 传输文件
			byte[] sendBytes = new byte[1024];
			while ((fis.read(sendBytes, 0, sendBytes.length)) > 0) {
				s1 = new String(sendBytes);
				s2 = s2 + s1;
			}
			dos.writeUTF(s2);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("deliver()");
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5BA2\u6237\u7AEF");
		frame.setBounds(100, 100, 750, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		springLayout.putConstraint(SpringLayout.WEST, textArea, 22, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);

		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 60, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 500, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 22, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 31, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, 206, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton button = new JButton("\u8FDE\u670D\u52A1\u5668");
		button.setBackground(UIManager.getColor("Button.background"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText() != null)
					ip = textField.getText();
				canWrite = true;
				connect(ip, port);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button, 21, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, textField);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u65AD\u5F00\u8FDE\u63A5");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disconnect();

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.WEST, button_1, 15, SpringLayout.EAST, button);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("\u76D1\u63A7\u7ED3\u675F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				com = false;
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 27, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.WEST, button_2, 0, SpringLayout.WEST, textField);
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("\u76D1\u63A7\u5F00\u59CB");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				com = true;
				getScreen screen = new getScreen();
				screen.start();
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, button_3, 0, SpringLayout.WEST, button_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_3, 0, SpringLayout.SOUTH, button_2);
		frame.getContentPane().add(button_3);

		JButton button_4 = new JButton("\u8FDC\u7A0B\u5173\u673A");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					out.writeUTF("cmd;cmd /c shutdown -s -t 3");// cmd;cmd /c shutdown -s -t 3
					textField.setText("");
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 71, SpringLayout.SOUTH, button_4);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 195, SpringLayout.SOUTH, button_4);
		springLayout.putConstraint(SpringLayout.NORTH, button_4, 20, SpringLayout.SOUTH, button_2);
		springLayout.putConstraint(SpringLayout.WEST, button_4, 0, SpringLayout.WEST, textField);
		frame.getContentPane().add(button_4);

		JButton button_5 = new JButton("\u53D1\u9001\u6D88\u606F");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					out.writeUTF(textField.getText());
					textArea.append(textField.getText()+"\n");
					textField.setText("");
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button_5, 0, SpringLayout.NORTH, button_4);
		springLayout.putConstraint(SpringLayout.WEST, button_5, 0, SpringLayout.WEST, button_1);
		frame.getContentPane().add(button_5);
		frame.getContentPane().add(textArea);

		JButton button_6 = new JButton("\u5BA2\u6237\u547D\u540D");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = textField.getText();
				textField.setText("");
				frame.setTitle(id);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, button_6, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, button_6, -23, SpringLayout.NORTH, textArea);
		frame.getContentPane().add(button_6);

		JButton button_7 = new JButton("\u4F20\u8F93\u6587\u4EF6");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deliver();
				textField.setText("");
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, button_7, 0, SpringLayout.WEST, button_1);
		springLayout.putConstraint(SpringLayout.SOUTH, button_7, 0, SpringLayout.SOUTH, button_6);
		frame.getContentPane().add(button_7);

		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 32, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 1, SpringLayout.SOUTH, textArea);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);

	}
}
