package number;

import java.io.Serializable;

@SuppressWarnings("serial")
public class num implements Serializable{

	private int id;
	private int num=0;
	public int eachNum[][]=new int[20][20];
	public float eachP[][]=new float[20][20];
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
