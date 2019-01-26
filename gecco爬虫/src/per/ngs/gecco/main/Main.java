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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(str+"start");
        GeccoEngine.create()
           //工程的包路径
           .classpath("per.ngs.gecco")
           //开始抓取的页面地址
           .start("http://jobsky.csu.edu.cn/Home/ArticleDetails/"+str)
           //开启几个爬虫线程
           .thread(1)
           //单个爬虫每次抓取完一个请求后的间隔时间
           .interval(200)
           //使用pc端userAgent
           .mobile(false)
           //开始运行
           .start();
   }
}
