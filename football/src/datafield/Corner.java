package datafield;

public class Corner extends AbstractPosition {
	private int cornerPoint;
	private boolean isCorner;
	
	public Corner(int cornerPoint, boolean isCorner, int position) {
		super(position);
		this.cornerPoint = cornerPoint;
		this.isCorner = isCorner;
	}
	
	public int isCornerPoint() {
		return cornerPoint;
	}
	public void setCornerPoint(int cornerPoint) {
		this.cornerPoint = cornerPoint;
	}
	public boolean isCorner() {
		return isCorner;
	}
	public void setCorner(boolean isCorner) {
		this.isCorner = isCorner;
	}
	
	public String toString() {
		return "The corner is at position: " + cornerPoint + " and the ball is on corner position? Answer : " + isCorner; 
	}
}
