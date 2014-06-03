package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class GamePanel extends JPanel {
	public JPanel panel;
	public int sizeX;
	public int sizeY;
	
	public GamePanel(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.setSize(new Dimension(this.sizeX*32,this.sizeY*32));
		panel = new JPanel();
		panel.setLayout(new GridLayout(this.sizeY,this.sizeX,-5,-5));
		this.setBackground(Color.white);
		for(int i=0;i<this.sizeX*this.sizeY;i++)
			panel.add(new CasePanel());
		this.add(panel);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
