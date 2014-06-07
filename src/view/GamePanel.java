package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Case;
import control.UpdateDisplayListener;
import control.WindowManager;


public class GamePanel extends JPanel implements UpdateDisplayListener {
	/*
	 * Attributes
	 */
	
	public JPanel panel;
	public int sizeX;
	public int sizeY;
	
	/*
	 * Constructor
	 */
	
	public GamePanel(int sizeX, int sizeY) {
		/* Updating global variable */
		this.calculateIconSize();
		WindowManager.udc.add(this);
		
		/* Initializations */
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.setPreferredSize(new Dimension(this.sizeX*WindowManager.iconSize+(this.sizeX+1)*WindowManager.margin,this.sizeY*WindowManager.iconSize+(this.sizeY+1)*WindowManager.margin));
		this.setBackground(Color.white);
		
		/* Initialization of the global Panel */
		this.panel = new JPanel();
		this.panel.setBackground(new Color(190,189,188));
		this.panel.setLayout(null);
		this.panel.setPreferredSize(new Dimension(this.sizeX*WindowManager.iconSize+(this.sizeX+1)*WindowManager.margin,this.sizeY*WindowManager.iconSize+(this.sizeY+1)*WindowManager.margin));
		this.add(this.panel);
		
		/* Filling the panel with all the cases, and setting their position */
		for(int i=0;i<this.sizeY;i++) {
			for(int j=0;j<this.sizeX;j++) {
				this.panel.add(new CasePanel(String.valueOf(j).concat("#").concat(String.valueOf(i))));
				this.panel.getComponent(j+this.sizeX*i).setBounds(WindowManager.margin+j*(WindowManager.iconSize+WindowManager.margin), WindowManager.margin+i*(WindowManager.iconSize+WindowManager.margin), WindowManager.iconSize, WindowManager.iconSize);
			}
		}
	}
	
	/*
	 * Methods
	 */
	
	public void calculateIconSize() {
		if(MainFrame.realUsableWidth/((this.sizeX*64)+((this.sizeX+1)*10)) >= 1 && MainFrame.realUsableHeight/((this.sizeY*64)+((this.sizeY+1)*10)) >= 1) {
			WindowManager.iconSize = 64;
			WindowManager.margin = 10;
		}
		else if(MainFrame.realUsableWidth/((this.sizeX*48)+((this.sizeX+1)*7)) >= 1 && MainFrame.realUsableHeight/((this.sizeY*48)+((this.sizeY+1)*7)) >= 1) {
			WindowManager.iconSize = 48;
			WindowManager.margin = 7;
		}
		else if(MainFrame.realUsableWidth/((this.sizeX*32)+((this.sizeX+1)*5)) >= 1 && MainFrame.realUsableHeight/((this.sizeY*32)+((this.sizeY+1)*5)) >= 1) {
			WindowManager.iconSize = 32;
			WindowManager.margin = 5;
		}
		else if(MainFrame.realUsableWidth/((this.sizeX*24)+((this.sizeX+1)*4)) >= 1 && MainFrame.realUsableHeight/((this.sizeY*24)+((this.sizeY+1)*4)) >= 1) {
			WindowManager.iconSize = 24;
			WindowManager.margin = 4;
		}
		else {
			WindowManager.iconSize = 16;
			WindowManager.margin = 3;
		}
	}
	
	public void paintComponent(Graphics g) {
		/* Before we repaint the component, we recalculate the icon's size*/
		this.calculateIconSize();
		
		/* Update the panel and the cases */
		this.panel.setPreferredSize(new Dimension(this.sizeX*WindowManager.iconSize+(this.sizeX+1)*WindowManager.margin,this.sizeY*WindowManager.iconSize+(this.sizeY+1)*WindowManager.margin));
		this.setPreferredSize(new Dimension(this.sizeX*WindowManager.iconSize+(this.sizeX+1)*WindowManager.margin,this.sizeY*WindowManager.iconSize+(this.sizeY+1)*WindowManager.margin));
		for(int i=0;i<this.sizeY;i++) {
			for(int j=0;j<this.sizeX;j++) {
				((CasePanel)this.panel.getComponent(j+this.sizeX*i)).loadImages();
				this.panel.getComponent(j+this.sizeX*i).setBounds(WindowManager.margin+j*(WindowManager.iconSize+WindowManager.margin), WindowManager.margin+i*(WindowManager.iconSize+WindowManager.margin), WindowManager.iconSize, WindowManager.iconSize);
			}
		}
		
		super.paintComponent(g);
	}
	
	/* Implementation of UpdateDisplayListener */
	public void updateCase(int x, int y, Case.Content content, Case.State state) {
		((CasePanel) panel.getComponents()[x+(this.sizeX)*y]).updateCase(content, state);
	}
}
