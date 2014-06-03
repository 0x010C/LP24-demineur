package control;

import view.MainFrame;

public class WindowManager implements ButtonControllerListener {

	protected MainFrame.Card currentCard;
	
	public WindowManager() {
		MainFrame mainFrame = new MainFrame();
		ButtonController bc = new ButtonController();
		bc.add(this);
		mainFrame.setButtonListener(bc);
	}
	
}
