package bubble;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EventAction extends Thread implements ActionListener{

	private JPanel jpanel;
	private Graphics g;
	private volatile boolean xm=false;
	private static int m=0,r=0,cent_x=150,cent_y=150;
	private BufferedImage image;
	private int[][] pic;
	private ArrayList<Point> pointList=new ArrayList<Point>();
	public EventAction(JPanel jpanel) {
		super();
		this.jpanel = jpanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		JButton jbt=(JButton) e.getSource();
		if(jbt.getBackground()==Color.yellow) {
			importJpg();
		}else if(jbt.getBackground()==Color.green) {
			
		}else if(jbt.getBackground()==Color.red) {
			xm=!xm;
		}
	}

	private void importJpg() {
		if(g==null) {
			g=jpanel.getGraphics();
		}
		try {
			image=ImageIO.read(new File("src/246.png"));
			pic=new int[image.getWidth()][image.getHeight()];
			for(int i=0;i<image.getWidth();i++) {
				for(int j=0;j<image.getHeight();j++) {
					int argb = image.getRGB(i, j);
					int r = (argb >> 16) & 0xFF;  
					int g = (argb >> 8) & 0xFF; 
					int b = (argb >> 0) & 0xFF;
					int grayPixel = (int) ((b * 29 + g * 150 + r * 77 + 128) >> 8);
					pic[i][j]=grayPixel;
				}
			}
			BufferedImage bi2=new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_4BYTE_ABGR );
			Ellipse2D.Double shape=new Ellipse2D.Double(0, 0, image.getWidth(), image.getHeight());
			Graphics2D g2=bi2.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setClip(shape);
			g2.drawImage(image, 0, 0, null);
			g2.dispose();
			System.out.println(image.getHeight());
			System.out.println(image.getWidth());
			initPoint();
			
			//g.drawImage(bi2, cent_x-image.getHeight()/2, cent_y-image.getWidth()/2, null);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	}/*
	public static int getGray(Color pixel) {
        return (pixel.getRed()*30+pixel.getGreen()*60+pixel.getBlue()*10)/100;
    }
	private void toGray() {
		bfi = new BufferedImage(image.getWidth()/5,image.getHeight()/5,BufferedImage.TYPE_BYTE_GRAY); 
		bfi.getGraphics().drawImage(image, 0, 0,null); 
		pic=new int[image.getWidth()/5][image.getHeight()/5];
		for(int i=0;i<image.getWidth()/5*5;i++) {
			for(int j=0;j<image.getHeight()/5*5;j++) {
				Color pixel = new Color(image.getRGB(i, j));  
				bfi.setRGB(i/5, j/5,new Color(getGray(pixel),getGray(pixel),getGray(pixel)).getRGB());
				int argb = image.getRGB(i, j);
				int r = (argb >> 16) & 0xFF;  
				int g = (argb >> 8) & 0xFF; 
				int b = (argb >> 0) & 0xFF;
				int grayPixel = (int) ((b * 29 + g * 150 + r * 77 + 128) >> 8);
				pic[i/5][j/5]=grayPixel;
			}
		}
		try {
            ImageIO.write(bfi, "jpg", new File("src/test1.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		System.out.println(image.getWidth()/5);
		System.out.println(image.getHeight()/5);
		g.drawImage(bfi, 0, 0, null);
	}
	 */

	public void run() {
		while(true) {
			if(xm) {
				show();
			}
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	public int AverageValue(int x1, int y1, int x2, int y2) {
		int num=0,sum=0;
		Point p_opsite=new Point(x2,y2);
		if(x2-x1==0) 
		{
			int h=y2-cent_y;
			p_opsite.x=x2;
			p_opsite.y=cent_y-h;
			int y_min=Math.min(p_opsite.y, y2);
			int y_max=Math.max(p_opsite.y, y2);
			while(y_min<=y_max) {
				sum+=pic[x2-cent_x+r][y_min-cent_y+r];
				y_min++;
				num++;
			}
			return  (sum/num);
		}
		double k=(y2-y1)/(double)(x2-x1);
		double k_same=999;
		double k2=0;
		//System.out.println(x3+":"+y3);
		//System.out.println(inOral(x3,y3));
		for(int i=0;i<200;i++) {
			Point p1=pointList.get(i);
			if(p1.x==x2)continue;
			double k3=(p1.y-y2)/(double)(p1.x-x2);
			if(Math.abs(k3-k)<k_same) {
				p_opsite=p1;
				k_same=Math.abs(k3-k);
				k2=k3;
			}
		}
		//System.out.println(k_same+"k222222kkkk"+k2);
		//System.out.println(p_opsite);
		int x_begin,y_begin,x_end,y_end;
		if(p_opsite.x<x2) {
			x_begin=p_opsite.x;
			y_begin=p_opsite.y;
			x_end=x2;
			y_end=y2;
		}else {
			x_begin=x2;
			y_begin=y2;
			x_end=p_opsite.x;
			y_end=p_opsite.y;
		}
		
		//System.out.println(x_begin+":"+y_begin+":"+k2);
		//System.out.println(x_end+":"+y_end);
		y_end=y_begin;
		while(x_begin<=x_end) {
			sum+=pic[x_begin-cent_x+r][y_begin-cent_y+r];
			num++;
			y_begin=(int) (y_end+num*k2);
			if(y_begin-cent_y+r<0||y_begin-cent_y+r>208)break;
			x_begin++;
			//System.out.println(x_begin+":"+y_begin+":"+k2);
		}
		//g.setColor(new Color((int)sum/num,(int)sum/num,(int)sum/num));
		//g.drawLine(p_opsite.x, p_opsite.y, x2, y2);
		return (sum/num);
	}

	private void initPoint() {
		r=image.getWidth()/2;
		for(double i=0;i<Math.PI*2;i+=Math.PI/100) {
			Point p=new Point();
			p.x=(int) (cent_x+r*Math.cos(i));
			p.y=(int) (cent_y+r*Math.sin(i));
			pointList.add(p);
		}
	}

	public void show() {
		int x,y,l1,l2;
		if(m>2500) {
			xm=!xm;
		}
		m++;
		//System.out.println(m);
		Random r0=new Random();
		double d=Math.PI/10;
		while(true) {
			l1=r0.nextInt(r);
			l2=r0.nextInt(200);
			x=(int) (cent_x+l1*Math.cos(l2*d));
			y=(int) (cent_y+l1*Math.sin(l2*d));
			if(pic[x-cent_x+r][y-cent_y+r]<90 )
				break;
		}
		//g.setColor(Color.blue);
		//g.fillOval(x, y, 5, 5);
		//System.out.println(x+":"+y);
		int x1=0,y1=0,min=255,m1=0;
		for(int i=0;i<200;i++) {
			Point p1=pointList.get(i);
			m1=AverageValue(x,y,p1.x,p1.y);
			if(m1<min) {
				min=m1;
				x1=p1.x;
				y1=p1.y;
			}
		}
		//System.out.println(min);
		Point pp=changeRGB(x, y, x1, y1);
		min=40;
		g.setColor(new Color(min,min,min));
		//g.setColor(Color.green);
		//System.out.println(x1+":"+y1);
		g.drawLine(pp.x, pp.y, x1, y1);
		
	}

	public Point changeRGB(int x1, int y1, int x2, int y2) {
		int num=0;
		Point p_opsite=new Point(x2,y2);
		if(x2-x1==0) 
		{
			int h=y2-cent_y;
			p_opsite.x=x2;
			p_opsite.y=cent_y-h;
			int y_min=Math.min(p_opsite.y, y2);
			int y_max=Math.max(p_opsite.y, y2);
			while(y_min<=y_max) {
				pic[x2-cent_x+r][y_min-cent_y+r]+=50;
				y_min++;
				num++;
			}
			return p_opsite;
		}
		double k=(y2-y1)/(double)(x2-x1);
		double k_same=999;
		double k2=0;
		//System.out.println(x3+":"+y3);
		//System.out.println(inOral(x3,y3));
		for(int i=0;i<200;i++) {
			Point p1=pointList.get(i);
			if(p1.x==x2)continue;
			double k3=(p1.y-y2)/(double)(p1.x-x2);
			if(Math.abs(k3-k)<k_same) {
				p_opsite=p1;
				k_same=Math.abs(k3-k);
				k2=k3;
			}
		}
		int x_begin,y_begin,x_end,y_end;
		if(p_opsite.x<x2) {
			x_begin=p_opsite.x;
			y_begin=p_opsite.y;
			x_end=x2;
			y_end=y2;
		}else {
			x_begin=x2;
			y_begin=y2;
			x_end=p_opsite.x;
			y_end=p_opsite.y;
		}
		//System.out.println(x_begin+":"+y_begin);
		//System.out.println(x_end+":"+y_end);
		y_end=y_begin;
		while(x_begin<=x_end) {
			pic[x_begin-cent_x+r][y_begin-cent_y+r]+=45;
			num++;
			y_begin= (int) (y_end+num*k2);
			if(y_begin-cent_y+r<0||y_begin-cent_y+r>208)break;
			x_begin++;
		}

		return p_opsite;
	}
}
