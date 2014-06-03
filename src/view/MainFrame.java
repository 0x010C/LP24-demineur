package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

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
		
		JPanel menuPanel = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		ImagePanel logo = new ImagePanel("images/png/logo.png", this.logoWidth, this.logoHeight);
		JPanel card = new JPanel();
		
		this.getContentPane().add(BorderLayout.NORTH, menuPanel);
		this.getContentPane().add(BorderLayout.CENTER, card);
		
		/* Menu Panel */
		menuPanel.setLayout(new BorderLayout());
		
		// Creation of menus and items
		JMenu menu1 = new JMenu("MineSweeper");
		JMenuItem itemPause = new JMenuItem("Pause");
		JMenuItem itemRules = new JMenuItem("Rules");
		JMenuItem itemAbout = new JMenuItem("About");
		JMenuItem itemScore = new JMenuItem("Scores");
		JMenuItem itemQuit = new JMenuItem("Quit");
		
		// Adding of the shortcuts
		menu1.setMnemonic('M');
		itemPause.setAccelerator(KeyStroke.getKeyStroke('p'));
		itemAbout.setAccelerator(KeyStroke.getKeyStroke('a'));
		itemRules.setAccelerator(KeyStroke.getKeyStroke('r'));
		itemQuit.setAccelerator(KeyStroke.getKeyStroke('q'));
		itemScore.setAccelerator(KeyStroke.getKeyStroke('s'));
		
		// Adding of the menus and items
		itemPause.setEnabled(false);
		menu1.add(itemPause);
		menu1.addSeparator();
		menu1.add(itemRules);
		menu1.add(itemAbout);
		menu1.add(itemScore);
		menu1.addSeparator();
		menu1.add(itemQuit);
		menuBar.add(menu1);
		menuPanel.add(BorderLayout.NORTH, menuBar);
		menuPanel.add(BorderLayout.CENTER, logo);
		
		/*itemQuit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
			}
		});*/
		
		/* Card Panel */
		card.setSize(this.width, this.height-this.logoHeight);
		CardLayout cardLayout = new CardLayout();
		card.setLayout(cardLayout);
		
		// Define the start's panel
		StartPanel startPanel = new StartPanel();
		
		// Define the customization's panel
		JPanel customizationPanel = new JPanel();
		
		// Define the rules' frame
		RulesFrame rulesFrame = new RulesFrame();
		
		// Define the about's frame
		AboutFrame aboutFrame = new AboutFrame();
		
		// Define the game's panel
		GamePanel gamePanel = new GamePanel(10,10);
		
		// Define the pause's panel
		JPanel pausePanel = new JPanel();
		
		// Define the score's frame
		ScoreFrame scoreFrame = new ScoreFrame();
		
		// Adding of the different JPanel
		card.add(startPanel, "start");
		card.add(customizationPanel, "customization");
		card.add(gamePanel, "game");
		card.add(pausePanel, "pause");
		
		cardLayout.show(card, "start");
		rulesFrame.setVisible(true);
		
		
		/* Display the window */
		this.setVisible(true);
	}
}
