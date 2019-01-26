package per.ngs.gecco.dao;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

@SuppressWarnings("serial")
@Gecco(matchUrl="http://jobsky.csu.edu.cn/Home/ArticleDetails/{code}",pipelines="ContentPipeline")
public class Content implements HtmlBean{
	@Request
    private HttpRequest request;
	@Text
	@HtmlField(cssPath="#title > h1")
    private String title;
	@Text
	@HtmlField(cssPath="#placeAndTime > p.text-center.time")
    private String time;
	@Text
	@HtmlField(cssPath="#placeAndTime > p.text-center.place")
    private String location;
	
	//@HtmlField(cssPath="")
    //private String url;
	@Text
	@HtmlField(cssPath="#demand > table > tbody > tr:nth-child(3) > td:nth-child(2)")
    private String major;
	@Text
	@HtmlField(cssPath="#demand > table > tbody > tr:nth-child(5) > td:nth-child(2)")
    private String job;
	@RequestParameter
    private String code;
	
	public Content() {
		super();
		System.out.println("¹¹Ôìº¯Êý");
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public HttpRequest getRequest() {
		return request;
	}
	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
