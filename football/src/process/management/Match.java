package process.management;
import java.util.ArrayList;
import java.util.Iterator;

import databall.DataBall;
import datafield.Position;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.movement.Vision;
import process.scores.Score;
import process.movement.MovementBall;
import process.movement.MovementPlayer;

public class Match {	// if singleton : re-chech every variables 
	/**
	 * Used in playerBehavior();
	 * allow one action for each soccer-player
	 * @param userTeam
	 * @param botTeam
	 */

	private Boolean goal, outOfField, falt;
	private DataTeam userTeam, botTeam;
	private Map positions;
	private DataBall ball;
	private MovementBall mb;
	private MovementPlayer mp;

	public Match(DataTeam userTeam, DataTeam botTeam, Map positions, DataBall ball, Score score, PositionTactics pt, PositionTactics pt2) {
		this.userTeam = userTeam;
		this.botTeam = botTeam;
		this.positions = positions;
		this.ball = ball;
		this.mp = new MovementPlayer(positions, ball);
		this.mb = new MovementBall(ball, positions, score, pt, pt2, userTeam, botTeam);
	}

	public void matchOneRound() { 		

		Iterator<DataPlayer> itUser;
		Iterator<DataPlayer> itBot;
		DataPlayer currentPlayer;
		Boolean itsUserRound = true;
		Boolean bothHavePlayed;
		Vision v = new Vision();
		ArrayList<Position> objectsSeen = null;
		int i;

		//each round we initialize the list (iterator) of players to check
		itUser = userTeam.getPlayers().values().iterator();
		itBot = botTeam.getPlayers().values().iterator();

		itsUserRound = true;
		bothHavePlayed = false;
		Position posBall = new Position(ball.getPositionX(), ball.getPositionY());	// singleton ?
		
		/**
		 * first we move the ball considering its own speed (if it was shoot)
		 * and slow it down
		 */
		
		if (ball.getOwnedBy()==null)
		{
			System.out.println("they see me rollin'...");
			mb.roll();
			if (Math.abs(ball.getSpeedX())!=0)
				{
					if (ball.getSpeedX()>0) ball.setSpeedX(ball.getSpeedX()-1);
					else 					ball.setSpeedX(ball.getSpeedX()+1);
				}
			if (Math.abs(ball.getSpeedY())!=0) {
					if (ball.getSpeedY()>0)	ball.setSpeedY(ball.getSpeedY()-1);
					else 					ball.setSpeedY(ball.getSpeedY()+1);
				}
		}
		else System.out.print(ball.getOwnedBy().getPlayerName() + " owns the ball; ");
		
		// While there is nothing to interrupt the match, players are playing
		// And while both teams have players to deal with:
		while ((itUser.hasNext() || itBot.hasNext())){
			bothHavePlayed = false;
			while (!bothHavePlayed) {
				if(itsUserRound && itUser.hasNext()) {
					currentPlayer = itUser.next();
					itsUserRound = false;
					bothHavePlayed = false;
				}
				else {
					currentPlayer = itBot.next();
					bothHavePlayed = true;
					itsUserRound = true;
				}

				
				objectsSeen = v.see(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);
				
				if (currentPlayer.getHaveBall())
				{
					if (v.seeCages(currentPlayer.getPositionX(), currentPlayer.getPositionY(), itsUserRound))
					{
						// CONSIDER IF HE IS BLOCKED BY A DEFENDER
						// if yes : can he pass ?
							// yes -> pass
							// no -> shoot
						System.out.println("and shoot");
						mp.shoot(currentPlayer, ball, itsUserRound);
					}
					else
					{
						System.out.println("and runs to cages");
						mp.runtoCages(currentPlayer, itsUserRound, ball);
					}
				}
				else // player does not have ball
				{
					for (i=0; i<objectsSeen.size() ; i++) {
	
						if (objectsSeen.get(i) instanceof DataBall ) {
	
							posBall = objectsSeen.get(i);
	
							if (ball.getOwnedBy()!=null) // ball is not free:
							{
								if (ball.getOwnedBy().getTeam().compareTo(currentPlayer.getTeam())!=0) // if ball is owned by ennemy
								{
									mp.move(currentPlayer, ball);
									if (mp.isCloseToBall(currentPlayer, ball));
									{
										if (mp.tryInterception(currentPlayer, ball)) 
										{
										mp.runtoCages(currentPlayer, itsUserRound, ball);
										System.out.println("INTERCEPTION !");
										}
										else
										{
										System.out.println("INTERCEPTION FAILED");	
										}
									}
								}
								else // ball is owned by ally : cover ally
								{
									if (currentPlayer.getPositionX()-ball.getSpeedX()>15)
									{
										mp.move(currentPlayer, ball);
									}
								}
							}
							else // case of free ball:
							{
								mp.move(currentPlayer, ball);
								if (mp.isCloseToBall(currentPlayer, ball)) // if free ball is reached : get ball.
								{
									currentPlayer.setHaveBall(true);
									ball.setOwnedBy(currentPlayer);
								}
							}
						}
					}
				}
				objectsSeen.removeAll(objectsSeen);
			}
		}
	}
}
