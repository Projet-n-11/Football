package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import process.scores.ChronometerGUI;

public class MatchScreen extends JPanel{

	private static final long serialVersionUID = 2301016752658769684L;
	private int widthx = 1300;
	private int widthy = 800;
	
	public MatchScreen() {
		
		JPanel container=initLayout();
	}
	
	public JPanel initLayout() {
		JPanel container = new JPanel();
		GraphicalField field = new GraphicalField();
		ChronometerGUI chrono = new ChronometerGUI();
        this.setSize(widthx, widthy);
        
        container.setLayout(new BorderLayout());
        container.add(chrono,BorderLayout.NORTH);
        container.add(field, BorderLayout.CENTER);
        container.add(new JButton("BAS"),BorderLayout.SOUTH);
        container.add(new JButton("DROITE"),BorderLayout.EAST);
        container.add(new JButton("GAUCHE"),BorderLayout.WEST);
      
        this.setVisible(true);
        this.setLocation(350,150);
        return container;
	}

}
