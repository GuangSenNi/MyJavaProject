package FireWorks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class FireWorksThread extends Thread {
	private static JPanel panel;
	Graphics g;
	// 终于在这里有个画图片的例子
	Image img = Toolkit.getDefaultToolkit().createImage("333.png");
	// 保存粒子的队列
	private ArrayList<Particle> pr = new ArrayList<>();
	// 起始位置
	private int startX = 300, startY = 500;

	public FireWorksThread(JPanel panel) {
		this.panel = panel;
	}

	public void setStartXY(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	public void run() {
		// 时间增量
		double dt = 0.1d;
		while (true) {
			// 画背景
			g = panel.getGraphics();

			// 生成粒子放入链表
			Particle tp = new Particle();
			tp.position = new VecT(startX, startY);
			tp.velocity = new VecT(10, -20);// 速度向量
			tp.acceleration = sampleDirection();
			tp.life = 30;
			tp.age = 1;
			tp.color = new Color(255, 0, 255);
			tp.size = 12;
			pr.add(tp);

			// 链表中的粒子画到缓冲区，再画到界面上
			Image image = panel.createImage(panel.getWidth(), panel.getHeight());
			Graphics2D bg = (Graphics2D) image.getGraphics();

			bg.setColor(Color.black);
			// bg.setColor(new Color(16316137));
			bg.fillRect(0, 0, panel.getWidth(), panel.getHeight());// 画背景
			bg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			for (int i = 0; i < pr.size(); ++i) {
				Particle p = pr.get(i);
				// 1.判断粒子的生命是否到期，到期后，从链表中移除
				p.age += dt;
				if (p.age >= p.life) {
					pr.remove(i);
				}
				// 2.计算每个粒子的下一个位置
				int r = p.color.getRGB();
				r -= 1000;
				Color c = new Color(r);
				p.color = c;
				// 判断是否碰撞到墙
				isrebound(p);
				p.position = p.position.add(p.velocity.multiply(dt));
				p.velocity = p.velocity.add(p.acceleration.multiply(dt));
				// 画到缓冲区
				bg.setColor(p.color);
				// bg.drawImage(img, p.getX(), p.getY(), 50, 50, null);
				bg.fillOval(p.getX(), p.getY(), p.size, p.size);
			}
			// 将缓冲图片画到面板上
			g.drawImage(image, 0, 0, panel);
			try {
				Thread.sleep(10);
			} catch (Exception ef) {
			}
		}
	}

	// 让粒子碰到墙后反弹
	public static void isrebound(Particle p) {
		if (p.getX() <= 0 || p.getX() >= panel.getWidth())
			p.velocity.x *= -1;
		if (p.getY() <= 0)
			p.velocity.y *= -1;
	}

	// 生成一个随机方向
	public static VecT sampleDirection() {
		double theta = Math.random() * 2 * Math.PI;
		return new VecT((Math.cos(theta)), (Math.sin(theta)));
	}
}
