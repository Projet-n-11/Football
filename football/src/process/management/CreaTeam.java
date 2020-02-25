package process.management;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import dataplayer.*;
import dataplayer.DataPlayer;
import datateam.DataTeam;

public class CreaTeam {
	
	public DataTeam creaTeam(String teamName, int userOrBot) throws IOException {
		int i =0;
		
		// r�cup�rer dans teamsLists en 2 arrayList : un String par joueur avec tous ses data
		RecupTeam teamsLists = new RecupTeam(teamName);
		
		// pr�parer un hashmap qui associe chaque nom de joueur � ses donn�es
		HashMap<String, DataPlayer> userPlayers = new HashMap<String, DataPlayer>();
		
			// on parcours avec i : chaque ligne repr�sentant les donn�es d'un joueur
			while (i<=teamsLists.getNumberPlayersUser()) {			
				userPlayers.put(teamsLists.getUserTeamPlayerName(i),CreaPlayer.creaPlayer(teamsLists, i, userOrBot) );
				i++;
				System.gc();
			}
			
		
		return new DataTeam (teamName, teamsLists.getNumberPlayersUser(), userPlayers,teamsLists.getUserTeamColor(), 0);
	}
		
		// r�p�ter pour la team du bot
		
		

	
	
	// NOTES;
    // instancier les joueurs et les 2 �quipes, 
    // laisser l�utilisateur choisir sa strat�gie : File fTactics = new File ("tactics.txt");
    // choisir les joueurs parmi la liste propos�e dans l��quipe qu�il a choisie
}
