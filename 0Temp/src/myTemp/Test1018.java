package myTemp;

import java.util.Calendar;
public class Test1018 {
	static String ss="";
	public static void main(String[] args) {
		String s1="2018年11月3日 11:20";
		Calendar calendar = Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int mon=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DATE);
		System.out.println(year);
		System.out.println(mon);
		System.out.println(day);
		System.out.println(compareDate(s1,year,mon,day));
		System.out.println(ss);
	}
	public static boolean compareDate(String date,int year,int mon,int day) {
		int y=Integer.parseInt(date.substring(0, 4));
		int m=Integer.parseInt(date.split("年")[1].split("月")[0]);
		int d=Integer.parseInt(date.split("月")[1].split("日")[0]);
		String h=date.substring(date.length()-5, date.length());
		//System.out.println(y+"-"+m+"-"+d+" "+h);
		ss=y+"-"+m+"-"+d+" "+h;
		if(y>year)return true;
		if(year==y) {
			if(m>mon)return true;
			if(m==mon) {
				if(d>day)return true;
			}
		}
		return false;
	}
}
class Student{
	String name ;
	int id;
	public Student(int id,String name) {
		this.id=id;
		this.name=name;
	}
}
