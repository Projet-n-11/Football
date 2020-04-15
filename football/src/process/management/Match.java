package process.management;
import java.util.ArrayList;
import java.util.Iterator;

import databall.DataBall;
import datafield.Position;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.movement.Vision;
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

	public Match(DataTeam userTeam, DataTeam botTeam, Map positions, DataBall ball, MovementBall mb) {
		this.userTeam = userTeam;
		this.botTeam = botTeam;
		this.positions = positions;
		this.ball = ball;
		this.mp = new MovementPlayer(positions, ball);
		this.mb = mb;
	}

	public void matchOneRound() { 		

		Iterator<DataPlayer> itUser;
		Iterator<DataPlayer> itBot;
		DataPlayer currentPlayer;
		DataPlayer secondPlayer;
		DataPlayer thirdPlayer;
		Boolean itsUserRound = true;
		Boolean bothHavePlayed;
		Vision v = new Vision();
		ArrayList<Position> objectsSeen = null;
		ArrayList<Position> visionForPass = null;
		int i, j;

		
		//each round we initialize the list (iterator) of players to check
		itUser = userTeam.getPlayers().values().iterator();
		itBot = botTeam.getPlayers().values().iterator();

		itsUserRound = true;
		bothHavePlayed = false;

		/**
		 * first we move the ball considering its own speed (if it was shoot)
		 * and slow it down
		 */

		if (ball.getOwnedBy()==null)
		{
			System.out.println("they see me rollin'...");
			if (ball.getCanIt()+ball.getSpeedX()>=5 || ball.getCanIt()+ball.getSpeedY()>=5)
			{
				mb.roll();				
			}
			else if (ball.getCanIt()+ball.getSpeedX()<5 || ball.getCanIt()+ball.getSpeedY()<5)
			{
				ball.setCanIt(ball.getCanIt()+1);
			}

		}
		else {
			System.out.print(ball.getOwnedBy().getPlayerName() + " owns the ball; ");
		}
		
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
				
				if (currentPlayer.getPlayerType().getCanHe()+currentPlayer.getPlayerType().getSpeed().getSpeedX()==5)
				{	
								
					if (currentPlayer.getPlayerType().getPlayerTypeName().compareTo("Goalie")==0) {
					objectsSeen = v.Goalsee(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);
				}
				else {
					objectsSeen = v.see(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);
				}

				if (currentPlayer.getHaveBall())
				{
					if (v.seeCages(currentPlayer.getPositionX(), currentPlayer.getPositionY(), itsUserRound))
					{
						// CONSIDER IF HE IS BLOCKED BY A DEFENDER
						for (i=0; i<objectsSeen.size() ; i++) {
							if (objectsSeen.get(i) instanceof DataPlayer) {
								secondPlayer = (DataPlayer)objectsSeen.get(i);
								if (secondPlayer.getTeam().compareTo(currentPlayer.getTeam())!=0) // if blocked : can he pass ?
								{
									visionForPass = v.largeSee(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);
									j=0;
									for (j=0; j<visionForPass.size(); j++) 
									{
										if(visionForPass.get(j) instanceof DataPlayer) {
											thirdPlayer = (DataPlayer)visionForPass.get(j);
											if (thirdPlayer.getTeam().compareTo(currentPlayer.getTeam())==0) {
												mp.passBalltoPal(currentPlayer, thirdPlayer, ball);
											}
										}
										
									}
								}
								else{
									mp.shoot(currentPlayer, ball, itsUserRound);
								}
							}
						}

						System.out.println("and shoot");
						mp.shoot(currentPlayer, ball, itsUserRound);
					}
					else // player does not see cages :
					{
						// CONSIDER IF HE IS BLOCKED BY A DEFENDER
						for (i=0; i<objectsSeen.size() ; i++) {
							if (objectsSeen.get(i) instanceof DataPlayer) {
								secondPlayer = (DataPlayer)objectsSeen.get(i);
								if (secondPlayer.getTeam().compareTo(currentPlayer.getTeam())!=0) // if blocked : can he pass ?
								{
									visionForPass = v.largeSee(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);
									j=0;
									for (j=0; j<visionForPass.size(); j++) 
									{
										if(visionForPass.get(j) instanceof DataPlayer) {
											thirdPlayer = (DataPlayer)visionForPass.get(j);
											if (thirdPlayer.getTeam().compareTo(currentPlayer.getTeam())==0) {
												mp.passBalltoPal(currentPlayer, thirdPlayer, ball);
											}
										}
									}


								}
								else
								{
									System.out.println("and runs to cages");
									mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
								}
							}
						}
					}
				}
				else // player does not have ball
				{
					for (i=0; i<objectsSeen.size() ; i++) {

						if (objectsSeen.get(i) instanceof DataBall ) { // player see ball

							if (ball.getOwnedBy()!=null) // ball is not free:
							{
								if (ball.getOwnedBy().getTeam().compareTo(currentPlayer.getTeam())!=0) // if ball is owned by ennemy
								{
									mp.move(currentPlayer, ball, itsUserRound);
									if (mp.isCloseToBall(currentPlayer, ball));
									{
										if (mp.tryInterception(currentPlayer, ball, itsUserRound)) 
										{
											mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
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
										mp.move(currentPlayer, ball, itsUserRound);
									}
								}
							}
							else // case of free ball:
							{
								// ************************************************* if you're a goalie you DIVE !
								mp.move(currentPlayer, ball, itsUserRound);
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
					
				
				currentPlayer.getPlayerType().setCanHe(0); // CHANGER DE PLACE: on set à 0 seulement si le joueur a agi
				}
				else if (currentPlayer.getPlayerType().getCanHe()+currentPlayer.getPlayerType().getSpeed().getSpeedX()<5){		
					currentPlayer.getPlayerType().setCanHe(currentPlayer.getPlayerType().getCanHe()+1);
				}
				
				

				
			}
		}
	}
}
