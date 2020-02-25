package datafield;

public abstract class AbstractPosition{
	private int positionx, positiony;
	
	public AbstractPosition(int positionx, int positiony) {
		this.positionx = positionx;
		this.positiony = positiony;
	}
	public int getPositionX() {
		return positionx;
	}
	public void setPositionX(int newPositionX) {
		this.positionx = newPositionX;
	}
	
	public int getPositionY() {
		return positiony;
	}
	public void setPositionY(int newPositionY) {
		this.positiony = newPositionY;
	}
	
	public String toString() {
		return "X =" + positionx + " ; Y =" + positiony;
	}
	
}
