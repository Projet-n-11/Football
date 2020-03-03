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
		g4.scale(scale, scale);
		g4.translate(1, 1);
		g4.setColor(new Color(0,0,0,200));
		g4.setStroke(stroke);
		
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
		g3.draw(new Line2D.Double(ConstantPosition.CORNER1X, 0, j ,90));
	}
}
