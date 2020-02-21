package datafield;

public class Goal extends AbstractPosition {
	private boolean insideBall;

	public Goal(boolean insideBall, int positionX, int positionY) {
		super(positionX, positionY);
		this.insideBall = insideBall;
	}
	public boolean isInsideBall() {
		return insideBall;
	}

	public void setInsideBall(boolean insideBall) {
		this.insideBall = insideBall;
	}
	
	public String toString() {
		return "Is the ball inside of a goal? Answer : " + insideBall;
	}
}
