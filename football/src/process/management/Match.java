package process.management;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import datafield.Grass;
import datafield.Position;
import datafield.SpecialPosition;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.movement.Vision;
import process.movement.MovementPlayer;

public class Match {	// if singleton : re-chech every variables
	
	
	public static Boolean goal, outOfField, falt;
	
	/**
	 * Used in playerBehavior();
	 * allow one action for each soccer-player
	 * @param userTeam
	 * @param botTeam
	 */
	public static void matchOneRound(DataTeam userTeam, DataTeam botTeam) { 		
		
		Iterator<DataPlayer> itUser;
		Iterator<DataPlayer> itBot;
		DataPlayer currentPlayer;
		Boolean itsUserRound = true;
		Boolean bothHavePlayed;
		Map positions = new Map();
		MovementPlayer mp = new MovementPlayer();
		SpecialPosition specPos = new SpecialPosition();
		int i;
		
		//each round we initialize the list (iterator) of players to check
		itUser = userTeam.getPlayers().values().iterator();
		itBot = botTeam.getPlayers().values().iterator();
		
		itsUserRound = true;

		// While there is nothing to interrupt the match, players are playing
		// And while both teams have players to deal with:
		while ((!goal || !outOfField || !falt) && (itUser.hasNext() || itBot.hasNext()) ){
			
				bothHavePlayed = false;
				Position posBall = null;	// singleton ?
				
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
					
					ArrayList<Position> objectsSeen = Vision.see(currentPlayer.getPositionX(), currentPlayer.getPositionY());
					
					/**
					 * for now, players will run after the ball
					 */
					for (i=0; i<objectsSeen.size() ; i++) {
						/**
						 * if one of the object seen is the ball :
						 * check if it is close to player = the player owns the ball
						 * if it is not, player have to run to the ball
						 */
						if (objectsSeen.get(i).getClass().getName().contentEquals("databall.DataBall")==true) {
							
							posBall = objectsSeen.get(i);
							
							/**
							 * if the player owns the ball, he has to run to the goal.
							 */
							if (Vision.areClose(posBall,currentPlayer)) {
								mp.runWithBall(posBall,currentPlayer, itsUserRound); // replace player AND ball to new destination
							}
							else {
							Grass grass = new Grass(currentPlayer.getPositionX(),currentPlayer.getPositionY());
					 		mp.move(posBall,currentPlayer); //should be static, modify only the attributes positionning data
							positions.setElement(grass);
							positions.setElement(currentPlayer);
							}
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
