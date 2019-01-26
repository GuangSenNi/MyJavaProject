package myTemp;

public class Test1217 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Test1217 t=new Test1217();
		System.out.println(t.staget());
		System.out.println(t.myget());
		
	}

	static int index=1;
	int m=5;
	public int myget() {
		return index+staget()+m;
	}
	static int staget() {
		return index;
	}
}
