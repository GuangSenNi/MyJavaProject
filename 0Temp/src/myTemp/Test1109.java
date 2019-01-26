package myTemp;
import java.util.concurrent.Callable ;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test1109 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Worker w=new Worker();
		FutureTask<Integer> ft = new FutureTask<>(w);
		Thread thread = new Thread(ft);
	    thread.start();
	    try {
			System.out.println(ft.get());
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}

class Worker implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO 自动生成的方法存根
		return 111;
	}
	
}