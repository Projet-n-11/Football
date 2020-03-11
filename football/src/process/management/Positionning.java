package process.management;

import datafield.AbstractPosition;
import datafield.Grass;

public class Positionning {
	private AbstractPosition[][] position;
	
	public Positionning(){
		
		for(int x=0; x<ConstantPosition.WIDTH; x++) {
			for(int y=0; y<ConstantPosition.HEIGHT; y++) {
				Grass xy = new Grass(x, y);
				this.position[x][y] = xy;
			}
		}
	}

	public void setElement(AbstractPosition element) {
		this.position[element.getPositionX()][element.getPositionY()] = element;
	}
	
	public AbstractPosition getElement(int posX, int posY) {
		return position[posX][posY];
	}
	
	public void testParcourir(int x, int y) {
		int radiusVision = 15;
		
	}
	/*
	public AbstractPosition guessObject(int posX, int posY) {
		if (position[posX][posY] instanceof Grass) {}
		return null;
	}
	*/

}
