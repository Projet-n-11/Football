package gui.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
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
	private ChronometerGUI chrono;
	private JFrame frame;
	private JPanel transitionPanel;
	
	private static final int GAME_SPEED = ConstantValues.GAME_SPEED;

	public GraphicalField(DataTeam team, DataTeam team2, DataBall ball, Score score, JFrame frame, ChronometerGUI chrono){
		this.team = team;
		this.team2 = team2;
		this.ball = ball;
		this.score = score;
		this.frame = frame;
		this.chrono = chrono;
		initLayout(this.team, this.team2, this.ball);
	}

	private void initLayout(DataTeam team, DataTeam team2, DataBall ball) {
		df = new DrawField(team, team2, ball);
		df.setPreferredSize(new Dimension(900, 700));
		add(df);
		setBackground(new Color(0, 128, 0));
		setSize(widthx, widthy);
		setVisible(true);
		this.repaint();
	}

	private void initTransitionLayout(JPanel panel) {
		this.remove(df);
		this.setBackground(new Color(245, 235, 200));
		this.add(panel);
		this.repaint();
	}
	
	@Override
	public void run() {
		boolean started = true;
		boolean paused = false;
		boolean alreadyPlacedLeft = false;
		boolean transition = false;
		int game_duration = 0; // This will represent the actual time which will help to know when to put the TransitionPanel
		
		//Initializing each elements from the game (map, placing the ball, placing each players following their tactics)
		Map field = Map.getInstance();
		PositionBall pb = new PositionBall(ball, field);
		PositionTactics pt = new PositionTactics(team, field, alreadyPlacedLeft);
		pt.placePlayers(team, field, alreadyPlacedLeft);
		alreadyPlacedLeft = true;
		PositionTactics pt2 = new PositionTactics(team2, field, alreadyPlacedLeft);
		pt2.placePlayers(team2, field, alreadyPlacedLeft);
		alreadyPlacedLeft = false;

		ArrayList<DataPlayer> allPlayersFromTeam1 = new ArrayList<DataPlayer>(team.getPlayers().values());
		ArrayList<DataPlayer> allPlayersFromTeam2 = new ArrayList<DataPlayer>(team2.getPlayers().values());
		ArrayList<DataPlayer> allPlayers = new ArrayList<DataPlayer>();
		MovementBall mb = new MovementBall(ball, field, score, pt, pt2, team, team2, pb);
		Match m = new Match(team, team2, field, ball, mb);
		TransitionPanel tp = new TransitionPanel("Transition Panel", frame, team);	
	    transitionPanel = tp.createTransitionPanel();
		
		while(started == true) {
			if(paused == false) {
				while(game_duration < ConstantValues.TRANSITION_TIME) {
					try{
						Thread.sleep(GAME_SPEED);
						this.repaint();
						m.matchOneRound();
						pb.setPositionBall(ball.getPositionX(), ball.getPositionY(), ball, field);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					game_duration++;
				}
				chrono.pause();
				transition = true;
				paused = true;
			}
			else {
				if(transition == true) {
					remove(df);
					initTransitionLayout(transitionPanel);
					transition = false;
				}
				
				if(tp.isResumed() == true){
					add(df);
					setBackground(new Color(0, 128, 0));
					chrono.resume();
					paused = false;
					game_duration = 0;
					tp.setResumedFalse();
				}
			}
		}
	}
}
