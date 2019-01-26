package myarray;

import java.util.Random;

public class myarray<E> {
	public Object[] name;
	public int size,maxsize;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		myarray<Integer> m=new myarray<Integer>();
		Random rand=new Random();
		for(int i=0;i<11;i++) {
			int n=rand.nextInt(50);
			m.add(n);
			System.out.println(n);
		}
		System.out.println("<<<");
		System.out.println(m.nowsize());
		System.out.println(m.maxsize);
		for(int j=0;j<11;j++) {
			System.out.println(m.get(j));
		}
	}
	public myarray() {
		this.name= new Object[10];
		this.size=-1;
		this.maxsize=10;
	}
	public void add(E element) {
		size++;
		if (size > maxsize-1 )  //如果指定要插入的数组下标超过数组容量或者指定的下标小于0，抛异常
		{
			Object[] a=new Object[maxsize+5];
			for(int i=0;i<maxsize;i++) {
				a[i]=name[i];
			}
			maxsize+=5;
			a[size]=element;
			name=a;
		}else {
			name[size]=element;
		}  
	    }
	public E remove(int index) {
		Object m=null;
		if(index<0||index>size) {
			return null;
		}else {
			maxsize--;
			size--;
			Object[] a=new Object[maxsize];
			for(int i=0;i<maxsize;i++) {
				if(i<index) {
					a[i]=name[i];
				}if(i>index) {
					a[i-1]=name[i];
				}if(i==index) {
					m= name[i];
				}
			}
			name=a;
			return (E) m;
		}
	    } 
	public int maxsize() {
		return maxsize;
	}
	public int nowsize() {
		return size;
	}
	public E get(int index) {
		if (index < 0 || index > size)
			return null;
		return (E)name[index];
	}
}
