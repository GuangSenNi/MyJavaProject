package test;

import java.util.Scanner;

public class UcBrowser {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner s=new Scanner(System.in);
		int num;
		num=s.nextInt();
		/*s.nextLine();
		for(int i=0;i<num;i++) {
			int n=s.nextInt();
			if(n==0)continue;
			String str=s.next();
			int out=level(str);
			System.out.println(out);	
		}*/
		while(num-->0){
			int n=s.nextInt();
			if(n==0)continue;
			String str=s.next();
			
			//System.out.println("ans"+ans);
			System.out.println(level(str));
			
		}
		s.close();
	}
	
	static int level(String s1) {
		String[] charArray=s1.split("0");
		//int j=0,num=0;
		int tmp=0;
		int num=0;
		for(String s:charArray) {
			if(s.length()<=5)
				for(int i=0;i<s.length();i++){
					tmp=tmp+10;
					num+=tmp;
				}
			if(s.length()>5){
				num=150; int tmp2=0;
				for(int i=0;i<s.length()-5;i++)
					{tmp2=tmp2+10;
				      num+=tmp2;}
				
			}
		}
		
		//System.out.println("num"+num);
		if(num>=50 && num<=149)
			return 1;
		if(num>=150 && num<=249)
			return 2;
		if(num>=250 &&num<=349)
			return 3;
		if(num>=350 && num<=449)
			return 4;
		if(num>=450 && num<=549)
			return 5;
		if(num>=550 && num<=649)
			return 6;
		if(num>=650 && num<=749)
			return 7;
		if(num>=750)
			return 8;
		else
		return 0;
	}

}
