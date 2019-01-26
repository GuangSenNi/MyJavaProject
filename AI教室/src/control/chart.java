package control;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class chart {
	// ����1������CategoryDataset����׼�����ݣ� 
	CategoryDataset dataset = createDataset();  
	// ����2������Dataset ����JFreeChart�����Լ�����Ӧ������  
	JFreeChart freeChart = createChart(dataset); 
	//����CategoryDataset����JFreeChart����
	public static JFreeChart createChart(CategoryDataset categoryDateset){
		// ����JFreeChart����ChartFactory.createLineChart  
		JFreeChart jfreechart = ChartFactory.createLineChart("Human flow changes", // ����
				"quarter",         //categoryAxisLabel ��category�ᣬ���ᣬX���ǩ��
				"number/m",      // valueAxisLabel��value�ᣬ���ᣬY��ı�ǩ��
				categoryDateset,  //Dataset  
				PlotOrientation.VERTICAL, true, // legend 
				false,          //Tooltips
				false);        //URLs

		// ʹ��CategoryPlot���ø��ֲ�����  
		CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();  
		// ����ɫ ͸����  
		plot.setBackgroundAlpha(0.5f);  
		// ǰ��ɫ ͸����  
		plot.setForegroundAlpha(0.7f);  
		// �������� �ο� CategoryPlot��  
		/* LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();  
        renderer.setBaseShapesVisible(true); // series �㣨�����ݵ㣩�ɼ�  
        renderer.setBaseLinesVisible(true); // series �㣨�����ݵ㣩�������߿ɼ�  
        renderer.setUseSeriesOffset(true); // ����ƫ����  
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true);  */
		return jfreechart;  
	}

	public static CategoryDataset createDataset() {  
		String[] rowKeys = {"am","pm","night"};  
		String[] colKeys = {"Spring","Summer","Autumn","Winter"};  

		double[][] data = {{5.4,1,6,2},{4.2,2,5,1},{4,1,4,1.5},};   
		//System.out.println(TimeChat.btime_Heap);
		return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data); 
	}


}
