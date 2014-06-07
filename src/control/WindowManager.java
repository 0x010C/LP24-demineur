package control;

import model.Chunk;
import view.AboutFrame;
import view.MainFrame;
import view.RulesFrame;
import view.ScoreFrame;

public class WindowManager implements ButtonListener {
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
	
	public static GameController gc;
	public static UpdateDisplayController udc;
	
	private Chunk chunk;
	private int sizeX;
	private int sizeY;
	private int nbBombs;
	
	public static int iconSize = 32;
	public static int margin = 5;
	
	public WindowManager() {
		/* Initialisation of our Main Frame */
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
	
	/* ButtonListener */
	
	public void startGame(int sizeX, int sizeY, int nbBombs) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbBombs = nbBombs;
		
		WindowManager.gc = new GameController();
		chunk = new Chunk(this.sizeX, this.sizeY, this.nbBombs);
		gc.add(chunk);
		WindowManager.udc = new UpdateDisplayController();
		
		this.mainFrame.initGamePanel(this.sizeX, this.sizeY);
		this.mainFrame.setSize(this.sizeX*37+20, this.sizeY*37+200+20); //TODO: mettre une meilleur taille
		this.mainFrame.setEnableGameItem(true);
		this.currentCard = MainFrame.Card.game;
		this.mainFrame.switchCard(currentCard);
	}
	
	public void abrogateGame() {
		
	}
	
	public void endGame(boolean win) {
		
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
