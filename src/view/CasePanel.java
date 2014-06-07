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
	
	//All the images
	private String basePath;
	private JPanel hiddenImg;
	private JPanel emptyImg;
	private JPanel flagImg;
	private JPanel askImg;
	private JPanel bombImg;
	private JPanel explodeImg;
	private JPanel oneImg;
	private JPanel twoImg;
	private JPanel threeImg;
	private JPanel fourImg;
	private JPanel fiveImg;
	private JPanel sixImg;
	private JPanel sevenImg;
	private JPanel eightImg;
	
	/*
	 * Constructor
	 */
	public CasePanel(String xy) {
		super();
		this.setPreferredSize(new Dimension(WindowManager.iconSize, WindowManager.iconSize));
		this.setBackground(new Color(190,189,188));
		this.setName(xy);
		this.setLayout(null);
		this.loadImages();
		this.updateCase(Case.Content.empty, Case.State.hidden);
		this.addMouseListener(WindowManager.gc);
	}
	
	/*
	 * Methods
	 */
	
	public void loadImages() {
		this.basePath = new String("images/png/".concat(String.valueOf(WindowManager.iconSize)).concat("/"));
		System.out.println(basePath);
		
		this.hiddenImg = new ImagePanel(basePath.concat("hidden.png"));
		this.emptyImg = new ImagePanel(basePath.concat("empty.png"));
		this.flagImg = new ImagePanel(basePath.concat("flag.png"));
		this.askImg = new ImagePanel(basePath.concat("ask.png"));
		this.bombImg = new ImagePanel(basePath.concat("bomb.png"));
		this.explodeImg = new ImagePanel(basePath.concat("bang.png"));
		this.oneImg = new ImagePanel(basePath.concat("one.png"));
		this.twoImg = new ImagePanel(basePath.concat("two.png"));
		this.threeImg = new ImagePanel(basePath.concat("three.png"));
		this.fourImg = new ImagePanel(basePath.concat("four.png"));
		this.fiveImg = new ImagePanel(basePath.concat("five.png"));
		this.sixImg = new ImagePanel(basePath.concat("six.png"));
		this.sevenImg = new ImagePanel(basePath.concat("seven.png"));
		this.eightImg = new ImagePanel(basePath.concat("eight.png"));
	}
	
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
		this.getComponent(0).setBounds(0, 0, WindowManager.iconSize, WindowManager.iconSize);
		this.updateUI();
	}
}
