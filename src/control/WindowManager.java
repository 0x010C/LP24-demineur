package control;

import model.Case;
import model.Chunk;
import view.AboutFrame;
import view.MainFrame;
import view.RulesFrame;
import view.ScoreFrame;

public class WindowManager implements ButtonListener, UpdateDisplayListener {
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
	
	private Score score;
	
	private Chunk chunk;
	private int sizeX;
	private int sizeY;
	private int nbBombs;
	
	public static int iconSize = 32;
	public static int margin = 5;
	
	public WindowManager() {
		// Define the rules' frame
		rulesFrame = new RulesFrame();
				
		// Define the about's frame
		aboutFrame = new AboutFrame();
		
		// Define the score's frame
		score = new Score();
		scoreFrame = new ScoreFrame(score);
		
		/* Initialisation of our Main Frame */
		mainFrame = new MainFrame();
		bc = new ButtonController();
		bc.add(this);
		mainFrame.setButtonListener(bc);
		this.currentCard = MainFrame.Card.start;
		mainFrame.switchCard(currentCard);
		this.mainFrame.setResizable(false);
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
		WindowManager.udc.add(this);
		
		this.mainFrame.initGamePanel(this.sizeX, this.sizeY);
		this.mainFrame.setSize(this.sizeX*37+20, this.sizeY*37+200+20); //TODO: mettre une meilleur taille
		this.mainFrame.setEnableGameItem(true);
		this.currentCard = MainFrame.Card.game;
		this.mainFrame.switchCard(currentCard);
		this.mainFrame.setResizable(true);
	}
	
	public void abrogateGame() {
		this.mainFrame.setEnableGameItem(false);
		chunk = null;
		this.currentCard = MainFrame.Card.start;
		this.mainFrame.switchCard(currentCard);
		this.mainFrame.setResizable(false);
		this.mainFrame.setSize(700, 280);
	}
	
	public void endGame(boolean win) {
		if(win) {
			this.score.AddingScore(this.sizeX, this.sizeY, this.nbBombs, 10452);
			this.scoreFrame.selectComboBox(this.sizeX, this.sizeY, this.nbBombs);
			this.scoreFrame.setCurrentScore(10452);
			this.openFrame(WindowManager.Frame.score);
		}
		else {
			
		}
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
	
	/* UpdateDisplayListener */
	public void loose() {
		this.endGame(false);
	}
	public void win() {
		this.endGame(true);
	}
	public void updateCase(int x, int y, Case.Content content, Case.State state) {//required but useless
	}
}
