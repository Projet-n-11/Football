package gui.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import process.management.ConstantPosition;
import process.management.ConstantTactics;

public class DrawField extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8187623550893249601L;

	public DrawField() {
		repaint();
		setBackground(new Color(0, 128, 0));
		//setBackground(new Color(0, 0, 0));
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		Graphics2D g3 = (Graphics2D) g.create();
		Graphics2D g4 = (Graphics2D) g.create();
		Graphics2D g5 = (Graphics2D) g.create();
		double width = getWidth();
		double height = getHeight();
		double fieldLength = 120d;
		double fieldWidth = 90d;
		double scaleWidth = fieldLength+2;
		double scaleHeight = fieldWidth+2;
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
		g4.scale(scale, scale);
		g4.translate(1, 1);
		g4.setColor(Color.RED);
		g4.setStroke(stroke2);
		//g5
		g5.scale(scale, scale);
		g5.translate(1,1);
		g5.setColor(Color.YELLOW);
		g5.setStroke(stroke2);
		
		drawGrid(g3, fieldLength, fieldWidth);
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
		drawSpecialPositions(g4, fieldLength, fieldWidth);
		drawPlayersTactics(g5, fieldLength, fieldWidth);
	}
	
	private void drawPenaltyArches(Graphics2D g2, double fieldLength,
			double fieldWidth) {
//		double extent = 2*Math.toDegrees(Math.acos(6d/10d));
		double extent = 106.26020470831196d;
		g2.draw(new Arc2D.Double(fieldLength-12-10, (fieldWidth/2)-10, 20, 20, 180-(extent/2), extent, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(12-10, (fieldWidth/2)-10, 20, 20, -extent/2, extent, Arc2D.OPEN));
	}

	private void drawPenaltyMarks(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.fill(new Ellipse2D.Double(fieldLength-12-(10d/36), (fieldWidth/2)-(10d/36), (20d/36), (20d/36)));
		g2.fill(new Ellipse2D.Double(12-(10d/36), (fieldWidth/2)-(10d/36), (20d/36), (20d/36)));
	}

	private void drawPenaltyAreas(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Rectangle2D.Double(0, (fieldWidth/2)-22, 18, 42));
		g2.draw(new Rectangle2D.Double(fieldLength-18, (fieldWidth/2)-22, 18, 42));
	}

	private void drawGoalAreas(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Rectangle2D.Double(0, (fieldWidth/2)-10, 6, 20));
		g2.draw(new Rectangle2D.Double(fieldLength-6, (fieldWidth/2)-10, 6, 20));
	}

	private void drawGoals(Graphics2D g2, double fieldLength, double fieldWidth) {
		g2.draw(new Rectangle2D.Double(-1, (fieldWidth/2)-4, 1, 8));
		g2.draw(new Rectangle2D.Double(fieldLength, (fieldWidth/2)-4, 1, 8));
	}

	private void drawCornerArches(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Arc2D.Double(-1, -1, 2, 2, 270, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(fieldLength-1, -1, 2, 2, 180, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(fieldLength-1, fieldWidth-1, 2, 2, 90, 90, Arc2D.OPEN));
		g2.draw(new Arc2D.Double(-1, fieldWidth-1, 2, 2, 0, 90, Arc2D.OPEN));
	}

	private void drawCenterMark(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.fill(new Ellipse2D.Double((fieldLength/2)-(10d/36), (fieldWidth/2)-(10d/36), (20d/36), (20d/36)));
	}

	private void drawCenterCircle(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Ellipse2D.Double((fieldLength/2)-10, (fieldWidth/2)-10, 20, 20));
	}

	private void drawCenterLine(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Line2D.Double(fieldLength/2, 0, fieldLength/2, fieldWidth));
	}

	private void drawGoalLines(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Line2D.Double(0, 0, 0, fieldWidth));
		g2.draw(new Line2D.Double(fieldLength, 0, fieldLength, fieldWidth));
	}

	private void drawTouchLines(Graphics2D g2, double fieldLength,
			double fieldWidth) {
		g2.draw(new Line2D.Double(0, 0, fieldLength, 0));
		g2.draw(new Line2D.Double(0, fieldWidth, fieldLength, fieldWidth));
	}
	
	private void drawGrid(Graphics2D g3, double fieldLength, double fieldWidth) {
		for(int i=0; i<90; i++) {
			g3.draw(new Line2D.Double(0, i, 120 , i));
		}
		
		for(int j=0; j<120; j++) {
			g3.draw(new Line2D.Double(j, 0, j ,90));
		}
	}
	
	private void drawSpecialPositions(Graphics2D g4, double fieldLength, double doubleWidth) {
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
	
	private void drawPlayersTactics(Graphics2D g5, double fieldLength, double doubleWidth) {
		g5.draw(new Line2D.Double(ConstantTactics.GOALKEEPERX, ConstantTactics.GOALKEEPERY, ConstantTactics.GOALKEEPERX ,ConstantTactics.GOALKEEPERY));
		g5.draw(new Line2D.Double(ConstantTactics.FRONT_DEFENDERX, ConstantTactics.FRONT_DEFENDERY, ConstantTactics.FRONT_DEFENDERX ,ConstantTactics.FRONT_DEFENDERY));
		g5.draw(new Line2D.Double(ConstantTactics.LEFT_DEFENDERX, ConstantTactics.LEFT_DEFENDERY, ConstantTactics.LEFT_DEFENDERX ,ConstantTactics.LEFT_DEFENDERY));
		g5.draw(new Line2D.Double(ConstantTactics.RIGHT_DEFENDERX, ConstantTactics.RIGHT_DEFENDERY, ConstantTactics.RIGHT_DEFENDERX ,ConstantTactics.RIGHT_DEFENDERY));
		g5.draw(new Line2D.Double(ConstantTactics.LEFT_MIDFIELDERX, ConstantTactics.LEFT_MIDFIELDERY, ConstantTactics.LEFT_MIDFIELDERX ,ConstantTactics.LEFT_MIDFIELDERY));
		g5.draw(new Line2D.Double(ConstantTactics.MIDLEFT_MIDFIELDERX, ConstantTactics.MIDLEFT_MIDFIELDERY, ConstantTactics.MIDLEFT_MIDFIELDERX ,ConstantTactics.MIDLEFT_MIDFIELDERY));
		g5.draw(new Line2D.Double(ConstantTactics.MIDRIGHT_MIDFIELDERX, ConstantTactics.MIDRIGHT_MIDFIELDERY, ConstantTactics.MIDRIGHT_MIDFIELDERX ,ConstantTactics.MIDRIGHT_MIDFIELDERY));
		g5.draw(new Line2D.Double(ConstantTactics.RIGHT_MIDFIELDERX, ConstantTactics.RIGHT_MIDFIELDERY, ConstantTactics.RIGHT_MIDFIELDERX ,ConstantTactics.RIGHT_MIDFIELDERY));
		g5.draw(new Line2D.Double(ConstantTactics.RIGHT_FORWARDX, ConstantTactics.RIGHT_FORWARDY, ConstantTactics.RIGHT_FORWARDX ,ConstantTactics.RIGHT_FORWARDY));
		g5.draw(new Line2D.Double(ConstantTactics.LEFT_FORWARDX, ConstantTactics.LEFT_FORWARDY, ConstantTactics.LEFT_FORWARDX ,ConstantTactics.LEFT_FORWARDY));
		g5.draw(new Line2D.Double(ConstantTactics.MID_FORWARDX, ConstantTactics.MID_FORWARDY, ConstantTactics.MID_FORWARDX ,ConstantTactics.MID_FORWARDY));

	}
}
