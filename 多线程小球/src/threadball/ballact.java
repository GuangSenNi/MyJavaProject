package threadball;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class ballact extends MouseAdapter implements Runnable,KeyListener{
	private mainUI m;
	private int x=0,y=0;
	private ArrayList<ball> arr;
	private Graphics g;
	private volatile boolean real=true;//volatile 因为线程无自己的存储空间
	public ballact(mainUI m,ArrayList<ball> arr) {
		super();
		this.m = m;
		this.arr=arr;
	}

	public void mouseReleased(MouseEvent e) {
		if(g==null) {
			g=m.getGraphics();
		}
		x = e.getX();
		y = e.getY();
		Random r=new Random();
		int r1=r.nextInt(60)+10;
		ball b =new ball(x,y,r1,m);
		arr.add(b);
		//m.repaint();
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		Random r=new Random();
		int i=0;
		while(true) {
			if(real) {
				if(i<10) {
					i++;
					ball b1 =new ball(r.nextInt(600),y,r.nextInt(40)+10,m);
					arr.add(b1);
				}
				m.repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		System.out.println(e.getKeyCode());//放到keyTyped有时无法打印
		if(e.getExtendedKeyCode()==32) {
			real=!real;
		}
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
}
