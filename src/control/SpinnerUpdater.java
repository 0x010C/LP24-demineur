package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class SpinnerUpdater implements FocusListener {
	private ArrayList<SpinnerUpdaterListener> client = new ArrayList<SpinnerUpdaterListener>();
	
	public void add(SpinnerUpdaterListener sul) {
		this.client.add(sul);
	}
	
	public void focusLost(FocusEvent e) {
		for(SpinnerUpdaterListener sul : client) {
			sul.update();
		}
	}
	public void focusGained(FocusEvent e) {//useless but required
		for(SpinnerUpdaterListener sul : client) {
			sul.update();
		}
	}
}
