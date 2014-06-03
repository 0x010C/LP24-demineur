package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonController implements ActionListener {
	private ArrayList<ButtonControllerListener> client = new ArrayList<ButtonControllerListener>();
	
	public void add(ButtonControllerListener bcl) {
		this.client.add(bcl);
	}
	
	public void actionPerformed(ActionEvent e) {
		for(ButtonControllerListener bcl : client) {
			switch (e.getActionCommand()) {
				case "btEasy":
					break;
				case "btMedium":
					break;
				case "btDifficult":
					break;
				case "btCustom":
					break;
				case "btInfinite":
					break;
				case "itemRules":
					break;
				case "itemAbout":
					break;
				case "itemScore":
					break;
				case "itemQuit":
					break;
			}
		}
	}
}