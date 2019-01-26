package myFire;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Control extends Thread{
	private Graphics g;
	private int width,height;
	private BufferedImage bi;
	private ArrayList<Cell> pointColor;
	private JPanel jpanel;
	private volatile boolean exe=false;
	public boolean isExe() {
		return exe;
	}

	public void setExe(boolean exe) {
		this.exe = exe;
	}

	public Control(ArrayList<Cell> pointColor, JPanel jpanel) {
		super();
		this.pointColor = pointColor;
		this.jpanel = jpanel;
		g=jpanel.getGraphics();
	}

	public void cutPicture() {
		for(int i=0;i<width;i+=4) {
			for(int j=0;j<height;j+=4) {
				int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字  
				int alpha = (pixel >> 24) & 0xff;
				if (alpha == 0) {//去掉透明点
					continue;
				}
				int r = (pixel & 0xff0000) >> 16;  
				int g = (pixel & 0xff00) >> 8;  
				int b = (pixel & 0xff); 
				RGB rgb=new RGB(r, g, b);
				Cell cell=new Cell(rgb, 100+i/4, j/4);
				pointColor.add(cell);
			}
		}
	}

	public void importPicture() {
		try {
			bi = ImageIO.read(new File("src/timg (1).png"));
			height=bi.getHeight();
			width=bi.getWidth();
			g.drawImage(bi,100, 0,width/4 ,height/4,null);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  
	}

	public void run() {
		while(true) {
		if(exe) {
			jpanel.repaint();
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
