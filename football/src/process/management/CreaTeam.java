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
		
		// donner les param�tres substitute, players, positiononField
		DataTeam userTeam = new DataTeam (teamName, teamsLists.getNumberPlayersUser(), HashMap<String, DataPlayer> players,
				teamsLists.getColorUserTeam(), 0);
		
		// r�p�ter pour la team du bot
		
	}
	
	// NOTES;
    // instancier les joueurs et les 2 �quipes, 
    // laisser l�utilisateur choisir sa strat�gie : File fTactics = new File ("tactics.txt");
    // choisir les joueurs parmi la liste propos�e dans l��quipe qu�il a choisie
}
