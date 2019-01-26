package jiemian;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JButton;

public class shijian extends MouseAdapter implements ActionListener{
	private int x1,x2,y1,y2;
	private Graphics2D g;
	private Color col=Color.black;
	private String kind="";
	private String wei="thin";
	private window wi;
	private ArrayList<reshow> arr;
	public shijian(window wi,ArrayList<reshow> arr) {
		this.wi=wi;
		this.arr=arr;
	}
	public void actionPerformed(ActionEvent e) {
	    if(e.getActionCommand().equals("")) {
			JButton j=(JButton)e.getSource();
			col=j.getBackground();
		}else if(e.getActionCommand().equals("thin")||e.getActionCommand().equals("heavy")) {
			wei=e.getActionCommand();
		}else if(e.getActionCommand().equals("save")){
			OutputStream out;
			try {
				//ArrayList里面的数组elementData是声明为transient的，表示ArrayList在序列化的时候，默认不会序列化这些数组元素
				out = new FileOutputStream("src/save.txt");
				ObjectOutputStream oout=new ObjectOutputStream(out);
				System.out.println(arr.size());
				oout.writeObject(arr);
				oout.close();
				out.close();
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("read")){
			InputStream in;
			try {
				in = new FileInputStream("src/save.txt");
				ObjectInputStream oin=new ObjectInputStream(in);
				//System.out.println(oin.readObject());
				arr=(ArrayList<reshow>) oin.readObject();
				System.out.println(arr.size());
				
				oin.close();
				in.close();
				wi.repaint();
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("back")) {
			arr.remove(arr.size()-1);
			wi.repaint();
		}else if(e.getActionCommand().equals("clear")) {
			kind="clear";
			wi.repaint();
		}else {
			kind=e.getActionCommand();
		}
		
	}
	
	public ArrayList<reshow> getArr() {
		return arr;
	}
	public void setArr(ArrayList<reshow> arr) {
		this.arr = arr;
	}
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		this.g=(Graphics2D)wi.getGraphics();
		this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);// 设置画笔开启抗锯齿
		this.g.setColor(col);
		if(wei.equals("heavy")) {
			this.g.setStroke(new BasicStroke(5));
		}else {
			this.g.setStroke(new BasicStroke(1));
		}
	}
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		reshow re;
		if(kind.equals("line")) {
			g.drawLine(x1, y1, x2, y2);
			re = new reshow(x1, y1, x2, y2, col, kind, g.getStroke());
			arr.add(re);
		}else if(kind.equals("oval")) {
			g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			re = new reshow(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), col, kind, g.getStroke());
			arr.add(re);
		}else if(kind.equals("rec")) {
			g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			re = new reshow(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), col, kind, g.getStroke());
			arr.add(re);
		}
		
	
	}
	public void mouseDragged(MouseEvent e) {
		//System.out.println(kind);
		x2 = e.getX();
		y2 = e.getY();
		if (kind.equals("pen")) {
			x2 = e.getX();
			y2 = e.getY();
			g.drawLine(x1, y1, x2, y2);
			reshow re = new reshow(x1, y1, x2, y2, col, kind, g.getStroke());
			arr.add(re);
			x1 = x2;
			y1 = y2;
		}
		reshow re;
		if(kind.equals("line")) {
			g.drawLine(x1, y1, x2, y2);
			re = new reshow(x1, y1, x2, y2, col, kind, g.getStroke());
			if(arr.size()>0)
			arr.remove(arr.size()-1);
			wi.repaint();
			arr.add(re);
		}else if(kind.equals("oval")) {
			g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			re = new reshow(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), col, kind, g.getStroke());
			if(arr.size()>0)
			arr.remove(arr.size()-1);
			wi.repaint();
			arr.add(re);
		}else if(kind.equals("rec")) {
			g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
			re = new reshow(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1), col, kind, g.getStroke());
			if(arr.size()>0)
			arr.remove(arr.size()-1);
			wi.repaint();
			arr.add(re);
		}else if(kind.equals("clear")) {
			g.setColor(Color.WHITE);
			g.fillOval(x2, y2, 20, 20);
			re = new reshow(x2, y2, 20, 20, Color.WHITE, kind, g.getStroke());
			wi.repaint();
			arr.add(re);
		}
	}

}
