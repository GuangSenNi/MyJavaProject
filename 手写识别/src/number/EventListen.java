package number;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventListen extends MouseAdapter implements ActionListener{

	private static int x,y,x1,y1,right=-1,left=-1,top=-1,bottom=-1;
	private JPanel jpanel;
	public JLabel jlabel;
	public JComboBox<Integer> comboBox;
	private Graphics g;
	private Graphics2D g1,g2;
	private static BufferedImage smallimage;
	private ArrayList<Point> pointgroup=new ArrayList<Point>(); 
	private BYS bys=new BYS();
	public EventListen(JPanel jpanel,JLabel jlabel,JComboBox<Integer> comboBox) {
		super();
		this.jpanel = jpanel;
		this.jlabel=jlabel;
		this.comboBox=comboBox;
		initPic();
	}
	
	public void initPic() {
		smallimage=new BufferedImage(20,
				20, BufferedImage.TYPE_BYTE_GRAY);
		g1=smallimage.createGraphics();
		g1.setColor(Color.white);
		g1.fillRect(0,0,20,20);
	}

	public void DrawOnBigPic() {
		if(g==null) {
			g=jpanel.getGraphics();
			g2=(Graphics2D) g;
		}
		g2.setStroke(new BasicStroke(8));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);// 设置画笔开启抗锯齿
		Point point=new Point(x, y);
		pointgroup.add(point);
		g2.setColor(Color.black);
		g2.drawLine(x1, y1, x, y);
		x1=x;
		y1=y;
	}
	public static void initBorder() {
		right=-1;
		left=-1;
		top=-1;
		bottom=-1;
	}
	public static void findBorder() {
		if(x<left||left==-1)left=x;
		if(x>right||right==-1)right=x;
		if(y<top||top==-1)top=y;
		if(y>bottom||bottom==-1)bottom=y;
		
	}
	public void mouseDragged(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		x=arg0.getX();
		y=arg0.getY();
		findBorder();
		DrawOnBigPic();
	}
	
	public void mousePressed(MouseEvent e) {
		x1=e.getX();
		y1=e.getY();
		pointgroup.clear();
		Point point=new Point(x1, y1);
		pointgroup.add(point);
	}

	public void drawOnSmallPic() {
		g1.setColor(Color.black);
		g1.setStroke(new BasicStroke(2));
		int a,b,c,d,rl,tb;
		float li;
		rl=right-left;
		tb=bottom-top;
		li=Math.max(tb, rl);
		//System.out.println(left+":"+right+":"+top+":"+bottom);
		for(int i=0;i<pointgroup.size()-1;i++) {
			a=(int) ((pointgroup.get(i).getX()-left)/li*20);
			b=(int) ((pointgroup.get(i).getY()-top)/li*20);
			c=(int) ((pointgroup.get(i+1).getX()-left)/li*20);
			d=(int) ((pointgroup.get(i+1).getY()-top)/li*20);
			g1.drawLine(a,b,c,d);
			//System.out.println(a+":"+b+":"+c+":"+d);
		}
		g.drawImage(smallimage, 0, 0, null);
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		drawOnSmallPic();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand().equals("train")) {
			//System.out.println(comboBox.getSelectedItem());
			bys.trainData(smallimage, (int) comboBox.getSelectedItem());
			clearPanel();
		}else if(e.getActionCommand().equals("test")) {
			int result=bys.test(smallimage);
			jlabel.setText(""+result);
			clearPanel();
		}else if(e.getActionCommand().equals("clear")) {
			clearPanel();
		}else if(e.getActionCommand().equals("save")) {
			bys.save();
		}else if(e.getActionCommand().equals("read")) {
			bys.readData();
		}
	}
	public void clearPanel() {
		g1.setColor(Color.white);
		g1.fillRect(0,0,20,20);
		g.setColor(Color.white);
		g.fillRect(0, 0, 300, 300);
		initBorder();
	}
}
