import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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
		
		/* Creation of the panels north and center */
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		
		content.add(BorderLayout.NORTH,panelNorth);
		content.add(BorderLayout.CENTER,panelCenter);
		
		/* Adding the title of the frame */
		JLabel labelTitle = new JLabel("About MineSweeper !");
		
		/* Adding the content of the frame */
		JLabel label1 = new JLabel("<html><span><center>1.00<br /><br />The popular logic game MineSweeper.<br />Find the mines in the table using the\n indications given by the cases already opened.<br /><br />MineSweeper was created for a project of LP24, a course in the UTBM school.</center></span></html>");
		JLabel label2 = new JLabel("<html><span><center>Game created by <a href=\"mailto:antoine.lamielle@utbm.fr\">Antoine LAMIELLE</a> and <a href=\"mailto:vincent.merat@utbm.fr\">Vincent MERAT</a> .</center></span></html>");
		
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
