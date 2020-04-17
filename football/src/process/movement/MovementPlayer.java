package process.movement;

import java.util.Random;

import databall.DataBall;
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
	private final int BORDERBOTTOM = ConstantPosition.HEIGHT;
	private final int BORDERLEFT = 0;
	private final int BORDERRIGHT = ConstantPosition.WIDTH;
	private Map map;


	public MovementPlayer(Map map, DataBall ball) {
		this.map = map;
	}

	public void reachBall(DataPlayer player, DataBall ball) {
		System.out.println(player.getPlayerName() + " reached ball");
		if (ball.getSpeedX()==0 && ball.getSpeedY()==0)
		{
			player.setHaveBall(true);
			ball.setOwnedBy(player);
		}
		else 
		{
			int ballGrade = Math.abs(ball.getSpeedX()*ball.getSpeedY())+50;
			int playerGrade = Math.abs(player.getPlayerType().getSpeed().getSpeedX()*player.getPlayerType().getSpeed().getSpeedY())
					-player.getPlayerType().getStress()+player.getPlayerType().getStamina();
			if (playerGrade>=ballGrade)
			{
				player.setHaveBall(true);
				ball.setOwnedBy(player);
			}
		}
	}
	
	public void move(DataPlayer player, DataBall ball, Boolean itsUserRound) {
		moveToCoord(player, ball.getPositionX(), ball.getPositionY(), itsUserRound);
	}

	public void moveToCoord(DataPlayer player, int x, int y, Boolean itsUserRound) {
		if(player.getPlayerType().getStamina() != 0) {
			map.removeElement(player.getPositionX(), player.getPositionX());
			// X AXIS
			if(x < player.getPositionX()) {
				if(player.getPositionX() - x == 1) {
					player.setPositionX(player.getPositionX() - 1);
				}
				else {
					player.setPositionX(player.getPositionX() - 1);
				}
			}
			else if(x > player.getPositionX()) {
				if(player.getPositionX() - x == 1) {
					player.setPositionX(player.getPositionX() + 1);
				}
				else {
					player.setPositionX(player.getPositionX() + 1);
				}
			}
	
			// Y AXIS
			if(y < player.getPositionY()) {
				if(player.getPositionY() - y == 1) {
					player.setPositionY(player.getPositionY() - 1);
				}
				else {
					player.setPositionY(player.getPositionY() - 1);
				}
			}
			else if(y > player.getPositionY()) {
				if(player.getPositionY() - y == 1) {
					player.setPositionY(player.getPositionY() + 1);
				}
				else {
					player.setPositionY(player.getPositionY() + 1);
				}
			}
			checkPosition(player, itsUserRound);
			map.setElement(player);
		}
		else {
			player.setPlayerStamina(player.getPlayerType().getStamina() + 1);
		}
		
	}
	
	/**
	 * runtoCages is called when player own the ball and is distant from cages.
	 * @param player
	 * @param itsBotRound
	 * @param ball
	 */
	public void runtoCages(DataPlayer player, DataBall ball, Boolean itsUserRound, MovementBall moveball) {
		if(player.getPlayerType().getStamina() != 0) {
			Random r = new Random();
			int goalx;
			int GOALY1 = ConstantPosition.GOALY1;
			int GOALY2 = ConstantPosition.GOALY2;
			int cages = r.nextInt(GOALY2 - GOALY1) + GOALY1;
			int d;
			
			if (!itsUserRound) 
			{
				goalx = ConstantPosition.GOAL1X;
				d = -2;
			} 
			else {
				goalx = ConstantPosition.GOAL2X;
				d = 2;
			}
			
			moveToCoord(player, goalx, cages, itsUserRound);
			
			/*if(goalx < player.getPositionX()) {
				player.setPositionX(player.getPositionX() - 1);
			}
			else if(goalx > player.getPositionX()) {
				player.setPositionX(player.getPositionX() + 1);
			}

			if(cages < player.getPositionY()) {
				player.setPositionY(player.getPositionY() - 1);
			}
			else if(cages > player.getPositionY()) {
				player.setPositionY(player.getPositionY() + 1);
			}*/
			player.setPlayerStamina(player.getPlayerType().getStamina() - 1);
			player.setPlayerStress(player.getPlayerType().getStress() +1);
			checkPosition(player, itsUserRound);
			moveball.setPositionBall(player.getPositionX()+d, player.getPositionY());
			System.out.println(player.getPlayerName() + " runs to cages");
		}
		else {
			player.setPlayerStamina(player.getPlayerType().getStamina() + 1);
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
		
		player.setHaveBall(false);
		ball.setSpeedX(speed_towards_palX);
		ball.setSpeedY(speed_towards_palY);
	}
	
	public void shoot(DataPlayer player, DataBall ball, Boolean itsUserRound) {
		int direction;
		if (itsUserRound)
		{
			direction = -1;
		} else
		{
			direction = 1;
		}		
		System.out.println("SHOOT by " + player.getPlayerName());
		player.setPositionX(player.getPositionX()-direction); // player steps back
		ball.setSpeedX( (int) ( direction*5));
		player.setHaveBall(false);
		ball.setOwnedBy(null);

	}

	public void tryInterception(DataPlayer player, DataBall ball, Boolean itsUserRound, MovementBall mb) {
		
		Random r = new Random();
		int speedx = player.getPlayerType().getSpeed().getSpeedX();
		int speedy = player.getPlayerType().getSpeed().getSpeedY();
		int interceptorGrade = Math.abs(speedx*speedy)-player.getPlayerType().getStress();
		
		int speedx2 = ball.getOwnedBy().getPlayerType().getSpeed().getSpeedX();
		int speedy2 = ball.getOwnedBy().getPlayerType().getSpeed().getSpeedY();
		int ballPlayerGrade = Math.abs(speedx2*speedy2)-ball.getOwnedBy().getPlayerType().getStress();
		
		DataPlayer winner, looser;
		
		if (interceptorGrade+r.nextInt(4)>ballPlayerGrade+r.nextInt(4))
		{
			winner = player;
			looser = ball.getOwnedBy();
		}
		else if (ballPlayerGrade+r.nextInt(4)>interceptorGrade+r.nextInt(4))
		{
			winner = ball.getOwnedBy();
			looser = player;
		}
		else if (r.nextInt(2)==0)
		{
			winner = player;
			looser = ball.getOwnedBy();
		}
		else
		{
			winner = ball.getOwnedBy();
			looser = player;
		}
		
		winner.getPlayerType().setStress(winner.getPlayerType().getStress()-5);
		looser.getPlayerType().setStress(winner.getPlayerType().getStress()+5);
		winner.setHaveBall(true);
		looser.setHaveBall(false);
		ball.setOwnedBy(winner);
		winner.getPlayerType().setCanHeAct(5-winner.getPlayerType().getSpeed().getSpeedX());
		looser.getPlayerType().setCanHeAct(-1);
		
				
		if(player.getHaveBall())
		{
			System.out.println("INTERCEPTION BY " + player.getPlayerName());
			runtoCages(player, ball, itsUserRound, mb);
		}
	}

	public void cover(DataPlayer player, DataPlayer ballPlayer, Boolean itsUserRound) {
		int dx = 10, dy = 15;
		System.out.println(player.getPlayerName() + " covers " + ballPlayer.getPlayerName());
		if (player.getPlayerType().getPlayerTypeName()=="Forward" && !itsUserRound || itsUserRound && player.getPlayerType().getPlayerTypeName()=="defender")
		{
			if (Math.abs(player.getPositionY()-ballPlayer.getPositionY())<dy) // if too close to pal to cover :
			{
				if (player.getPositionY()<ballPlayer.getPositionY() ) 
				{
					moveToCoord(player, player.getPositionX()-dx, player.getPositionY()-dy, itsUserRound);
				} else
				{
					moveToCoord(player, player.getPositionX()-dx, player.getPositionY()+dy, itsUserRound);
				}
			}
			else
			{
				moveToCoord(player, ballPlayer.getPositionX(), ballPlayer.getPositionY(), itsUserRound);
			}
			
		}
		else if (player.getPlayerType().getPlayerTypeName()=="Forward" && itsUserRound || !itsUserRound && player.getPlayerType().getPlayerTypeName()=="defender")
		{
			if (Math.abs(player.getPositionY()-ballPlayer.getPositionY())<dy) 
			{
				if (player.getPositionY()<ballPlayer.getPositionY()) 
				{
					moveToCoord(player, player.getPositionX()+dx, player.getPositionY()-dy, itsUserRound);
				} else
				{
					moveToCoord(player, player.getPositionX()+dx, player.getPositionY()+dy, itsUserRound);
				}
			}

		}
	}
	
	public Boolean isCloseToBall(DataPlayer player, DataBall ball) {
		if (Math.abs(player.getPositionX()-ball.getPositionX())==1 || Math.abs(player.getPositionX()-ball.getPositionX())==0)
		{
			if (Math.abs(player.getPositionY()-ball.getPositionY())==1 || Math.abs(player.getPositionY()-ball.getPositionY())==0)
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
	
	public void goBackToInitialPosition(DataPlayer player, Position initialPos, boolean itsUserRound) {
		player.setHaveBall(false);
		moveToCoord(player, initialPos.getPositionX(), initialPos.getPositionY(), itsUserRound);
	}
	
	public void checkPosition(DataPlayer player, Boolean itsUserRound) {
		int middleX = (ConstantPosition.WIDTH/2);
		int limitOneThird1 = (ConstantPosition.WIDTH/3);
		int limitOneThird2 = ConstantPosition.WIDTH-(ConstantPosition.WIDTH/3);
		int GoalLimitX, GoalLimitY1 = ConstantPosition.HEIGHT/2-40/2, GoalLimitY2 = ConstantPosition.HEIGHT/2+40/2;
		if (!itsUserRound)
		{
			GoalLimitX = ConstantPosition.INITIAL_POINT+15;
		}
		else
		{
			GoalLimitX = ConstantPosition.WIDTH-15;
		}
		if (player.getPlayerType().getPlayerTypeName().compareTo("Goalie")==0)		// Goalie
		{
			if (!itsUserRound)
			{
				if (player.getPositionX()<GoalLimitX)
				{
					player.setPositionX(GoalLimitX);
					System.out.println(player.getPlayerName());
				}
			}
			else
			{
				if (player.getPositionX()>GoalLimitX)
				{
					player.setPositionX(GoalLimitX);
				}
			}
			if (player.getPositionY()<GoalLimitY1)
			{
				player.setPositionY(GoalLimitY1);
			}
			else if (player.getPositionY()>GoalLimitY2)
			{
				player.setPositionY(GoalLimitY2);
			}
		}
		else if (player.getPlayerType().getPlayerTypeName().compareTo("Defender")==0) // Defender
		{
			if (!itsUserRound)
			{
				if (middleX>player.getPositionX())
				{
					player.setPositionX(middleX);
				}
			}
			else {
				if (player.getPositionX()>middleX)
				{
					player.setPositionX(middleX);
				}
			}
		}
		else if (player.getPlayerType().getPlayerTypeName().compareTo("Midfielder")==0) // Midfielder
		{
			if (player.getPositionX()>limitOneThird2) 
			{
				player.setPositionX(limitOneThird2);
			}
			else if (player.getPositionX()<limitOneThird1)
			{
				player.setPositionX(limitOneThird1);
			}
		}
		else 																			// forward
		{
			if (itsUserRound)
			{
				if (player.getPositionX()>limitOneThird2)
				{
					player.setPositionX(limitOneThird2);
				}
			}
			else
				if (player.getPositionX()<limitOneThird1)
				{
					player.setPositionX(limitOneThird1);
				}
		}
	
	}


}