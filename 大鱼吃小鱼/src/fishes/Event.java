package fishes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Event extends Thread implements KeyListener,MouseListener,ActionListener{

	private Ui u1;
	private int num=0,v=30;
	private Random random=new Random();
	public ArrayList<fish> fishlist;
	private fish myfish;
	private volatile boolean start=false;
	public boolean isStart() {
		return start;
	}


	public void setStart(boolean start) {
		this.start = start;
	}

	private static Color[] color= {Color.CYAN,Color.GRAY,Color.GREEN,Color.ORANGE,
			Color.PINK,Color.YELLOW,Color.RED, new Color(20,200,150)};
	public Event(Ui u1, ArrayList<fish> fishlist) {
		super();
		this.u1 = u1;
		this.fishlist = fishlist;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO 自动生成的方法存根
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getExtendedKeyCode());
		int x,y;
		x=fishlist.get(0).getX();
		y=fishlist.get(0).getY();
		if(e.getExtendedKeyCode()==37) {
			x-=v;
			fishlist.get(0).setX(x);
		}else if(e.getExtendedKeyCode()==39) {
			x+=v;
			fishlist.get(0).setX(x);
		}else if(e.getExtendedKeyCode()==38) {
			y-=v;
			fishlist.get(0).setY(y);
		}else if(e.getExtendedKeyCode()==40) {
			y+=v;
			fishlist.get(0).setY(y);
		}else if(e.getExtendedKeyCode()==32) {
			start=!start;
		}else if(e.getExtendedKeyCode()==107) {
			v+=20;
		}else if(e.getExtendedKeyCode()==109) {
			v-=20;
		}
		u1.repaint();
	
		}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO 自动生成的方法存根
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("切换焦点到主面板");
		u1.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand()=="Start") {	
			fishlist.clear();
			myfish=new fish(280, 300, 30, 0,new Color(100,200,10));
			myfish.setIsMY(1);
			fishlist.add(myfish);
			start=true;
			u1.repaint();
		}else if(e.getActionCommand()=="Pause") {
			start=!start;
		}
	}
	
	public void run() {
		while(true) {
		while(start) {
			num=fishlist.size();
			if(num<10) {
				fish f=new fish(random.nextInt(500),random.nextInt(200),random.nextInt(40)+10,random.nextInt(12)+3,color[random.nextInt(8)]);
				fishlist.add(f);
			}
			u1.repaint();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	}
}
