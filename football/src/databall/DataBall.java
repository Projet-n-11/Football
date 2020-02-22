package databall;

public class DataBall {
	private final int BALLSIZE = 2;
	private final String COLOR = "White";
	private int positionx, positiony;
	
	public DataBall() {
		this.positionx = 50;
		this.positiony = 48;
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
	
	public String toString() {
		return "Ball size is : " + BALLSIZE + " and it's color is : " + COLOR + " for the position | x : " + positionx + " ; y =" + positiony;
	}
}
