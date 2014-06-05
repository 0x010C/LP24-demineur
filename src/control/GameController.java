package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import view.CasePanel;

public class GameController implements MouseListener {
	private ArrayList<GameControllerListener> client = new ArrayList<GameControllerListener>();

	public void add(GameControllerListener gcl) {
		this.client.add(gcl);
	}
	

	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			String xy[] = e.getComponent().getName().split("#");
			for(GameControllerListener gcl : client) {
				gcl.revealing(Integer.valueOf(xy[0]), Integer.valueOf(xy[1]));
			}
		}
		else if(e.getButton() == MouseEvent.BUTTON3) {
			String xy[] = e.getComponent().getName().split("#");
			for(GameControllerListener gcl : client) {
				gcl.flagging(Integer.valueOf(xy[0]), Integer.valueOf(xy[1]));
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
