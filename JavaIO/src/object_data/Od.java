package object_data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Od {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Od o=new Od();
		o.RWobject("src/student.txt", "src/student.txt");
	}
	public void RWobject(String str1,String str2) {
		try {
			OutputStream out=new FileOutputStream(str2);
			ObjectOutputStream oout=new ObjectOutputStream(out);
			Student s1=new Student(123, 10, "Tomy");
			oout.writeObject(s1);
			oout.close();
			out.close();
			InputStream in=new FileInputStream(str1);
			ObjectInputStream oin=new ObjectInputStream(in);
			//System.out.println(oin.readObject());读的时候光标定位，所以读两次会出错
			Student s2=(Student) oin.readObject();
			System.out.println(s2);//重写toString 才能输出文字
			oin.close();
			in.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public void RWData(String str1,String str2) {
		try {
			OutputStream out=new FileOutputStream(str2);
			DataOutputStream dout =new DataOutputStream(out);
			dout.writeInt(11);
			dout.writeByte('h');
			dout.writeUTF("hello*");
			dout.close();
			out.close();
			
			InputStream in=new FileInputStream(str1);//读写需要按相同顺序，否则会出错
			DataInputStream din=new DataInputStream(in);
			System.out.println(din.readInt());
			System.out.println((char)din.readByte());
			System.out.println(din.readUTF());
			din.close();
			in.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
