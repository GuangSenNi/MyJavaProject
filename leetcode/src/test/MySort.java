package test;
import java.util.Arrays;
import java.util.*;
public class MySort {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ArrayList<Student> array =new ArrayList<Student>();
		array.add(new Student("c",18));
		array.add(new Student("m",1));
		array.add(new Student("d",5));
		array.add(new Student("e",-10));
		array.sort((e1,e2)->e1.age-e2.age);//��ע���ּ���÷�
		for(Student i:array)
		System.out.println(i.name);
		
		
	}
	

	//ps:integerתint -�� int i=j.intValue();  
	public static void Arraysort1(Integer[] array) {//�����ڲ��� ע������������Integer
		Arrays.sort(array,new Comparator<Integer>() {
			public int compare(Integer i,Integer j) {
				return j-i;
			}
		});
		//return array;
	}
	
	public static void Arraysort2(ArrayList<Student> array) {//jdk8֮�����lambda���ʽ
		Comparator<Student> c=(Student t1,Student t2)->((Student) t1).getAge()-((Student) t2).getAge();
		Collections.sort(array, c);
	}
}
