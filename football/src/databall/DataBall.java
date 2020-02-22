package databall;

public class DataBall {
	private final int BALLSIZE = 2;
	private final String COLOR = "White";
	private int positionx, positiony;
	private float speed;
	public DataBall() {
		this.positionx =69;
		this.positiony = 7;
	}
	
	public DataBall(int positionx, int positiony) {
		this.positionx = positionx;
		this.positiony = positiony;
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
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed=speed;
	}
	public String toString() {
		return "Ball size is : " + BALLSIZE + " and it's color is : " + COLOR + " for the position | x : " + positionx + " ; y =" + positiony;
	}
	
}
