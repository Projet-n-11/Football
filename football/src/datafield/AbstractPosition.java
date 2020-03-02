package datafield;

public abstract class AbstractPosition{
	private String position[][];
	private int posX, posY;
	
	public AbstractPosition(int positionx, int positiony, String element) {
		this.posX = positionx; 
		this.posY = positiony;
		this.position[posX][posY] = element;
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


	public String getPositionContent(int x, int y) {
		return position[x][y];
	}
	
	public void setPositionX(int x, int y, String newelement) {
		this.position[x][y] = newelement;
	}
	
	
	public String toString() {
		String content = "";
		for(int i = 0; i<position.length; i++) {
			for(int j=0; j <position[i].length; j++) {
				content += position[i][j];
			}
		}
		return content;
	}
	
}
