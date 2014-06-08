package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PausePanel extends JPanel {
	private static final long serialVersionUID = 354054054054L;
	private BorderLayout bl;

	private JPanel panelNorth;
	private JPanel panelCenter;
	
	public PausePanel() {
		super();
		
		/* Definition of the BoderLayout */
		bl = new BorderLayout();
		this.setLayout(bl);
		
		/* Creation of the panels north and center */
		panelNorth = new JPanel();
		panelCenter = new JPanel();
		
		this.add(BorderLayout.NORTH,panelNorth);
		this.add(BorderLayout.CENTER,panelCenter);
		
		/* Adding the labels to the panels */
		panelCenter.setLayout(new FlowLayout());
		Font fontTitle = new Font("Liberation Sans", Font.BOLD, 20);
		JLabel labelTitle = new JLabel("<html><span><center><br />You choose to take a little pause !</center></span></html>");
		labelTitle.setFont(fontTitle);
		
		Font fontContent = new Font("Liberation Sans", Font.ITALIC, 16);
		JLabel labelContent = new JLabel("<html><span><center><br /><br />(press p to continue)</center></span></html>");
		labelContent.setFont(fontContent);
		
		panelNorth.add(labelTitle);
		panelCenter.add(labelContent);
		
		/* Adding the color of the background */
		panelNorth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
	}
}
