package process.movement;

import java.util.Random;

import databall.DataBall;
import datafield.Position;
import datafield.SpecialPosition;
import dataplayer.DataPlayer;
import process.management.ConstantPosition;


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
		Boolean positionOnX = false;
		Boolean positionOnY = false;

		if(db.getPositionX() < dp.getPositionX()) {
			if(dp.getPositionX() - db.getPositionX() == 1) {
				dp.setPositionX(dp.getPositionX() - 1);
			}
			else if(dp.getPositionX() - db.getPositionX() <= dp.getPlayerType().getSpeed().getSpeedX() ) {
				dp.setPositionX(db.getPositionX());
			}
			else {
				dp.setPositionX(dp.getPositionX() - dp.getPlayerType().getSpeed().getSpeedX());
			}
		}
		else if(db.getPositionX() > dp.getPositionX()) {
			if(dp.getPositionX() - db.getPositionX() == 1) {
				dp.setPositionX(dp.getPositionX() + 1);
			}
			else if(db.getPositionX() - dp.getPositionX() <= dp.getPlayerType().getSpeed().getSpeedX()) {
				dp.setPositionX(db.getPositionX());
			}
			else {
				dp.setPositionX(dp.getPositionX() + dp.getPlayerType().getSpeed().getSpeedX());
			}
		}
		else if(db.getPositionX() == dp.getPositionX()) {
			positionOnX = true;
		}

		/*
		 * Player's conditions so he'll run to the ball's position
		 * to get it. Only for the y axis.
		 *  
		 */
		if(db.getPositionY() < dp.getPositionY()) {
			if(dp.getPositionY() - db.getPositionY() == 1) {
				dp.setPositionY(dp.getPositionY() - 1);
			}
			else if(dp.getPositionY() - db.getPositionY() <= dp.getPlayerType().getSpeed().getSpeedY()){
				dp.setPositionY(db.getPositionY());
			}
			else {
				dp.setPositionY(dp.getPositionY() - dp.getPlayerType().getSpeed().getSpeedY());
			}
		}
		else if(db.getPositionY() > dp.getPositionY()) {
			if(dp.getPositionY() - db.getPositionY() == 1) {
				dp.setPositionY(dp.getPositionY() + 1);
			}
			else if(db.getPositionY() - dp.getPositionY() <= dp.getPlayerType().getSpeed().getSpeedY()){
				dp.setPositionY(db.getPositionY());
			}
			else {
				dp.setPositionY(dp.getPositionY() + dp.getPlayerType().getSpeed().getSpeedY());
			}
		}
		else if(db.getPositionY() == dp.getPositionY()) {
			positionOnY = true;
		}

		if(positionOnX == true && positionOnY == true) {
			dp.setHaveBall(true);
		}
	}

	public void runWithBall(Position ball, DataPlayer player, boolean itsUserRound) {
		int d = 0;
		int goal;
		if (itsUserRound) // in order to know which goal to go...
		{
			goal = specPos.getGoal2().getPositionX();
		}
		else{
			goal = specPos.getGoal1().getPositionX();
		}

		int x = player.getPositionX();
		//int y = player.getPositionY(); //stock old position to know direction and then which side place ball

		runtoCages(player, goal);

		if ( ( x - player.getPositionX() )>=0 ) // d is to place ball on the good side of player
		{
			d = +5;
		}
		else 
		{
			d = -5;
		} 
		ball.setPositionX(player.getPositionX()+d);
		ball.setPositionY(player.getPositionY());
	}

	public void runtoCages(DataPlayer player, int goalx) {
		Random r = new Random();
		int GOALY1 = ConstantPosition.GOALY1;
		int GOALY2 = ConstantPosition.GOALY2;
		int cages = r.nextInt(GOALY2 - GOALY1) + GOALY1;
		if(player.getHaveBall()) {
			if(goalx < player.getPositionX()) {
				if(player.getPositionX() - goalx == 1) {
					player.setPositionX(player.getPositionX() - 1);
				}
				else if(player.getPositionX() - goalx <= player.getPlayerType().getSpeed().getSpeedX() ) {
					player.setPositionX(goalx);
				}
				else {
					player.setPositionX(player.getPositionX() - player.getPlayerType().getSpeed().getSpeedX());
				}
			}
			else if(goalx > player.getPositionX()) {
				if(player.getPositionX() - goalx == 1) {
					player.setPositionX(player.getPositionX() + 1);
				}
				else if(goalx - player.getPositionX() <= player.getPlayerType().getSpeed().getSpeedX()) {
					player.setPositionX(goalx);
				}
				else {
					player.setPositionX(player.getPositionX() + player.getPlayerType().getSpeed().getSpeedX());
				}
			}

			if(cages < player.getPositionY()) {
				if(player.getPositionY() - cages == 1) {
					player.setPositionY(player.getPositionY() - 1);
				}
				else if(player.getPositionY() - cages <= player.getPlayerType().getSpeed().getSpeedY()){
					player.setPositionY(cages);
				}
				else {
					player.setPositionY(player.getPositionY() - player.getPlayerType().getSpeed().getSpeedY());
				}
			}
			else if(cages > player.getPositionY()) {
				if(player.getPositionY() - cages == 1) {
					player.setPositionY(player.getPositionY() + 1);
				}
				else if(cages - player.getPositionY() <= player.getPlayerType().getSpeed().getSpeedY()){
					player.setPositionY(cages);
				}
				else {
					player.setPositionY(player.getPositionY() + player.getPlayerType().getSpeed().getSpeedY());
				}
			}
		}
	}
	
	public void passBalltoPal(DataPlayer player, DataPlayer player2, DataBall ball) {
		Position posPlayer = new Position(player.getPositionX(), player.getPositionY());
		Position posPlayer2 = new Position(player2.getPositionX(), player2.getPositionY());
		int deltaX = 0;
		int deltaY = 0;
		if(posPlayer.getPositionX() > posPlayer2.getPositionX()) {
			deltaX = posPlayer.getPositionX() - posPlayer2.getPositionX();
		}
		else if (posPlayer.getPositionX() < posPlayer2.getPositionX()){
			deltaX = posPlayer2.getPositionX() - posPlayer.getPositionX();
		}
		
		if(posPlayer.getPositionY() > posPlayer2.getPositionY()) {
			deltaY = posPlayer.getPositionY() - posPlayer2.getPositionY();
		}
		else if (posPlayer.getPositionX() < posPlayer2.getPositionX()){
			deltaY = posPlayer2.getPositionY() - posPlayer.getPositionY();
		}
		
		int speed_towards_palX = deltaX/4;
		int speed_towards_palY = deltaY/4;
		
		ball.setSpeedX(speed_towards_palX);
		ball.setSpeedY(speed_towards_palY);
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