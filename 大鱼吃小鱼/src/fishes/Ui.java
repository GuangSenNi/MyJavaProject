package fishes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Ui extends JPanel{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Ui u=new Ui();
		u.initUI();
	}
	public ArrayList<fish> fishlist=new ArrayList<fish>();
	private int grade=0;
	JLabel label=new JLabel("0");
	Event event=new Event(this,fishlist);
	public void initUI() {
		JFrame jf=new JFrame("大鱼吃小鱼");
		jf.setSize(600,500);
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		jf.add(this,BorderLayout.CENTER);
		JPanel jp=new JPanel();
		jp.setBackground(new Color(50, 150, 200));
		JButton jb1=new JButton("Start");
		JButton jb2=new JButton("Pause");
		
		jb1.addActionListener(event);
		jb2.addActionListener(event);
		
		label.setPreferredSize(new Dimension(50, 30));
		//label.setBackground(Color.green);//标签是透明的
		jp.add(label);
		jp.add(jb1);
		jp.add(jb2);
		jf.add(jp,BorderLayout.NORTH);
		jf.setFocusable(false);
		this.setFocusable(true);//键盘监听和按钮同时出现，焦点会到按钮上
		this.addKeyListener(event);
		this.addMouseListener(event);
		jf.setResizable(false);
		jf.setVisible(true);
		event.run();
	}
	public synchronized void paint(Graphics g) {
		super.paint(g);
		fish b,b1;
		ImageIcon icon=new ImageIcon("src/timg.jpg");
		ImageIcon icon1=new ImageIcon("src/timg (1).png");
		ImageIcon icon2=new ImageIcon("src/timg (2).png");
	    g.drawImage(icon.getImage(),0,0,600,500,this);
	    //g.drawImage(icon2.getImage(),100,100,60,50,this);
		for(int i=0;i<fishlist.size();i++) {
			if(fishlist.get(i)!=null) {
				b=fishlist.get(i);
				if(b.getIsMY()==0)b.Move();
				g.setColor(b.getColor());
				//g.fillOval(b.getX(), b.getY(), b.getR(), b.getR());
				if(i==0)g.drawImage(icon2.getImage(),b.getX(),b.getY(),b.getR(),b.getR(),null);
				else
					g.drawImage(icon1.getImage(),b.getX(),b.getY(),b.getR(),b.getR(),null);
				for(int j=0;j<i;j++) {
					if(fishlist.size()>j-1) {
						b1=fishlist.get(j);
						int x2,y2,r2;
						x2=Math.abs(b1.getX()-b.getX());
						y2=Math.abs(b1.getY()-b.getY());
						r2=(b1.getR()+b.getR())/2;
						if(Math.sqrt(y2*y2+x2*x2)<r2&&b1.getIsMY()+b.getIsMY()>0) {
							if(b1.getR()>b.getR()) {
								fishlist.remove(i);
								if(b.getIsMY()==1) {
									event.setStart(false);
									fishlist.clear();
									grade=0;
									JOptionPane.showMessageDialog(this, "game over");
								}
								//fishlist.set(i,null);
								b1.setR(b1.getR()+5);
							}else if(b.getR()>b1.getR()) {
								fishlist.remove(j);
								if(b1.getIsMY()==1) {
									event.setStart(false);
									fishlist.clear();
									grade=0;
									JOptionPane.showMessageDialog(this, "game over");
									g.drawImage(icon.getImage(),0,0,600,500,this);
								}
								//fishlist.set(j,null);
								b.setR(b.getR()+5);
							}
							grade++;
							label.setText(grade+"");
							
							if(grade>5) {
								event.setStart(false);
								fishlist.clear();
								JOptionPane.showMessageDialog(this, "win");
								g.drawImage(icon.getImage(),0,0,600,500,this);
							}
						}
					}
				}
			}	
		}
	   
		
	}
}
