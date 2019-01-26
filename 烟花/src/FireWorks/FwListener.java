package FireWorks;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FwListener extends MouseAdapter {
	FireWorksThread ft;

	public FwListener(FireWorksThread ft) {
		this.ft = ft;
	}

	public void mouseDragged(MouseEvent e) {
		ft.setStartXY(e.getX(), e.getY());
	}
}
