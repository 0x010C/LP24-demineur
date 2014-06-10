package control;

import java.util.ArrayList;

import model.Case;

public class UpdateDisplayController {
	private ArrayList<UpdateDisplayListener> client = new ArrayList<UpdateDisplayListener>();

	public void add(UpdateDisplayListener udl) {
		this.client.add(udl);
	}
	
	public void updateCase(int x, int y, Case.Content content, Case.State state) {
		for(UpdateDisplayListener udl : client) {
			udl.updateCase(x, y, content, state);
		}
	}
	
	public void loose() {
		for(UpdateDisplayListener udl : client) {
			udl.loose();
		}
	}
	
	public void win() {
		for(UpdateDisplayListener udl : client) {
			udl.win();
		}
	}
}
