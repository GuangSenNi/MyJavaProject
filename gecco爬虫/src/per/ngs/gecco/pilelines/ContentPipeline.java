package per.ngs.gecco.pilelines;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;

import per.ngs.gecco.dao.Content;
import per.ngs.gecco.daomain.ContentDaomain;

@PipelineName(value="ContentPipeline")

public class ContentPipeline implements Pipeline<Content>{

	private String title;
	private String url;
	private String time;
	private String location;
	private String major;
	private String code;
	ContentDaomain contentdomain=new ContentDaomain();
	public boolean compareDate(String date) {
		Calendar calendar = Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int mon=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DATE);
		int y=Integer.parseInt(date.substring(0, 4));
		int m=Integer.parseInt(date.split("年")[1].split("月")[0]);
		int d=Integer.parseInt(date.split("月")[1].split("日")[0]);
		//System.out.println(y+":"+m+":"+d);
		String h=date.substring(date.length()-5, date.length());
		this.time=y+"-"+m+"-"+d+" "+h;
		if(y>year)return true;
		if(year==y) {
			if(m>mon)return true;
			if(m==mon) {
				if(d>day)return true;
			}
		}
		return false;
	}
	@Override
	public synchronized void process(Content content) {
		// TODO 自动生成的方法存根
		System.out.println("run ContentPipeline");

		title=content.getTitle();
		time=content.getTime();
		//job=content.getJob();
		location=content.getLocation();
		major=content.getMajor();
		code=content.getCode();
		url="http://jobsky.csu.edu.cn/Home/ArticleDetails/"+code;
		int c=Integer.parseInt(code);
		//if(c<19196) { 添加任务
		c++;
		url="http://jobsky.csu.edu.cn/Home/ArticleDetails/"+c;
		HttpRequest currRequest = content.getRequest();
		SchedulerContext.into(currRequest.subRequest(url));
		//}
		synchronized(this){  
		try {
			BufferedWriter bfw=new BufferedWriter(new FileWriter("E:/Temp/log.txt"));
			bfw.write(code);
			bfw.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		}
		System.out.println(code+title);
		if(title==null) {
			System.exit(0);
		}
		if(time!=null&&location!=null) {
			time=time.substring(5);
			location=location.substring(5);	
			if(compareDate(time)&&location.startsWith("中南大学校本部")) {
				String[] temp=major.split(",");
				for(String str:temp) {
					contentdomain.insertData(title, url, str, time,location);
				}
				//System.out.println(title+"@"+time+"@"+code);
			}

		}

	}

}
