package per.ngs.gecco.main;

import java.io.BufferedReader;
import java.io.FileReader;

import com.geccocrawler.gecco.GeccoEngine;

public class Main {
	public static void main(String[] args) {
		String str="";
		try {
			BufferedReader bfr=new BufferedReader(new FileReader("E:/Temp/log.txt"));
			str=bfr.readLine();			
			bfr.close();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println(str+"start");
        GeccoEngine.create()
           //���̵İ�·��
           .classpath("per.ngs.gecco")
           //��ʼץȡ��ҳ���ַ
           .start("http://jobsky.csu.edu.cn/Home/ArticleDetails/"+str)
           //�������������߳�
           .thread(1)
           //��������ÿ��ץȡ��һ�������ļ��ʱ��
           .interval(200)
           //ʹ��pc��userAgent
           .mobile(false)
           //��ʼ����
           .start();
   }
}
