package draw_pic;

import java.awt.*;

import javax.swing.*;

public class first {
	JFrame mainJf;
	first1 f1;
	public class first1 extends JPanel{
		public void paintComponent(Graphics g) {
			this.setSize(700,700);
			this.setVisible(true);
			double x=0,y=0,a=-2.7,b=-2.5,c=-2,d=-2;
			int max_x=0,min_x=0,max_y=0,min_y=0;
			for(int i=0;i<100000;i++) {
				x=d*Math.sin(a*x)-Math.sin(b*y);
				y=c*Math.cos(a*x)+Math.cos(b*y);
				int m=(int)(x*100+330);
				int n=(int)(y*100+350);
				//System.out.println(m);
				if(m< min_x) min_x = m;  
				if(m> max_x) max_x = m;  
				if(n < min_y) min_y = n;  
				if(n > max_y) max_y = n;
				//g.setColor(new Color(250,i%255,i%155));
				//g.drawLine(m, n, m, n);
			}
			double r =Math.min((max_x-min_x)/700.0, (max_y-min_y)/700.0);
			double mid_x=(max_x+min_x)/2,mid_y=(max_y+min_y)/2;
			int x0=(int)(350-mid_x);
			int y0=(int)(350-mid_y);			
			for(int i=0;i<100000;i++) {
				x=d*Math.sin(a*x)-Math.sin(b*y);
				y=c*Math.cos(a*x)+Math.cos(b*y);
				int m=(int)(x*100+330);
				int n=(int)(y*100+350);
				g.setColor(new Color(250,i%255,i%155));
				int m1=(int)(r*m+x0),n1=(int)(r*n+y0);
				g.drawLine(m1, n1, m1, n1);
			}
			//g.setColor(Color.BLACK);
			//g.drawRect(10, 10, 100, 100);
		}
	}
	public void first() {
		mainJf=new JFrame("first");
		f1=new first1();
		mainJf.setVisible(true);
		mainJf.setSize(700,700);
		mainJf.getContentPane().add(f1);
		mainJf.setLocationRelativeTo(null);
		mainJf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]) {
		first t=new first();	
		t.first();
	}
}