package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RulesFrame extends JFrame {
	private static final long serialVersionUID = 354054054054L;
	
	private int width = 700;
	private int height = 340;
	private int minWidth = 700;
	private int minHeight = 280;
	private int logoWidth = 700;
	private int logoHeight = 100;
	
	public RulesFrame() {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setBounds(60, 60, this.width, this.height);
		this.setMinimumSize(new Dimension(this.minWidth,this.minHeight));
		this.setResizable(false);
		
		/* Global Panel */
		this.getContentPane().setLayout(new BorderLayout());
		
		ImagePanel logo = new ImagePanel("src/images/png/logo.png", this.logoWidth, this.logoHeight);
		JPanel content = new JPanel();
		this.getContentPane().add(BorderLayout.NORTH, logo);
		this.getContentPane().add(BorderLayout.CENTER, content);
		
		/* Content Panel */
		content.setSize(this.width, this.height-this.logoHeight);
		content.setLayout(new BorderLayout());
		
		/* Creation of the panels north and center */
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		
		content.add(BorderLayout.NORTH,panelNorth);
		content.add(BorderLayout.CENTER,panelCenter);
		
		/* Adding the title of the frame */
		JLabel labelTitle = new JLabel("Rules of the game !");
		
		/* Adding the content of the frame */
		JLabel label1 = new JLabel("<html><span><center><strong>The rules in Minesweeper are quite simple :</strong><br />Uncover a mine, and the game ends<br />Uncover an empty square, and you keep playing<br />Uncover a number, and it tells you the number of mines just next to this number</center></span></html>");
		JLabel label2 = new JLabel("<html><span><center><br />To play, you just need a mouse. <br />The left button is used to discover the mines. <br />The right one is used to mark the mines (a second right click put a \"?\" instead if you are not sure)</center></span></html>");
		
		/* Settings the fonts */
		Font fontTitle = new Font("Liberation Sans", Font.BOLD, 20);
		labelTitle.setFont(fontTitle);
		
		Font fontContent = new Font("Liberation Sans", Font.PLAIN, 16);
		label1.setFont(fontContent);
		label2.setFont(fontContent);
		
		/* Adding of the labels to the panels */
		panelNorth.add(labelTitle);
		panelCenter.add(label1);
		panelCenter.add(label2);
		
		/* Adding the color of the background */
		panelNorth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
	}
}
