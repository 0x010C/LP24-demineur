package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import control.SpinnerUpdater;
import control.SpinnerUpdaterListener;

public class CustomPanel extends JPanel implements SpinnerUpdaterListener {
	private BorderLayout bl;
	
	private JPanel panelCenter;
	private JPanel contentPanel;
	
	private JSpinner spinnerX;
	private JSpinner spinnerY;
	private JSpinner spinnerB;
	private JSpinner.NumberEditor spinnerXEditor;
	private JSpinner.NumberEditor spinnerYEditor;
	private JSpinner.NumberEditor spinnerBEditor;
	
	public CustomPanel(){
		super();		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		/* Definition of the BoderLayout */
		bl = new BorderLayout();
		this.setLayout(bl);
		
		/* Creation of the panels north, south, center, east and west */
		panelCenter = new JPanel();
		panelCenter.setSize(this.getPreferredSize());
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
		contentPanel.setBackground(Color.white);
		
		/* JSpinners */
		// X
		spinnerX = new JSpinner();
		spinnerXEditor = new JSpinner.NumberEditor(spinnerX);
		spinnerX.setEditor(spinnerXEditor);
		spinnerX.setBackground(Color.white);
		
		spinnerXEditor.getModel().setMinimum(4);
		spinnerXEditor.getModel().setMaximum((int) (toolkit.getScreenSize().getWidth()/32*0.95));
		spinnerXEditor.getModel().setStepSize(1);
		spinnerXEditor.getModel().setValue(8);		

		// Y
		spinnerY = new JSpinner();
		spinnerYEditor = new JSpinner.NumberEditor(spinnerY);
		spinnerY.setEditor(spinnerYEditor);
		spinnerY.setBackground(Color.white);
		
		spinnerYEditor.getModel().setMinimum(4);
		spinnerYEditor.getModel().setMaximum((int) ((toolkit.getScreenSize().getWidth()-100)/32*0.95));
		spinnerYEditor.getModel().setStepSize(1);
		spinnerYEditor.getModel().setValue(8);

		// Bombs
		spinnerB = new JSpinner();
		spinnerBEditor = new JSpinner.NumberEditor(spinnerB);
		spinnerB.setEditor(spinnerBEditor);
		spinnerB.setBackground(Color.white);
		
		spinnerBEditor.getModel().setMinimum(1);
		spinnerBEditor.getModel().setMaximum((Integer)spinnerXEditor.getModel().getNumber()*(Integer)spinnerYEditor.getModel().getNumber()-10);
		spinnerBEditor.getModel().setStepSize(1);
		spinnerBEditor.getModel().setValue(10);
		
		/*Adding the panels at the right place */
		this.add(BorderLayout.CENTER,panelCenter);
		
		/* Adding the color of the background */
		panelCenter.setBackground(Color.white);
		
		JLabel labelX = new JLabel("<html><span><center>Horizontal :<br /></center></span></html>");
		JLabel labelY = new JLabel("<html><span><center>Vertical :<br /></center></span></html>");
		JLabel labelB = new JLabel("<html><span><center>Number of bombs :<br /></center></span></html>");
		
		contentPanel.add(labelX);
		contentPanel.add(spinnerX);
		contentPanel.add(labelY);
		contentPanel.add(spinnerY);
		contentPanel.add(labelB);
		contentPanel.add(spinnerB);
		
		contentPanel.setPreferredSize(new Dimension(300, 120));
		
		panelCenter.setLayout(new FlowLayout());
		panelCenter.add(contentPanel);
		
		/* Création du listener */
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