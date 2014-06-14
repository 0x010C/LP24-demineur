package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Score;

public class ScoreFrame extends JFrame implements ItemListener {
	private static final long serialVersionUID = 354054054054L;
	
	private int width = 700;
	private int height = 430;
	private int logoWidth = 700;
	private int logoHeight = 100;
	private int podiumWidth = 300;
	private int podiumHeight = 150;
	private int sizeArray;
	
	private Score score;
	
	private ImagePanel logo;
	private ImagePanel podium;

	private JPanel content;
	private JPanel panelNorth;
	private JPanel panelCenter;
	private JPanel panelSouth;
	
	private JComboBox<String> combo;
	private String[] array;
	private String filePath;
	
	private boolean disableListener;
	
	private JLabel labelTitle;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel labelText;
	private JLabel labelScore;
	
	public ScoreFrame(Score score) {
		this.setSize(new Dimension(this.width, this.height));
		this.setResizable(false);
		this.setBounds(60, 60, this.width, this.height);
		this.setTitle("MineSweeper - Scores");
		
		this.score = score;
		
		/* Global Panel */
		this.getContentPane().setLayout(new BorderLayout());
		
		this.logo = new ImagePanel("src/images/png/logo.png", this.logoWidth, this.logoHeight);
		this.content = new JPanel();
		this.getContentPane().add(BorderLayout.NORTH, logo);
		this.getContentPane().add(BorderLayout.CENTER, content);
		
		/* Content Panel */
		this.content.setSize(this.width, this.height-this.logoHeight);
		this.content.setLayout(new BorderLayout());
		this.panelNorth = new JPanel();
		this.panelCenter = new JPanel();
		this.panelSouth = new JPanel();
		
		this.content.add(BorderLayout.NORTH,panelNorth);
		this.content.add(BorderLayout.CENTER,panelCenter);
		this.content.add(BorderLayout.SOUTH,panelSouth);
		this.panelSouth.setLayout(null);
		this.panelSouth.setPreferredSize(new Dimension(700, 220));
		
		/* Creation of the image podium */
		this.podium = new ImagePanel("src/images/png/podium.png", this.podiumWidth, this.podiumHeight);
		this.podium.setBounds(this.width/2-(this.podiumWidth/2), 30, this.podiumWidth, this.podiumHeight);
		
		/* Adding the title of the frame */
		this.labelTitle = new JLabel("<html><span><center>Select the score you're looking for !<br /><br /></center></span></html>");
				
		/* Settings the fonts */
		Font fontTitle = new Font("Liberation Sans", Font.BOLD, 20);
		this.labelTitle.setFont(fontTitle);
		
		/* ComboBox */
		this.filePath = "src/scores/";
		this.sizeArray = score.getSizeTreeHumanReadable(filePath);
		this.array = new String[sizeArray];
		this.array = score.TreeHumanReadable(filePath);
		this.combo = new JComboBox<String>(array);
		this.combo.setBackground(Color.white);
		
		/* Adding of the labels to the panels */
		this.panelNorth.add(labelTitle);
		this.panelCenter.add(combo);
		this.panelSouth.add(podium);
		this.podium.setBounds(this.width/2-(this.podiumWidth/2), 30, this.podiumWidth, this.podiumHeight);

		this.label1 = new JLabel("");
		this.label2 = new JLabel("");
		this.label3 = new JLabel("");
		
		/* Adding the color of the background */
		this.panelNorth.setBackground(Color.white);
		this.panelCenter.setBackground(Color.white);
		this.panelSouth.setBackground(Color.white);
		
		this.setComboBox(8, 8, 10);
		this.disableListener = false;
		this.combo.addItemListener(this);
		this.labelText = new JLabel("");
		this.labelScore = new JLabel("");
	}
	
	public void ShowScores() {
		ArrayList<Integer> scores = this.score.Reading(this.score.HumanReadableToFilePath(this.combo.getSelectedItem().toString()));
		this.ShowScores(scores.get(0), scores.get(1), scores.get(2));
	}
	
	public void ShowScores(int score1, int score2, int score3) {
		/* Adding the JLabels to the JPanel */
		if(score1 != -1)
			label1.setText(Integer.toString(score1));
		else
			label1.setText("");
		if(score2 != -1)
			label2.setText(Integer.toString(score2));
		else
			label2.setText("");
		if(score3 != -1)
			label3.setText(Integer.toString(score3));
		else
			label3.setText("");
		
		if(score1 != -1) {
			this.panelSouth.add(label1);
			this.panelSouth.setComponentZOrder(this.label1, this.getComponentCount()-1);
		}
		if(score2 != -1) {
			this.panelSouth.add(label2);
			this.panelSouth.setComponentZOrder(this.label2, this.getComponentCount()-1);
		}
		if(score3 != -1) {
			this.panelSouth.add(label3);
			this.panelSouth.setComponentZOrder(this.label3, this.getComponentCount()-1);
		}
		
		/* Setting the location of the labels */
		this.label1.setBounds(this.width/2-43, 22, 80, 10);
		this.label1.setHorizontalAlignment(JLabel.CENTER);
		this.label2.setBounds(225, 79, 80, 10);
		this.label2.setHorizontalAlignment(JLabel.CENTER);
		this.label3.setBounds(376, 85, 80, 10);
		this.label3.setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	public void setComboBox(int sizeX, int sizeY, int nbBombs) {
		String humanReadable;
		
		this.disableListener = true;
		this.combo.removeAllItems();
		this.array = score.TreeHumanReadable(this.filePath);
		for(String str : this.array)
			this.combo.addItem(str);
		this.disableListener = false;
		
		if(sizeX < sizeY) {
			int temp = sizeX;
			sizeX = sizeY;
			sizeY = temp;
		}
		
		if (nbBombs == 1) {
			humanReadable = (Integer.toString(sizeX) + " X " + Integer.toString(sizeY) + ", " + Integer.toString(nbBombs) + " mine");
		} else {
			humanReadable = (Integer.toString(sizeX) + " X " + Integer.toString(sizeY) + ", " + Integer.toString(nbBombs) + " mines");
		}
	
		int i = 0, index = -1;
		
		while(i<this.sizeArray && index == -1) {
			if(humanReadable.replace(" ", "").compareToIgnoreCase(this.array[i].replace(" ", "")) == 0)
				index = i;
			i++;
		}
		if(index == -1)
			index = 1;
		
		this.combo.setSelectedIndex(index);
		this.ShowScores();
	}
	
	public void setCurrentScore(int score) {
		if(score == -1){
			this.labelText.setText("");
			this.labelScore.setText("");
			this.panelSouth.add(labelText);
			this.panelSouth.add(labelScore);
		} else {
			this.labelText.setText("Your actual score");
			this.labelScore.setText(Integer.toString(score));
			
			Font font = new Font("Liberation Sans", Font.BOLD, 20);
			this.labelText.setFont(font);
			this.labelScore.setFont(font);
			
			this.panelSouth.add(labelText);
			this.panelSouth.add(labelScore);
			this.labelText.setBounds(245, 176, 200, 20);
			this.labelText.setHorizontalAlignment(JLabel.CENTER);
			this.labelScore.setBounds(243, 200, 200, 20);
			this.labelScore.setHorizontalAlignment(JLabel.CENTER);
		}
	}

	/* ItemListener */
	public void itemStateChanged(ItemEvent e) {
		if(!this.disableListener)
			this.ShowScores();
	} 
}
