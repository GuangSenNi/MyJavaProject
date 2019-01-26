package project1;

import java.awt.EventQueue;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class custom {

	private JFrame frame;
	private JTextField textField;

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
		
		try {  
            Socket socket=new Socket("127.0.0.1",3004);//�����ͻ���socket,��Ϊ�Ǳ���,ip��ַ����127.0.0.1  
            OutputStream os=socket.getOutputStream();  
            PrintWriter pw=new PrintWriter(os);  
            pw.write(textField.getText());  
            pw.flush();  
            socket.shutdownOutput();//���������仰����ʾ������Ľ�����ע���ʱ���ܹر�os,��Ϊ�ر�os��رհ󶨵�socket  
            //�ڿͻ��˻�ȡ��Ӧ��Ϣ  
            InputStream is=socket.getInputStream();  
            BufferedReader br=new BufferedReader(new InputStreamReader(is));  
            String info=null;  
            while((info=br.readLine())!=null){  
            	textField.setText("���ǿͻ���,�����˵:"+info); 
            }  
            br.close();  
            is.close();  
            pw.close();  
            os.close();  
            socket.close();  
        } catch (UnknownHostException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
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
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 42, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 40, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 37, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, btnNewButton);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

}
