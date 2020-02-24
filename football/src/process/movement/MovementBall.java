package process.movement;
import dataplayer.AbstractDataPlayerType;
import databall.DataBall;
import dataplayer.DataPlayer;
import dataplayer.PlayerSpeed;


/**
 * @author quitt
 *
 */
public class MovementBall {
	private final int BORDERTOP = 6;
	private final int BORDERBOTTOM = 42;
	private final int BORDERLEFT = 6;
	private final int BORDERRIGHT = 78;
	
	public MovementBall(DataBall db, DataPlayer dp) {
		move(db,dp);
		
	}
	
	public void move(DataBall db, DataPlayer dp) {
		while(dp.getPositionX()==db.getPositionX() && dp.getPositionY()==db.getPositionY()) {
			PlayerSpeed v=dp.getPlayerType().getSpeed();
			db.setSpeedX(v.getSpeedX());
			db.setSpeedY(v.getSpeedY());
			db.setPositionX(db.getPositionX()+db.getSpeedX());
			db.setPositionY(db.getPositionY()+db.getSpeedY());
			System.out.println("-----------------------------------");
			System.out.println("Coordinates  ball: x = " + db.getPositionX() + " ; y = " + db.getPositionY());
			System.out.println("Coordinates  player: x = " + dp.getPositionX() + " ; y = " + dp.getPositionY());
			System.out.println("-----------------------------------");
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		db.setSpeedX(0);
		db.setSpeedY(0);
		
		
	}
	
	public Boolean Limits(DataBall db) {
		
		if(db.getPositionX() == BORDERLEFT || db.getPositionX() < BORDERLEFT) {
			db.setPositionX(BORDERLEFT);
			return false;
		}
		else if( db.getPositionX() == BORDERRIGHT ||db.getPositionX() > BORDERRIGHT) {
			db.setPositionX(BORDERRIGHT);
			return false;
		}
		else if(db.getPositionX() < BORDERLEFT && db.getPositionY() < BORDERTOP) {
			db.setPositionX(BORDERLEFT);
			db.setPositionY(BORDERTOP);
			return false;
		}
		else if(db.getPositionY() == BORDERTOP || db.getPositionY() < BORDERTOP) {
			db.setPositionY(BORDERTOP);
			return false;
		}
		else if(db.getPositionY() == BORDERBOTTOM || db.getPositionY() > BORDERBOTTOM) {
			db.setPositionY(BORDERBOTTOM);
			return false;
		}
		else if(db.getPositionX() > BORDERRIGHT && db.getPositionY() > BORDERBOTTOM) {
			db.setPositionX(BORDERRIGHT);
			db.setPositionY(BORDERBOTTOM);
			return false;
		}
		
		System.out.println("Coordinates : x = " + db.getPositionX() + " ; y = " + db.getPositionY());
		return true;
	}
	
}
