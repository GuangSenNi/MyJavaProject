package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayToList {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		ArrayList<String> array=new ArrayList<String>();
		array.add("top");
		array.add("cat");
		array.add("hat");
		String[] array2=array.toArray(new String[array.size()]);
		/*for(String s:array)
			System.out.println(s);*/
		tolist2(array2);
	}

	static void tolist(String[] array) {
		ArrayList<String> array3=new ArrayList<String>(Arrays.asList(array));
		System.out.println(array3);
	}
	
	static void tolist2(String[] array) {
		ArrayList<String> array3=new ArrayList<String>(array.length);
		Collections.addAll(array3, array);
		System.out.println(array3);
	}
}
