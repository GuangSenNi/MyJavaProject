package test;
import java.util.*;
public class LCS {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner s=new Scanner(System.in);
		String s1=s.nextLine();
		s.close();
		findRise(s1);
	}

	static void findRise(String s) {//�����������
		String[] array=s.split(" ");
		int[] arr=new int[array.length];
		arr[0]=1;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<i;j++) {
				//System.out.println(s.length());
				int a=Integer.parseInt(array[i]);
				int b=Integer.parseInt(array[j]);
				if(b<a) {
					arr[i]=arr[j]+1;
				}
			}
		}
		int max=-999;
		for(int i:arr) {
			max=Math.max(i, max);
		}
		System.out.println(max);
	}
	
	static void maxValue(String s) {//����������е����ֵ�����뺬��ֵ
		String[] array=s.split(" ");
		int max=0;
		for(String i:array) {
			int t=Integer.parseInt(i);
			if(max<0)max=0;
			max+=t;
		}
		System.out.println(max);
	}
	//������Ӵ� �Ӵ���ĸǰ��˳��һ������һ������
	static String findLongest(String s1,String s2) {
		int a=s1.length();
		int b=s2.length();
		int[][] temp=new int[a+1][b+1];
		StringBuffer sbf=new StringBuffer("");
		int mark=-1,t=-1;
		for(int i=0;i<s1.length();i++) {
			for(int j=0;j<s2.length();j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					temp[i+1][j+1]=temp[i][j]+1;
					t=i;
				}else {
					temp[i+1][j+1]=Math.max(temp[i+1][j], temp[i][j+1]);
				}
			}
			if(mark<temp[i+1][b]) {
				mark=temp[i+1][b];
				sbf.append(s1.charAt(t));
			}
		}
		String out=sbf.toString();
		System.out.println("�������Ϊ��"+out+"������Ϊ��"+temp[a][b]);
		return out;
	}
}
