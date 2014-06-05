package view;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Case;

import control.WindowManager;


public class CasePanel extends JPanel {
	private JPanel hiddenImg = new ImagePanel("images/png/hidden.png");
	private JPanel emptyImg = new ImagePanel("");
	private JPanel flagImg = new ImagePanel("images/png/flag.png");
	private JPanel askImg = new ImagePanel("images/png/ask.png");
	private JPanel bombImg = new ImagePanel("images/png/bomb.png");
	private JPanel explodeImg = new ImagePanel("images/png/bang.png");
	private JPanel oneImg = new ImagePanel("");
	private JPanel twoImg = new ImagePanel("");
	private JPanel threeImg = new ImagePanel("");
	private JPanel fourImg = new ImagePanel("");
	private JPanel fiveImg = new ImagePanel("");
	private JPanel sixImg = new ImagePanel("");
	private JPanel sevenImg = new ImagePanel("");
	private JPanel eightImg = new ImagePanel("");
	
	public CasePanel(String xy) {
		super();
		this.setSize(32, 32);
		this.setBackground(new Color(190,189,188));
		this.addMouseListener(WindowManager.gc);
		this.setName(xy);
		this.updateCase(Case.Content.empty, Case.State.hidden);
	}
	
	protected void updateCase(Case.Content content, Case.State state) {
		this.removeAll();
		switch(state) {
			case hidden:
				this.add(this.hiddenImg);
				break;
			case flag:
				this.add(this.flagImg);
				break;
			case ask:
				this.add(this.askImg);
				break;
			case open:
				switch(content) {
					case empty:
						this.add(this.emptyImg);
						break;
					case one:
						this.add(this.oneImg);
						break;
					case two:
						this.add(this.twoImg);
						break;
					case three:
						this.add(this.threeImg);
						break;
					case four:
						this.add(this.fourImg);
						break;
					case five:
						this.add(this.fiveImg);
						break;
					case six:
						this.add(this.sixImg);
						break;
					case seven:
						this.add(this.sevenImg);
						break;
					case eight:
						this.add(this.eightImg);
						break;
					case bomb:
						this.add(this.bombImg);
						break;
				}
				break;
		}
		System.out.print("repaint (");
		System.out.print(this.getName());
		System.out.print(" & ");
		System.out.print(state);
		System.out.print(" & ");
		System.out.print(content);
		System.out.println(")");
		this.updateUI();
	}
}
