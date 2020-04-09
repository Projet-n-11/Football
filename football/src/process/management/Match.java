package process.management;
import java.util.ArrayList;
import java.util.Iterator;

import databall.DataBall;
import datafield.Grass;
import datafield.Position;
import datafield.SpecialPosition;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.movement.Vision;
import process.scores.Score;
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

	public Match(DataTeam userTeam, DataTeam botTeam, Map positions, DataBall ball) {
		this.userTeam = userTeam;
		this.botTeam = botTeam;
		this.positions = positions;
		this.ball = ball;
	}

	public void matchOneRound() { 		

		Iterator<DataPlayer> itUser;
		Iterator<DataPlayer> itBot;
		DataPlayer currentPlayer;
		Boolean itsUserRound = true;
		Boolean bothHavePlayed;
		MovementPlayer mp = new MovementPlayer();
		SpecialPosition specPos = new SpecialPosition();
		Vision v = new Vision();
		int i;

		//each round we initialize the list (iterator) of players to check
		itUser = userTeam.getPlayers().values().iterator();
		itBot = botTeam.getPlayers().values().iterator();

		itsUserRound = true;
		bothHavePlayed = false;
		Position posBall = new Position(ball.getPositionX(), ball.getPositionY());	// singleton ?
		// While there is nothing to interrupt the match, players are playing
		// And while both teams have players to deal with:
		while ((itUser.hasNext() || itBot.hasNext())){
			bothHavePlayed = false;
			itsUserRound = true;
			while (!bothHavePlayed) {
				if(itsUserRound && itUser.hasNext()) { //careful, but the end of the list may not be reached
					currentPlayer = itUser.next();
					itsUserRound = false;
					bothHavePlayed = false;
				}
				else {
					currentPlayer = itBot.next();
					bothHavePlayed = true;
				}

				ArrayList<Position> objectsSeen = Vision.see(currentPlayer.getPositionX(), currentPlayer.getPositionY(), positions);

				/*System.out.println("---------------");
					for(Position pos: objectsSeen) {
						System.out.println(pos.toString());
					}
					System.out.println("---------------");*/

				/**
				 * for now, players will run after the ball
				 */
				for (i=0; i<objectsSeen.size() ; i++) {
					/**
					 * if one of the object seen is the ball :
					 * check if it is close to player = the player owns the ball
					 * if it is not, player have to run to the ball
					 */
					if (objectsSeen.get(i) instanceof DataBall ) {

						posBall = objectsSeen.get(i);

						/**
						 * TO TEST : we do not allow any player to go to the ball
						 * if it is already possessed by another player
						 */

						if (v.isPossessed(posBall, positions)==true)
						{

						}

						/**
						 * if the player owns the ball, he has to run to the goal.
						 */
						if (v.areClose(posBall,currentPlayer)) {
							currentPlayer.setHaveBall(true);
							mp.runWithBall(posBall,currentPlayer, itsUserRound); // replace player AND ball to new destination
							for(DataPlayer botPlayers: botTeam.getPlayers().values()) {
								if(botPlayers.getPositionY() == currentPlayer.getPositionY()) {
									mp.passBalltoPal(currentPlayer, botPlayers, ball);
								}
								else {
									System.out.println("Fdp");
								}
							}
						}
						else {
							currentPlayer.setHaveBall(false);
							Grass grass = new Grass(currentPlayer.getPositionX(),currentPlayer.getPositionY());
							mp.move(posBall,currentPlayer); //should be static, modify only the attributes positionning data
							positions.setElement(grass);
							positions.setElement(currentPlayer);
						}
					}
					else if(objectsSeen.get(i) instanceof DataPlayer) {
		
					}
				}

				/**
				 * to this later
				 */
				if (currentPlayer.getPlayerType().getPlayerTypeName().compareTo("Gardien")!=0) {
					/**
					 * this loop is about all players that AREN'T GOALIES.
					 */
				} 

			}

			// one test possible but the goal should not be considered as one square but an area
			if (posBall.getPositionX()==specPos.getGoal1().getPositionX() && posBall.getPositionY()==specPos.getGoal1().getPositionY()) 
			{
				goal = true;
			}
		}
	}

}
