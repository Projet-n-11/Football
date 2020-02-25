package process.management;
import dataplayer.*;

public class CreaPlayer {
	
	public static DataPlayer creaPlayer(RecupTeam teamsLists, int i,int userOrBot) {
		AbstractDataPlayerType playerType ;
		
		// n'est pas une fonction en l'état car on ne peut pas renvoyer un Abstract !
		if (userOrBot==0) { //user
			if (teamsLists.getUserTeamPlayerType(i).compareTo("goalie")==0) {
				int a = Integer.parseInt(teamsLists.getUserTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getUserTeamSpecialStats(i).charAt(1)+"");
				Dive dive = new Dive(a);
				Reflex reflex = new Reflex(b);
				playerType = new PlayerGoalie(reflex,dive);
			}
			else if (teamsLists.getUserTeamPlayerType(i).compareTo("defender")==0) {
				int a = Integer.parseInt(teamsLists.getUserTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getUserTeamSpecialStats(i).charAt(1)+"");
				Knowledge k = new Knowledge(a);
				Strength s = new Strength(b);
				playerType = new PlayerDefender(k,s);
			}
			else if (teamsLists.getUserTeamPlayerType(i).compareTo("midfielder")==0) {
				int a = Integer.parseInt(teamsLists.getUserTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getUserTeamSpecialStats(i).charAt(1)+"");
				ReadPlay r = new ReadPlay(a);
				Precision p = new Precision(b);
				playerType = new PlayerMidFielder(r,p);
			}
			else {// forward
				int a = Integer.parseInt(teamsLists.getUserTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getUserTeamSpecialStats(i).charAt(1)+"");
				Acceleration r = new Acceleration(a);
				Precision p = new Precision(b);
				playerType = new PlayerForward(r,p);
			}
		}
		else {	// bot
			if (teamsLists.getBotTeamPlayerType(i).compareTo("goalie")==0) {
				int a = Integer.parseInt(teamsLists.getBotTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getBotTeamSpecialStats(i).charAt(1)+"");
				Dive dive = new Dive(a);
				Reflex reflex = new Reflex(b);
				playerType = new PlayerGoalie(reflex,dive);
			}
			else if (teamsLists.getBotTeamPlayerType(i).compareTo("defender")==0) {
				int a = Integer.parseInt(teamsLists.getBotTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getBotTeamSpecialStats(i).charAt(1)+"");
				Knowledge k = new Knowledge(a);
				Strength s = new Strength(b);
				playerType = new PlayerDefender(k,s);
			}
			else if (teamsLists.getBotTeamPlayerType(i).compareTo("midfielder")==0) {
				int a = Integer.parseInt(teamsLists.getBotTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getBotTeamSpecialStats(i).charAt(1)+"");
				ReadPlay r = new ReadPlay(a);
				Precision p = new Precision(b);
				playerType = new PlayerMidFielder(r,p);
			}
			else {// forward
				int a = Integer.parseInt(teamsLists.getBotTeamSpecialStats(i).charAt(0)+"");
				int b = Integer.parseInt(teamsLists.getBotTeamSpecialStats(i).charAt(1)+"");
				Acceleration r = new Acceleration(a);
				Precision p = new Precision(b);
				playerType = new PlayerForward(r,p);
			}
		}
		
		
		DataPlayer dataplayer = new DataPlayer(teamsLists.getUserTeamPlayerName(i),teamsLists.getUserTeamNumberOfOnePlayer(i),playerType,teamsLists.getUserTeamName(),true,2,teamsLists.getUserTeamColor(),0,0);
		return dataplayer;
	}
	
}
