package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StartPanel extends JPanel{
	private BorderLayout bl;
	private GridLayout gl;
	
	private JPanel panelNorth;
	private JPanel panelSouth;
	private JPanel panelCenter;
	private JPanel panelEast;
	private JPanel panelWest;
	
	private JButton btEasy;
	private JButton btMedium;
	private JButton btDifficult;
	private JButton btCustom;
	private JButton btInfinite;
	
	public StartPanel(){
		super();
				
		/* Definition of the BoderLayout */
		bl = new BorderLayout();
		this.setLayout(bl);
		
		/* Definition of the GridLayout */
		gl = new GridLayout();
		gl.setColumns(5);
		gl.setRows(1);
		gl.setHgap(10);
		gl.setVgap(10);
		
		/* Creation of the panels north, south, center, east and west */
		panelNorth = new JPanel();
		panelSouth = new JPanel();
		panelCenter = new JPanel();
		panelEast = new JPanel();
		panelWest = new JPanel();
		
		this.add(BorderLayout.NORTH,panelNorth);
		this.add(BorderLayout.SOUTH,panelSouth);
		this.add(BorderLayout.CENTER,panelCenter);
		this.add(BorderLayout.EAST,panelEast);
		this.add(BorderLayout.WEST,panelWest);
		
		/* Creation of the buttons and setting the buttons' texts */
		btEasy = new JButton("Easy");
		btMedium = new JButton("Medium");
		btDifficult = new JButton("Difficult");
		btCustom = new JButton("Custom");
		btInfinite = new JButton("Infinite");
		
		// Setting of the ActionCommand of the buttons
		btEasy.setActionCommand("btEasy");
		btMedium.setActionCommand("btMedium");
		btDifficult.setActionCommand("btDifficult");
		btCustom.setActionCommand("btCustom");
		btInfinite.setActionCommand("btInfinite");

		/* Adding the buttons and label to the panels */
		panelCenter.setLayout(gl);
		Font font = new Font("Liberation Sans", Font.BOLD, 20);
		JLabel label = new JLabel("<html><span><center>Choose your difficulty !</center></span></html>");
		label.setFont(font);
		panelNorth.add(label);
		
		panelCenter.add(btEasy);
		panelCenter.add(btMedium);
		panelCenter.add(btDifficult);
		panelCenter.add(btCustom);
		panelCenter.add(btInfinite);
		
		/* Adding the color of the background */
		panelNorth.setBackground(Color.white);
		panelSouth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		panelEast.setBackground(Color.white);
		panelWest.setBackground(Color.white);
	}
	
	public void setButtonListener(ActionListener al){
		btEasy.addActionListener(al);
		btMedium.addActionListener(al);
		btDifficult.addActionListener(al);
		btCustom.addActionListener(al);
		btInfinite.addActionListener(al);
	}
}
