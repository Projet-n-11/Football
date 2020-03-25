package gui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import databall.DataBall;
import datateam.DataTeam;
import process.management.CreaTeam;

public class GraphicalField extends JPanel {

	/*
	 *  GraphicalField is the frame that will generate the Soccer field, it will
	 *  show the field with different draw forms to make the field's shape.
	 *  
	 *  @author Aladdine Ben Romdhane
	 * 
	 */

	private static final long serialVersionUID = -1333721048498985453L;
	private int widthx = 1000;
	private int widthy = 900;
	private DataTeam team, team2;
	private DataBall ball;
	private DrawField df;
	
	public GraphicalField(DataTeam team, DataTeam team2, DataBall ball){
		this.team = team;
		this.team2 = team2;
		this.ball = ball;
		initLayout(this.team, this.team2, ball);
	}
	
	private void initLayout(DataTeam team, DataTeam team2, DataBall ball) {
		df = new DrawField(team, team2, ball);
		Thread matchgui = new Thread(df);
		matchgui.start();
		df.setPreferredSize(new Dimension(900, 700));
		add(df);
		setBackground(new Color(0, 128, 0));
		setSize(widthx, widthy);
		setVisible(true);
	}
}
