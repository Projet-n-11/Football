package data;

public class Penalty extends AbstractPosition {
	private boolean penaltyPoint;
	private boolean fault;
	
	public boolean isPenaltyPoint() {
		return penaltyPoint;
	}
	public void setPenaltyPoint(boolean penaltyPoint) {
		this.penaltyPoint = penaltyPoint;
	}
	public boolean isFault() {
		return fault;
	}
	public void setFault(boolean fault) {
		this.fault = fault;
	}
}
