package media;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Music extends Thread{

	static AudioClip audioClip = null;
	public void run() {
		
		//��fileת��Ϊurl
		try {
			audioClip = Applet.newAudioClip(new URL("file:TheClassic.wav"));
		} catch (MalformedURLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//ѭ������	����һ�ο���ʹ��audioClip.play
		audioClip.loop();
		System.out.println("��ʼ���ֲ���");
		
	}
	public void stopMusic() {
		audioClip.stop();
	}
}
