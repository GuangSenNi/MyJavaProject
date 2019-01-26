package mainui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Label;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ui extends JPanel{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Ui u=new Ui();
		u.mainUI();

	}
	public int[][] moni ;
	public void mainUI() {
		JFrame jf=new JFrame("五子棋");
		jf.setSize(700,630);
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);

		this.setPreferredSize(new Dimension(600, 0));
		this.setBackground(Color.yellow);
		jf.add(this, BorderLayout.CENTER);

		JPanel jp=new JPanel();
		jp.setBackground(Color.yellow);
		jp.setPreferredSize(new Dimension(100, 0));
		jf.add(jp, BorderLayout.EAST);
		String[] btname= {"开始","悔棋","模式:","人机","人人"};

		moni=new int[16][16];
		lisen lis=new lisen(this,moni);
		ButtonGroup bg=new ButtonGroup();
		for(int i=0;i<btname.length;i++) {
			if(i<2) {
				JButton bt =new JButton(btname[i]);
				bt.setPreferredSize(new Dimension(90, 50));
				jp.add(bt);
				bt.addActionListener(lis);
			}else if(i==2) {
				Label l=new Label(btname[i]);
				l.setPreferredSize(new Dimension(90, 50));
				jp.add(l);
			}else {
				JRadioButton jr=new JRadioButton(btname[i]);
				jr.setPreferredSize(new Dimension(90, 30));
				jr.setSelected(true);
				jr.setOpaque(false); 
				bg.add(jr);
				jp.add(jr);
				jr.addItemListener(lis);
			}
		}
		
		this.addMouseListener(lis);
		jf.setVisible(true);
	}
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<=15;i++) {
			g.setColor(Color.black);
			g.drawLine(20, 20+40*i, 580, 20+40*i);
			g.drawLine(20+40*i, 20, 20+40*i, 580);
			for(int j=0;j<=15;j++) {
				if(moni[i][j]==1) {
					g.setColor(Color.black);
					g.fillOval(i*40, j*40, 40, 40);
				}else if(moni[i][j]==-1) {
					g.setColor(Color.WHITE);
					g.fillOval(i*40, j*40, 40, 40);
				}
			}
		}

	}

	public int isend(int[][] moni,int x,int y) {
		int sign=1;
		for(int i=y;i<15;i++) {//向下
			if(moni[x][i]==moni[x][i+1]) {
				sign++;
				if(sign==5) {
					return moni[x][i];
				}
			}else {
				//sign=1;
				break;
			}
		}
		for(int i=y;i>0;i--) {//向上
			if(moni[x][i]==moni[x][i-1]) {
				sign=sign+1;
				if(sign==5) {
					return moni[x][i];
				}
			}else {
				sign=1;
				break;
			}
		}
		for(int i=x;i<15;i++) {//向右
			if(moni[i][y]==moni[i+1][y]) {
				sign++;
				if(sign==5) {
					return moni[i][y];
				}
			}else {
				//sign=1;
				break;
			}
		}
		for(int i=x;i>0;i--) {//向左
			if(moni[i][y]==moni[i-1][y]) {
				sign++;
				if(sign==5) {
					return moni[i][y];
				}
			}else {
				sign=1;
				break;
			}
		}
		for(int i=x;i>0;i--) {//向左下
			if(moni[i][y+x-i]==moni[i-1][y+x-i+1]) {
				sign++;
				if(sign==5) {
					return moni[x][y];
				}
			}else {
				//sign=1;
				break;
			}
		}
		for(int i=x;i<15;i++) {//向右上
			if(y-i+x-1>=0&&moni[i][y-i+x]==moni[i+1][y-i+x-1]) {
				sign++;
				if(sign==5) {
					return moni[x][y];
				}
			}else {
				sign=1;
				break;
			}
		}
		for(int i=x;i>0;i--) {//向左上
			if(y-x+i-1>=0&&moni[i][y-x+i]==moni[i-1][y-x+i-1]) {
				sign++;
				if(sign==5) {
					return moni[x][y];
				}
			}else {
				//sign=1;
				break;
			}
		}
		for(int i=x;i<15;i++) {//向右下
			if(moni[i][y+i-x]==moni[i+1][y+i-x+1]) {
				sign++;
				if(sign==5) {
					return moni[x][y];
				}
			}else {
				sign=1;
				break;
			}
		}return 0;
	}

}
