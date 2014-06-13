package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import model.Chrono;
import control.WindowManager;

/* For more details, see the graph of the interface */
public class MainFrame extends JFrame implements ActionListener {
	
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
	private JPanel topMenuPanel;
	private JPanel leftMenuPanel;
	private JPanel rightMenuPanel;
	private JMenuBar menuBar;
	private JPanel logoPanel;
	private ImagePanel logo;
	private JPanel card;
	
	private ImagePanel buttonNewGame;
	private ImagePanel buttonPause;
	private ImagePanel buttonRules;
	private ImagePanel buttonAbout;
	private ImagePanel buttonScore;
	private ImagePanel buttonQuit;
	private JLabel labelScore;
	
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
		topMenuPanel = new JPanel();
		leftMenuPanel = new JPanel();
		rightMenuPanel = new JPanel();
		//menuBar = new JMenuBar();
		logoPanel = new JPanel();
		logo = new ImagePanel("src/images/png/logo.png", this.logoWidth, this.logoHeight);
		card = new JPanel();
		
		this.getContentPane().add(BorderLayout.NORTH, menuPanel);
		this.getContentPane().add(BorderLayout.CENTER, card);
		
		/* Menu Panel */
		menuPanel.setLayout(new BorderLayout());
		
		topMenuPanel.setLayout(new BorderLayout());
		leftMenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		rightMenuPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		topMenuPanel.add(BorderLayout.WEST, leftMenuPanel);
		topMenuPanel.add(BorderLayout.EAST, rightMenuPanel);
		menuPanel.add(BorderLayout.NORTH, topMenuPanel);
		
		buttonNewGame = new ImagePanel("src/images/png/newgame.png");
		buttonPause = new ImagePanel("src/images/png/pause.png");
		buttonRules = new ImagePanel("src/images/png/rules.png");
		buttonAbout = new ImagePanel("src/images/png/about.png");
		buttonScore = new ImagePanel("src/images/png/score.png");
		buttonQuit = new ImagePanel("src/images/png/quit.png");
		labelScore = new JLabel("");
		
		labelScore.setFont(new Font("Liberation Sans", Font.BOLD, 20));
		
		leftMenuPanel.add(buttonNewGame);
		leftMenuPanel.add(buttonPause);
		leftMenuPanel.add(buttonRules);
		leftMenuPanel.add(buttonAbout);
		leftMenuPanel.add(buttonScore);
		leftMenuPanel.add(buttonQuit);
		rightMenuPanel.add(labelScore);
		
		// Setting the ActionCommand of the buttons
		buttonNewGame.setName("itemNewGame");
		buttonPause.setName("itemPause");
		buttonRules.setName("itemRules");
		buttonAbout.setName("itemAbout");
		buttonScore.setName("itemScore");
		buttonQuit.setName("itemQuit");

		// Disabling some items at the beginning
		buttonNewGame.setEnabled(false);
		buttonPause.setEnabled(false);
		
		// Setting the ToolTip of the items
		buttonNewGame.setToolTipText("New Game");
		buttonPause.setToolTipText("Pause");
		buttonRules.setToolTipText("Rules");
		buttonAbout.setToolTipText("About");
		buttonScore.setToolTipText("Score");
		buttonQuit.setToolTipText("Quit");
		
		// Hidding the background of the items
		buttonNewGame.setOpaque(false);
		buttonPause.setOpaque(false);
		buttonRules.setOpaque(false);
		buttonAbout.setOpaque(false);
		buttonScore.setOpaque(false);
		buttonQuit.setOpaque(false);
		
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
		
		Chrono.timer.addActionListener(this);
		
		/* Display the window */
		this.setVisible(true);
	}
	
	public void setButtonListener(EventListener al){
		startPanel.setButtonListener((ActionListener)al);
		customPanel.setButtonListener((ActionListener)al);

		buttonNewGame.addMouseListener((MouseListener)al);
		buttonPause.addMouseListener((MouseListener)al);
		buttonRules.addMouseListener((MouseListener)al);
		buttonAbout.addMouseListener((MouseListener)al);
		buttonScore.addMouseListener((MouseListener)al);
		buttonQuit.addMouseListener((MouseListener)al);
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
				buttonPause.setName("itemPause");
				buttonPause.changeImage("src/images/png/pause.png");
				buttonPause.setToolTipText("Pause");
				break;
			case pause:
				cardLayout.show(this.card, "pause");
				buttonPause.setName("itemContinue");
				buttonPause.changeImage("src/images/png/play.png");
				buttonPause.setToolTipText("Continue");
				break;
		}
	}
	
	public void initGamePanel(int sizeX, int sizeY) {
		gamePanel = new GamePanel(sizeX, sizeY);
		this.card.add(gamePanel, "game");
	}
	
	public void setEnableGameItem(boolean b) {
		if(b) {
			buttonPause.changeImage("src/images/png/pause.png");
			buttonNewGame.changeImage("src/images/png/newgame.png");
			buttonPause.setName("itemPause");
			buttonNewGame.setName("itemNewGame");
		}
		else {
			buttonPause.changeImage("src/images/png/pause-grey.png");
			buttonNewGame.changeImage("src/images/png/newgame-grey.png");
			buttonPause.setName("itemPauseDisabled");
			buttonNewGame.setName("itemNewGameDisabled");
		}
	}
	
	public void resetScore() {
		this.labelScore.setText("");
	}
	
	public void paint(Graphics g) {
		MainFrame.realUsableHeight = (int)this.getSize().getHeight() - this.logoHeight;
		MainFrame.realUsableWidth = (int)this.getSize().getWidth();
		super.paint(g);
	}
	public void actionPerformed(ActionEvent e) {
		labelScore.setText("Chrono : "+WindowManager.chrono.getTime()+"s");
	}
}
