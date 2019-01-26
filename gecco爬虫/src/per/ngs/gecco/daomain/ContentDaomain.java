package per.ngs.gecco.daomain;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;

public class ContentDaomain extends DaoSupport{

	private HashMap<String,String> map=new HashMap<String,String>(70);
	public ContentDaomain() {
		map.put("测控技术与仪器", "信息科学与工程学院");
		map.put("电气工程及其自动化", "信息科学与工程学院");
		map.put("电子信息工程", "信息科学与工程学院");
		map.put("通信工程", "信息科学与工程学院");
		map.put("自动化", "信息科学与工程学院");
		map.put("计算机科学与技术", "信息科学与工程学院");
		map.put("信息安全", "信息科学与工程学院");
		map.put("物联网工程", "信息科学与工程学院");
		map.put("智能科学与技术", "信息科学与工程学院");
		map.put("材料化学", "粉末冶金研究院");
		map.put("粉体材料科学与工程", "粉末冶金研究院");
		map.put("行政管理", "公共管理学院");
		map.put("社会学", "公共管理学院");
		map.put("劳动与社会保障", "公共管理学院");
		map.put("航空航天工程", "航空航天学院");
		map.put("探测制导与控制技术", "航空航天学院");
		map.put("材料科学与工程", "材料科学与工程学院");
		map.put("化学工程与工艺", "化学化工学院");
		map.put("制药工程", "化学化工学院");
		map.put("应用化学", "化学化工学院");
		map.put("软件工程", "软件学院");
		map.put("数学与应用数学", "数学与统计学院");
		map.put("信息与计算科学", "数学与统计学院");
		map.put("统计学", "数学与统计学院");
		map.put("环境工程", "冶金与环境学院");
		map.put("新能源材料与器件", "冶金与环境学院");
		map.put("采矿工程", "资源与安全工程学院");
		map.put("安全工程", "资源与安全工程学院");
		map.put("城市地下空间工程", "资源与安全工程学院");
		map.put("应用物理学", "物理与电子学院");
		map.put("电子信息科学与技术", "物理与电子学院");
		map.put("汉语言文学", "文学院");
		map.put("广播电视学", "文学院");
		map.put("机械设计制造及其自动化", "机电工程学院");
		map.put("微电子制造工程", "机电工程学院");
		map.put("车辆工程", "机电工程学院");
		map.put("地质工程", "地球科学与信息物理学院");
		map.put("地球信息科学与技术", "地球科学与信息物理学院");
		map.put("测绘工程", "地球科学与信息物理学院");
		map.put("地理信息科学", "地球科学与信息物理学院");
		map.put("遥感科学与技术", "地球科学与信息物理学院");
		map.put("生物医学工程", "地球科学与信息物理学院");
		map.put("能源与动力工程", "能源科学与工程学院");
		map.put("建筑环境与能源应用工程", "能源科学与工程学院");
		map.put("新能源科学与工程", "能源科学与工程学院");
		map.put("法学", "法学院");
		map.put("英语", "外国语学院");
		map.put("法语", "外国语学院");
		map.put("日语", "外国语学院");
		map.put("建筑学", "建筑与艺术学院");
		map.put("城市规划", "建筑与艺术学院");
		map.put("艺术设计", "建筑与艺术学院");
		map.put("工业设计", "建筑与艺术学院");
		map.put("音乐表演", "建筑与艺术学院");
		map.put("矿物加工工程", "资源加工与生物工程学院");
		map.put("无机非金属材料工程", "资源加工与生物工程学院");
		map.put("生物工程", "资源加工与生物工程学院");
		map.put("生物技术", "资源加工与生物工程学院");
		map.put("国际经济与贸易", "商学院");
		map.put("金融学", "商学院");
		map.put("信息管理与信息系统", "商学院");
		map.put("工商管理", "商学院");
		map.put("会计学", "商学院");
		map.put("财务管理", "商学院");
		map.put("电子商务", "商学院");
		//删除过时信息
		Calendar calendar = Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);
		int mon=calendar.get(Calendar.MONTH)+1;
		int day=calendar.get(Calendar.DATE)-1;
		String date=year+"-"+mon+"-"+day+" 12:00:00";
		//System.out.println(date);
		String sql="delete from arrange where unix_timestamp(ctime)<unix_timestamp('"+
				date+"');";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			this.close();
		}
	}
	
	public void insertData(String cname,String url,String cmajor,String ctime,String location) {
		String academic=map.get(cmajor);
		if(academic==null) {
			academic="不限制";
		}
		String sql = 
				"insert into Arrange values (null,'"+academic+
				"','进校招聘','','"+cmajor+"','"+cname+"','"+ctime+"','"
						+location+"','D','中南大学','"+url+"');";
		//System.out.println(sql);
		try {
			statement.executeUpdate(sql);
			//System.out.println(c);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			this.close();
		}
	}
}
