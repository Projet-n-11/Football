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
		DataPlayer currentPlayer = null;
		DataPlayer secondPlayer = null;
		DataPlayer thirdPlayer = null;
		Boolean itsUserRound = true;
		Boolean bothHavePlayed;
		Boolean receivedPass;
		Boolean didNothing;
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
		 * first we move the ball considering its own speed (if it is free)
		 * and slow it down
		 */

		if (ball.getOwnedBy()==null)
		{
			System.out.println("they see me rollin'...");
			if (ball.getCanIt()+Math.abs(ball.getSpeedX())>=5 || ball.getCanIt()+Math.abs(ball.getSpeedY())>=5)
			{
				mb.roll();			
			}
			else
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
				
				receivedPass = false;
				didNothing = true;
				
				if (currentPlayer.getPlayerType().getCanHeAct() + currentPlayer.getPlayerType().getSpeed().getSpeedX()==5)
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
									
									if (secondPlayer.getPlayerType().getPlayerTypeName().compareTo("Goalie")!=0 && 
											secondPlayer.getTeam().compareTo(currentPlayer.getTeam())!=0) // if blocked (goalie does not count) : can he pass ?
									{
										visionForPass = v.largeSee(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);
										j=0;
										
										for (j=0; j<visionForPass.size(); j++) 
										{
											if(visionForPass.get(j) instanceof DataPlayer) {
												thirdPlayer = (DataPlayer)visionForPass.get(j);
												if (thirdPlayer.getTeam().compareTo(currentPlayer.getTeam())==0 && currentPlayer.getPlayerType().getCanHePass()>=4) {
													mp.passBalltoPal(currentPlayer, thirdPlayer, ball);
													System.out.println("pass from " + currentPlayer.getPlayerName() + " to " + thirdPlayer.getPlayerName());
													receivedPass = true;
													j=objectsSeen.size();
													i=objectsSeen.size()+2;
												}
											}
											
										}
									}
								}
							}
							if (i>=objectsSeen.size()+2)
							{
								System.out.println("and shoot");
								mp.shoot(currentPlayer, ball, itsUserRound);
							}
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
												if (thirdPlayer.getTeam().compareTo(currentPlayer.getTeam())==0 && currentPlayer.getPlayerType().getCanHePass()>=4) {
													mp.passBalltoPal(currentPlayer, thirdPlayer, ball);
													System.out.println("pass from " + currentPlayer.getPlayerName() + " to " + thirdPlayer.getPlayerName());
													receivedPass = true;
													i=objectsSeen.size()+2;
												}
											}
										}
									}
								}
							}
							if (i>=objectsSeen.size()+2)
							{
								System.out.println(currentPlayer.getPlayerName() + " runs to cages");
								mp.runtoCages(currentPlayer, ball, itsUserRound, mb);
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
												System.out.println("INTERCEPTION by " + currentPlayer.getPlayerName() + " from " + ball.getOwnedBy().getPlayerName());
											}
											else
											{
												System.out.println("INTERCEPTION FAILED by " + currentPlayer.getPlayerName() + " from " + ball.getOwnedBy().getPlayerName());
											}
											i=objectsSeen.size()+2;
										}
									}
									else // ball is owned by ally : cover ally
									{
										if (currentPlayer.getPositionX()-ball.getSpeedX()>15)
										{
											mp.move(currentPlayer, ball, itsUserRound);
											i=objectsSeen.size()+2;
										}
									}
									
								}
								else // case of free ball:
								{
									// ************************************************* if you're a goalie you DIVE !
									mp.move(currentPlayer, ball, itsUserRound);
									if (mp.isCloseToBall(currentPlayer, ball)) // if free ball is reached : get ball.
									{
										System.out.println(currentPlayer.getPlayerName() + " reached the ball");
										currentPlayer.setHaveBall(true);
										ball.setOwnedBy(currentPlayer);
										i=objectsSeen.size();
									}
								}
							}
						}
					}
					objectsSeen.removeAll(objectsSeen);
						
					
					currentPlayer.getPlayerType().setCanHeAct(0); // CHANGER DE PLACE: on set à 0 seulement si le joueur a agi
				} // end of case of player which can act
				
				else if (currentPlayer.getPlayerType().getCanHeAct()+currentPlayer.getPlayerType().getSpeed().getSpeedX()<5){		
					currentPlayer.getPlayerType().setCanHeAct(currentPlayer.getPlayerType().getCanHeAct()+1);
				}
				
				if (thirdPlayer!=null) {
					thirdPlayer.getPlayerType().setCanHePass(currentPlayer.getPlayerType().getCanHePass()+1);
					if (receivedPass==true) 
					{
						currentPlayer.getPlayerType().setCanHePass(0);
						thirdPlayer.getPlayerType().setCanHePass(0);
					}
				}
				if (didNothing)
				{
					currentPlayer.setPlayerStamina(currentPlayer.getPlayerType().getStamina() + 1);
					currentPlayer.setPlayerStress(currentPlayer.getPlayerType().getStress()-1);
				}
			}		
		}
		System.out.println("1 round done");
	}
}
