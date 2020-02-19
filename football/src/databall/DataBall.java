package databall;

public class DataBall {
	private final int BALLSIZE = 2;
	private final String COLOR = "White";
	private int position;
	
	public DataBall(int position) {
		this.position = position;
	}
	
	public int getBallsize() {
		return BALLSIZE;
	}
	public String getColor() {
		return COLOR;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String toString() {
		return "Ball size is : " + BALLSIZE + " and it's color is : " + COLOR + " for the position : " + position;
	}
}
