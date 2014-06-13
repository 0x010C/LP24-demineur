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
	
	private static final long serialVersionUID = 354054054054L;
	
	//All the images
	private String[] basePath = new String[5];
	private int[] baseSize = new int[5];
	private Case.Content content;
	private Case.State state;
	
	private JPanel[] hiddenImg = new JPanel[5];
	private JPanel[] emptyImg = new JPanel[5];
	private JPanel[] flagImg = new JPanel[5];
	private JPanel[] askImg = new JPanel[5];
	private JPanel[] bombImg = new JPanel[5];
	private JPanel[] explodeImg = new JPanel[5];
	private JPanel[] oneImg = new JPanel[5];
	private JPanel[] twoImg = new JPanel[5];
	private JPanel[] threeImg = new JPanel[5];
	private JPanel[] fourImg = new JPanel[5];
	private JPanel[] fiveImg = new JPanel[5];
	private JPanel[] sixImg = new JPanel[5];
	private JPanel[] sevenImg = new JPanel[5];
	private JPanel[] eightImg = new JPanel[5];
	
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
		this.baseSize[0] = 16;
		this.baseSize[1] = 24;
		this.baseSize[2] = 32;
		this.baseSize[3] = 48;
		this.baseSize[4] = 64;
		
		for(int i=0;i<5;i++) {
			this.basePath[i] = new String("src/images/png/".concat(Integer.toString(baseSize[i])).concat("/"));
			
			this.hiddenImg[i] = new ImagePanel(basePath[i].concat("hidden.png"));
			this.emptyImg[i] = new ImagePanel(basePath[i].concat("empty.png"));
			this.flagImg[i] = new ImagePanel(basePath[i].concat("flag.png"));
			this.askImg[i] = new ImagePanel(basePath[i].concat("ask.png"));
			this.bombImg[i] = new ImagePanel(basePath[i].concat("bomb.png"));
			this.explodeImg[i] = new ImagePanel(basePath[i].concat("explode.png"));
			this.oneImg[i] = new ImagePanel(basePath[i].concat("one.png"));
			this.twoImg[i] = new ImagePanel(basePath[i].concat("two.png"));
			this.threeImg[i] = new ImagePanel(basePath[i].concat("three.png"));
			this.fourImg[i] = new ImagePanel(basePath[i].concat("four.png"));
			this.fiveImg[i] = new ImagePanel(basePath[i].concat("five.png"));
			this.sixImg[i] = new ImagePanel(basePath[i].concat("six.png"));
			this.sevenImg[i] = new ImagePanel(basePath[i].concat("seven.png"));
			this.eightImg[i] = new ImagePanel(basePath[i].concat("eight.png"));
		}
	}
	
	protected void updateCase() {
		updateCase(this.content, this.state);
	}
	
	protected void updateCase(Case.State state) {
		updateCase(this.content, state);
	}
	
	protected void updateCase(Case.Content content, Case.State state) {
		/* We save the content and the state */
		this.content = content;
		this.state = state;
		
		/* First, remove the previous image */
		this.removeAll();
		
		/* Before the next step, we must select the right icon size */
		int i=0;
		while(this.baseSize[i] != WindowManager.iconSize)
			i++;

		/* Then pick the new one and past it */
		switch(state) {
			case hidden:
				if(content == Case.Content.explode)
					this.add(this.explodeImg[i]);
				else
					this.add(this.hiddenImg[i]);
				break;
			case flag:
				this.add(this.flagImg[i]);
				break;
			case ask:
				this.add(this.askImg[i]);
				break;
			case open:
				switch(content) {
					case empty:
						this.add(this.emptyImg[i]);
						break;
					case one:
						this.add(this.oneImg[i]);
						break;
					case two:
						this.add(this.twoImg[i]);
						break;
					case three:
						this.add(this.threeImg[i]);
						break;
					case four:
						this.add(this.fourImg[i]);
						break;
					case five:
						this.add(this.fiveImg[i]);
						break;
					case six:
						this.add(this.sixImg[i]);
						break;
					case seven:
						this.add(this.sevenImg[i]);
						break;
					case eight:
						this.add(this.eightImg[i]);
						break;
					case bomb:
						this.add(this.bombImg[i]);
						break;
					case explode:
						break;
				}
				break;
		}
		/* And finely, we correctly position the image and refresh the panel */
		this.getComponent(0).setBounds(0, 0, WindowManager.iconSize, WindowManager.iconSize);
		this.updateUI();
	}
}
