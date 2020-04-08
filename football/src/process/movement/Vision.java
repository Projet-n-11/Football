package process.movement;

import java.util.ArrayList;

import datafield.Position;
import dataplayer.DataPlayer;
import datafield.Grass;
import process.management.ConstantPosition;
import process.management.Map;

public class Vision {
	
	
	/**
	 * this function takes in parameters the position of a player and return
	 * an arrayList of all objects around it (radius of 15 squares)
	 * @param x
	 * @param y
	 * @return ArrayList<AbstractPosition> objects
	 */
	public static ArrayList<Position> see(int x, int y, Map position) {
		ArrayList<Position> objects = new ArrayList<Position>();
		int radiusVision = ConstantPosition.RADIUSVISION;
		int i=0, j=0; 

		for (i=0; i<=radiusVision; i++) {
			for (j=0; j<=radiusVision; j++) {
                if (!(i+x<0 || i+x>120 || j+y<0 || j+y>90)) {
                	if(!(position.getElement(i+x, j+y) instanceof Grass)) { 
                		objects.add(position.getElement(i+x, j+y));
                	}
                }
			}
		}
		return objects;
	}
	/**
	 * this position
	 * @param player
	 * @param ball
	 * @return true/false
	 */
	public Boolean areClose(Position a, Position b) {
		int dx = a.getPositionX()-b.getPositionX();
		int dy = a.getPositionY()-b.getPositionY();
		if (dx<=1 && dx>=-1) 
		{
			if (dy<=1 && dy>=-1) 
			{
				return true;
			}
		}
		return false;
	}
	
	public Boolean isPossessed(Position ball, Map position) {
        int x = ball.getPositionX();
        int y = ball.getPositionY();
        if ( (x+1<122) || (x-1>=0) || (y+1<92) || (y-1>=0) ) {
            if (position.getElement(x, y+1) instanceof DataPlayer
                    || position.getElement(x-1, y) instanceof DataPlayer
                    || position.getElement(x+1, y) instanceof DataPlayer
                    || position.getElement(x, y-1) instanceof DataPlayer) {
                return true;
            }
        }
        return false;
    }
}
