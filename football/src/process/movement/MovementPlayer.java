package process.movement;

import databall.DataBall;
import datafield.Position;
import datafield.SpecialPosition;
import dataplayer.DataPlayer;


/*
 * Class which will do the player's movement based on the ball's position.
 * Player will always try to move next to the ball
 * 
 * @author Aladdine Ben Romdhane
 */
public class MovementPlayer{

	private final int BORDERTOP = 0;
	private final int BORDERBOTTOM = 48;
	private final int BORDERLEFT = 0;
	private final int BORDERRIGHT = 84;
	private SpecialPosition specPos;
	//private int movX = 0;
	//private int movY = 0;
	
	
	
	public MovementPlayer() {
		specPos = new SpecialPosition();
	}
	
	
	//We didn't took the player speed (with the class PlayerSpeed) so we will just add 1 or subtract 1 to get an elementary move.
	
		/*
		 * Method Move will be the method that moves the players based to 
		 * where the ball is, at every moment
		 * 
		 * @param DataBall db, DataPlayer dp
		 */
	public void move(Position db, DataPlayer dp) {
		/*
		 * Player's conditions so he'll run to the ball's position
		 * to get it. Only for the x axis.
		 * 
		 */	
		while(dp.getPositionY() != db.getPositionY() || dp.getPositionX() != db.getPositionX() && limits(dp))
		{
					if(db.getPositionX() < dp.getPositionX()) {
						//////////////////////////////////////
						if(dp.getPositionX() - db.getPositionX() == 1) {
							dp.setPositionX(dp.getPositionX() - 1);
						}
						else if(dp.getPositionX() - db.getPositionX() <= dp.getPlayerType().getSpeed().getSpeedX() ) {
							dp.setPositionX(db.getPositionX());
						}
						else {
							dp.setPositionX(dp.getPositionX() - dp.getPlayerType().getSpeed().getSpeedX());
						}
						//////////////////////////////////////j
					}
					else if(db.getPositionX() > dp.getPositionX()) {
						//////////////////////////////////////
						if(dp.getPositionX() - db.getPositionX() == 1) {
							dp.setPositionX(dp.getPositionX() + 1);
						}
						else if(db.getPositionX() - dp.getPositionX() <= dp.getPlayerType().getSpeed().getSpeedX()) {
							dp.setPositionX(db.getPositionX());
						}
						else {
							dp.setPositionX(dp.getPositionX() + dp.getPlayerType().getSpeed().getSpeedX());
						}
						//////////////////////////////////////
					}
				
				/*
				 * Player's conditions so he'll run to the ball's position
				 * to get it. Only for the y axis.
				 *  
				 */
				if(db.getPositionY() < dp.getPositionY()) {
					//////////////////////////////////:
					if(dp.getPositionY() - db.getPositionY() == 1) {
						dp.setPositionY(dp.getPositionY() - 1);
					}
					else if(dp.getPositionY() - db.getPositionY() <= dp.getPlayerType().getSpeed().getSpeedY()){
						dp.setPositionY(db.getPositionY());
					}
					else {
						dp.setPositionY(dp.getPositionY() - dp.getPlayerType().getSpeed().getSpeedY());
					}
					//////////////////////////////////:
				}
				else if(db.getPositionY() > dp.getPositionY()) {
					//////////////////////////////////:
					if(dp.getPositionY() - db.getPositionY() == 1) {
						dp.setPositionY(dp.getPositionY() + 1);
					}
					else if(db.getPositionY() - dp.getPositionY() <= dp.getPlayerType().getSpeed().getSpeedY()){
						dp.setPositionY(db.getPositionY());
					}
					else {
						dp.setPositionY(dp.getPositionY() + dp.getPlayerType().getSpeed().getSpeedY());
					}
					//////////////////////////////////:
				}	
				// System.out.println("Coordinates : x = " + dp.getPositionX() + " ; y = " + dp.getPositionY());
		}
	}

	public void runWithBall(Position ball, DataPlayer player, boolean itsUserRound) {
		int d= 0;
		Position goal;
		if (itsUserRound) // in order to know which goal to go...
		{
			goal = specPos.getGoal2();
		}
		else{
			goal = specPos.getGoal1();
		}
		 
		int x = player.getPositionX();
		//int y = player.getPositionY(); //stock old position to know direction and then which side place ball
		
		move(goal, player);
		if ( ( x - player.getPositionX() )>=0 ) // d is to place ball on the good side of player
		{
			d = 1;
		}
		else 
		{
			d = -1;
		} 
		ball.setPositionX(player.getPositionX()+d);
		ball.setPositionY(player.getPositionY());
	}
	
	/*
	 * Method limits will be delimiting the players limitations on the playfield
	 * so the player can get out of the field
	 * @param DataBall db, DataPlayer dp
	 */
	
	public Boolean limits(DataPlayer dp) {
		
		if(dp.getPositionX() == BORDERLEFT || dp.getPositionX() < BORDERLEFT) {
			dp.setPositionX(BORDERLEFT);
			return false;
		}
		else if( dp.getPositionX() == BORDERRIGHT ||dp.getPositionX() > BORDERRIGHT) {
			dp.setPositionX(BORDERRIGHT);
			return false;
		}
		else if(dp.getPositionX() < BORDERLEFT && dp.getPositionY() < BORDERTOP) {
			dp.setPositionX(BORDERLEFT);
			dp.setPositionY(BORDERTOP);
			return false;
		}
		else if(dp.getPositionY() == BORDERTOP || dp.getPositionY() < BORDERTOP) {
			dp.setPositionY(BORDERTOP);
			return false;
		}
		else if(dp.getPositionY() == BORDERBOTTOM || dp.getPositionY() > BORDERBOTTOM) {
			dp.setPositionY(BORDERBOTTOM);
			return false;
		}
		else if(dp.getPositionX() > BORDERRIGHT && dp.getPositionY() > BORDERBOTTOM) {
			dp.setPositionX(BORDERRIGHT);
			dp.setPositionY(BORDERBOTTOM);
			return false;
		}
		else {
			return true;
		}
	}


}