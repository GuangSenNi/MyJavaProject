package test;

import java.util.Scanner;
public class Main {
	
	
	static int level(int sum){
		if(sum>=50 && sum<=149)
			return 1;
		if(sum>=150 && sum<=249)
			return 2;
		if(sum>=250 &&sum<=349)
			return 3;
		if(sum>=350 && sum<=449)
			return 4;
		if(sum>=450 && sum<=549)
			return 5;
		if(sum>=550 && sum<=649)
			return 6;
		if(sum>=650 && sum<=749)
			return 7;
		if(sum>=750)
			return 8;
		else
		return 0;
	}
	
	static int  calculate(String s){
		int tmp=0;
		int ans=0;
		if(s.length()<=5)
			for(int i=0;i<s.length();i++){
				tmp=tmp+10;
				ans+=tmp;
			}
		if(s.length()>5){
			ans=150; int tmp2=0;
			for(int i=0;i<s.length()-5;i++)
				{tmp2=tmp2+10;
			      ans+=tmp2;}
			
		}
		
		return ans;
		
	}
 
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0){
			int n=sc.nextInt();
			if(n==0)continue;
			String str=sc.next();
			String s[]=str.split("0");
			int ans=0;
			for(int i=0;i<s.length;i++){
				ans+=calculate(s[i]);
			}
			//System.out.println("ans"+ans);
			System.out.println(level(ans));
			
		}
		      sc.close();
	}
	}

