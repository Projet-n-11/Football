package process.movement;

import java.util.Random;

import databall.DataBall;
import datafield.Grass;
import datafield.Position;
import datafield.SpecialPosition;
import dataplayer.DataPlayer;
import process.management.ConstantPosition;
import process.management.Map;


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
	private Map map;


	public MovementPlayer(Map map, DataBall ball) {
		this.map = map;
	}

	public void move(DataPlayer dp, DataBall db) {
		/*
		 * Player's conditions so he'll run to the ball's position
		 * to get it. Only for the x axis. 
		 */	
		Grass grass = new Grass(dp.getPositionX(), dp.getPositionY());
		map.setElement(grass);
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

		/*
		 * Player's conditions so he'll run to the ball's position
		 * to get it. Only for the y axis.
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

	}

	/**
	 * runtoCages is called when player own the ball and is distant from cages.
	 * @param player
	 * @param itsUserRound
	 * @param ball
	 */
	public void runtoCages(DataPlayer player, Boolean itsUserRound, DataBall ball) {
		Random r = new Random();
		int goalx;
		int GOALY1 = ConstantPosition.GOALY1;
		int GOALY2 = ConstantPosition.GOALY2;
		int cages = r.nextInt(GOALY2 - GOALY1) + GOALY1;
		int d;
		int oldPlayerPosX = player.getPositionX();
		int oldPlayerPosY = player.getPositionY();
		
		if (itsUserRound) 
		{
			goalx = ConstantPosition.GOAL1X;
			d = -3;
		} else
		{
			goalx = ConstantPosition.GOAL2X;
			d = 3;
		}
		
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
		Grass grass = new Grass(oldPlayerPosX, oldPlayerPosX);
		System.out.println("grass " + oldPlayerPosX + " : " + oldPlayerPosY);
		map.setElement(grass);
		MovementBall.setPositionBall(player.getPositionX()+d, player.getPositionY());	
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
	
	public void shoot(DataPlayer player, DataBall ball, Boolean itsUserRound) {
		if (itsUserRound)
		{
			player.setPositionX(player.getPositionX()+1); // player steps back
		} else
		{
			player.setPositionX(player.getPositionX()-1); // player steps back
		}
		ball.setSpeedX(player.getPlayerType().getSpeed().getSpeedX()*2); // ball get the double of
		ball.setSpeedY(player.getPlayerType().getSpeed().getSpeedY()*2); // the player's speed
		player.setHaveBall(false);
		ball.setOwnedBy(null);
	}

	public Boolean tryInterception(DataPlayer player, DataBall ball) {
		
		return null;
	}
	
	public Boolean isCloseToBall(DataPlayer player, DataBall ball) {
		if (Math.abs(player.getPositionX()-ball.getPositionX())==1 || player.getPositionX()-ball.getPositionX()==0)
		{
			if (Math.abs(player.getPositionY()-ball.getPositionY())==1 || player.getPositionY()-ball.getPositionY()==0)
			{
				return true;
			}
		}
		return false;
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