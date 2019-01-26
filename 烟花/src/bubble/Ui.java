package bubble;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ui extends JPanel{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Ui u=new Ui();
		u.initUI();
	}

	public void initUI() {
		JFrame f = new JFrame();
		
		f.setSize(346, 329);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(3);
		f.setResizable(false);
		EventAction eventListen=new EventAction(this);
		eventListen.start();
		JPanel jpanelEast=new JPanel();
		jpanelEast.setBackground(Color.black);
		jpanelEast.setPreferredSize(new Dimension(40, 0));
		Color[] btnGroup= {Color.red,Color.green,Color.yellow};
		for(Color i:btnGroup) {
			JButton jbt=new JButton();
			jbt.setBackground(i);
			jbt.setPreferredSize(new Dimension(25, 25));
			jbt.addActionListener(eventListen);
			jpanelEast.add(jbt);
		}
		f.add(jpanelEast, BorderLayout.EAST);
		f.add(this,BorderLayout.CENTER);
		f.setVisible(true);	
		System.out.println(f.getInsets());
	}
	public void paint(Graphics g) {
		/*g.drawLine(150, 0, 150, 300);
		g.drawLine(0, 150, 300, 150);
		g.drawLine(0, 0, 300, 300);
		g.drawLine(0, 300, 300, 0);*/
		g.setColor(new Color(90, 20,20));
		g.fillRect(0, 0, 300, 300);
		g.setColor(new Color(200, 255, 210));
		g.fillOval(45, 45, 208, 208);;
	}
}
