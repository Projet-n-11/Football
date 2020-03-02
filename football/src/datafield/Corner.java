package datafield;

public class Corner extends AbstractPosition {
	
	private boolean isCorner = false;
	
	public Corner(boolean isCorner, int positionX, int positionY) {
		super(positionX, positionY, "C");
		this.isCorner = isCorner;
	}
	

	public boolean getIsCorner() {
		return isCorner;
	}
	public void setIsCorner(boolean isCorner) {
		this.isCorner = isCorner;
	}
	
	public String toString() {
		return "Is the ball on the corner? " + isCorner; 
	}
	
}
