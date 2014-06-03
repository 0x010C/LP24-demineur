package control;

import view.MainFrame;
import view.AboutFrame;
import view.RulesFrame;
import view.ScoreFrame;

public class WindowManager implements ButtonControllerListener {
	public enum Frame {
		main,
		about,
		rules,
		score
	}
	
	private MainFrame mainFrame;
	private RulesFrame rulesFrame;
	private AboutFrame aboutFrame;
	private ScoreFrame scoreFrame;
	private ButtonController bc;
	private MainFrame.Card currentCard;
	
	public WindowManager() {
		mainFrame = new MainFrame();
		bc = new ButtonController();
		bc.add(this);
		mainFrame.setButtonListener(bc);

		this.currentCard = MainFrame.Card.start;
		mainFrame.switchCard(currentCard);
		
		// Define the rules' frame
		rulesFrame = new RulesFrame();
				
		// Define the about's frame
		aboutFrame = new AboutFrame();
		
		// Define the score's frame
		scoreFrame = new ScoreFrame();
	}
	
	/* ButtonControllerListener */
	
	public void startGame(int sizeX, int sizeY, int nbBombes) {
		mainFrame.initGamePanel(sizeX, sizeY);
		
		this.currentCard = MainFrame.Card.game;
		mainFrame.switchCard(currentCard);
	}
	
	public void switchCard(MainFrame.Card newCard) {
		this.mainFrame.switchCard(newCard);
	}
	
	public void openFrame(WindowManager.Frame frame) {
		switch(frame) {
		case about:
			aboutFrame.setVisible(true);
			break;
		case rules:
			rulesFrame.setVisible(true);
			break;
		case score:
			scoreFrame.setVisible(true);
			break;
		default:
			break;
		}
		//TODO: si le jeu est lancé (currentCard = game), passer en pause
	}
}
