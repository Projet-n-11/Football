package process.movement;
import databall.DataBall;
import dataplayer.DataPlayer;
import dataplayer.PlayerSpeed;
import datafield.Corner;
import datafield.Goal;
import datafield.SpecialPosition;
import process.scores.Score;
/**
 * @author quitt
 *
 */
public class MovementBall {
	private final int BORDERTOP = 6;
	private final int BORDERBOTTOM = 42;
	private final int BORDERLEFT = 7;
	private final int BORDERRIGHT = 77;
	private Score results=new Score(null, null);
	public MovementBall(DataBall db, DataPlayer dp) {
		
		move(db,dp);
		
	}
	
	public void move(DataBall db, DataPlayer dp) {
		while(dp.getPositionX()==db.getPositionX() && dp.getPositionY()==db.getPositionY() && limits(db)) {
			PlayerSpeed v=dp.getPlayerType().getSpeed();
			db.setSpeedX(v.getSpeedX());
			db.setSpeedY(v.getSpeedY());
			db.setPositionX(db.getPositionX()+db.getSpeedX());
			db.setPositionY(db.getPositionY()+db.getSpeedY());
			System.out.println("―――――――――――――――");
			System.out.println("Coordinates  ball: x = " + db.getPositionX() + " ; y = " + db.getPositionY());
			System.out.println("Coordinates  player: x = " + dp.getPositionX() + " ; y = " + dp.getPositionY());
			System.out.println("―――――――――――――――");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		db.setSpeedX(0);
		db.setSpeedY(0);
	}
	
	public Boolean limits(DataBall db) {
		SpecialPosition sp=new SpecialPosition();
		Boolean corner=limitsCorner(db,sp);
		Boolean goal=limitsGoal(db,sp);
		if(goal==true){
			System.out.println("GOAL!!!");
			results.toString();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			
			db.setPositionX(sp.getEngagement().getPositionX());
			db.setPositionY(sp.getEngagement().getPositionY());
			return false;
		}
		else if(corner==true) {
			return false;
			
		}
		else if(db.getPositionX()>=BORDERLEFT && db.getPositionX()<=BORDERRIGHT) {
			if(db.getPositionY()<BORDERTOP ) {
				System.out.println("THROW!!!");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				db.setPositionY(BORDERTOP);
				return false;
			}
			else if(db.getPositionY()>BORDERBOTTOM ) {
				System.out.println("THROW!!!");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				db.setPositionY(BORDERBOTTOM);
				return false;
			}
			else {
				System.out.println("Coordinates : x = " + db.getPositionX() + " ; y = " + db.getPositionY());
				return true;
			}
		}
		else {
			return true;
		}
		
		
		
	}
	
	public Boolean limitsCorner(DataBall db,SpecialPosition sp) {
		
		Corner c1=sp.getCorner1();
		Corner c2=sp.getCorner2();
		Corner c3=sp.getCorner3();
		Corner c4=sp.getCorner4();
		
		if(db.getPositionX()<=c1.getPositionX() && db.getPositionY()>=0 ) {
			db.setPositionX(c1.getPositionX());
			db.setPositionY(c1.getPositionY());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			return true;
			
		}
		else if(db.getPositionX()<=c2.getPositionX() && db.getPositionY()<=48) {
			db.setPositionX(c2.getPositionX());
			db.setPositionY(c2.getPositionY());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			return true;
		}
		else if(db.getPositionX()>=c3.getPositionX() && db.getPositionY()>=0) {
			db.setPositionX(c3.getPositionX());
			db.setPositionY(c3.getPositionY());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			return true;
		}
		else if(db.getPositionX()>=c4.getPositionX() && db.getPositionY()<=48) {
			db.setPositionX(c4.getPositionX());
			db.setPositionY(c4.getPositionY());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			return true;
		}
		
		else {
			return  false;
		}
		
	}
	
	public Boolean limitsGoal(DataBall db,SpecialPosition sp) {
		Goal g1=sp.getGoal1();
		Goal g2=sp.getGoal2();
		if(db.getPositionX()<=g1.getPositionX()) {
			if(db.getPositionY()>=g1.getPositionY() && db.getPositionY()<=g1.getPosition2Y()) {
				
				results.setScoreTeam2(results.getScoreTeam2()+1);
				
				return true;
			}
			else {
				return false;
			}
			
		}
		else if(db.getPositionX()>=g2.getPositionX()) {
			if(db.getPositionY()>=g2.getPositionY() && db.getPositionY()<=g2.getPosition2Y()) {
				
				results.setScoreTeam1(results.getScoreTeam1()+1);
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
