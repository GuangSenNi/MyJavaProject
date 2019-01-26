package jiemian;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.io.Serializable;

public class reshow implements Serializable{
	public int x1, y1, x2, y2;
	public Color cl;
	public String type;
	public transient Stroke stroke;//该类未序列话
	public String wide="thin";
	public reshow(int x1, int y1, int x2, int y2, Color cl, String type, Stroke stroke) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.cl = cl;
		this.type = type;
		this.stroke = stroke;
		if(stroke.equals(new BasicStroke(5))) {
			this.wide="heavy";
		}
	}
	public String getWide() {
		return wide;
	}
	public void setWide(String wide) {
		this.wide = wide;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public Color getCl() {
		return cl;
	}
	public void setCl(Color cl) {
		this.cl = cl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Stroke getStroke() {
		return stroke;
	}
	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

}
