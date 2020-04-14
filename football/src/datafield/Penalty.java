package datafield;

public class Penalty extends Position {
	
	private boolean fault;
	
	
	public Penalty(boolean fault, int positionX, int positionY) {
		super(positionX, positionY);

		this.fault = fault;
	}


	public boolean isFault() {
		return fault;
	}
	public void setFault(boolean fault) {
		this.fault = fault;
	}

	@Override
	public String toString() {
		return "fault=" + fault + ", positions:  "+super.getPositionX()+super.getPositionY();
	}

	
}
