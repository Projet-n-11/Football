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
	public static DataTeam creaTeam(String teamName) throws IOException {
		int i =0;
		
		// gets the ArrayList<String> with all the data to create players of the teamName's team
		RecupTeam teamList = new RecupTeam(teamName);
		// associate name of the player with their DataPlayer
		HashMap<String, DataPlayer> userPlayers = new HashMap<String, DataPlayer>();
		
			// on parcours avec i : chaque ligne représentant les données d'un joueur
			while (i<teamList.getNumberPlayers()) {			
				userPlayers.put(teamList.getTeamPlayerName(i),CreaPlayer.creaPlayer(teamList, i) );
				i++;
				System.gc();
			}
			
		
		return new DataTeam (teamName, teamList.getNumberPlayers(), userPlayers,teamList.getTeamColor(), 0);
	}
		
		
}
