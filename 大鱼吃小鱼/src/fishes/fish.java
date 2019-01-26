package fishes;

import java.awt.Color;

public class fish {
	private int x,y,r,v=0,isMY=0,vx,vy;
	public int getIsMY() {
		return isMY;
	}
	public void setIsMY(int isMY) {
		this.isMY = isMY;
	}
	private Color color;
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
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
		vx=vx+5;
		vy=vy+5;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public fish(int x, int y, int r, int v, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		this.v = v;
		this.color = color;
		vx=v;
		vy=v;
	}
	public void Move() {
		y=(int) (y+vy);
		x=(int) (x+vx);
		if(y>=430-r||y<=0) {
			vy=-vy;
		}if(x>=600-r||x<=0) {
			vx=-vx;
		}if(y>450-r) {
			y=450-r;
		}if(y<0) {
			y=0;
		}if(x<0)x=0;
		if(x>600-r)x=600-r;
	}
}
