package test;
import java.util.Arrays;
import java.util.*;
public class MySort {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ArrayList<Student> array =new ArrayList<Student>();
		array.add(new Student("c",18));
		array.add(new Student("m",1));
		array.add(new Student("d",5));
		array.add(new Student("e",-10));
		array.sort((e1,e2)->e1.age-e2.age);//关注这种简便用法
		for(Student i:array)
		System.out.println(i.name);
		
		
	}
	

	//ps:integer转int -》 int i=j.intValue();  
	public static void Arraysort1(Integer[] array) {//匿名内部类 注意数组声明成Integer
		Arrays.sort(array,new Comparator<Integer>() {
			public int compare(Integer i,Integer j) {
				return j-i;
			}
		});
		//return array;
	}
	
	public static void Arraysort2(ArrayList<Student> array) {//jdk8之后可用lambda表达式
		Comparator<Student> c=(Student t1,Student t2)->((Student) t1).getAge()-((Student) t2).getAge();
		Collections.sort(array, c);
	}
}
