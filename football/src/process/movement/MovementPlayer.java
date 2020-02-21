package process.movement;

import databall.DataBall;
import dataplayer.DataPlayer;


/*
 * Class which will do the player's movement based on the ball's position.
 * Player will always try to move next to the ball
 * 
 * @author Aladdine Ben Romdhane
 */
public class MovementPlayer /*implements Movement*/ {

	private final int BORDERTOP = 0;
	private final int BORDERBOTTOM = 48;
	private final int BORDERLEFT = 0;
	private final int BORDERRIGHT = 84;
	//private int movX = 0;
	//private int movY = 0;

	
	public MovementPlayer(DataBall db, DataPlayer dp) {
		Move(db, dp);
		Limits(dp);
	}
	
	
	//We didn't took the player speed (with the class PlayerSpeed) so we will just add 1 or subtract 1 to get an elementary move.
	
		/*
		 * Method Move will be the method that moves the players based to 
		 * where the ball is, at every moment
		 * 
		 * @param DataBall db, DataPlayer dp
		 */
	
	public void Move(DataBall db, DataPlayer dp) {
		/*
		 * Player's conditions so he'll run to the ball's position
		 * to get it. Only for the x axis.
		 * 
		 */
		if(db.getPositionX() < dp.getPositionX()) {
			dp.setPositionX(dp.getPositionX() - 1);
		}
		else if(db.getPositionX() > dp.getPositionX()) {
			dp.setPositionX(dp.getPositionX() + 1);
		}
		
		/*
		 * Player's conditions so he'll run to the ball's position
		 * to get it. Only for the y axis.
		 * 
		 */
		if(db.getPositionY() < dp.getPositionY()) {
			dp.setPositionY(dp.getPositionY() - 1);
		}
		else if(db.getPositionY() > dp.getPositionY()) {
			dp.setPositionY(dp.getPositionY() + 1);
		}
	}

	/*
	 * Méthod limits will be delimiting the players limitations on the playfield
	 * so the player can get out of the field
	 * @param DataBall db, DataPlayer dp
	 */
	
	public void Limits(DataPlayer dp) {
		
		if(dp.getPositionX() == BORDERLEFT || dp.getPositionX() < BORDERLEFT) {
			dp.setPositionX(BORDERLEFT);
		}
		else if( dp.getPositionX() == BORDERRIGHT ||dp.getPositionX() > BORDERRIGHT) {
			dp.setPositionX(BORDERRIGHT);
		}
		else if(dp.getPositionX() < BORDERLEFT && dp.getPositionY() < BORDERTOP) {
			dp.setPositionX(BORDERLEFT);
			dp.setPositionY(BORDERTOP);
		}
		else if(dp.getPositionY() == BORDERTOP || dp.getPositionY() < BORDERTOP) {
			dp.setPositionY(BORDERTOP);
		}
		else if(dp.getPositionY() == BORDERBOTTOM || dp.getPositionY() > BORDERBOTTOM) {
			dp.setPositionY(BORDERBOTTOM);
		}
		else if(dp.getPositionX() > BORDERRIGHT && dp.getPositionY() > BORDERBOTTOM) {
			dp.setPositionX(BORDERRIGHT);
			dp.setPositionY(BORDERBOTTOM);
		}
	}
	
}