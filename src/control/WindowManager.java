package control;

import view.MainFrame;

public class WindowManager implements ButtonControllerListener {

	private MainFrame mainFrame;
	private ButtonController bc;
	private MainFrame.Card currentCard;
	
	public WindowManager() {
		mainFrame = new MainFrame();
		bc = new ButtonController();
		bc.add(this);
		mainFrame.setButtonListener(bc);

		this.currentCard = MainFrame.Card.start;
		mainFrame.switchCard(currentCard);
	}
	
	/* ButtonControllerListener */
	
	public void startGame(int sizeX, int sizeY, int nbBombes) {
		this.currentCard = MainFrame.Card.game;
		mainFrame.switchCard(currentCard);
	}
	
}
