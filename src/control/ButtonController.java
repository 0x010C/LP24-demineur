package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import view.MainFrame;

public class ButtonController implements ActionListener {
	private ArrayList<ButtonListener> client = new ArrayList<ButtonListener>();
	
	public void add(ButtonListener bl) {
		this.client.add(bl);
	}
	
	public void actionPerformed(ActionEvent e) {
		for(ButtonListener bl : client) {
			switch (e.getActionCommand()) {
				case "btEasy":
					bl.startGame(8, 8, 10);
					break;
				case "btMedium":
					bl.startGame(16, 16, 40);
					break;
				case "btDifficult":
					bl.startGame(30, 16, 99);
					break;
				case "btCustom":
					bl.switchCard(MainFrame.Card.custom);
					break;
				case "btInfinite":
					break;
				case "itemNewGame":
					bl.abrogateGame();
					break;
				case "itemPause":
					bl.switchCard(MainFrame.Card.pause);
					break;
				case "itemContinue":
					bl.switchCard(MainFrame.Card.game);
					break;
				case "itemRules":
					bl.openFrame(WindowManager.Frame.rules);
					break;
				case "itemAbout":
					bl.openFrame(WindowManager.Frame.about);
					break;
				case "itemScore":
					bl.openFrame(WindowManager.Frame.score);
					break;
				case "itemQuit":
					System.exit(0);
					break;
				case "customCancel":
					bl.switchCard(MainFrame.Card.start);
					break;
				case "customOK":
					String param[] = ((JButton) e.getSource()).getName().split("#");
					bl.startGame((int)Integer.valueOf(param[0]), (int)Integer.valueOf(param[1]), (int)Integer.valueOf(param[2]));
					break;
			}
		}
	}
}