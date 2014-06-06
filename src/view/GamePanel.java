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
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.setSize(new Dimension(this.sizeY*32,this.sizeX*32));
		panel = new JPanel();
		panel.setLayout(new GridLayout(this.sizeY,this.sizeX,-5,-5));
		this.setBackground(Color.white);
		WindowManager.iconSize = this.calculateIconSize();
		for(int i=0;i<this.sizeY;i++) {
			for(int j=0;j<this.sizeX;j++)
				panel.add(new CasePanel(String.valueOf(j).concat("#").concat(String.valueOf(i))));
		}
		this.add(panel);
		WindowManager.udc.add(this);
	}
	
	public int calculateIconSize() {
		return 0;
	}
	
	public void paintComponent(Graphics g) {
		WindowManager.iconSize = this.calculateIconSize();
		super.paintComponent(g);
	}
	
	public void updateCase(int x, int y, Case.Content content, Case.State state) {
		((CasePanel) panel.getComponents()[x+(this.sizeX)*y]).updateCase(content, state);
	}
}
