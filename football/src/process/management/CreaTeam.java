package process.management;

import java.io.IOException;
import java.util.HashMap;

import dataplayer.DataPlayer;
import datateam.DataTeam;

public class CreaTeam {
	
	public CreaTeam(String teamName) throws IOException {
		
		RecupTeam teamsLists = new RecupTeam(teamName);
		
		// initialiser players; 
		// HashMap<String, DataPlayer> players = ...;
		
		// donner les paramètres substitute, players, positiononField
		DataTeam userTeam = new DataTeam (teamName, teamsLists.getNumberPlayersUser(), HashMap<String, DataPlayer> players,
				teamsLists.getColorUserTeam(), 0);
		
		// répéter pour la team du bot
		
	}
	
	// NOTES;
    // instancier les joueurs et les 2 équipes, 
    // laisser l’utilisateur choisir sa stratégie : File fTactics = new File ("tactics.txt");
    // choisir les joueurs parmi la liste proposée dans l’équipe qu’il a choisie
}
