package control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class Ui extends JPanel{

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Ui u=new Ui();
		u.initUI();
	}
	JFrame f = new JFrame("����1");
	private JPanel jpanel=new JPanel();
	EventDeal event;
	private void initUI() {
		f.setSize(820, 350);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(3);
		f.setResizable(false);
		//f.setLayout(new FlowLayout());
		//f.getContentPane().setBackground(new Color(90,50,40));//jframe ������ɫ����
		//this.setPreferredSize(new Dimension(320, 260));
		jpanel.setPreferredSize(new Dimension(200,0));
		jpanel.setLayout(null);
		String btnArr[]= {"�������������ͼ","��������������ͼ","����������Ԥ��ͼ","������Ϣ��ѯ","AI CLASS"};
		JLabel title=new JLabel(btnArr[4]);
		title.setForeground(Color.red);
		title.setFont(new Font("Dialog", 1, 32));
		title.setBounds(25, 10, 150, 50);
		jpanel.add(title);
		event=new EventDeal(f);
		for(int i=0;i<4;i++) {
			JButton jbt=new JButton(btnArr[i]);
			jbt.setBounds(25, 70+40*i, 150, 30);
			jbt.addActionListener(event);
			jpanel.add(jbt);
		}
		JTextField jtf=new JTextField();
		jtf.setBounds(25, 70+40*4, 80, 30);
		jpanel.add(jtf);
		JButton jbt=new JButton("����");
		jbt.setBounds(115, 70+40*4, 60, 30);
		jbt.addActionListener(event);
		jpanel.add(jbt);
		f.add(jpanel,BorderLayout.WEST);
		
		//this.addMouseListener(eventListen);
		//this.addMouseMotionListener(eventListen);
		f.setVisible(true);		
	}
}
