import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JPanel;


public class StartPanel extends JPanel{
	
	public StartPanel(){
		super();
				
		/* Definition of the BoderLayout */
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		/* Definition of the GridLayout */
		GridLayout gl = new GridLayout();
		gl.setColumns(5);
		gl.setRows(1);
		gl.setHgap(10);
		gl.setVgap(10);
		
		/* Creation of the panels north, center and south */
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();
		panelCenter.setMaximumSize(new Dimension(700, 30));
		
		this.add(BorderLayout.NORTH,panelNorth);
		this.add(BorderLayout.CENTER,panelCenter);
		this.add(BorderLayout.SOUTH,panelSouth);
		this.add(BorderLayout.WEST,panelWest);
		this.add(BorderLayout.EAST,panelEast);
		

		/* Creation of the buttons and setting the buttons' texts */
		JButton btEasy = new JButton("Easy");
		JButton btMedium = new JButton("Medium");
		JButton btDifficult = new JButton("Difficult");
		JButton btCustom = new JButton("Custom");
		JButton btInfinite = new JButton("Infinite");

		/* Adding the buttons and label to the panels */
		panelCenter.setLayout(gl);
		Font font = new Font("Liberation Sans", Font.BOLD, 20);
		panelNorth.setFont(font);
		Label label = new Label("Choose your difficulty !");
		label.setFont(font);
		panelNorth.add(label);
		
		panelCenter.add(btEasy);
		panelCenter.add(btMedium);
		panelCenter.add(btDifficult);
		panelCenter.add(btCustom);
		panelCenter.add(btInfinite);
		
		/* Adding the color of the background */
		panelNorth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		panelSouth.setBackground(Color.white);
		panelWest.setBackground(Color.white);
		panelEast.setBackground(Color.white);
	}
}
