package datafield;

public class Corner extends AbstractPosition {
	
	private boolean isCorner;
	
	public Corner(boolean isCorner, int positionX, int positionY) {
		super(positionX, positionY);
		
		this.isCorner = isCorner;
	}
	

	public boolean getIsCorner() {
		return isCorner;
	}
	public void setIsCorner(boolean isCorner) {
		this.isCorner = isCorner;
	}
	
	public String toString() {
		return "The corner is at position: " + super.getPositionX()+";"+super.getPositionY() + " and the ball is on corner position? Answer : " + isCorner; 
	}
	
}
