package gui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import databall.DataBall;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.management.ConstantPosition;
import process.management.ConstantValues;
import process.management.CreaTeam;
import process.management.Map;
import process.management.Match;
import process.management.PositionBall;
import process.management.PositionTactics;
import process.movement.MovementBall;
import process.movement.MovementPlayer;
import process.scores.Score;

public class GraphicalField extends JPanel implements Runnable{

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
	private Score score;
	private static final int GAME_SPEED = ConstantValues.GAME_SPEED;
	
	public GraphicalField(DataTeam team, DataTeam team2, DataBall ball, Score score){
		this.team = team;
		this.team2 = team2;
		this.ball = ball;
		this.score = score;
		initLayout(this.team, this.team2, ball);
	}
	
	private void initLayout(DataTeam team, DataTeam team2, DataBall ball) {
		df = new DrawField(team, team2, ball);
		df.setPreferredSize(new Dimension(900, 700));
		add(df);
		setBackground(new Color(0, 128, 0));
		setSize(widthx, widthy);
		setVisible(true);
	}

	@Override
	public void run() {
		boolean paused = false;
		boolean alreadyPlacedLeft = false;
		//Initializing each elements from the game (map, placing the ball, placing each players following their tactics)
		Map field = new Map();
		PositionBall pb = new PositionBall(ball, field);
		PositionTactics pt = new PositionTactics(team, field, alreadyPlacedLeft);
		pt.placePlayers(team, field, alreadyPlacedLeft);
		alreadyPlacedLeft = true;
		PositionTactics pt2 = new PositionTactics(team2, field, alreadyPlacedLeft);
		pt2.placePlayers(team2, field, alreadyPlacedLeft);
		alreadyPlacedLeft = false;
		
		ArrayList<DataPlayer> allPlayersFromTeam1=new ArrayList<DataPlayer>(team.getPlayers().values());
		ArrayList<DataPlayer> allPlayersFromTeam2=new ArrayList<DataPlayer>(team2.getPlayers().values());
		ArrayList<DataPlayer> allPlayers = new ArrayList<DataPlayer>();
		
		Match m = new Match(team, team2, field, ball, score, pt, pt2);
		MovementBall mb = new MovementBall(ball, field, score, pt, pt2, team, team2);
		
		while(paused == false){
			try {
				mb.move(pb, field, pt, pt2, team, team2);
				m.matchOneRound();
				pb.setPositionBall(ball.getPositionX(), ball.getPositionY(), ball, field);
				this.repaint();
				Thread.sleep(GAME_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
