package l_system;

import java.awt.*;

import javax.swing.*;

public class process extends JPanel{
	public process() {
		this.setSize(800,800);   
		this.setVisible(true);
	}

	public void paintComponent(Graphics g){
		double ra,rb;//旋转角
		ra = 60*Math.PI/180;  
		rb = 60*Math.PI/180;
		String sequence="F-F++F-F";
		//规定单位F的长度  
		double len = 10;  
		//设置方向向量  
		double dx = 1,dy = 0;  
		//设置起点坐标  
		double x0 = 0,y0 = 0;  
		double min_x,max_x,min_y,max_y;

		min_x=max_x=x0;  
		min_y=max_y=y0; 
		//迭代次数
		for(int i=0;i<3;i++) {
			sequence=sequence.replaceAll("F", "F-F++F-F");
		}

		for(int i = 0; i < sequence.length(); i++)  
		{
			if(sequence.charAt(i) == 'F') {
				double x1 = x0 + len*dx;  
				double y1 = y0 + len*dy;  
				x0 = x1;  
				y0 = y1;
				if(x0 < min_x) min_x = x0;  
				if(x0 > max_x) max_x = x0;  
				if(y0 < min_y) min_y = y0;  
				if(y0 > max_y) max_y = y0; 
			}else if(sequence.charAt(i) == '+') {
				double _dx = dx*Math.cos(ra)-dy*Math.sin(ra);  
				double _dy = dx*Math.sin(ra)+dy*Math.cos(ra);  
				dx = _dx;  
				dy = _dy; 
			}else if(sequence.charAt(i) == '-') {
				double _dx = dx*Math.cos(-rb)-dy*Math.sin(-rb);  
				double _dy = dx*Math.sin(-rb)+dy*Math.cos(-rb);  
				dx = _dx;  
				dy = _dy;
			}
			/*System.out.print(dx);
			System.out.print(',');
			System.out.println(dy);*/
		}
		//自动匹配画布大小
		double r =Math.min(800.0/(max_x-min_x), 800.0/(max_y-min_y));
		len*=r;
		double mid_x=(max_x+min_x)/2,mid_y=(max_y+min_y)/2;
		dx=1;
		dy=0;
		x0=400-mid_x*r;
		y0=400-mid_y*r;//????
		int n=1;
		for(int i = 0; i < sequence.length(); i++)  
			if(sequence.charAt(i) == 'F')   n++; 

		Point points[] = new Point[n];  
		points[0] = new Point((int)x0,(int)y0);  
		int num = 1;  
		for(int i = 0; i < sequence.length(); i++)  
		{  
			if(sequence.charAt(i) == 'F')  
			{  
				double x1 = x0 + len*dx;  
				double y1 = y0 + len*dy;  
				x0 = x1;  
				y0 = y1;  
				points[num++] = new Point((int)x0,(int)y0);  
			}else if(sequence.charAt(i) == '+')  
			{    
				double _dx = dx*Math.cos(ra)-dy*Math.sin(ra);  
				double _dy = dx*Math.sin(ra)+dy*Math.cos(ra);  
				dx = _dx;  
				dy = _dy;   
			}else if(sequence.charAt(i) == '-')  
			{  
				double _dx = dx*Math.cos(-rb)-dy*Math.sin(-rb);  
				double _dy = dx*Math.sin(-rb)+dy*Math.cos(-rb);  
				dx = _dx;  
				dy = _dy;
			}  
		}
		int x1,x2,y1,y2;
		x2 = points[0].x;  
		y2 = points[0].y;
		for(int i = 0; i < num; i++)  
		{  
			x1 = points[i].x;  
			y1 = points[i].y;  
			g.setColor(Color.red);
			g.drawLine(x2,y2,x1,y1); 
			x2 = x1;  
			y2 = y1;  
		}  
	} 

}
