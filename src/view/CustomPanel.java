package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import control.SpinnerUpdater;
import control.SpinnerUpdaterListener;

public class CustomPanel extends JPanel implements SpinnerUpdaterListener {
	private BorderLayout bl;
	
	private JPanel panelNorth;
	private JPanel panelCenter;
	private JPanel panelSouth;
	private JPanel horizontalPanel;
	private JPanel verticalPanel;
	private JPanel bombsPanel;
	
	private JSpinner spinnerX;
	private JSpinner spinnerY;
	private JSpinner spinnerB;
	private JSpinner.NumberEditor spinnerXEditor;
	private JSpinner.NumberEditor spinnerYEditor;
	private JSpinner.NumberEditor spinnerBEditor;

	private JButton customCancel;
	private JButton customOK;

	private JLabel labelNorth;
	private JLabel labelX;
	private JLabel labelY;
	private JLabel labelB;
	
	public CustomPanel(){
		super();		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		/* Definition of the BoderLayout */
		bl = new BorderLayout();
		this.setLayout(bl);
		
		/* Creation of the panels south, center, horizontal, vertical and bombs */
		panelNorth = new JPanel();
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		
		horizontalPanel = new JPanel();
		horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.PAGE_AXIS));
		
		verticalPanel = new JPanel();
		verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.PAGE_AXIS));
		
		bombsPanel = new JPanel();
		bombsPanel.setLayout(new BoxLayout(bombsPanel, BoxLayout.PAGE_AXIS));
		
		/* Creation of the JSpinners */
		// X
		spinnerX = new JSpinner();
		spinnerXEditor = new JSpinner.NumberEditor(spinnerX);
		spinnerX.setEditor(spinnerXEditor);
		
		spinnerXEditor.getModel().setMinimum(4);
		spinnerXEditor.getModel().setMaximum((int) (toolkit.getScreenSize().getWidth()/32*0.95));
		spinnerXEditor.getModel().setStepSize(1);
		spinnerXEditor.getModel().setValue(8);		

		// Y
		spinnerY = new JSpinner();
		spinnerYEditor = new JSpinner.NumberEditor(spinnerY);
		spinnerY.setEditor(spinnerYEditor);
		
		spinnerYEditor.getModel().setMinimum(4);
		spinnerYEditor.getModel().setMaximum((int) ((toolkit.getScreenSize().getWidth()-100)/32*0.95));
		spinnerYEditor.getModel().setStepSize(1);
		spinnerYEditor.getModel().setValue(8);

		// Bombs
		spinnerB = new JSpinner();
		spinnerBEditor = new JSpinner.NumberEditor(spinnerB);
		spinnerB.setEditor(spinnerBEditor);
		
		spinnerBEditor.getModel().setMinimum(1);
		spinnerBEditor.getModel().setMaximum((Integer)spinnerXEditor.getModel().getNumber()*(Integer)spinnerYEditor.getModel().getNumber()-10);
		spinnerBEditor.getModel().setStepSize(1);
		spinnerBEditor.getModel().setValue(10);
		
		/* Creations of the buttons */
		customCancel = new JButton("Cancel");
		customOK = new JButton("OK");
		
		/* Creation of the labels */
		labelNorth = new JLabel("<html><span><center>You can choose your parameters for your personal game !</center></span></html>");
		labelX = new JLabel("<html><span><center>Horizontal :<br /></center></span></html>");
		labelY = new JLabel("<html><span><center>Vertical :<br /></center></span></html>");
		labelB = new JLabel("<html><span><center>Number of bombs :<br /></center></span></html>");
		
		// Settings the fonts
		Font fontNorth = new Font("Liberation Sans", Font.BOLD, 18);
		labelNorth.setFont(fontNorth);
		Font fontContent = new Font("Liberation Sans", Font.PLAIN, 16);
		labelX.setFont(fontContent);
		labelY.setFont(fontContent);
		labelB.setFont(fontContent);
		
		/*Adding the panels at the right place */
		this.add(BorderLayout.NORTH, panelNorth);
		this.add(BorderLayout.CENTER, panelCenter);
		this.add(BorderLayout.SOUTH, panelSouth);
		
		/* Adding the color of the background */
		panelNorth.setBackground(Color.white);
		panelCenter.setBackground(Color.white);
		panelSouth.setBackground(Color.white);
		horizontalPanel.setBackground(Color.white);
		verticalPanel.setBackground(Color.white);
		bombsPanel.setBackground(Color.white);
		spinnerX.setBackground(Color.white);
		spinnerY.setBackground(Color.white);
		spinnerB.setBackground(Color.white);
				
		/* Adding the content to the panels */
		panelNorth.add(labelNorth);
		
		horizontalPanel.add(labelX);
		horizontalPanel.add(spinnerX);
		verticalPanel.add(labelY);
		verticalPanel.add(spinnerY);
		bombsPanel.add(labelB);
		bombsPanel.add(spinnerB);
		
		horizontalPanel.setPreferredSize(new Dimension(175, 40));
		verticalPanel.setPreferredSize(new Dimension(175, 40));
		bombsPanel.setPreferredSize(new Dimension(175, 40));
		
		panelCenter.setLayout(new FlowLayout());
		panelCenter.add(horizontalPanel);
		panelCenter.add(verticalPanel);
		panelCenter.add(bombsPanel);
		panelSouth.add(customCancel);
		panelSouth.add(customOK);
		
		// Setting of the ActionCommand of the buttons
		customCancel.setActionCommand("customCancel");
		customOK.setActionCommand("customOK");
		
		/* Creation of the listener */
		SpinnerUpdater su = new SpinnerUpdater();
		su.add(this);
		((JSpinner.DefaultEditor) spinnerX.getEditor()).getTextField().addFocusListener(su);
		((JSpinner.DefaultEditor) spinnerY.getEditor()).getTextField().addFocusListener(su);
	}
	
	public void update() {
		int newMaxBomb = (Integer)spinnerXEditor.getModel().getNumber()*(Integer)spinnerYEditor.getModel().getNumber()-10;
		if((Integer)spinnerBEditor.getModel().getNumber() >= newMaxBomb)
			spinnerBEditor.getModel().setValue(newMaxBomb);
		spinnerBEditor.getModel().setMaximum(newMaxBomb);
	}
}