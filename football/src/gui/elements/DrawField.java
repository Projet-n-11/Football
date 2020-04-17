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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
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

public class DrawField extends JPanel {

	private static final long serialVersionUID = 8187623550893249601L;
	
	@SuppressWarnings("unused")
	private DataTeam team, team2;
	private DataBall ball;
	private static ArrayList<DataPlayer> Pteam, IAteam;
	
	public DrawField(DataTeam team, DataTeam team2, DataBall ball) {
		this.team = team;
		Pteam = new ArrayList<>(team.getPlayers().values());
		this.team2 = team2;
		IAteam = new ArrayList<>(team2.getPlayers().values());
		this.ball = ball;
		
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
		
		double width = getWidth() - 35;
		double height = getHeight() - 35;
		double fieldLength = ConstantPosition.WIDTH;
		double fieldWidth = ConstantPosition.HEIGHT;
		double scaleWidth = fieldLength+3;
		double scaleHeight = fieldWidth+3;
		double scale;
		
		if((width/height) >= (120d/90d)) {
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
		g6.setStroke(stroke3);
		//g7
		g7.scale(scale, scale);
		g7.translate(1,1);
		g7.setColor(Color.BLACK);
		g7.setStroke(stroke2);
		
		
		if(team.getColor().contains("green")) {
			g6.setColor(Color.GREEN);
		}
		else if(team.getColor().contains("blue")) {
			g6.setColor(Color.BLUE);
		}
		else if(team.getColor().contains("red")) {
			g6.setColor(Color.RED);
		}
		else if(team.getColor().contains("black")) {
			g6.setColor(Color.BLACK);
		}
		else if(team.getColor().contains("beige")) {
			g6.setColor(new Color(245, 245, 220));
		}
		else if(team.getColor().contains("yellow")) {
			g6.setColor(Color.YELLOW);
		}
		else {
			g6.setColor(Color.WHITE);
		}

		if(team2.getColor().contains("green")) {
			g5.setColor(Color.GREEN);
		}
		else if(team2.getColor().contains("blue")) {
			g5.setColor(Color.BLUE);
		}
		else if(team2.getColor().contains("red")) {
			g5.setColor(Color.RED);
		}
		else if(team2.getColor().contains("black")) {
			g5.setColor(Color.BLACK);
		}
		else if(team2.getColor().contains("beige")) {
			g5.setColor(new Color(245, 245, 220));
		}
		else if(team2.getColor().contains("yellow")) {
			g5.setColor(Color.YELLOW);
		}
		else {
			g5.setColor(Color.WHITE);
		}
		
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
		drawPlayers(g6, g5, fieldLength, fieldWidth);
		drawBall(g7, fieldLength, fieldWidth);
	}
	
	public void drawPenaltyArches(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		double extent = 2*Math.toDegrees(Math.acos(6d/10d));
		//double extent = 106.26020470831196d;
		g2.draw(new Arc2D.Double(fieldLength-12-10, (fieldWidth/2)-10, 20, 20, 180-(extent/2), extent, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(12-4, (fieldWidth/2)-10, 20, 20, -extent/2, extent, Arc2D.OPEN));
	}

	public void drawPenaltyMarks(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.fill(new Ellipse2D.Double(fieldLength-12-(10d/36), (fieldWidth/2)-(10d/36), (20d/36), (20d/36)));
		g2.fill(new Ellipse2D.Double(18-(10d/36), (fieldWidth/2)-(10d/36), (20d/36), (20d/36)));
	}

	public void drawPenaltyAreas(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Rectangle2D.Double(6, (fieldWidth/2)-22, 18, 42));
		g2.draw(new Rectangle2D.Double(fieldLength-18, (fieldWidth/2)-22, 18, 42));
	}

	public void drawGoalAreas(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Rectangle2D.Double(6, (fieldWidth/2)-10, 6, 20));
		g2.draw(new Rectangle2D.Double(fieldLength-6, (fieldWidth/2)-10, 6, 20));
	}

	public void drawGoals(Graphics2D g2, double fieldLength, double fieldWidth) {
		g2.draw(new Rectangle2D.Double(5, (fieldWidth/2)-4, 1, 8));
		g2.draw(new Rectangle2D.Double(fieldLength, (fieldWidth/2)-4, 1, 8));
	}

	public void drawCornerArches(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Arc2D.Double(5, 5, 2, 2, 270, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(fieldLength-1, 5, 2, 2, 180, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(fieldLength-1, fieldWidth-1, 2, 2, 90, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(5, fieldWidth-1, 2, 2, 0, 90, Arc2D.OPEN));
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
		g2.draw(new Line2D.Double(fieldLength/2, 6, fieldLength/2, fieldWidth));
	}

	public void drawGoalLines(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Line2D.Double(6, 6, 6, fieldWidth));
		g2.draw(new Line2D.Double(fieldLength, 6, fieldLength, fieldWidth));
	}

	public void drawTouchLines(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Line2D.Double(6, 6, fieldLength, 6));
		g2.draw(new Line2D.Double(6, fieldWidth, fieldLength, fieldWidth));
	}
	
	public void drawGrid(Graphics2D g3, double fieldLength, double fieldWidth) {
		for(int i=-1; i<ConstantPosition.HEIGHT + 7; i++) {
			g3.draw(new Line2D.Double(-1, i, ConstantPosition.WIDTH + 7, i));
		}
		
		for(int j=-1; j<ConstantPosition.WIDTH + 10; j++) {
			g3.draw(new Line2D.Double(j, -1, j ,ConstantPosition.HEIGHT + 10));
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
	
	public void drawPlayers(Graphics2D gplayersteam, Graphics2D gplayersteam2, double fieldLength, double doubleWidth){
		Font font = new Font("SANS_SERIF", Font.BOLD, 2);
		gplayersteam.setFont(font);
		gplayersteam2.setFont(font);
		for(DataPlayer playersteam1 : Pteam) {
			if(playersteam1.getPlayerType().getTitularPlayer() == 1) {
				gplayersteam.drawString(playersteam1.getPlayerName(), playersteam1.getPositionX()-2, playersteam1.getPositionY()-2);
				gplayersteam.draw(new Line2D.Double(playersteam1.getPositionX(), playersteam1.getPositionY(), playersteam1.getPositionX(), playersteam1.getPositionY()));
			}
		}
		
		for(DataPlayer playersteam2 : IAteam) {
			if(playersteam2.getPlayerType().getTitularPlayer() == 1) {
				gplayersteam2.drawString(playersteam2.getPlayerName(), playersteam2.getPositionX()-2, playersteam2.getPositionY()-2);
				gplayersteam2.draw(new Line2D.Double(playersteam2.getPositionX(), playersteam2.getPositionY(), playersteam2.getPositionX(), playersteam2.getPositionY()));
			}
		}
	}
	
	public void drawBall(Graphics2D gball, double fieldLength, double doubleWidth) {        
		gball.draw(new Ellipse2D.Double(ball.getPositionX(), ball.getPositionY(), 0.4, 0.4));
	}
}