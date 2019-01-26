package number;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UImain extends JPanel{

	private JFrame jframe;
	private JPanel jpanel;
	private EventListen eventlisten;
	public JLabel jlabel;
	public JComboBox<Integer> comboBox;
	public void initUI() {
		jframe=new JFrame("ÊÖÐ´Ê¶±ð");
		jframe.setSize(400, 300);
		jframe.setDefaultCloseOperation(3);
		jframe.setLocationRelativeTo(null);
		
		comboBox=new JComboBox<Integer>();
		comboBox.getPreferredSize();
		for(int i=0;i<10;i++) {
			comboBox.addItem(i);  
		}
		
		jlabel=new JLabel("result",JLabel.CENTER);
		jlabel.setOpaque(true);
		jlabel.setPreferredSize(new Dimension(80, 20));
		jlabel.setBackground(Color.YELLOW);
		jlabel.setFont(new   java.awt.Font("Dialog",   1,   20));   
		jlabel.setForeground(Color.red);
		
		eventlisten=new EventListen(this,jlabel,comboBox);
		this.addMouseMotionListener(eventlisten);
		this.addMouseListener(eventlisten);
		this.setPreferredSize(new Dimension(300, 300));
		this.setBackground(Color.WHITE);
		jframe.add(this,BorderLayout.CENTER);
		jpanel=new JPanel();
		jpanel.setPreferredSize(new Dimension(100, 0));
		String[] jbt= {"train","test","clear","save","read"};
		for(String i:jbt) {
			JButton jbtn=new JButton(i);
			jbtn.setPreferredSize(new Dimension(80, 20));
			jbtn.addActionListener(eventlisten);
			jpanel.add(jbtn);
		}
		
		
		jpanel.add(jlabel);
		
		JLabel jlabel2=new JLabel("num:",JLabel.CENTER);
		jlabel2.setFont(new   java.awt.Font("Dialog",   1,   15));
		jlabel2.setPreferredSize(new Dimension(40, 20));
		jpanel.add(jlabel2);
		
		
		jpanel.add(comboBox);
		/*
		JTextField text=new JTextField(7);
		jpanel.add(text);*/
		jframe.add(jpanel, BorderLayout.EAST);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}
}
