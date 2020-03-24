package gui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import datateam.DataTeam;
import process.management.CreaTeam;

public class GraphicalField extends JFrame {

	/*
	 *  GraphicalField is the frame that will generate the Soccer field, it will
	 *  show the field with different draw forms to make the field's shape.
	 *  
	 *  @author Aladdine Ben Romdhane
	 * 
	 */
	
	DrawField df;
	private static final long serialVersionUID = -1333721048498985453L;
	private int widthx = 1000;
	private int widthy = 900;
	
	public GraphicalField(){
		initLayout();
	}
	
	private void initLayout() {
		df = new DrawField();
		df.setPreferredSize(new Dimension(900, 700));
		add(df);
		setBackground(new Color(0, 128, 0));
		setSize(widthx, widthy);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GraphicalField();
	}
}
