package databall;

import datafield.Position;

public class DataBall extends Position{
	private final int BALLSIZE = 2;
	private final String COLOR = "White";
	private int positionx, positiony;
	private int speedX, speedY;
	
	public DataBall() {
		super();
		this.speedX = 0;
		this.speedY = 0;
	}
	
	public DataBall(int positionx, int positiony) {
		super(positionx, positiony);
	}
	
	public int getBallsize() {
		return BALLSIZE;
	}
	
	public String getColor() {
		return COLOR;
	}
	
	public int getPositionX() {
		return positionx;
	}
	
	public void setPositionX(int positionx) {
		this.positionx = positionx;
	}
	public int getPositionY() {
		return positiony;
	}
	public void setPositionY(int positiony) {
		this.positiony = positiony;
	}
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX=speedX;
	}
	public int getSpeedY() {
		return speedY;
		
	}
	public void setSpeedY(int speedY) {
		this.speedY=speedY;
	}
	public String toString() {
		return "Ball size is : " + BALLSIZE + " and it's color is : " + COLOR + " for the position | x : " + positionx + " ; y =" + positiony;
	}
	
}
