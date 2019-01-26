package test;

import java.util.*;
public class MyTemp{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		while(s.hasNext()) {
			String str=s.next();
			int count=0;
			for(int i=0;i<str.length();i++) {
				int tem;
				char c=str.charAt(i);
				if(c>='A') {
					tem=c-'A'+10;
				}else {
					tem=c-'0';
				}
				int tem2=1;
				for(int j=0;j<str.length()-i-1;j++) {
					tem2*=16;
				}
				count+=tem2*tem;
			}
			int[] arr=new int[1000000];
			int cal=0;
			while(count!=0) {
				arr[cal]=count%8;
				count/=8;
				cal++;
			}
			cal--;
			while(cal>=0) {
				System.out.print(arr[cal]);
				cal--;
			}
			System.out.print("\n");
		}
		s.close();
	}
}