package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StartPanel extends JPanel {
	private static final long serialVersionUID = 354054054054L;
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
	private JButton btHard;
	
	public StartPanel() {
		super();
				
		/* Definition of the BoderLayout */
		this.bl = new BorderLayout();
		this.setLayout(this.bl);
		
		/* Definition of the GridLayout */
		this.gl = new GridLayout();
		this.gl.setColumns(5);
		this.gl.setRows(1);
		this.gl.setHgap(10);
		this.gl.setVgap(10);
		
		/* Creation of the panels north, south, center, east and west */
		this.panelNorth = new JPanel();
		this.panelSouth = new JPanel();
		this.panelCenter = new JPanel();
		this.panelEast = new JPanel();
		this.panelWest = new JPanel();
		
		this.add(BorderLayout.NORTH,this.panelNorth);
		this.add(BorderLayout.SOUTH,this.panelSouth);
		this.add(BorderLayout.CENTER,this.panelCenter);
		this.add(BorderLayout.EAST,this.panelEast);
		this.add(BorderLayout.WEST,this.panelWest);
		
		/* Creation of the buttons and setting the buttons' texts */
		this.btEasy = new JButton("Easy");
		this.btMedium = new JButton("Medium");
		this.btDifficult = new JButton("Difficult");
		this.btCustom = new JButton("Custom");
		this.btHard = new JButton("Hard");
		
		// Setting of the ActionCommand of the buttons
		this.btEasy.setActionCommand("btEasy");
		this.btMedium.setActionCommand("btMedium");
		this.btDifficult.setActionCommand("btDifficult");
		this.btCustom.setActionCommand("btCustom");
		this.btHard.setActionCommand("btHard");

		/* Adding the buttons and label to the panels */
		this.panelCenter.setLayout(this.gl);
		Font font = new Font("Liberation Sans", Font.BOLD, 20);
		JLabel label = new JLabel("<html><span><center>Choose your difficulty !</center></span></html>");
		label.setFont(font);
		this.panelNorth.add(label);
		
		this.panelCenter.add(this.btEasy);
		this.panelCenter.add(this.btMedium);
		this.panelCenter.add(this.btDifficult);
		this.panelCenter.add(this.btCustom);
		this.panelCenter.add(this.btHard);
		
		/* Adding the color of the background */
		this.panelNorth.setBackground(Color.white);
		this.panelSouth.setBackground(Color.white);
		this.panelCenter.setBackground(Color.white);
		this.panelEast.setBackground(Color.white);
		this.panelWest.setBackground(Color.white);
	}
	
	public void setButtonListener(ActionListener al){
		this.btEasy.addActionListener(al);
		this.btMedium.addActionListener(al);
		this.btDifficult.addActionListener(al);
		this.btCustom.addActionListener(al);
		this.btHard.addActionListener(al);
	}
}
