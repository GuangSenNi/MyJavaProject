package javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Test t=new Test();
		t.BFR3("src/javaio/Test.java","src/javaio/Test.txt");
	}
	
	
	public void Fread(String str) {
		try {
			//�ֽڶ�
			FileInputStream fin=new FileInputStream(str);
			int size=fin.available();
			byte[] b=new byte[size];//��������
			fin.read(b);
			Fwriter("src/javaio/test.txt", b);
			fin.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public void Fwriter(String str,byte[] b) {
		try {
			//�ֽ�д
			FileOutputStream fout =new FileOutputStream(str);
			fout.write(b);
			fout.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public void FRW(String str1,String str2) {
		try {
			FileInputStream fin=new FileInputStream(str1);
			FileOutputStream fout =new FileOutputStream(str2);
			int i=fin.read();//���ֽڶ�
			while((char)i!=-1) {
				fout.write(i);
				i=fin.read();
			}
			fin.close();
			fout.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public void BFR(String str1,String str2) {// �������������
		try {
			FileInputStream fin=new FileInputStream(str1);
			FileOutputStream fout =new FileOutputStream(str2);
			BufferedInputStream bfin=new BufferedInputStream(fin);
			BufferedOutputStream bfout=new BufferedOutputStream(fout);
			int size =bfin.available();
			System.out.println(size);
			byte[] b=new byte[size];
			bfin.read(b);
			bfin.close();
			bfout.write(b);
			bfout.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public void BFR2(String str1,String str2) {
		try {
			FileInputStream fin=new FileInputStream(str1);
			FileOutputStream fout =new FileOutputStream(str2);
			BufferedInputStream bfin=new BufferedInputStream(fin);
			BufferedOutputStream bfout=new BufferedOutputStream(fout);
			int i=bfin.read();
			while(i!=-1) {
				bfout.write(i);
				i=bfin.read();
			}
			bfin.close();
			bfout.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	public void BFR3(String str1,String str2) {//readline
		try {
			BufferedReader bfr=new BufferedReader(new InputStreamReader(new FileInputStream(str1)));
			BufferedReader bfr1=new BufferedReader(new FileReader(str1));
			BufferedWriter bfw=new BufferedWriter(new FileWriter(str2));
			String str=bfr1.readLine();
			while(str!=null) {
				System.out.println(str);
				bfw.write(str);
				bfw.newLine();//�½�һ��
				str=bfr1.readLine();
			}
			bfr.close();
			bfr1.close();
			bfw.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
