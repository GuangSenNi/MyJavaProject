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
		// TODO �Զ����ɵķ������
		if(e.getActionCommand()=="�������������ͼ") {
			chart ct = new chart();
		    ChartPanel chartf = new ChartPanel(ct.freeChart,true);
		    f.add(chartf, BorderLayout.CENTER);
		    f.setVisible(true);
		}else if(e.getActionCommand()=="��������������ͼ") {
			BarChart b=new BarChart();
			f.add(b.getChartPanel(), BorderLayout.CENTER);
		    f.setVisible(true);
		}else if(e.getActionCommand()=="") {
			
		}else if(e.getActionCommand()=="") {
			
		}
		
	}

	
}
