package mainui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class lisen extends MouseAdapter implements ItemListener,ActionListener{

	private Ui u1;
	private Graphics g;
	private boolean m=true;
	private boolean n=true;
	private int[][] moni;
	private ArrayList<Integer>arr1=new ArrayList<Integer>();
	private ArrayList<Integer>arr2=new ArrayList<Integer>();
	
	public lisen(Ui u1,int[][] moni) {
		this.u1 = u1;
		this.moni=moni;		
	}

	public void mouseReleased(MouseEvent e) {
		if(g==null) {
			g=u1.getGraphics();
		}
		int x1,y1;
		x1 = e.getX();
		y1 = e.getY();
		
		if(moni[x1/40][y1/40]==1||moni[x1/40][y1/40]==-1) {
			System.out.println("勿重复落子");
		}else {
			if(m) {
				g.setColor(Color.black);
				g.fillOval(x1/40*40, y1/40*40, 40, 40);
				m=false;
				moni[x1/40][y1/40]=1;
			}else {
				g.setColor(Color.WHITE);
				g.fillOval(x1/40*40, y1/40*40, 40, 40);
				m=true;
				moni[x1/40][y1/40]=-1;
			}
			arr1.add(x1/40);
			arr2.add(y1/40);

			int m1=u1.isend(moni, x1/40, y1/40);			
			if(m1==1) {
				JOptionPane.showMessageDialog(u1, "黑棋胜");
				System.out.println("黑棋胜");
				reshow();
				return;
			}else if(m1==-1) {
				JOptionPane.showMessageDialog(u1, "白棋胜");
				System.out.println("白棋胜");
				reshow();
				return;
			}
			
			if(n) {
				AIchess ai=new AIchess(moni);
				int a1[]=ai.ai();
				if(m) {
					g.setColor(Color.black);
					g.fillOval(a1[0]*40, a1[1]*40, 40, 40);
					m=false;
					moni[a1[0]][a1[1]]=1;
				}else {
					g.setColor(Color.WHITE);
					g.fillOval(a1[0]*40, a1[1]*40, 40, 40);
					m=true;
					moni[a1[0]][a1[1]]=-1;
				}
				int m2=u1.isend(moni, a1[0], a1[1]);
				arr1.add(a1[0]);
				arr2.add(a1[1]);
				if(m2==1) {
					JOptionPane.showMessageDialog(u1, "黑棋胜");
					System.out.println("黑棋胜");
					reshow();
				}else if(m2==-1) {
					JOptionPane.showMessageDialog(u1, "白棋胜");
					System.out.println("白棋胜");
					reshow();
				}
			}
		}	
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自动生成的方法存根
		JRadioButton jr=(JRadioButton) e.getSource();
		if(jr.getText()=="人机"&&jr.isSelected()) {
			n=true;
		}else if(jr.getText()=="人人"&&jr.isSelected()) {
			n=false;
		}
		
	}

	public void reshow() {
		for(int i=0;i<16;i++) {
			for(int j=0;j<16;j++) {
				moni[i][j]=0;
			}
		}
		arr1=new ArrayList<Integer>();
		arr2=new ArrayList<Integer>();
		u1.repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		JButton bt=(JButton) e.getSource();
		if(bt.getText()=="开始") {
			reshow();
		}else if(bt.getText()=="悔棋") {
			int a,b;
			a=arr1.remove(arr1.size()-1);
			b=arr2.remove(arr2.size()-1);
			moni[a][b]=0;
			m=!m;
			u1.repaint();
		}
	}

}
