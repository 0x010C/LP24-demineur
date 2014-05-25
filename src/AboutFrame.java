import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class AboutFrame extends JFrame {
	private int width = 700;
	private int height = 600;
	private int minWidth = 700;
	private int minHeight = 280;
	private int logoWidth = 700;
	private int logoHeight = 100;
	
	public AboutFrame() {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setBounds(60, 60, this.width, this.height);
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
		
		// Adding of the different JPanel
		//card.add(startPanel, "start");
		//cardLayout.show(card, "start");
		
		/* Display the window */
		this.setVisible(true);
	}
}
