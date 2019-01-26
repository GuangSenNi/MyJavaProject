package pi;

public class Control {
	static int in_num;
	public static void main(String[] args) {
		int point_num=10000000;
		int thread_num=5;
		Caculate[] caculate=new Caculate[thread_num];
		int num=point_num/thread_num;
		double t1,t2,t3;
		t1=System.currentTimeMillis();
		for(int i=0;i<thread_num;i++) {
			caculate[i]=new Caculate();
			caculate[i].setNum(num);
			caculate[i].start();
		}
		for(int i=0;i<thread_num;i++) {
			try {
				caculate[i].join();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		t2=System.currentTimeMillis();
		t3=t2-t1;
		double pi=4.0*(double)in_num/(double)point_num;
		System.out.println("pi的值："+pi);
		System.out.println("执行时间："+t3);
		
	}
	
	
}
