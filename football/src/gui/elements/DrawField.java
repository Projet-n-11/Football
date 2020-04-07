package gui.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import databall.DataBall;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.management.ConstantPosition;
import process.management.ConstantTactics;
import process.management.CreaTeam;
import process.management.Map;
import process.management.Match;
import process.management.PositionBall;
import process.management.PositionTactics;
import process.movement.MovementBall;
import process.movement.MovementPlayer;
import process.movement.Vision;

public class DrawField extends JPanel implements Runnable {

	private static final long serialVersionUID = 8187623550893249601L;
	
	private DataTeam team, team2;
	private static DataBall ball;
	private static ArrayList<DataPlayer> Pteam, IAteam;
	
	public DrawField(DataTeam team, DataTeam team2, DataBall ball) {
		this.team = team;
		Pteam = new ArrayList<>(team.getPlayers().values());
		this.team2 = team2;
		IAteam = new ArrayList<>(team2.getPlayers().values());
		this.ball = ball;
		setBackground(new Color(0, 128, 0));
		setBackground(new Color(0, 128, 0));
		setSize(1920, 1080);
		setVisible(true);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//graphics for the field
		Graphics2D g2 = (Graphics2D) g.create();
		//graphics to create the tab
		Graphics2D g3 = (Graphics2D) g.create();
		//graphics for the special positions
		Graphics2D g4 = (Graphics2D) g.create();
		//graphics for right field players (tactics)
		Graphics2D g5 = (Graphics2D) g.create();
		//graphics for left field players (tactics)
		Graphics2D g6 = (Graphics2D) g.create();
		//graphics for the ball (tactics)
		Graphics2D g7 = (Graphics2D) g.create();
		double width = getWidth();
		double height = getHeight();
		double fieldLength = 120d;
		double fieldWidth = 90d;
		double scaleWidth = fieldLength+2.5;
		double scaleHeight = fieldWidth+2.5;
		double scale;
		if((width/height) >= (110d/70d)) {
			scale = height/scaleHeight;
		} else {
			scale = width/scaleWidth;
		}
		Stroke stroke = new BasicStroke(2/20);
		//g2
		g2.scale(scale, scale);
		g2.translate(1, 1);
		g2.setColor(Color.WHITE);
		g2.setStroke(stroke);
		//g3
		g3.scale(scale, scale);
		g3.translate(1, 1);
		g3.setColor(new Color(0,0,0,200));
		g3.setStroke(stroke);
		//g4
		Stroke stroke2 = new BasicStroke(5/4);
		Stroke stroke3 = new BasicStroke(8/4);
		g4.scale(scale, scale);
		g4.translate(1, 1);
		g4.setColor(Color.RED);
		g4.setStroke(stroke2);
		//g5
		g5.scale(scale, scale);
		g5.translate(1,1);
		g5.setColor(Color.YELLOW);
		g5.setStroke(stroke3);
		//g6
		g6.scale(scale, scale);
		g6.translate(1,1);
		g6.setColor(Color.BLUE);
		g6.setStroke(stroke3);
		//g7
		g7.scale(scale, scale);
		g7.translate(1,1);
		g7.setColor(Color.BLACK);
		g7.setStroke(stroke2);
		//drawGrid(g3, fieldLength, fieldWidth);
		drawTouchLines(g2, fieldLength, fieldWidth);
		drawGoalLines(g2, fieldLength, fieldWidth);
		drawCenterLine(g2, fieldLength, fieldWidth);
		drawCenterCircle(g2, fieldLength, fieldWidth);
		drawCenterMark(g2, fieldLength, fieldWidth);
		drawCornerArches(g2, fieldLength, fieldWidth);
		drawGoals(g2, fieldLength, fieldWidth);
		drawGoalAreas(g2, fieldLength, fieldWidth);
		drawPenaltyAreas(g2, fieldLength, fieldWidth);
		drawPenaltyMarks(g2, fieldLength, fieldWidth);
		drawPenaltyArches(g2, fieldLength, fieldWidth);
		//drawSpecialPositions(g4, fieldLength, fieldWidth);
		//drawPlayersTacticsR(g5, fieldLength, fieldWidth);
		//drawPlayersTacticsL(g6, fieldLength, fieldWidth);
		try {
			drawPlayers(g6, g5, fieldLength, fieldWidth);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drawBall(g7, fieldLength, fieldWidth);
	}
	
	public void drawPenaltyArches(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		double extent = 2*Math.toDegrees(Math.acos(6d/10d));
		//double extent = 106.26020470831196d;
		g2.draw(new Arc2D.Double(fieldLength-12-10, (fieldWidth/2)-10, 20, 20, 180-(extent/2), extent, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(12-10, (fieldWidth/2)-10, 20, 20, -extent/2, extent, Arc2D.OPEN));
	}

	public void drawPenaltyMarks(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.fill(new Ellipse2D.Double(fieldLength-12-(10d/36), (fieldWidth/2)-(10d/36), (20d/36), (20d/36)));
		g2.fill(new Ellipse2D.Double(12-(10d/36), (fieldWidth/2)-(10d/36), (20d/36), (20d/36)));
	}

	public void drawPenaltyAreas(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Rectangle2D.Double(0, (fieldWidth/2)-22, 18, 42));
		g2.draw(new Rectangle2D.Double(fieldLength-18, (fieldWidth/2)-22, 18, 42));
	}

	public void drawGoalAreas(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Rectangle2D.Double(0, (fieldWidth/2)-10, 6, 20));
		g2.draw(new Rectangle2D.Double(fieldLength-6, (fieldWidth/2)-10, 6, 20));
	}

