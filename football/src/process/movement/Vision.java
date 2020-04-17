package process.movement;

import java.util.ArrayList;

import datafield.Position;
import datafield.Grass;
import process.management.ConstantPosition;
import process.management.ConstantValues;
import process.management.Map;

public class Vision {
	
	
	/**
	 * this function takes in parameters the position of a player and return
	 * an arrayList of all objects around it (radius of 15 squares)
	 * @param x
	 * @param y
	 * @return ArrayList<AbstractPosition> objects
	 */
	 public ArrayList<Position> see(int x, int y, Map position) {
	        ArrayList<Position> objects = new ArrayList<Position>();
	        int radiusVision = ConstantValues.RADIUSVISION+15;
	        int i=0, j=0; 

	        for (i=-radiusVision; i<=radiusVision; i++) {
	            for (j=-radiusVision; j<=radiusVision; j++) {
	                if (!(i+x<ConstantPosition.INITIAL_POINT || i+x>ConstantPosition.WIDTH 
	                		|| j+y<ConstantPosition.INITIAL_POINT || j+y>ConstantPosition.HEIGHT)) {
	                    if((i!=0 && j!=0 && position.getElement(i+x, j+y)!=null)) {  
	                        objects.add(position.getElement(i+x, j+y));
	                    }
	                }
	            }
	        }
	        return objects;
	    }
	    
	    public ArrayList<Position> largeSee(int x, int y, Map position) {
	        ArrayList<Position> objects = new ArrayList<Position>();
	        int radiusVision = ConstantValues.RADIUSVISION+15;
	        int i=0, j=0; 

	        for (i=-radiusVision; i<=radiusVision; i++) {
	            for (j=-radiusVision; j<=radiusVision; j++) {
	                if (!(i+x<ConstantPosition.INITIAL_POINT || i+x>ConstantPosition.WIDTH 
	                		|| j+y<ConstantPosition.INITIAL_POINT || j+y>ConstantPosition.HEIGHT)) {
	                    if((i!=0 && j!=0 && position.getElement(i+x, j+y)!=null)) { 
	                        objects.add(position.getElement(i+x, j+y));
	                    }
	                }
	            }
	        }
	        return objects;
	    }
	
	public ArrayList<Position> Goalsee(int x, int y, Map position) {
		ArrayList<Position> objects = new ArrayList<Position>();
		int radiusVision = ConstantValues.RADIUSVISION+5;
		int i=0, j=0; 

		for (i=-radiusVision; i<=radiusVision; i++) {
			for (j=-radiusVision; j<=radiusVision; j++) {
                if (!(i+x<0 || i+x>120 || j+y<0 || j+y>90)) {
                	if(i!=0 && j!=0 && position.getElement(i+x, j+y) != null) { 
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
	
	public Boolean seeCages(int playerPosX, int playerPosY, Boolean itsUserRound) {
		if (!itsUserRound)
		{
			if (playerPosX<=ConstantPosition.GOAL1X+10)
			{
				return true;
			}
		}
		else
		{
			if (playerPosX>=ConstantPosition.GOAL2X-10)
			{
				return true;
			}
		}
		return false;
	}
}
