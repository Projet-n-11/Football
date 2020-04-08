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
import process.management.CreaTeam;
import process.management.Map;
import process.management.Match;
import process.management.PositionBall;
import process.management.PositionTactics;
import process.movement.MovementBall;

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
	
	public GraphicalField(DataTeam team, DataTeam team2, DataBall ball){
		this.team = team;
		this.team2 = team2;
		this.ball = ball;
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
		int posXinc = 1;
		ArrayList<DataPlayer> allPlayersFromTeam1=new ArrayList<>(team.getPlayers().values());
		ArrayList<DataPlayer> allPlayersFromTeam2=new ArrayList<>(team2.getPlayers().values());
		ArrayList<DataPlayer> allPlayers = new ArrayList<>();
		while(paused == false){
			try {		
				//System.out.println(ball.getPositionX() + " : " + ball.getPositionY());
				boolean alreadyPlacedLeft = false;
				Map p = new Map();
				PositionTactics pt = new PositionTactics(team, p, alreadyPlacedLeft);
				alreadyPlacedLeft = true;
				PositionTactics pt2 = new PositionTactics(team2, p, alreadyPlacedLeft);
				PositionBall pb = new PositionBall(ball, p);
				pb.setPositionBall(20+posXinc, 10 + posXinc, ball, p);
				MovementBall mb = new MovementBall(ball, p);
				Match m = new Match();
				allPlayers.addAll(allPlayersFromTeam1);
				allPlayers.addAll(allPlayersFromTeam2);
				m.matchOneRound(team, team2, p, ball);
				this.repaint();
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		posXinc++;
		}
	}
}
