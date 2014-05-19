import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {
	protected int height;
	protected int width;
	protected String filePath;
	protected Image img;
	
	/* Constructor with only the path as parameter */
	public ImagePanel(String filePath) {
		super();
		this.filePath = filePath;
		this.img = new ImageIcon(this.filePath).getImage();
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.setPreferredSize(new Dimension(this.width, this.height));
	}
	
	/* Complete constructor */
	public ImagePanel(String filePath, int width, int height) {
		super();
		this.filePath = filePath;
		this.img = new ImageIcon(this.filePath).getImage();
		this.height = height;
		this.width = width;
		this.setPreferredSize(new Dimension(this.width, this.height));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setSize(this.width, this.height);
		g.drawImage(this.img, 0, 0, this);
	}
}
