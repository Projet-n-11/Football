package datafield;

public class Goal extends AbstractPosition {
	private boolean insideBall;
	private int position2Y;
	public Goal(boolean insideBall, int positionX, int positionY, int position2Y) {
		super(positionX, positionY);
		
		this.position2Y=position2Y;
		this.insideBall = insideBall;
	}
	public boolean isInsideBall() {
		return insideBall;
	}

	public void setInsideBall(boolean insideBall) {
		this.insideBall = insideBall;
	}
	

	public int getPosition2Y() {
		return position2Y;
	}
	public void setPosition2Y(int position2y) {
		position2Y = position2y;
	}
	public String toString() {
		return "Is the ball inside of a goal? Answer : " + insideBall;
	}
}
