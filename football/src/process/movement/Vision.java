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
	 * an arrayList of all objects around it (radius of 30 squares)
	 * @param position on x-axis
	 * @param position on y-axis
	 * @return ArrayList<AbstractPosition> objects seen
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
	    
	 /**
	 * this function takes in parameters the position of a player and return
	 * an arrayList of all objects around it (radius of 40 squares)
	 * @param position on x-axis
	 * @param position on y-axis
	 * @return ArrayList<AbstractPosition> objects seen
	 */
	public ArrayList<Position> largeSee(int x, int y, Map position) {
	    ArrayList<Position> objects = new ArrayList<Position>();
	    int radiusVision = ConstantValues.RADIUSVISION+25;
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
	
	/**
	 * this function must be called for Goalies used. Their radius is
	 * 20 squares.
	 * It takes in parameters the position of the player and return
	 * an arrayList of all objects around it.
	 * @param position on x-axis
	 * @param position on y-axis
	 * @return ArrayList<AbstractPosition> objects seen
	 */
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
	 * this function use the position (x,y) of a player and determines if the
	 * cages he has to shoot are close enough. The distance is 13 squares.
	 * @param playerPosX
	 * @param playerPosY
	 * @param itsUserRound
	 * @return true/false
	 */
	public Boolean seeCages(int playerPosX, int playerPosY, Boolean itsUserRound) {
		if (!itsUserRound)
		{
			if (playerPosX<=ConstantPosition.GOAL1X+13)
			{
				return true;
			}
		}
		else
		{
			if (playerPosX>=ConstantPosition.GOAL2X-13)
			{
				return true;
			}
		}
		return false;
	}
}
