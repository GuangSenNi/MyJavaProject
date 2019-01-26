package control;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class chart {
	// 步骤1：创建CategoryDataset对象（准备数据） 
	CategoryDataset dataset = createDataset();  
	// 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置  
	JFreeChart freeChart = createChart(dataset); 
	//根据CategoryDataset创建JFreeChart对象
	public static JFreeChart createChart(CategoryDataset categoryDateset){
		// 创建JFreeChart对象：ChartFactory.createLineChart  
		JFreeChart jfreechart = ChartFactory.createLineChart("Human flow changes", // 标题
				"quarter",         //categoryAxisLabel （category轴，横轴，X轴标签）
				"number/m",      // valueAxisLabel（value轴，纵轴，Y轴的标签）
				categoryDateset,  //Dataset  
				PlotOrientation.VERTICAL, true, // legend 
				false,          //Tooltips
				false);        //URLs

		// 使用CategoryPlot设置各种参数。  
		CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();  
		// 背景色 透明度  
		plot.setBackgroundAlpha(0.5f);  
		// 前景色 透明度  
		plot.setForegroundAlpha(0.7f);  
		// 其他设置 参考 CategoryPlot类  
		/* LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();  
        renderer.setBaseShapesVisible(true); // series 点（即数据点）可见  
        renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见  
        renderer.setUseSeriesOffset(true); // 设置偏移量  
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
