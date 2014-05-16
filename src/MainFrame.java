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
	private int height = 450;
	private int minWidth = 700;
	private int minHeight = 200;
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
		
		JPanel startPanel = new JPanel();
		startPanel.setBackground(Color.white);
		JPanel customizationPanel = new JPanel();
		JPanel rulePanel = new JPanel();
		rulePanel.setBackground(Color.green);
		JPanel aboutPanel = new JPanel();
		aboutPanel.setBackground(Color.blue);
		JPanel gamePanel = new JPanel();
		JPanel pausePanel = new JPanel();
		JPanel scorePanel = new JPanel();
		card.add(startPanel, "start");
		card.add(customizationPanel, "customization");
		card.add(rulePanel, "rule");
		card.add(aboutPanel, "about");
		card.add(gamePanel, "game");
		card.add(pausePanel, "pause");
		card.add(scorePanel, "score");
		
		//cardLayout.show(card, "about");
		
		/* Display the windows */
		this.setVisible(true);
	}
}
