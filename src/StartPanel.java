import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class StartPanel extends JPanel{
	public StartPanel(){
		super();
		this.setBackground(Color.white);
		
		/* Definition of the GridLayout */
		GridLayout gl = new GridLayout();
		gl.setColumns(2);
		gl.setRows(3);
		gl.setHgap(10);
		gl.setVgap(10);
		
		/* Adding of the GridLayout to StartPanel */
		this.setLayout(gl);
		
		/* Creation of the buttons and setting the buttons' texts */
		JButton btEasy = new JButton("Easy");
		JButton btMedium = new JButton("Medium");
		JButton btDifficult = new JButton("Difficult");
		JButton btCustom = new JButton("Custom");
		JButton btInfinite = new JButton("Infinite");
		
		/* Adding the buttons to the panel */
		this.add(btEasy);
		this.add(btMedium);
		this.add(btDifficult);
		this.add(btCustom);
		this.add(btInfinite);
	}
}
