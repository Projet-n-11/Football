package datafield;

public class Penalty extends AbstractPosition {
	private int penaltyPoint;
	private boolean fault;
	
	public Penalty(int penaltyPoint, boolean fault, int position) {
		super(position);
		this.penaltyPoint = penaltyPoint;
		this.fault = fault;
	}
	public int isPenaltyPoint() {
		return penaltyPoint;
	}
	public void setPenaltyPoint(int penaltyPoint) {
		this.penaltyPoint = penaltyPoint;
	}
	public boolean isFault() {
		return fault;
	}
	public void setFault(boolean fault) {
		this.fault = fault;
	}
}
