package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Score;

public class ScoreFrame extends JFrame {
	private int width = 700;
	private int height = 420;
	private int minWidth = 700;
	private int minHeight = 280;
	private int logoWidth = 700;
	private int logoHeight = 100;
	private int podiumWidth = 300;
	private int podiumHeight = 150;
	
	private ImagePanel logo;
	private ImagePanel podium;

	private JPanel content;
	private JPanel panelNorth;
	private JPanel panelCenter;
	private JPanel panelSouth;
	
	private JComboBox<String> combo;
	private Score score;
	private String[] array;
	private String filePath;
	
	
	public ScoreFrame() {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setBounds(60, 60, this.width, this.height);
		this.setMinimumSize(new Dimension(this.minWidth,this.minHeight));
		this.setResizable(false);
		
		/* Global Panel */
		this.getContentPane().setLayout(new BorderLayout());
		
		logo = new ImagePanel("images/png/logo.png", this.logoWidth, this.logoHeight);
		content = new JPanel();
		this.getContentPane().add(BorderLayout.NORTH, logo);
		this.getContentPane().add(BorderLayout.CENTER, content);
		
		/* Content Panel */
		content.setSize(this.width, this.height-this.logoHeight);
		content.setLayout(new BorderLayout());
		
		/* Creation of the panels north, center and south*/
		panelNorth = new JPanel();
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		
		content.add(BorderLayout.NORTH,panelNorth);
		content.add(BorderLayout.CENTER,panelCenter);
		content.add(BorderLayout.SOUTH,panelSouth);
		
		/* Creation of the image */
		podium = new ImagePanel("images/png/podium.png", this.podiumWidth, this.podiumHeight);
		
		/* Adding the title of the frame */
		JLabel labelTitle = new JLabel("<html><span><center>You can the configuration of the scores you want to know !<br /><br /></center></span></html>");
				
		/* Settings the fonts */
		Font fontTitle = new Font("Liberation Sans", Font.BOLD, 20);
		labelTitle.setFont(fontTitle);
		
		/* ComboBox */
		filePath = "scores/";
		score = new Score();
		array = new String[score.getSizeTreeHumanReadable(filePath)];
		array = score.TreeHumanReadable(filePath);
		combo = new JComboBox<String>(array);
		combo.setBackground(Color.white);
		
		/* Adding of the labels to the panels */
		panelNorth.add(labelTitle);
		panelCenter.add(combo);
		panelSouth.add(podium);
	
		/* Adding the color of the background */
		panelNorth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		panelSouth.setBackground(Color.white);
	}
}
