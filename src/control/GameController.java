package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameController implements MouseListener {
	private ArrayList<GameListener> client = new ArrayList<GameListener>();

	public void add(GameListener gl) {
		this.client.add(gl);
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			String xy[] = e.getComponent().getName().split("#");
			for(GameListener gl : client) {
				gl.revealing(Integer.valueOf(xy[0]), Integer.valueOf(xy[1]));
			}
		}
		else if(e.getButton() == MouseEvent.BUTTON3) {
			String xy[] = e.getComponent().getName().split("#");
			for(GameListener gl : client) {
				gl.flagging(Integer.valueOf(xy[0]), Integer.valueOf(xy[1]));
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
