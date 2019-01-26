package boyi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;



public class moni extends MouseAdapter implements ActionListener{
	private UI u1;
	private Graphics g;
	private int[][] table;
	private static int l=99999,h=-99999;
	private boolean m=true;
	private Boyi b;
	private static int x1,y1;
	public moni(UI u1, int[][] table) {
		super();
		this.u1 = u1;
		this.table = table;
	}

	public void mouseReleased(MouseEvent e) {
		if(g==null) {
			g=u1.getGraphics();
		}
		
		x1 = e.getX();
		y1 = e.getY();
		if(table[x1/40][y1/40]==1||table[x1/40][y1/40]==-1) {
			JOptionPane.showMessageDialog(u1,"勿重复落子");
			System.out.println("勿重复落子");
			return;
		}else {
			if(m) {
				g.setColor(Color.black);
				g.fillOval(x1/40*40, y1/40*40, 40, 40);
				m=!m;
				table[x1/40][y1/40]=-1;
			}else {
				g.setColor(Color.WHITE);
				g.fillOval(x1/40*40, y1/40*40, 40, 40);
				m=!m;
				table[x1/40][y1/40]=1;
			}
		}
		b=new Boyi(table);
		
		myAI();
		//System.out.println(b.getMark(table));
		/*
		if(b.isEnd(x1/40, y1/40)) {
			System.out.println("end");
		}*/
	}

	public void myAI(){ 
        Node node=new Node();  
        Boyi.tree(0,node,h,l);  
        Point p1=node.bestChild.p; 
        //System.out.println(node.mark);
        if((int)Math.abs(node.mark)==99999) {
        	JOptionPane.showMessageDialog(u1, "end");
        	for(int i=0;i<15;i++) {
        		for(int j=0;j<15;j++) {
        			table[i][j]=0;
        		}
        	}
        	u1.repaint();
        	m=true;
        	return;
        }if(node.mark==0) {
        	int m1=x1/40+1,n1=y1/40;
        	while(table[m1][n1]!=0) {
        		m1++;
        	}
        	 if(m) {
     			g.setColor(Color.black);
     			g.fillOval(m1*40, n1*40, 40, 40);
     			m=!m;
     			table[m1][n1]=-1;
     		}else {
     			g.setColor(Color.WHITE);
     			g.fillOval(m1*40, n1*40, 40, 40);
     			m=!m;
     			table[m1][n1]=1;
     		}
        	 return;
        }
        if(m) {
			g.setColor(Color.black);
			g.fillOval(p1.x*40, p1.y*40, 40, 40);
			m=!m;
			table[p1.x][p1.y]=-1;
		}else {
			g.setColor(Color.WHITE);
			g.fillOval(p1.x*40, p1.y*40, 40, 40);
			m=!m;
			table[p1.x][p1.y]=1;
		}
		
    }  
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getActionCommand()=="开始") {
			for(int i=0;i<15;i++) {
        		for(int j=0;j<15;j++) {
        			table[i][j]=0;
        		}
        	}
			u1.repaint();
		}
	}
}
