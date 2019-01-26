package jiemian;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class window extends JPanel{
	private ArrayList<reshow> arr =new ArrayList<reshow>();
	private shijian sj;
	private void showFrame() {
		JFrame jframe;
		jframe =new JFrame();
		jframe.setSize(700, 600);
		
		jframe.setTitle("painting");
		jframe.setDefaultCloseOperation(3);
		jframe.setLocationRelativeTo(null);

		this.setBackground(Color.white);
		
		jframe.add(this, BorderLayout.CENTER);

		sj=new shijian(this,arr);
		this.addMouseListener(sj);
		this.addMouseMotionListener(sj);
		JPanel p2=new JPanel();
		p2.setVisible(true);
		String[] arrayMenu = { "line", "rec","oval",
				"pen" ,"thin","heavy","save","read","back","clear"}; 
		for (int i = 0; i < arrayMenu.length; i++){
			JButton bt=new JButton(arrayMenu[i]);
			p2.add(bt);
			bt.addActionListener(sj);
		}
		jframe.add(p2, BorderLayout.NORTH);

		JPanel p3=new JPanel();
		p3.setVisible(true);
		Color[] arrayMenu2 = {Color.black, Color.red,
				Color.green}; 
		for (int i = 0; i < arrayMenu2.length; i++){
			JButton bt2= new JButton();
			bt2.setBackground(arrayMenu2[i]);
			bt2.setPreferredSize(new Dimension(30, 30));
			p3.add(bt2);
			bt2.addActionListener(sj);
		}
		jframe.add(p3,BorderLayout.SOUTH);
		jframe.setVisible(true);
	}
	public void paint(Graphics gr) {
		super.paint(gr);
		Graphics2D g = (Graphics2D) gr;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);// 设置画笔抗锯齿
		if(true) {
			arr=sj.getArr();
		}
		System.out.println(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			reshow s = arr.get(i);
			g.setColor(s.getCl());
			if(s.getWide().equals("heavy")) {
				g.setStroke(new BasicStroke(5));
			}else {
				g.setStroke(new BasicStroke(1));
			}
			//g.setStroke(s.getStroke());
			if (s.getType().equals("line") || s.getType().equals("pen")) {
				g.drawLine(s.getX1(), s.getY1(), s.getX2(), s.getY2());
			} else if (s.getType().equals("oval")) {
				g.drawOval(s.getX1(), s.getY1(), s.getX2(), s.getY2());
			}else if (s.getType().equals("rec")) {
				g.drawRect(s.getX1(), s.getY1(), s.getX2(), s.getY2());
			}else if (s.getType().equals("clear")) {
				g.setColor(Color.WHITE);
				g.fillOval(s.getX1(), s.getY1(), s.getX2(), s.getY2());
			}
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		window w=new window();
		w.showFrame();
	}
}
