package datafield;

public class Penalty extends AbstractPosition {
	
	private boolean fault;
	private int posX, posY;
	
	public Penalty(boolean fault, int positionX, int positionY) {
		super(positionX, positionY, "PE");
		this.posX = positionX;
		this.posY = positionY;
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
		return "Fault =" + fault + "position:"+super.getPositionContent(posX, posY) + "]";
	}
	
	
}
