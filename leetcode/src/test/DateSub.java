package test;

import java.util.Scanner;

public class DateSub {

	 static int[][][] date=new int[5001][13][32];
	    static int[][] mon={{0,0},{31,31},{28,29},{31,31},{30,30},{31,31},{30,30},{31,31},{31,31},
	                 {30,30},{31,31},{30,30},{31,31}};
	    public static void main(String[] args){
	        Scanner sn=new Scanner(System.in);
	        String s1=sn.nextLine();
	        String s2=sn.nextLine();
	        help1();
	        sn.close();
	        System.out.println(Math.abs(help(s1)-help(s2))+1);
	    }
	    static int help(String s){
	        int year=Integer.parseInt(s.substring(0,4));
	        int month=Integer.parseInt(s.substring(4,6));
	        int day=Integer.parseInt(s.substring(6,8));
	        return date[year][month][day];
	    }
	    static void help1(){
	        int y=0,m=1,d=1,p=0,i=0;
	        while(y<5000){
	            i++;
	            if(y%100!=0&&y%4==0||y%400==0){
	                p=1;
	            }else{p=0;}
	            d++;
	            if(d>mon[m][p]){
	                d=1;
	                m++;
	                if(m>12){
	                    m=1;
	                    y++;
	                }
	            }
	            date[y][m][d]=i;
	        }
	    }
	
}
