package gui.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import databall.DataBall;
import datateam.DataTeam;
import process.scores.ChronometerGUI;

public class MatchScreen extends JPanel implements Runnable{

	private static final long serialVersionUID = 2301016752658769684L;
	private int widthx = 1300;
	private int widthy = 800;
	
	public MatchScreen(DataTeam team, DataTeam team2, DataBall ball) {
		initLayout(team, team2, ball);
	}
	
	public void initLayout(DataTeam team, DataTeam team2, DataBall ball) {
		GraphicalField field = new GraphicalField(team, team2, ball);
		ChronometerGUI chrono = new ChronometerGUI();
		
        this.setLayout(new BorderLayout());
        this.add(chrono,BorderLayout.NORTH);
        this.add(field, BorderLayout.CENTER);
        this.add(new JButton("Score des �quipes"),BorderLayout.SOUTH);
        this.add(new JButton("joueurs de l'�quipe 2"),BorderLayout.EAST);
        this.add(new JButton("joueurs de l'�quipe 1"),BorderLayout.WEST);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
