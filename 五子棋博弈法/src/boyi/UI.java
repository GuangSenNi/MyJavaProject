package boyi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class UI extends JPanel{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		UI u=new UI();
		u.showUI();
	}
	public int[][] table=new int[15][15] ;
	public void showUI() {
		JFrame jf=new JFrame("五子棋博弈");
		jf.setSize(700,630);
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);

		this.setPreferredSize(new Dimension(600, 0));
		this.setBackground(Color.yellow);
		jf.add(this, BorderLayout.CENTER);
		
		moni m=new moni(this, table);
		JPanel jp=new JPanel(new GridLayout(10,1));
		jp.setBackground(Color.yellow);
		jp.setPreferredSize(new Dimension(100, 0));
		jf.add(jp, BorderLayout.EAST);
		String[] btname= {"开始","悔棋","人机","人人"};
		ButtonGroup bg=new ButtonGroup();
		for(int i=0;i<btname.length;i++) {
			if(i<2) {
				JButton bt =new JButton(btname[i]);
				jp.add(bt);
				bt.addActionListener(m);
			}else {
				JRadioButton jr=new JRadioButton(btname[i]);
				jr.setSelected(true);
				jr.setOpaque(false); 
				bg.add(jr);
				jp.add(jr);
			}
		}
		this.addMouseListener(m);
		jf.setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<15;i++) {
			g.setColor(Color.black);
			g.drawLine(20, 20+40*i, 580, 20+40*i);
			g.drawLine(20+40*i, 20, 20+40*i, 580);
			for(int j=0;j<15;j++) {
				if(table[i][j]==1) {
					g.setColor(Color.black);
					g.fillOval(i*40, j*40, 40, 40);
				}else if(table[i][j]==-1) {
					g.setColor(Color.WHITE);
					g.fillOval(i*40, j*40, 40, 40);
				}
			}
		}
	}
}
