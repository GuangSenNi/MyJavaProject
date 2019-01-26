package FireWorks;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FireWorksMain extends JPanel {

	public static void main(String[] args) {
		FireWorksMain fw = new FireWorksMain();
		fw.initUI();
	}

	public void initUI() {
		JFrame f = new JFrame();
		f.setTitle("ÑÌ»¨");
		f.setSize(800, 700);
		f.setDefaultCloseOperation(3);
		f.add(this);
		f.setVisible(true);

		FireWorksThread ft = new FireWorksThread(this);
		ft.start();
		FwListener fl=new FwListener(ft);
		this.addMouseMotionListener(fl);
	}

}
