package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;

import view.MainFrame;

public class ButtonController implements ActionListener, MouseListener {
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
				case "btHard":
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
	
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			for(ButtonListener bl : client) {
				switch (e.getComponent().getName()) {
					case "itemNewGame":
						bl.abrogateGame();
						break;
					case "itemPause":
						bl.switchCard(MainFrame.Card.pause);
						WindowManager.chrono.pause();
						break;
					case "itemContinue":
						bl.switchCard(MainFrame.Card.game);
						WindowManager.chrono.pause();
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
				}
			}
		}
	}
	public void mouseEntered(MouseEvent e) { //required but useless
	}
	public void mouseExited(MouseEvent e) { //required but useless
	}
	public void mousePressed(MouseEvent e) { //required but useless
	}
	public void mouseReleased(MouseEvent e) { //required but useless
	}
}