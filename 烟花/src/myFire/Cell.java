package myFire;

import java.util.Random;

public class Cell {

	private RGB rgb;
	private int x,y,x0,y0,age=0;
	public RGB getRgb() {
		return rgb;
	}
	public void setRgb(RGB rgb) {
		this.rgb = rgb;
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
	public Cell(RGB rgb, int x, int y) {
		super();
		this.rgb = rgb;
		this.x = x;
		this.y = y;
		this.x0 = x;
		this.y0 = y;
	}
	public void move() {
		int p=100-age;
		Random r=new Random();
		x=(int) Math.abs((x0-p*Math.cos(age*Math.PI/30)-r.nextInt(20)));
		y=(int) Math.abs((y0+p*Math.sin(age*Math.PI/30)+r.nextInt(20)));
		setAge(getAge() + 1);
	}
	public void move2() {
		Random r=new Random();
		x=(int) Math.abs(x0);
		y=(int) ((y0)*Math.sin(age*Math.PI/30)+y0);
		setAge(getAge() + 1);
	}
	public void move3() {
		Random r=new Random();
		y=(int) Math.abs(y0);
		x=(int) (-x0*Math.sin(age*Math.PI/30)+x0);
		setAge(getAge() + 1);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
