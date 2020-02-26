package process.management;
import dataplayer.*;

public class CreaPlayer {
	
	/**
	 * The function DataPlayer gets a RecupTeam to access the full ArrayList with all the players data.
	 * i is to select one of the player and return its DataPlayer
	 * @param teamsLists
	 * @param i
	 * @return DataPlayer
	 */
	public static DataPlayer creaPlayer(RecupTeam teamsLists, int i) {
		AbstractDataPlayerType playerType ;
		
		// NE PEUT PAS ETRE UNE FONCTION en l'etat car on ne peut pas RENVOYER/RETURN un Abstract !
			// goalie
			if (teamsLists.getTeamPlayerType(i).compareTo("goalie")==0) {
				int a = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(1)+"");
				Dive dive = new Dive(a);
				Reflex reflex = new Reflex(b);
				playerType = new PlayerGoalie(reflex,dive);
			}
			// defender
			else if (teamsLists.getTeamPlayerType(i).compareTo("defender")==0) {
				int a = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(1)+"");
				Knowledge k = new Knowledge(a);
				Strength s = new Strength(b);
				playerType = new PlayerDefender(k,s);
			}
			// midfielder
			else if (teamsLists.getTeamPlayerType(i).compareTo("midfielder")==0) {
				int a = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(1)+"");
				ReadPlay r = new ReadPlay(a);
				Precision p = new Precision(b);
				playerType = new PlayerMidFielder(r,p);
			}
			// forward
			else if (teamsLists.getTeamPlayerType(i).compareTo("forward")==0) {
				int a = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(1)+"");
				Acceleration r = new Acceleration(a);
				Precision p = new Precision(b);
				playerType = new PlayerForward(r,p);
			}
			else return null;
	
			DataPlayer dataplayer = new DataPlayer(teamsLists.getTeamPlayerName(i),teamsLists.getTeamNumberOfOnePlayer(i),playerType,CreaDataSuperPowers.creaDataSuperPowers(),teamsLists.getTeamName(),true,2,teamsLists.getTeamColor(),0,0);
			return dataplayer;
	}
	
}
