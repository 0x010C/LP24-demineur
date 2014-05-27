import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/* For more details, see the graph of the interface */
public class MainFrame extends JFrame {
	private int width = 700;
	private int height = 280;
	private int minWidth = 700;
	private int minHeight = 280;
	private int logoWidth = 700;
	private int logoHeight = 100;
	
	public MainFrame() {
		/* Define the screen size and location */
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setBounds((int) (toolkit.getScreenSize().getWidth()-this.width)/2,(int) (toolkit.getScreenSize().getHeight()-this.height)/2,this.width,this.height);
		this.setMinimumSize(new Dimension(this.minWidth,this.minHeight));
		
		/* Global Panel */
		this.getContentPane().setLayout(new BorderLayout());
		
		ImagePanel logo = new ImagePanel("images/png/logo.png", this.logoWidth, this.logoHeight);
		JPanel card = new JPanel();
		this.getContentPane().add(BorderLayout.NORTH, logo);
		this.getContentPane().add(BorderLayout.CENTER, card);
		
		/* Card Panel */
		card.setSize(this.width, this.height-this.logoHeight);
		CardLayout cardLayout = new CardLayout();
		card.setLayout(cardLayout);
		
		// Define the start's panel
		StartPanel startPanel = new StartPanel();
		
		// Define the customization's panel
		JPanel customizationPanel = new JPanel();
		
		// Define the rules' panel
		RulesFrame rulesFrame = new RulesFrame();
		
		// Define the about's panel
		AboutFrame aboutFrame = new AboutFrame();
		
		// Define the game's panel
		GamePanel gamePanel = new GamePanel(10,10);
		
		// Define the pause's panel
		JPanel pausePanel = new JPanel();
		
		// Define the score's panel
		JPanel scorePanel = new JPanel();
		
		// Adding of the different JPanel
		card.add(startPanel, "start");
		card.add(customizationPanel, "customization");
		card.add(gamePanel, "game");
		card.add(pausePanel, "pause");
		card.add(scorePanel, "score");
		
		cardLayout.show(card, "start");
		aboutFrame.setVisible(true);
		
		
		/* Display the window */
		this.setVisible(true);
	}
}
