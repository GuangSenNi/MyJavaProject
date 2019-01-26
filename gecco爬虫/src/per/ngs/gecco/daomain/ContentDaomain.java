package per.ngs.gecco.daomain;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;

public class ContentDaomain extends DaoSupport{

	private HashMap<String,String> map=new HashMap<String,String>(70);
	public ContentDaomain() {
		map.put("��ؼ���������", "��Ϣ��ѧ�빤��ѧԺ");
		map.put("�������̼����Զ���", "��Ϣ��ѧ�빤��ѧԺ");
		map.put("������Ϣ����", "��Ϣ��ѧ�빤��ѧԺ");
		map.put("ͨ�Ź���", "��Ϣ��ѧ�빤��ѧԺ");
		map.put("�Զ���", "��Ϣ��ѧ�빤��ѧԺ");
		map.put("�������ѧ�뼼��", "��Ϣ��ѧ�빤��ѧԺ");
		map.put("��Ϣ��ȫ", "��Ϣ��ѧ�빤��ѧԺ");
		map.put("����������", "��Ϣ��ѧ�빤��ѧԺ");
		map.put("���ܿ�ѧ�뼼��", "��Ϣ��ѧ�빤��ѧԺ");
		map.put("���ϻ�ѧ", "��ĩұ���о�Ժ");
		map.put("������Ͽ�ѧ�빤��", "��ĩұ���о�Ժ");
		map.put("��������", "��������ѧԺ");
		map.put("���ѧ", "��������ѧԺ");
		map.put("�Ͷ�����ᱣ��", "��������ѧԺ");
		map.put("���պ��칤��", "���պ���ѧԺ");
		map.put("̽���Ƶ�����Ƽ���", "���պ���ѧԺ");
		map.put("���Ͽ�ѧ�빤��", "���Ͽ�ѧ�빤��ѧԺ");
		map.put("��ѧ�����빤��", "��ѧ����ѧԺ");
		map.put("��ҩ����", "��ѧ����ѧԺ");
		map.put("Ӧ�û�ѧ", "��ѧ����ѧԺ");
		map.put("�������", "���ѧԺ");
		map.put("��ѧ��Ӧ����ѧ", "��ѧ��ͳ��ѧԺ");
		map.put("��Ϣ������ѧ", "��ѧ��ͳ��ѧԺ");
		map.put("ͳ��ѧ", "��ѧ��ͳ��ѧԺ");
		map.put("��������", "ұ���뻷��ѧԺ");
		map.put("����Դ����������", "ұ���뻷��ѧԺ");
		map.put("�ɿ󹤳�", "��Դ�밲ȫ����ѧԺ");
		map.put("��ȫ����", "��Դ�밲ȫ����ѧԺ");
		map.put("���е��¿ռ乤��", "��Դ�밲ȫ����ѧԺ");
		map.put("Ӧ������ѧ", "���������ѧԺ");
		map.put("������Ϣ��ѧ�뼼��", "���������ѧԺ");
		map.put("��������ѧ", "��ѧԺ");
		map.put("�㲥����ѧ", "��ѧԺ");
		map.put("��е������켰���Զ���", "���繤��ѧԺ");
		map.put("΢�������칤��", "���繤��ѧԺ");
		map.put("��������", "���繤��ѧԺ");
		map.put("���ʹ���", "�����ѧ����Ϣ����ѧԺ");
		map.put("������Ϣ��ѧ�뼼��", "�����ѧ����Ϣ����ѧԺ");
		map.put("��湤��", "�����ѧ����Ϣ����ѧԺ");
		map.put("������Ϣ��ѧ", "�����ѧ����Ϣ����ѧԺ");
		map.put("ң�п�ѧ�뼼��", "�����ѧ����Ϣ����ѧԺ");
		map.put("����ҽѧ����", "�����ѧ����Ϣ����ѧԺ");
		map.put("��Դ�붯������", "��Դ��ѧ�빤��ѧԺ");
		map.put("������������ԴӦ�ù���", "��Դ��ѧ�빤��ѧԺ");
		map.put("����Դ��ѧ�빤��", "��Դ��ѧ�빤��ѧԺ");
		map.put("��ѧ", "��ѧԺ");
		map.put("Ӣ��", "�����ѧԺ");
		map.put("����", "�����ѧԺ");
		map.put("����", "�����ѧԺ");
		map.put("����ѧ", "����������ѧԺ");
		map.put("���й滮", "����������ѧԺ");
		map.put("�������", "����������ѧԺ");
		map.put("��ҵ���", "����������ѧԺ");
		map.put("���ֱ���", "����������ѧԺ");
		map.put("����ӹ�����", "��Դ�ӹ������﹤��ѧԺ");
		map.put("�޻��ǽ������Ϲ���", "��Դ�ӹ������﹤��ѧԺ");
		map.put("���﹤��", "��Դ�ӹ������﹤��ѧԺ");
		map.put("���＼��", "��Դ�ӹ������﹤��ѧԺ");
		map.put("���ʾ�����ó��", "��ѧԺ");
		map.put("����ѧ", "��ѧԺ");
		map.put("��Ϣ��������Ϣϵͳ", "��ѧԺ");
		map.put("���̹���", "��ѧԺ");
		map.put("���ѧ", "��ѧԺ");
		map.put("�������", "��ѧԺ");
		map.put("��������", "��ѧԺ");
		//ɾ����ʱ��Ϣ
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			this.close();
		}
	}
	
	public void insertData(String cname,String url,String cmajor,String ctime,String location) {
		String academic=map.get(cmajor);
		if(academic==null) {
			academic="������";
		}
		String sql = 
				"insert into Arrange values (null,'"+academic+
				"','��У��Ƹ','','"+cmajor+"','"+cname+"','"+ctime+"','"
						+location+"','D','���ϴ�ѧ','"+url+"');";
		//System.out.println(sql);
		try {
			statement.executeUpdate(sql);
			//System.out.println(c);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			this.close();
		}
	}
}
