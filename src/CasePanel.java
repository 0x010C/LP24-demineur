import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class CasePanel extends JPanel {
	private static JPanel hiddenImg = new ImagePanel("images/png/hidden.png");
	/*private static JPanel clickedImg = new ImagePanel("");
	private static JPanel emptyImg = new ImagePanel("");
	private static JPanel flagImg = new ImagePanel("");
	private static JPanel askImg = new ImagePanel("");
	private static JPanel bombImg = new ImagePanel("");*/
	private static JPanel explodeImg = new ImagePanel("images/png/bang.png");
	//private static JPanel one = new JPanel();
	
	public CasePanel() {
		super();
		this.setSize(32, 32);
		this.add(CasePanel.hiddenImg);
		this.setBackground(new Color(190,189,188));
	}
	
	public void paintComponent(Graphics g) {
		this.selector();
		super.paintComponent(g);
	}
	
	protected void selector() {
		this.add(CasePanel.hiddenImg);
	}
}
