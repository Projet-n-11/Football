package process.management;
import dataplayer.*;

public class PlayerFactory {
	
	/*These functions all return special classes
	 * to complete special data of players
	 */
	public static Dive creaDive(int a) {
		return new Dive(a);
	}
	public static Reflex creaReflex(int a) {
		return new Reflex(a);
	}
	public static Knowledge creaKnowledge(int a) {
		return new Knowledge(a);
	}
	public static Strength creaStrength(int a) {
		return new Strength(a);
	}
	public static ReadPlay creaReadPlay(int a) {
		return new ReadPlay(a);
	}
	public static Precision creaPrecision(int a) {
		return new Precision(a);
	}
	public static Acceleration creaAcceleration(int a) {
		return new Acceleration(a);
	}
	
	/*
	 * these functions all return a player type with his
	 * stats completed by data given in parameters
	 */
	
	public static PlayerGoalie creaPlayerGoalie(Reflex r, Dive d) {
		return new PlayerGoalie(r,d);
	}
	public static PlayerDefender creaPlayerDefender(Knowledge k, Strength s) {
		return new PlayerDefender(k,s);
	}
	public static PlayerMidFielder creaPlayerMidFielder(ReadPlay r, Precision p) {
		return new PlayerMidFielder(r,p);
	}
	public static PlayerForward creaPlayerForward(Acceleration a, Precision p) {
		return new PlayerForward(a,p);
	}
	
	/**
	 * The function creaDataType uses the data collected on CSV file 
	 * to create the correct player type : it creates the good object 
	 * ( PlayerGoalie, etc) and complete the attributes with the correct informations
	 * for his peformances.
	 * it returns a concrete object by the abstract reference AbstractDataPlayerType 
	 * @param teamsLists
	 * @param i
	 * @return AbstractDataPlayerType
	 */
	public static AbstractDataPlayerType creaDataType(RecupTeam teamsLists, int i) {
	AbstractDataPlayerType playerType ;
	// goalie
	if (teamsLists.getTeamPlayerType(i).compareTo("goalie")==0) {
		int a = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(0)+"");
		int b = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(1)+"");
		Dive dive = creaDive(a);
		Reflex reflex = creaReflex(b);
		playerType = creaPlayerGoalie(reflex,dive);
	}
	// defender
	else if (teamsLists.getTeamPlayerType(i).compareTo("defender")==0) {
		int a = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(0)+"");
		int b = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(1)+"");
		Knowledge k = creaKnowledge(a);
		Strength s = creaStrength(b);
		playerType = creaPlayerDefender(k,s);
	}
	// midfielder
	else if (teamsLists.getTeamPlayerType(i).compareTo("midfielder")==0) {
		int a = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(0)+"");
		int b = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(1)+"");
		ReadPlay r = creaReadPlay(a);
		Precision p = creaPrecision(b);
		playerType = creaPlayerMidFielder(r,p);
	}
	// forward
	else if (teamsLists.getTeamPlayerType(i).compareTo("forward")==0) {
		int a = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(0)+"");
		int b = Integer.parseInt(teamsLists.getTeamSpecialStats(i).charAt(1)+"");
		Acceleration r = creaAcceleration(a);
		Precision p = creaPrecision(b);
		playerType = creaPlayerForward(r,p);
	}
	else
		return null;
	return playerType;
	}
	
	
	/**
	 * The function DataPlayer gets a RecupTeam to access the full ArrayList with all the players data.
	 * i is to select one of the player and return its DataPlayer
	 * @param teamsLists
	 * @param i
	 * @return DataPlayer
	 */
	public static DataPlayer creaPlayer(RecupTeam teamsLists, int i) {
		String name = teamsLists.getTeamPlayerName(i);
		String number = teamsLists.getTeamNumberOfOnePlayer(i);
		AbstractDataPlayerType playerType = creaDataType(teamsLists,i);
		DataSuperPowers superPowers = CreaDataSuperPowers.creaDataSuperPowers();
		String teamName = teamsLists.getTeamName();
		String color = teamsLists.getTeamColor();
		
		DataPlayer dataplayer = new DataPlayer(name,number,playerType,superPowers,teamName,true,2,color,0,0);
		return dataplayer;
		// order : player name, number, type, powers, team name, 
	}
	
}
