package datafield;

public class Penalty extends AbstractPosition {
	
	private boolean fault;
	
	public Penalty( boolean fault, int positionX, int positionY) {
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
		return "Penalty [fault=" + fault + "position:"+super.getPositionX()+";"+super.getPositionY()+"]";
	}
	
	
}
