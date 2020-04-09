package process.movement;

import databall.DataBall;
import dataplayer.DataPlayer;
import dataplayer.PlayerSpeed;
import datafield.Corner;
import datafield.Goal;
import datafield.SpecialPosition;
import process.management.PositionBall;
import process.management.ConstantPosition;
import process.management.Map;
/**
 * @author quitt
 *
 */
public class MovementBall {
	
	
	public MovementBall(DataBall db, Map table){
		PositionBall pb;
		pb=new PositionBall(db, table);
		move(db,pb,table);

	}
	
	public void move(DataBall db, PositionBall pb, Map table) {
		
		if(limitsGoalLeft(db)) {
			System.out.println("GOAL !!! Congratulations team2  ");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			pb.placeBallEngagement(db, table);
		}
		
		else if(limitsGoalRight(db)) {
			System.out.println("GOAL !!! Congratulations team1  ");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			pb.placeBallEngagement(db, table);
		}
		else if (limitsSideLineTop(db)) {
			System.out.println("THROW (top)!!!");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			pb.setPositionBall(db.getPositionX(), ConstantPosition.INITIAL_POINT, db, table);
		}
		else if (limitsSideLineBottom(db)) {
			System.out.println("THROW (bottom)!!!");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			//pb.setPositionBall(db.getPositionX(), ConstantPosition.HEIGHT, db, table);
		}
		else if(limitsCornersLeft(db)) {
			System.out.println("Corner Left");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			pb.setPositionBall(ConstantPosition.SIXYARD1X, ConstantPosition.SIXYARD1Y, db, table);
		}
		else if(limitsCornersRight(db)) {
			System.out.println("Corner Right");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			pb.setPositionBall(ConstantPosition.SIXYARD2X, ConstantPosition.SIXYARD2Y, db, table);
		}
		else {
			//System.out.println("no problem with limits");
		}
	}
		
	public boolean limitsGoalLeft (DataBall db) {
		
		if(db.getPositionX()<ConstantPosition.GOAL1X) {
			if(db.getPositionY()>ConstantPosition.GOALY1 && db.getPositionY()<ConstantPosition.GOALY2) {
				
				
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	
	public boolean limitsGoalRight(DataBall db) {
		if(db.getPositionX()>ConstantPosition.GOAL2X) {
			if(db.getPositionY()>ConstantPosition.GOALY1 && db.getPositionY()<ConstantPosition.GOALY2) {
				
				return true;
				
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean limitsSideLineTop(DataBall db) {
		if(db.getPositionX()>ConstantPosition.INITIAL_POINT && db.getPositionX()<ConstantPosition.WIDTH) {
			if(db.getPositionY()<ConstantPosition.INITIAL_POINT) {
			
				return true;
			}
			
		
			else {
				return false;
			}
		}
		else {
			return false;
		}
			
	}
	public boolean limitsSideLineBottom(DataBall db) {
		if(db.getPositionX()>ConstantPosition.INITIAL_POINT && db.getPositionX()<ConstantPosition.WIDTH) {
			
			if(db.getPositionY()>ConstantPosition.HEIGHT) {

				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean limitsCornersLeft(DataBall db) {
		
		if(db.getPositionX()<ConstantPosition.CORNER1X) {
			if(db.getPositionY()>ConstantPosition.CORNER1Y && db.getPositionY()<ConstantPosition.GOALY1) {
				
				return true;
			}
			else if (db.getPositionY()<ConstantPosition.CORNER2Y && db.getPositionY()>ConstantPosition.GOALY2) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean limitsCornersRight(DataBall db) {
		
		if(db.getPositionX()>ConstantPosition.CORNER3X) {
			if(db.getPositionY()>ConstantPosition.CORNER3Y && db.getPositionY()<ConstantPosition.GOALY1) {
				
				return true;
			}
			else if (db.getPositionY()<ConstantPosition.CORNER4Y && db.getPositionY()>ConstantPosition.GOALY2) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
