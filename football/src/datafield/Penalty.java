package datafield;

public class Penalty extends Position {
	
	private boolean fault;
	private int posX, posY;
	
	public Penalty(boolean fault, int positionX, int positionY) {
		super(positionX, positionY);
		this.posX = positionX;
		this.posY = positionY;
		this.fault = fault;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean isFault() {
		return fault;
	}
	public void setFault(boolean fault) {
		this.fault = fault;
	}

	@Override
	public String toString() {
		return "fault=" + fault + ", posX=" + posX + ", posY=" + posY;
	}

	
}
