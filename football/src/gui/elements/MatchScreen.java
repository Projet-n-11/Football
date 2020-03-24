package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import process.scores.ChronometerGUI;

public class MatchScreen extends JFrame{

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
        this.setLayout(new BorderLayout());
        this.add(chrono,BorderLayout.NORTH);
        this.add(field, BorderLayout.CENTER);
        this.add(new JButton("BAS"),BorderLayout.SOUTH);
        this.add(new JButton("DROITE"),BorderLayout.EAST);
        this.add(new JButton("GAUCHE"),BorderLayout.WEST);
      
        this.setVisible(true);
        this.setLocation(350,150);
        return container;
	}

	public static void main(String[] args) {
		new MatchScreen();
	}
}
