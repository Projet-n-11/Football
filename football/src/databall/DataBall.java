package databall;

import datafield.Position;
import dataplayer.DataPlayer;

public class DataBall extends Position{
	private final int BALLSIZE = 2;
	private final String COLOR = "White";
	
	private int speedX, speedY;
	private DataPlayer ownedBy;
	
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
		return "Ball size is : " + BALLSIZE + " and it's color is : " + COLOR + " for the position | x : " + getPositionX() + " ; y =" + getPositionY();
	}

	public DataPlayer getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(DataPlayer ownedBy) {
		this.ownedBy = ownedBy;
	}
	
}
