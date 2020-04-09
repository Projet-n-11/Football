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
	public static DataTeam creaTeam(String teamName) {

		try {
			int i =0;	
			// gets the ArrayList<String> with all the data to create players of the teamName's team
			RecupTeam teamList = new RecupTeam(teamName);
			// associate name of the player with their DataPlayer
			HashMap<String, DataPlayer> userPlayers = new HashMap<String, DataPlayer>();
			// associating each line of data for one player, to their name
			while (i<teamList.getNumberPlayers()) {		
				userPlayers.put(teamList.getTeamPlayerName(i), PlayerFactory.creaPlayer(teamList, i) );
				i++;
				System.gc();
			}
			return new DataTeam (teamName, teamList.getNumberPlayers(), userPlayers,teamList.getTeamColor(), 0, teamList.defaultStrategy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}		
}
