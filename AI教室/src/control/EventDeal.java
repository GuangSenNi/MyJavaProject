package control;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;

public class EventDeal implements ActionListener{

	JFrame f;
	
	public EventDeal(JFrame f) {
		super();
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand()=="年度人流量折线图") {
			chart ct = new chart();
		    ChartPanel chartf = new ChartPanel(ct.freeChart,true);
		    f.add(chartf, BorderLayout.CENTER);
		    f.setVisible(true);
		}else if(e.getActionCommand()=="本周人流量柱形图") {
			BarChart b=new BarChart();
			f.add(b.getChartPanel(), BorderLayout.CENTER);
		    f.setVisible(true);
		}else if(e.getActionCommand()=="") {
			
		}else if(e.getActionCommand()=="") {
			
		}
		
	}

	
}
