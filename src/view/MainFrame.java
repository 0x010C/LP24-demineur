package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* For more details, see the graph of the interface */
public class MainFrame extends JFrame {
	
	public enum Card {
		start,
		custom,
		game,
		pause
	}
	
	private static final long serialVersionUID = 354054054054L;
	
	private int width = 700;
	private int height = 310;
	private int minWidth = 700;
	private int minHeight = 310;
	private int logoWidth = 700;
	private int logoHeight = 100;
	
	public static int realUsableWidth;
	public static int realUsableHeight;
	
	private JPanel menuPanel;
	private JMenuBar menuBar;
	private JPanel logoPanel;
	private ImagePanel logo;
	private JPanel card;
	
	private JMenuItem itemNewGame;
	private JMenuItem itemPause;
	private JMenuItem itemRules;
	private JMenuItem itemAbout;
	private JMenuItem itemScore;
	private JMenuItem itemQuit;
	
	private CardLayout cardLayout;
	private StartPanel startPanel;
	private CustomPanel customPanel;
	private GamePanel gamePanel;
	private PausePanel pausePanel;
	
	public MainFrame() {
		/* Define the screen size and location */
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setBounds((int) (toolkit.getScreenSize().getWidth()-this.width)/2,(int) (toolkit.getScreenSize().getHeight()-this.height)/2,this.width,this.height);
		this.setMinimumSize(new Dimension(this.minWidth,this.minHeight));
		
		/* Global Panel */
		this.getContentPane().setLayout(new BorderLayout());
		menuPanel = new JPanel();
		menuBar = new JMenuBar();
		logoPanel = new JPanel();
		logo = new ImagePanel("images/png/logo.png", this.logoWidth, this.logoHeight);
		card = new JPanel();
		
		this.getContentPane().add(BorderLayout.NORTH, menuPanel);
		this.getContentPane().add(BorderLayout.CENTER, card);
		
		/* Menu Panel */
		menuPanel.setLayout(new BorderLayout());
		
		// Creation of menus and items
		itemNewGame = new JMenuItem(new ImageIcon("images/png/newgame.png"));
		itemPause = new JMenuItem(new ImageIcon("images/png/pause.png"));
		itemRules = new JMenuItem(new ImageIcon("images/png/rules.png"));
		itemAbout = new JMenuItem(new ImageIcon("images/png/about.png"));
		itemScore = new JMenuItem(new ImageIcon("images/png/score.png"));
		itemQuit = new JMenuItem(new ImageIcon("images/png/quit.png"));
		
		// Setting the ActionCommand of the items
		itemNewGame.setActionCommand("itemNewGame");
		itemPause.setActionCommand("itemPause");
		itemRules.setActionCommand("itemRules");
		itemAbout.setActionCommand("itemAbout");
		itemScore.setActionCommand("itemScore");
		itemQuit.setActionCommand("itemQuit");
		
		// Setting the ToolTip of the items
		itemNewGame.setToolTipText("New Game");
		itemPause.setToolTipText("Pause");
		itemRules.setToolTipText("Rules");
		itemAbout.setToolTipText("About");
		itemScore.setToolTipText("Score");
		itemQuit.setToolTipText("Quit");
		
		// Hidding the background of the items
		itemNewGame.setOpaque(false);
		itemPause.setOpaque(false);
		itemRules.setOpaque(false);
		itemAbout.setOpaque(false);
		itemScore.setOpaque(false);
		itemQuit.setOpaque(false);

		// Disabling some items at the beginning
		itemNewGame.setEnabled(false);
		itemPause.setEnabled(false);
		
		// Adding the items to the menuBar
		menuBar.add(itemNewGame);
		menuBar.add(itemPause);
		menuBar.add(itemRules);
		menuBar.add(itemAbout);
		menuBar.add(itemScore);
		menuBar.add(itemQuit);
		
		// Adding the menuBar to the panel he belongs to
		menuBar.setLayout(new FlowLayout());
		((FlowLayout)menuBar.getLayout()).setAlignment(FlowLayout.LEFT);
		menuPanel.add(BorderLayout.NORTH, menuBar);
		
		/* Setting the logo's parameters */
		logoPanel.setLayout(new FlowLayout());
		logoPanel.add(logo);
		logoPanel.setBackground(Color.white);
		menuPanel.add(BorderLayout.CENTER, logoPanel);
		
		/* Card Panel */
		card.setSize(this.width, this.height-this.logoHeight);
		cardLayout = new CardLayout();
		card.setLayout(cardLayout);

		MainFrame.realUsableHeight = (int)this.getSize().getHeight() - this.logoHeight;
		MainFrame.realUsableWidth = (int)this.getSize().getWidth();
		
		// Define the start's panel
		startPanel = new StartPanel();
		
		// Define the customization's panel
		customPanel = new CustomPanel();
		
		// Define the pause's panel
		pausePanel = new PausePanel();
		
		
		// Adding of the different JPanel
		card.add(startPanel, "start");
		card.add(customPanel, "custom");
		card.add(pausePanel, "pause");
		
		/* Display the window */
		this.setVisible(true);
	}
	
	public void setButtonListener(ActionListener al){
		startPanel.setButtonListener(al);
		customPanel.setButtonListener(al);

		itemNewGame.addActionListener(al);
		itemPause.addActionListener(al);
		itemRules.addActionListener(al);
		itemAbout.addActionListener(al);
		itemScore.addActionListener(al);
		itemQuit.addActionListener(al);
	}
	
	public void switchCard(MainFrame.Card newCard) {
		switch(newCard){
			case start:
				this.cardLayout.show(this.card, "start");
				break;
			case custom:
				cardLayout.show(this.card, "custom");
				break;
			case game:
				cardLayout.show(this.card, "game");
				itemPause.setActionCommand("itemPause");
				itemPause.setIcon(new ImageIcon("images/png/pause.png"));
				itemPause.setToolTipText("Pause");
				break;
			case pause:
				cardLayout.show(this.card, "pause");
				itemPause.setActionCommand("itemContinue");
				itemPause.setIcon(new ImageIcon("images/png/play.png"));
				itemPause.setToolTipText("Continue");
				break;
		}
	}
	
	public void initGamePanel(int sizeX, int sizeY) {
		gamePanel = new GamePanel(sizeX, sizeY);
		this.card.add(gamePanel, "game");
	}
	
	public void setEnableGameItem(boolean b) {
		itemPause.setEnabled(b);
		itemNewGame.setEnabled(b);
	}
	
	public void paint(Graphics g) {
		MainFrame.realUsableHeight = (int)this.getSize().getHeight() - this.logoHeight;
		MainFrame.realUsableWidth = (int)this.getSize().getWidth();
		super.paint(g);
	}
}
