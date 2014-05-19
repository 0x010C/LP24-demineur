import java.awt.Color;
import java.awt.Dimension;
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
		
		/* Adding of the GridLayout to RulesPanel */
		this.setLayout(gl);
		
		/* Creation of the buttons */
		JButton btEasy = new JButton();
		JButton btMedium = new JButton();
		JButton btDifficult = new JButton();
		JButton btCustom = new JButton();
		JButton btInfinite = new JButton();
		
		/* Setting the buttons' texts */
		btEasy.setText("Easy");
		btMedium.setText("Medium");
		btDifficult.setText("Difficult");
		btCustom.setText("Custom");
		btInfinite.setText("Infinite");
		
		/* Adding the buttons to the panel */
		this.add(btEasy);
		this.add(btMedium);
		this.add(btDifficult);
		this.add(btCustom);
		this.add(btInfinite);
	}
}
