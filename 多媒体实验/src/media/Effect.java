package media;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

public class Effect extends Thread{

	JPanel jp;
	Graphics g;
	private int[] posArr;
	private Random random = new Random();
	static boolean pause=true;
	public void run() {
		int width=jp.getWidth();
		int height=jp.getHeight();
		int gap=20;
		int lines;
		int columns;
		lines = height / gap;
        columns = width / gap;
        posArr = new int[columns + 1];
        random = new Random();
        for (int i = 0; i < posArr.length; i++) {
            posArr[i] = random.nextInt(lines);
        }
        g=jp.getGraphics();
        while(pause) {
        	BufferedImage img = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
    		Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("TimesRoman", Font.BOLD, 7));
            g2d.fillRect(0, 0, width, height);
            // 当前列
            int currentColumn = 0;
            for (int x = 0; x < width; x += gap) {
            	int endPos = posArr[currentColumn];
                g2d.setColor(Color.CYAN);
                g2d.drawString(String.valueOf(getChr()), x, endPos * gap);
                int cg = 0;
                for (int j = endPos - 8; j < endPos; j++) {
                    // 颜色渐变
                    cg += 25;
                    if (cg > 255) {
                        cg = 255;
                    }
                    g2d.setColor(new Color(0, cg, 0));
                    g2d.drawString(String.valueOf(getChr()), x, j * gap);
                }
             // 每放完一帧，当前列上雨点的位置随机下移1~5行
                posArr[currentColumn] += random.nextInt(3);
                // 当雨点位置超过屏幕高度时，重新产生一个随机位置
                if (posArr[currentColumn] * gap > height) {
                    posArr[currentColumn] = random.nextInt(lines);
                }
                currentColumn++;
            }
            g.drawImage(img, 0, 0, jp);
            try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        }
		
		
	}
	private char getChr() {
        return (char) (random.nextInt(94) + 33);
    }
	public Effect(JPanel jp) {
		super();
		this.jp = jp;
	}
	public void Pause() {
		pause=false;
	}
}
