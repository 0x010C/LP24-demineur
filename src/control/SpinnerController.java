package control;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class SpinnerController implements FocusListener {
	private ArrayList<SpinnerListener> client = new ArrayList<SpinnerListener>();
	
	public void add(SpinnerListener sl) {
		this.client.add(sl);
	}
	
	public void focusLost(FocusEvent e) {
		for(SpinnerListener sl : client) {
			sl.update();
		}
	}
	public void focusGained(FocusEvent e) {//useless but required
		for(SpinnerListener sl : client) {
			sl.update();
		}
	}
}