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
		// TODO �Զ����ɵķ������
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
			//System.out.println(oin.readObject());����ʱ���궨λ�����Զ����λ����
			Student s2=(Student) oin.readObject();
			System.out.println(s2);//��дtoString �����������
			oin.close();
			in.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
			
			InputStream in=new FileInputStream(str1);//��д��Ҫ����ͬ˳�򣬷�������
			DataInputStream din=new DataInputStream(in);
			System.out.println(din.readInt());
			System.out.println((char)din.readByte());
			System.out.println(din.readUTF());
			din.close();
			in.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
