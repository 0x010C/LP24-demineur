package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import view.MainFrame;

public class ButtonController implements ActionListener {
	private ArrayList<ButtonControllerListener> client = new ArrayList<ButtonControllerListener>();
	
	public void add(ButtonControllerListener bcl) {
		this.client.add(bcl);
	}
	
	public void actionPerformed(ActionEvent e) {
		for(ButtonControllerListener bcl : client) {
			switch (e.getActionCommand()) {
				case "btEasy":
					bcl.startGame(8, 8, 10);
					break;
				case "btMedium":
					bcl.startGame(16, 16, 40);
					break;
				case "btDifficult":
					bcl.startGame(30, 16, 99);
					break;
				case "btCustom":
					bcl.switchCard(MainFrame.Card.custom);
					break;
				case "btInfinite":
					break;
				case "itemRules":((JButton) e.getSource()).getName().split("#");
					bcl.openFrame(WindowManager.Frame.rules);
					break;
				case "itemAbout":
					bcl.openFrame(WindowManager.Frame.about);
					break;
				case "itemScore":
					bcl.openFrame(WindowManager.Frame.score);
					break;
				case "itemQuit":
					System.exit(0);
					break;
				case "customCancel":
					bcl.switchCard(MainFrame.Card.start);
					break;
				case "customOK":
					String param[] = ((JButton) e.getSource()).getName().split("#");
					bcl.startGame((int)Integer.valueOf(param[0]), (int)Integer.valueOf(param[1]), (int)Integer.valueOf(param[2]));
					break;
			}
		}
	}
}