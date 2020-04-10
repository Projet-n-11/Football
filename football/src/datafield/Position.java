package datafield;


public class Position{
	private volatile int posX, posY;
	
	public Position() {
		this.posX = 0;
		this.posY = 0;
	}
	
	public Position(int positionx, int positiony) {
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
	
	public void setPositionY(int posY) {
		this.posY = posY;
	}
	
	public String toString() {
		return "X= " + posX + "; Y= "+ posY;
	}
	
}
