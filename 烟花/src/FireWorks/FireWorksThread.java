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
	// �����������и���ͼƬ������
	Image img = Toolkit.getDefaultToolkit().createImage("333.png");
	// �������ӵĶ���
	private ArrayList<Particle> pr = new ArrayList<>();
	// ��ʼλ��
	private int startX = 300, startY = 500;

	public FireWorksThread(JPanel panel) {
		this.panel = panel;
	}

	public void setStartXY(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	public void run() {
		// ʱ������
		double dt = 0.1d;
		while (true) {
			// ������
			g = panel.getGraphics();

			// �������ӷ�������
			Particle tp = new Particle();
			tp.position = new VecT(startX, startY);
			tp.velocity = new VecT(10, -20);// �ٶ�����
			tp.acceleration = sampleDirection();
			tp.life = 30;
			tp.age = 1;
			tp.color = new Color(255, 0, 255);
			tp.size = 12;
			pr.add(tp);

			// �����е����ӻ������������ٻ���������
			Image image = panel.createImage(panel.getWidth(), panel.getHeight());
			Graphics2D bg = (Graphics2D) image.getGraphics();

			bg.setColor(Color.black);
			// bg.setColor(new Color(16316137));
			bg.fillRect(0, 0, panel.getWidth(), panel.getHeight());// ������
			bg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			for (int i = 0; i < pr.size(); ++i) {
				Particle p = pr.get(i);
				// 1.�ж����ӵ������Ƿ��ڣ����ں󣬴��������Ƴ�
				p.age += dt;
				if (p.age >= p.life) {
					pr.remove(i);
				}
				// 2.����ÿ�����ӵ���һ��λ��
				int r = p.color.getRGB();
				r -= 1000;
				Color c = new Color(r);
				p.color = c;
				// �ж��Ƿ���ײ��ǽ
				isrebound(p);
				p.position = p.position.add(p.velocity.multiply(dt));
				p.velocity = p.velocity.add(p.acceleration.multiply(dt));
				// ����������
				bg.setColor(p.color);
				// bg.drawImage(img, p.getX(), p.getY(), 50, 50, null);
				bg.fillOval(p.getX(), p.getY(), p.size, p.size);
			}
			// ������ͼƬ���������
			g.drawImage(image, 0, 0, panel);
			try {
				Thread.sleep(10);
			} catch (Exception ef) {
			}
		}
	}

	// ����������ǽ�󷴵�
	public static void isrebound(Particle p) {
		if (p.getX() <= 0 || p.getX() >= panel.getWidth())
			p.velocity.x *= -1;
		if (p.getY() <= 0)
			p.velocity.y *= -1;
	}

	// ����һ���������
	public static VecT sampleDirection() {
		double theta = Math.random() * 2 * Math.PI;
		return new VecT((Math.cos(theta)), (Math.sin(theta)));
	}
}
