package control;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class BarChart {
	ChartPanel frame1;  
    public  BarChart(){  
        CategoryDataset dataset = getDataSet();  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                             "������", // ͼ�����  
                            "ʱ��", // Ŀ¼�����ʾ��ǩ  
                            "����", // ��ֵ�����ʾ��ǩ  
                            dataset, // ���ݼ�  
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
                            false,          // �Ƿ����ɹ���  
                            false           // �Ƿ�����URL����  
                            );  
          
        //�����￪ʼ  
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������  
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�  
         domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����  
         domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����  
         ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״  
         rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));  
          chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
            
          //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������  
            
         frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame  
           
    }  
       private static CategoryDataset getDataSet() {  
    	   String[] rowKeys = {"��","��","��"};  
           String[] colKeys = {"Spring","Summer","Autumn","Winter"};  
           double[][] data = {{5.4,1,6,2},{4.2,2,5,1},{4,1,4,1.5},};   
           //System.out.println(TimeChat.btime_Heap);
           return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);   
}  
public ChartPanel getChartPanel(){  
    return frame1;  
      
}  
}
