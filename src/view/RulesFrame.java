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
	
	private ImagePanel logo;
	
	private JPanel content;
	private JPanel panelNorth;
	private JPanel panelCenter;
	
	private JLabel labelTitle;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	private int width = 700;
	private int height = 505;
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
		this.setTitle("MineSweeper - Rules");
		
		/* Global Panel */
		this.getContentPane().setLayout(new BorderLayout());
		
		this.logo = new ImagePanel("ressources/images/png/logo.png", this.logoWidth, this.logoHeight);
		this.content = new JPanel();
		this.getContentPane().add(BorderLayout.NORTH, logo);
		this.getContentPane().add(BorderLayout.CENTER, content);
		
		/* Content Panel */
		this.content.setSize(this.width, this.height-this.logoHeight);
		this.content.setLayout(new BorderLayout());
		
		/* Creation of the panels north and center */
		this.panelNorth = new JPanel();
		this.panelCenter = new JPanel();
		
		this.content.add(BorderLayout.NORTH,panelNorth);
		this.content.add(BorderLayout.CENTER,panelCenter);
		
		/* Adding the title of the frame */
		this.labelTitle = new JLabel("Rules of the game !");
		
		/* Adding the content of the frame */
		this.label1 = new JLabel("<html><span><center><strong>The rules in Minesweeper are quite simple :</strong><br /><br />Uncover a mine, and the game ends<br />Uncover an empty square, and you keep playing<br />Uncover a number, and it tells you the number of mines just next to this number</center></span></html>");
		this.label2 = new JLabel("<html><span><center><br />To play, you just need a mouse. <br />The left button is used to discover the mines. <br />The right one is used to mark the mines (a second right click put a \"?\" instead if you are not sure)</center></span></html>");
		this.label3 = new JLabel("<html><span><center><br />Before playing, you can choose your level of difficulty : <br /></center><ul><li>Easy : 8 X 8, 10 mines</li><li>Medium : 16 X 16, 40 mines</li><li>Difficult : 30 X 16, 99 mines</li><li>Hard : 16 X 16, 40 mines but you have to play each time before a timer of 15 seconds</li></ul><center>Moreover, you can choose a custom size with a custom number of bombs.</center></span></html>");
		
		/* Settings the fonts */
		Font fontTitle = new Font("Liberation Sans", Font.BOLD, 20);
		this.labelTitle.setFont(fontTitle);
		
		Font fontContent = new Font("Liberation Sans", Font.PLAIN, 16);
		this.label1.setFont(fontContent);
		this.label2.setFont(fontContent);
		this.label3.setFont(fontContent);
		
		/* Adding of the labels to the panels */
		this.panelNorth.add(labelTitle);
		this.panelCenter.add(label1);
		this.panelCenter.add(label2);
		this.panelCenter.add(label3);
		
		/* Adding the color of the background */
		this.panelNorth.setBackground(Color.white);
		this.panelCenter.setBackground(Color.white);
	}
}
