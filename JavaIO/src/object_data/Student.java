package object_data;

import java.io.Serializable;

public class Student implements Serializable{//序列化才能用objectoutputstream

	private int sno;
	private transient int age;//transient不序列该变量
	private String sname;
	public Student(int sno, int age, String sname) {
		super();
		this.sno = sno;
		this.age = age;
		this.sname = sname;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
