package view;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.Case;
import control.WindowManager;


public class CasePanel extends JPanel {
	/*
	 * Attributes
	 */
	
	//Loading all the images
	private JPanel hiddenImg = new ImagePanel("images/png/hidden.png");
	private JPanel emptyImg = new ImagePanel("images/png/empty.png");
	private JPanel flagImg = new ImagePanel("images/png/flag.png");
	private JPanel askImg = new ImagePanel("images/png/ask.png");
	private JPanel bombImg = new ImagePanel("images/png/bomb.png");
	private JPanel explodeImg = new ImagePanel("images/png/bang.png");
	private JPanel oneImg = new ImagePanel("images/png/one.png");
	private JPanel twoImg = new ImagePanel("images/png/two.png");
	private JPanel threeImg = new ImagePanel("images/png/three.png");
	private JPanel fourImg = new ImagePanel("images/png/four.png");
	private JPanel fiveImg = new ImagePanel("images/png/five.png");
	private JPanel sixImg = new ImagePanel("images/png/six.png");
	private JPanel sevenImg = new ImagePanel("images/png/seven.png");
	private JPanel eightImg = new ImagePanel("images/png/eight.png");
	
	/*
	 * Constructor
	 */
	public CasePanel(String xy) {
		super();
		this.setPreferredSize(new Dimension(32, 32));
		this.setBackground(new Color(190,189,188));
		this.setName(xy);
		this.setLayout(null);
		this.updateCase(Case.Content.empty, Case.State.hidden);
		this.addMouseListener(WindowManager.gc);
	}
	
	/*
	 * Methods
	 */
	
	protected void updateCase(Case.Content content, Case.State state) {
		/* First, remove the previous image */
		this.removeAll();
		
		/* Then pick the new one and past it */
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
		
		/* And finely, we correctly position the image and refresh the panel */
		this.getComponent(0).setBounds(0, 0, 32, 32);
		this.updateUI();
	}
}
