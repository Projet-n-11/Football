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
		int i=0, j=0, verticalLimit=0;
		for (i=(-radiusVision); i<=radiusVision ;i++) {
			if (i==-15 || i==15) verticalLimit=4;
			else if (i==(-14) || i==14) verticalLimit=7;	
			else if (i==(-13) || i==13) verticalLimit=9;
			else if (i==(-12) || i==12) verticalLimit=10;
			else if (i==(-11) || i==11) verticalLimit=11;
			else if (i==(-10) || i==10) verticalLimit=12;
			else if (i==(-9) || i==9) verticalLimit=13;
			else if (i==(-7) || i==7) verticalLimit=14;
			else if (i==(-4) || i==4) verticalLimit=15;
			
			for (j=(-verticalLimit); j<=verticalLimit; j++) {
                if (!(i<0 || i>122 || j<0 || j>92)) {
                	if(!(position.getElement(i, j) instanceof Grass)) { 
                		objects.add(position.getElement(i, j));
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
