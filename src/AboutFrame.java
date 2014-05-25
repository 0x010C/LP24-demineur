import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AboutFrame extends JFrame {
	private int width = 700;
	private int height = 320;
	private int minWidth = 700;
	private int minHeight = 280;
	private int logoWidth = 700;
	private int logoHeight = 100;
	
	public AboutFrame() {
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setBounds(60, 60, this.width, this.height);
		this.setMinimumSize(new Dimension(this.minWidth,this.minHeight));
		this.setResizable(false);
		
		/* Global Panel */
		this.getContentPane().setLayout(new BorderLayout());
		
		ImagePanel logo = new ImagePanel("images/png/logo.png", this.logoWidth, this.logoHeight);
		JPanel content = new JPanel();
		this.getContentPane().add(BorderLayout.NORTH, logo);
		this.getContentPane().add(BorderLayout.CENTER, content);
		
		/* Content Panel */
		content.setSize(this.width, this.height-this.logoHeight);
		content.setLayout(new BorderLayout());
		
		/* Creation of the panels north, south, center, east and west */
		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelWest = new JPanel();
		
		content.add(BorderLayout.NORTH,panelNorth);
		content.add(BorderLayout.SOUTH,panelSouth);
		content.add(BorderLayout.CENTER,panelCenter);
		content.add(BorderLayout.EAST,panelEast);
		content.add(BorderLayout.WEST,panelWest);
		
		/* Adding the title of the frame */
		Font fontTitle = new Font("Liberation Sans", Font.BOLD, 20);
		JLabel labelTitle = new JLabel("About MineSweeper !");
		labelTitle.setFont(fontTitle);
		panelNorth.add(labelTitle);
		
		/* Adding the content of the frame */
		Font fontContent = new Font("Liberation Sans", Font.PLAIN, 16);
		
		JLabel label1 = new JLabel("<html><span><center>1.00<br /><br />The popular logic game MineSweeper.<br />Find the mines in the table using the\n indications given by the cases already opened.<br /><br />MineSweeper was created in order to a project of LP24, a course in the UTBM school.</center></span></html>");
		JLabel label2 = new JLabel("<html><span><center>Game created by <a href=\"mailto:antoine.lamielle@utbm.fr\">Antoine LAMIELLE</a> and <a href=\"mailto:vincent.merat@utbm.fr\">Vincent MERAT</a> .</center></span></html>");
		
		label1.setFont(fontContent);
		label2.setFont(fontContent);
		
		panelCenter.add(label1);
		panelCenter.add(label2);
		
		/* Adding the color of the background */
		panelNorth.setBackground(Color.white);
		panelSouth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		panelEast.setBackground(Color.white);
		panelWest.setBackground(Color.white);
		
		/* Display the window */
		this.setVisible(true);
	}
}
