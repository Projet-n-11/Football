package process.management;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import datafield.Position;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import process.scores.Chronometer;
import process.scores.Score;
import process.management.CreaTeam;
import process.movement.Vision;

public class Match {
	
	
	public Boolean goal, outOfField, falt;
	public DataTeam userTeam;
	public DataTeam botTeam;
	public final int NB_TEAMS = 2;
	
	public void initiateObjectsForTheMatch(DataTeam userTeam, DataTeam botTeam) throws IOException {
		
		// à remplacer par le processus normal de choix d'équipe
		userTeam = CreaTeam.creaTeam("France");
		
		// on récupère les noms de toutes les équipes
		ArrayList<String> list = RecupTeam.getCountriesNames();
		int rand = 0;
		String otherTeamCurrentlyBrazil = "";
			
		/*
		 * while team randomly choosen is user team;
		 * generate random number <= number of teams
		 * then use it to collect the name of the team in the list
		 */
		do {
			rand = (int)Math.random() * ( NB_TEAMS );
			otherTeamCurrentlyBrazil = list.get(rand);
		} while (otherTeamCurrentlyBrazil.compareTo(userTeam.getTeamName())==0);	
		botTeam = CreaTeam.creaTeam(otherTeamCurrentlyBrazil);
	}
	
	
	public void match() { 		
		
		Iterator<DataPlayer> itUser;
		Iterator<DataPlayer> itBot;
		DataPlayer currentPlayer;
		Boolean itsUserRound = true;
		Boolean bothHavePlayed;
		Vision vision = new Vision();
		ArrayList<Position>

		while (!goal || !outOfField || !falt) {
			
			//each round we initialize the list (iterator) of players to check
			itUser = userTeam.getPlayers().values().iterator();
			itBot = botTeam.getPlayers().values().iterator();
			itsUserRound = true;
			
			// while both teams have players to deal with:
			while( itUser.hasNext() || itBot.hasNext() ) {
				
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
					
					
					vision.see(currentPlayer.getPositionX(), currentPlayer.getPositionY());
					
					/**
					 * this loop is about all players that AREN'T GOALIES.
					 */
					if (currentPlayer.getPlayerType().getPlayerTypeName().compareTo("Gardien")!=0) {
						
						} 

					
				}
				
				// vérifier la situation : ballon sorti ? Joueurs en faute ?
			}
		}
	}
	
}
