package l_system;

import javax.swing.*;

public class base extends JFrame{
	process pro;
	public  base() {
		pro=new process();
		this.setTitle("L-System");  
		this.setSize(800,800);  
		this.setLocationRelativeTo(null);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		this.setVisible(true);
		this.getContentPane().add(pro);
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new base();
		//b.base();
	}

}
