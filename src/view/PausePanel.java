package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PausePanel extends JPanel {
	private static final long serialVersionUID = 354054054054L;
	private BorderLayout bl;

	private JPanel panelNorth;
	
	public PausePanel() {
		super();
		
		/* Definition of the BoderLayout */
		bl = new BorderLayout();
		this.setLayout(bl);
		this.setBackground(Color.white);
		/* Creation of the panels north and center */
		panelNorth = new JPanel();
		
		this.add(BorderLayout.NORTH,panelNorth);
		
		/* Adding the labels to the panels */
		Font fontTitle = new Font("Liberation Sans", Font.BOLD, 20);
		JLabel labelTitle = new JLabel("<html><span><center><br />You choose to take a little pause !</center></span></html>");
		labelTitle.setFont(fontTitle);
		
		panelNorth.add(labelTitle);
		
		/* Adding the color of the background */
		panelNorth.setBackground(Color.white);
	}
}
