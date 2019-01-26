package threadball;

import java.util.Random;

public class ball {

	private int r,x,y,i;
	private mainUI m;
	public ball(int x, int y,int r, mainUI m) {
		super();
		this.x = x;
		this.y = y;
		this.m = m;
		this.r = r;
		Random rand=new Random();
		i=rand.nextInt(10)+1;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public void move() {
		if(y>=470-r||y<0) {
			i=-i;
		}
		i++;
		y=y+i;
		if(y>470-r) {
			y=470-r;
		}
		x=(int) (Math.sin(i)*i+x);
		if(x<0)x=0;
		if(x>600-r)x=600-r;
		//System.out.println(y);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
