package media;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Monitor extends Thread implements ActionListener{

	Image[] card;
	JPanel jp;
	public Monitor(Image[] card, JPanel jp) {
		super();
		this.card = card;
		this.jp = jp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		Music music=new Music();
		Effect effect=new Effect(jp);
		String command=e.getActionCommand();
		if(command.equals("Ԥ��")) {
			readIMG();
		}else if(command.equals("��ӳ")) {
			this.start();;
		}else if(command.equals("��Ч")) {		
			effect.start();
		}else if(command.equals("��ͣ")) {		
			effect.Pause();
		}else if(command.equals("����")) {
			music.start();
		}else if(command.equals("����")) {
			music.stopMusic();
		}
	}
	
	void readIMG() {
		for(int i=0;i<5;i++) {
			try {
				String url="imgs/"+i+".jpg";
				Image image = ImageIO.read(new File(url));
				card[i]=image;
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				System.out.println("����Ƭʧ��");
			}
		}
		System.out.println("����Ƭ�ɹ�");
	}

	void drawPIC() {
		Graphics g=jp.getGraphics();
		int width=jp.getWidth();
		int height=jp.getHeight();
		for(int i=0;i<5;i++) {
			g.drawImage(card[i], 0, 0, width, height, jp);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		drawPIC();
	}
}
