package myTemp;
import java.util.concurrent.Callable ;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test1109 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Worker w=new Worker();
		FutureTask<Integer> ft = new FutureTask<>(w);
		Thread thread = new Thread(ft);
	    thread.start();
	    try {
			System.out.println(ft.get());
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}

class Worker implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO �Զ����ɵķ������
		return 111;
	}
	
}