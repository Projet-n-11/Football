package process.movement;

import java.util.ArrayList;

import datafield.Position;
import datafield.Grass;
import process.management.ConstantPosition;
import process.management.Map;

public class Vision {
	
	private static Map position;	// singleton !
	
	/**
	 * this function takes in parameters the position of a player and return
	 * an arrayList of all objects around it (radius of 15 squares)
	 * @param x
	 * @param y
	 * @return ArrayList<AbstractPosition> objects
	 */
	public static ArrayList<Position> see(int x, int y) {
		ArrayList<Position> objects = new ArrayList<Position>();
		int radiusVision = ConstantPosition.RADIUSVISION;
		int i=0, j=0, verticalLimit=0;
		for (i=(-radiusVision); i<=radiusVision ;i++) {
			if (i==-15 || i==15) verticalLimit=4;			// ideally; replace this part with
			else if (i==(-14) || i==14) verticalLimit=7;	// trigonometrical calculus
			else if (i==(-13) || i==13) verticalLimit=9;
			else if (i==(-12) || i==12) verticalLimit=10;
			else if (i==(-11) || i==11) verticalLimit=11;
			else if (i==(-10) || i==10) verticalLimit=12;
			else if (i==(-9) || i==9) verticalLimit=13;
			else if (i==(-7) || i==7) verticalLimit=14;
			else if (i==(-4) || i==4) verticalLimit=15;
			
				for (j=(-verticalLimit); j<=verticalLimit; j++) {
					if (!(position.getElement(i, j) instanceof Grass)) { 
						objects.add(position.getElement(i, j));
						} 
					}
		}
		return objects;
		
	}
	
}
