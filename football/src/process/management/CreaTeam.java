package process.management;

import java.io.IOException;
import java.util.HashMap;
import dataplayer.DataPlayer;
import datateam.DataTeam;

public class CreaTeam {
	
	/**
	 * creaTeam needs the teamName (country) to return a DataTeam
	 * @param teamName
	 * @param userOrBot
	 * @return DataTeam
	 * @throws IOException
	 */
	public DataTeam creaTeam(String teamName) throws IOException {
		int i =0;
		
		// gets the ArrayList<String> with all the data to create players of the teamName's team
		RecupTeam teamList = new RecupTeam(teamName);
		
		// associate name of the player with their DataPlayer
		HashMap<String, DataPlayer> userPlayers = new HashMap<String, DataPlayer>();
		
			// on parcours avec i : chaque ligne repr�sentant les donn�es d'un joueur
			while (i<=teamList.getNumberPlayers()) {			
				userPlayers.put(teamList.getTeamPlayerName(i),CreaPlayer.creaPlayer(teamList, i) );
				i++;
				System.gc();
			}
			
		
		return new DataTeam (teamName, teamList.getNumberPlayers(), userPlayers,teamList.getTeamColor(), 0);
	}
		
		// r�p�ter pour la team du bot
		
		

	
	
	// NOTES;
    // instancier les joueurs et les 2 �quipes, 
    // laisser l�utilisateur choisir sa strat�gie : File fTactics = new File ("tactics.txt");
    // choisir les joueurs parmi la liste propos�e dans l��quipe qu�il a choisie
}
