package threadball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainUI extends JPanel{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		mainUI m=new mainUI();
		m.showUI();
	}
	private ballact b;
	private ArrayList<ball> arr=new ArrayList<>() ;
	public void showUI() {
		JFrame jf=new JFrame("fall ball");
		jf.setSize(600, 500);
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		this.setBackground(Color.yellow);
		jf.setFocusable(false);
		this.setFocusable(true);//把焦点放在面板上
		jf.add(this);
		jf.setResizable(false);
		jf.setVisible(true);
		b=new ballact(this,arr);
		this.addMouseListener(b);
		this.addKeyListener(b);
		Thread t1=new Thread(b);
		t1.start();

	}

	public synchronized void paint(Graphics g) {
		super.paint(g);
		ball b,b1;

		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)!=null) {
				b=arr.get(i);
				b.move();
				System.out.println(b.getX());
				g.fillOval(b.getX(), b.getY(), b.getR(), b.getR());	
				for(int j=0;j<i;j++) {
					if(arr.get(j)!=null) {
						b1=arr.get(j);
						int x2,y2,r2;
						x2=Math.abs(b1.getX()-b.getX());
						y2=Math.abs(b1.getY()-b.getY());
						r2=(b1.getR()+b.getR())/2;
						if(Math.sqrt(y2*y2+x2*x2)<r2) {
							if(b1.getR()>b.getR()) {
								arr.remove(i);
								//arr.set(i,null);
								b1.setR(b1.getR()+5);
							}else if(b.getR()>b1.getR()) {
								arr.remove(j);
								//arr.set(j,null);
								b.setR(b.getR()+5);
							}
						}
					}
				}
			}	
		}


	}

}
