import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class StartPanel extends JPanel{
	protected int height;
	protected int width;
	
	public StartPanel(int width, int height){
		super();
		this.width = width;
		this.height = height;
		this.setBackground(Color.green);
		
		/* Definition of the GridLayout */
		GridLayout gl = new GridLayout();
		gl.setColumns(2);
		gl.setRows(3);
		gl.setHgap(5);
		gl.setVgap(5);
		
		/* Adding of the GridLayout to RulesPanel */
		this.setLayout(gl);
		
		this.add(new JButton("Easy"));
		this.add(new JButton("Medium"));
		this.add(new JButton("Difficult"));
		this.add(new JButton("Custom"));
		this.add(new JButton("Infinite"));
	}
}
