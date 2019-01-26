package myFire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UImain extends JPanel{

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		UImain u=new UImain();
		u.initUI();
	}
	private JFrame f = new JFrame();
	private JPanel jpanelEast=new JPanel();
	private ArrayList<Cell> pointColor=new ArrayList<Cell>();
	private EventListen eventListen=new EventListen(f, this, pointColor);
	private void jpanelEast() {
		jpanelEast.setPreferredSize(new Dimension(40, 0));
		jpanelEast.setOpaque(false);
		Color[] btnGroup= {Color.red,Color.green,Color.yellow};
		for(Color i:btnGroup) {
			JButton jbt=new JButton();
			jbt.setBackground(i);
			jbt.setPreferredSize(new Dimension(25, 25));
			jbt.addActionListener(eventListen);
			jpanelEast.add(jbt);
		}
		f.add(jpanelEast, BorderLayout.EAST);
	}
	
	private void initUI() {
		f.setSize(480, 300);
		f.setLocationRelativeTo(null);
		this.setOpaque(false);//���͸��
		f.setUndecorated(true);//������ȥ��װ�ο�
		f.setBackground(new Color(0, 0, 0, 0));//����͸��
		//f.setOpacity(0.5f);//��������ݶ�͸��
		f.add(this,BorderLayout.CENTER);
		jpanelEast();
		this.addMouseListener(eventListen);
		this.addMouseMotionListener(eventListen);
		f.setVisible(true);		
	}
	
	public synchronized void paint(Graphics g) {
		//˫����
		BufferedImage img = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = img.createGraphics();
		//���û���Ϊ͸��
		img = g2.getDeviceConfiguration().createCompatibleImage(this.getWidth(),this.getHeight(), Transparency.TRANSLUCENT);
		g2.dispose();
		g2 = img.createGraphics();
		for(int i=0;i<pointColor.size();i++) {
			Cell cell=pointColor.get(i);
			if(i%2==0&&cell.getAge()<=30)cell.move3();
			else if(i%2==1&&cell.getAge()<=30)cell.move2();
			g2.setColor(new Color(cell.getRgb().getRed(), 
					cell.getRgb().getGreen(), cell.getRgb().getBlue()));
			g2.fillOval(cell.getX(), cell.getY(),3, 3);
			//if(cell.getAge()>30)pointColor.remove(i);
		}
		g.drawImage(img, 0, 0, null);
    }
}
