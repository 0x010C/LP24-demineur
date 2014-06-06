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
	public JPanel panel;
	public int sizeX;
	public int sizeY;
	
	public GamePanel(int sizeX, int sizeY) {
		/* Initializations */
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.setPreferredSize(new Dimension(this.sizeY*32,this.sizeX*32));
		this.setBackground(Color.white);
		
		/* Initialization of the global Panel */
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.panel.setPreferredSize(new Dimension(this.sizeY*32,this.sizeX*32));
		this.add(this.panel);
		
		/* Updating global variable */
		WindowManager.iconSize = this.calculateIconSize();
		WindowManager.udc.add(this);
		
		/* Filling the panel with all the cases, and setting their position */
		for(int i=0;i<this.sizeY;i++) {
			for(int j=0;j<this.sizeX;j++) {
				this.panel.add(new CasePanel(String.valueOf(j).concat("#").concat(String.valueOf(i))));
				this.panel.getComponent(j+this.sizeX*i).setBounds(j*32, i*32, 32, 32);
			}
		}
	}
	
	public int calculateIconSize() {
		return 32;
	}
	
	/* Before we repaint the component, we recalculate the icon's size*/
	public void paintComponent(Graphics g) {
		WindowManager.iconSize = this.calculateIconSize();
		super.paintComponent(g);
	}
	
	/* Implementation of UpdateDisplayListener */
	public void updateCase(int x, int y, Case.Content content, Case.State state) {
		((CasePanel) panel.getComponents()[x+(this.sizeX)*y]).updateCase(content, state);
	}
}
