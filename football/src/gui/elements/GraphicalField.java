package gui.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class GraphicalField extends JFrame{

	/*
	 *  GraphicalField is the frame that will generate the Soccer field, it will
	 *  show the field with different draw forms to make the field's shape.
	 *  
	 *  @author Aladdine Ben Romdhane
	 * 
	 */
	
	DrawField df;
	private static final long serialVersionUID = -1333721048498985453L;
	private int widthx = 780;
	private int widthy = 620;
	
	public GraphicalField() {
		super("Graphical Field v0.1");
		initLayout();
	}
	
	private void initLayout() {
		df = new DrawField();
		add(df);
		setBackground(new Color(0, 128, 0));
		setSize(widthx, widthy);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GraphicalField();
	}
}
