package myFire;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventListen extends MouseAdapter implements ActionListener{

	private JFrame jframe;
	private JPanel jpanel;
	private ArrayList<Cell> pointColor;
	private static Point originFrame;
	private static int x,y;
	private boolean pause=true;
	private Control control;
	
	public EventListen(JFrame jframe, JPanel jpanel, ArrayList<Cell> pointColor) {
		super();
		this.jframe = jframe;
		this.jpanel = jpanel;
		this.pointColor = pointColor;
	}
	
	private void moveJframe() {
		int nowX,nowY;
		Point nowPoint=jframe.getLocationOnScreen();
		nowX=(int)(nowPoint.getX()+x-originFrame.getX());//？
		nowY=(int) (nowPoint.getY()+y-originFrame.getY());
		jframe.setLocation(nowX,nowY);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		x=arg0.getX();
		y=arg0.getY();
		moveJframe();
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		originFrame=arg0.getPoint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		JButton jbt=(JButton) e.getSource();
		if(jbt.getBackground()==Color.red) {
			System.exit(0);
		}else if(jbt.getBackground()==Color.green) {
			pointColor.clear();
			control=new Control(pointColor, jpanel);
			control.importPicture();
			control.cutPicture();
			control.start();
		}else if(jbt.getBackground()==Color.yellow) {
			if(pause) {
				control.setExe(true);
				pause=!pause;
			}else {
				control.setExe(false);
				pause=!pause;
			}
		}
	}

}
