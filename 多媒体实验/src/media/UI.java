package media;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UI extends JPanel{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		UI u=new UI();
		u.initUI();
	}

	Image[] card = new Image[10];
	public void initUI() {
		JFrame jf=new JFrame("倪广森");
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null); 
		
		jf.add(this,BorderLayout.CENTER);
		
		Monitor monitor=new Monitor(card, this);
		
		JPanel jp=new JPanel();
		jp.setBackground(new Color(50, 150, 200));
		String[] jbtArray= {"预读","放映","特效","暂停","音乐","结束"}; 
		for(String str:jbtArray) {
			JButton jb=new JButton(str);
			jb.setBackground(new Color(170, 150, 200));
			jb.addActionListener(monitor);
			jp.add(jb);
		}
		
		jf.add(jp,BorderLayout.NORTH);		
		jf.setResizable(false);
		jf.setVisible(true);
	}
}