	public void drawGoals(Graphics2D g2, double fieldLength, double fieldWidth) {
		g2.draw(new Rectangle2D.Double(-1, (fieldWidth/2)-4, 1, 8));
		g2.draw(new Rectangle2D.Double(fieldLength, (fieldWidth/2)-4, 1, 8));
	}

	public void drawCornerArches(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Arc2D.Double(-1, -1, 2, 2, 270, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(fieldLength-1, -1, 2, 2, 180, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(fieldLength-1, fieldWidth-1, 2, 2, 90, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(-1, fieldWidth-1, 2, 2, 0, 90, Arc2D.OPEN));
	}

	public void drawCenterMark(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.fill(new Ellipse2D.Double((fieldLength/2)-(10d/36), (fieldWidth/2)-(10d/36), (20d/36), (20d/36)));
	}

	public void drawCenterCircle(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Ellipse2D.Double((fieldLength/2)-10, (fieldWidth/2)-10, 20, 20));
	}

	public void drawCenterLine(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Line2D.Double(fieldLength/2, 0, fieldLength/2, fieldWidth));
	}

	public void drawGoalLines(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Line2D.Double(0, 0, 0, fieldWidth));
		g2.draw(new Line2D.Double(fieldLength, 0, fieldLength, fieldWidth));
	}

	public void drawTouchLines(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Line2D.Double(0, 0, fieldLength, 0));
		g2.draw(new Line2D.Double(0, fieldWidth, fieldLength, fieldWidth));
	}
	
	public void drawGrid(Graphics2D g3, double fieldLength, double fieldWidth) {
		for(int i=-1; i<ConstantPosition.HEIGHT+2; i++) {
			g3.draw(new Line2D.Double(-1, i, ConstantPosition.WIDTH+1, i));
		}
		
		for(int j=-1; j<ConstantPosition.WIDTH+2; j++) {
			g3.draw(new Line2D.Double(j, -1, j ,ConstantPosition.HEIGHT+1));
		}
	}
	
	public void drawSpecialPositions(Graphics2D g4, double fieldLength, double doubleWidth) {
		g4.draw(new Line2D.Double(ConstantPosition.CORNER1X, ConstantPosition.CORNER1Y, ConstantPosition.CORNER1X ,ConstantPosition.CORNER1Y));
		g4.draw(new Line2D.Double(ConstantPosition.CORNER2X, ConstantPosition.CORNER2Y, ConstantPosition.CORNER2X ,ConstantPosition.CORNER2Y));
		g4.draw(new Line2D.Double(ConstantPosition.CORNER3X, ConstantPosition.CORNER3Y, ConstantPosition.CORNER3X ,ConstantPosition.CORNER3Y));
		g4.draw(new Line2D.Double(ConstantPosition.CORNER4X, ConstantPosition.CORNER4Y, ConstantPosition.CORNER4X ,ConstantPosition.CORNER4Y));
		g4.draw(new Line2D.Double(ConstantPosition.PENALTY1X, ConstantPosition.PENALTY1Y, ConstantPosition.PENALTY1X ,ConstantPosition.PENALTY1Y));
		g4.draw(new Line2D.Double(ConstantPosition.PENALTY2X, ConstantPosition.PENALTY2Y, ConstantPosition.PENALTY2X ,ConstantPosition.PENALTY2Y));
		g4.draw(new Line2D.Double(ConstantPosition.ENGAGEMENTX, ConstantPosition.ENGAGEMENTY, ConstantPosition.ENGAGEMENTX ,ConstantPosition.ENGAGEMENTY));
		g4.draw(new Line2D.Double(ConstantPosition.SIXYARD1X, ConstantPosition.SIXYARD1Y, ConstantPosition.SIXYARD1X ,ConstantPosition.SIXYARD1Y));
		g4.draw(new Line2D.Double(ConstantPosition.SIXYARD2X, ConstantPosition.SIXYARD2Y, ConstantPosition.SIXYARD2X ,ConstantPosition.SIXYARD2Y));
		g4.draw(new Line2D.Double(ConstantPosition.GOAL1X, ConstantPosition.GOALY1, ConstantPosition.GOAL1X ,ConstantPosition.GOALY2));
		g4.draw(new Line2D.Double(ConstantPosition.GOAL2X, ConstantPosition.GOALY1, ConstantPosition.GOAL2X ,ConstantPosition.GOALY2));
	}
	
	public static void drawPlayers(Graphics2D gplayersteam, Graphics2D gplayersteam2, double fieldLength, double doubleWidth) throws IOException {
		Font font = new Font("Serif", Font.PLAIN, 2);
		gplayersteam.setFont(font);
		gplayersteam2.setFont(font);
		for(DataPlayer playersteam1 : Pteam) {
			gplayersteam.drawString(playersteam1.getPlayerName(), playersteam1.getPositionX()-2, playersteam1.getPositionY()-2);
			gplayersteam.draw(new Line2D.Double(playersteam1.getPositionX(), playersteam1.getPositionY(), playersteam1.getPositionX(), playersteam1.getPositionY()));
		}
		
		for(DataPlayer playersteam2 : IAteam) {
			gplayersteam2.drawString(playersteam2.getPlayerName(), playersteam2.getPositionX()-2, playersteam2.getPositionY()-2);
			gplayersteam2.draw(new Line2D.Double(playersteam2.getPositionX(), playersteam2.getPositionY(), playersteam2.getPositionX(), playersteam2.getPositionY()));
		}
	}
	
	public static void drawBall(Graphics2D gball, double fieldLength, double doubleWidth) {
		gball.draw(new Ellipse2D.Double(ball.getPositionX(), ball.getPositionY(), 0.6, 0.6));
	}

	@Override
	public void run() {
		boolean paused = false;
		int posXinc = 1;
		ArrayList<DataPlayer> allPlayersFromTeam1=new ArrayList<>(team.getPlayers().values());
		ArrayList<DataPlayer> allPlayersFromTeam2=new ArrayList<>(team2.getPlayers().values());
		ArrayList<DataPlayer> allPlayers = new ArrayList<>();
		//System.out.println(ball.getPositionX() + " : " + ball.getPositionY());
		while(paused == false){
			try {
				boolean alreadyPlacedLeft = false;
				Map p = new Map();
				PositionTactics pt = new PositionTactics(team, p, alreadyPlacedLeft);
				alreadyPlacedLeft = true;
				PositionTactics pt2 = new PositionTactics(team2, p, alreadyPlacedLeft);
				PositionBall pb = new PositionBall(ball, p);
				Thread.sleep(250);
				Random random = new Random();
				pb.setPositionBall(ConstantPosition.ENGAGEMENTX + random.nextInt(30), ConstantPosition.ENGAGEMENTY + random.nextInt(10), ball, p);
				MovementBall mb = new MovementBall(ball, p);
				MovementPlayer mp = new MovementPlayer();
				Match m = new Match();
				Vision vision = new Vision();
				allPlayers.addAll(allPlayersFromTeam1);
				allPlayers.addAll(allPlayersFromTeam2);
				
				for(DataPlayer dp: allPlayers) {
					mp.move(ball, dp);
					m.matchOneRound(team, team2, p, ball);
					if(vision.areClose(ball, dp)) {
						dp.setHaveBall(true);
					}
					
					if(dp.getHaveBall() == true) {
						System.out.println(dp.toString());
					}
				}
				this.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		posXinc++;
		}
	}
}