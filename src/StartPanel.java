import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class StartPanel extends JPanel{
	public StartPanel(){
		super();
		this.setBackground(Color.white);
		
		/* Definition of Panels */
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel column = new JPanel();
		//column.setSize(new Dimension(1100,400));
		
		/* Definition of the BoxLayouts */
		p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));
		p3.setLayout(new BoxLayout(p3, BoxLayout.LINE_AXIS));
		p4.setLayout(new BoxLayout(p4, BoxLayout.LINE_AXIS));
		column.setLayout(new BoxLayout(column, BoxLayout.PAGE_AXIS));
		
		/* Adding of the different panels to the panel column */
		column.add(p1);
		column.add(Box.createVerticalGlue());
		column.add(p2);
		column.add(Box.createVerticalGlue());
		column.add(p3);
		column.add(Box.createVerticalGlue());
		column.add(p4);
		
		/* Creation of the buttons and setting the buttons' texts */
		JButton btEasy = new JButton("Easy");
		JButton btMedium = new JButton("Medium");
		JButton btDifficult = new JButton("Difficult");
		JButton btCustom = new JButton("Custom");
		JButton btInfinite = new JButton("Infinite");
		
		/* Define the size of the buttons */
		//btEasy.setPreferredSize(new Dimension(100,100));
		
		/* Adding the buttons to the panels */
		p1.add(new Label("Choose the difficulty."));
		
		p2.add(btEasy);
		//p2.add(Box.createHorizontalGlue());
		p2.add(btMedium);
		p2.
		p3.add(btDifficult);
		p3.add(Box.createHorizontalGlue());
		p3.add(btCustom);
		
		p4.add(btInfinite);
		
		/* Adding of the panel column to StartPanel */
		this.add(column);
	}
}
