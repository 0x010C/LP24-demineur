package control;

import view.AboutFrame;
import view.MainFrame;
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
	private GameManager gameManager;
	public static GameController gc;
	public static UpdateDisplayController udc;
	
	private int sizeX;
	private int sizeY;
	private int nbBombs;
	
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
	
	public void startGame(int sizeX, int sizeY, int nbBombs) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbBombs = nbBombs;
		
		this.gameManager = new GameManager(this.sizeX, this.sizeY, this.nbBombs);
		WindowManager.gc = new GameController();
		this.gameManager.setController(gc);
		WindowManager.udc = new UpdateDisplayController();
		
		this.mainFrame.initGamePanel(sizeX, sizeY);
		this.mainFrame.setSize(sizeX*37+20, sizeY*37+200+20); //TODO: mettre une meilleur taille
		this.currentCard = MainFrame.Card.game;
		this.mainFrame.switchCard(currentCard);
		
		
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
		
		if(this.currentCard == MainFrame.Card.game) {
			this.switchCard(MainFrame.Card.pause);
		}
	}
}
