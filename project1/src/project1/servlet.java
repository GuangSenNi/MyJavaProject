package project1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class servlet {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					servlet window = new servlet();
					window.frame.setVisible(true);
					window.servlet2();
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
	public void servlet2() 
	{
		try {
			System.out.println("0");
	        ServerSocket serversocket=new ServerSocket(3004);
	        System.out.println("1111");
	        Socket socket=null;  
	        int n=0;  
	        while(true){  
	                socket=serversocket.accept();//再来一个客户端就新建一个socket 
	                System.out.println("1");
	                ServerThread serverthread=new ServerThread(socket);  
	                serverthread.start();
	                System.out.println("2");
	                textField.setText("我是服务端,客户端说:"+serverthread.info);
	                n++;  
	                System.out.println("已有"+n+"台客户端连接");  
	                InetAddress address=socket.getInetAddress();//获取客户端的inetaddress对象  
	                System.out.println("当前主机ip:"+address.getHostAddress());//获取客户端的ip  
	            }  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 47, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 56, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 41, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, textField, 56, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, 149, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

}
