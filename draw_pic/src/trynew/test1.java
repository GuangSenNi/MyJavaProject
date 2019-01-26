package trynew;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class test1 extends JPanel{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		test1 t =new test1();
		t.show();

	}
	JFrame mainjf;
	public void show() {
		mainjf=new JFrame("creative");
		mainjf.setSize(700, 600);
		mainjf.setDefaultCloseOperation(3);
		mainjf.setLocationRelativeTo(null);
		mainjf.add(this);
		mainjf.setVisible(true);
	}
	public void paint(Graphics g) {
		 
	}

}
