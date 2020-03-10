package datafield;

public abstract class AbstractPosition{
	private int posX, posY;
	
	public AbstractPosition() {
		this.posX = 0;
		this.posY = 0;
	}
	
	public AbstractPosition(int positionx, int positiony) {
		this.posX = positionx; 
		this.posY = positiony;
	}
	
	public int getPositionX() {
		return posX;
	}


	public void setPositionX(int posX) {
		this.posX = posX;
	}


	public int getPositionY() {
		return posY;
	}
	
	public String toString() {
		return "X= " + posX + "; Y= "+ posY;
	}
	
}
