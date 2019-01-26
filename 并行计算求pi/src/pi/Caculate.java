package pi;

import java.util.Random;

public class Caculate extends Thread{
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public synchronized void run() {
		int threadsum=0;
		Random random=new Random();
		for(int i=0;i<num;i++) {
			double x=random.nextDouble();
			double y=random.nextDouble();
			double r=x*x+y*y;
			if(r<=1)threadsum++;
		}
		Control.in_num+=threadsum;	
	}
}
