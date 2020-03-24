package process.management;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import datafield.Grass;
import datafield.Position;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.movement.Vision;
import process.movement.MovementPlayer;

public class Match {
	
	
	public static Boolean goal, outOfField, falt;
	
	/**
	 * Used in playerBehavior();
	 * allow one action for each soccer-player
	 * @param userTeam
	 * @param botTeam
	 */
	public static void match_1_Big_round(DataTeam userTeam, DataTeam botTeam) { 		
		
		Iterator<DataPlayer> itUser;
		Iterator<DataPlayer> itBot;
		DataPlayer currentPlayer;
		Boolean itsUserRound = true;
		Boolean bothHavePlayed;
		Map positions = new Map();
		MovementPlayer mp = new MovementPlayer();
		int i;
		
		//each round we initialize the list (iterator) of players to check
		itUser = userTeam.getPlayers().values().iterator();
		itBot = botTeam.getPlayers().values().iterator();
		
		itsUserRound = true;

		// While there is nothing to interrupt the match, players are playing
		// And while both teams have players to deal with:
		while ((!goal || !outOfField || !falt) && (itUser.hasNext() || itBot.hasNext()) ){
			
				bothHavePlayed = false;
				
				while (!bothHavePlayed) {
					if(itsUserRound && itUser.hasNext()) { //careful : the end of the list may be reached,
						currentPlayer = itUser.next();		// this is why we use hasNext()
						itsUserRound = false;
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
							/**
							 * if the player owns the ball, he has to run to the goal.
							 */
							if (Vision.areClose(objectsSeen.get(i),currentPlayer)) {
								// create methode moveToGoal : replace player ET ball au bon endroit
							}
							
							Grass grass = new Grass(currentPlayer.getPositionX(),currentPlayer.getPositionY());
					 		mp.move(objectsSeen.get(i),currentPlayer); //should be static, modify only the attributes positionning data
							positions.setElement(grass);
							positions.setElement(currentPlayer);
						}
					}
					
					if (currentPlayer.getPlayerType().getPlayerTypeName().compareTo("Gardien")!=0) {
						/**
						 * this loop is about all players that AREN'T GOALIES.
						 */
						} 

					
				}
				
				// vérifier la situation : ballon sorti ? Joueurs en faute ?
		}
	}
	
}
