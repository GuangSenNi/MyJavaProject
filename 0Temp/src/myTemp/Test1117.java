package myTemp;
import java.util.concurrent.*;
public class Test1117 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ExecutorService ex=new ThreadPoolExecutor(2,2,2,TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		for(int i=0;i<10;i++) {
			Task runnable=new Task(i);
			ex.execute(runnable);
		}
		ex.shutdown();
	}

}
class Task implements Runnable {

	private int id;
	public Task(int id) {
		this.id=id;
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		System.out.println(id);
	}
	
}