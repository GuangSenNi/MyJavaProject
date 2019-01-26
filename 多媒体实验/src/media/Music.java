package media;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class Music extends Thread{

	static AudioClip audioClip = null;
	public void run() {
		
		//将file转换为url
		try {
			audioClip = Applet.newAudioClip(new URL("file:TheClassic.wav"));
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//循环播放	播放一次可以使用audioClip.play
		audioClip.loop();
		System.out.println("开始音乐播放");
		
	}
	public void stopMusic() {
		audioClip.stop();
	}
}
