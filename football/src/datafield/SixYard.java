package datafield;

public class SixYard extends AbstractPosition {
	private boolean sixYardPoint;

	public SixYard(boolean sixYardPoint, int positionX, int positionY) {
		super(positionX, positionY);
		this.sixYardPoint = sixYardPoint;
	}
	public boolean isSixYardPoint() {
		return sixYardPoint;
	}

	public void setSixYardPoint(boolean sixYardPoint) {
		this.sixYardPoint = sixYardPoint;
	}
	
	public String toString() {
		return "Is the ball on a sixYard point? Answer : " + sixYardPoint;
	}
	
}
