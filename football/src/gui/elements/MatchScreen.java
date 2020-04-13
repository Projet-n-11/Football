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
import process.scores.Score;

public class MatchScreen extends JPanel{

	private static final long serialVersionUID = 2301016752658769684L;
	
	public MatchScreen(DataTeam team, DataTeam team2, DataBall ball, Score score) {
		initLayout(team, team2, ball, score);
	}
	
	public void initLayout(DataTeam team, DataTeam team2, DataBall ball, Score score) {
		GraphicalField field = new GraphicalField(team, team2, ball, score);
		ChronometerGUI chrono = new ChronometerGUI();
		ScoresGUI scores = new ScoresGUI(score, team, team2);
		Thread matchgui = new Thread(field);
		matchgui.start();
		
        this.setLayout(new BorderLayout());
        this.add(chrono,BorderLayout.NORTH);
        this.add(field, BorderLayout.CENTER);
        this.add(scores,BorderLayout.SOUTH);
        this.add(new JButton("joueurs de l'�quipe 2"),BorderLayout.EAST);
        this.add(new JButton("joueurs de l'�quipe 1"),BorderLayout.WEST);
	}
}
