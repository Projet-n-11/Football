package datateam;
import java.util.HashMap;
import dataplayer.DataPlayer;

public class DataTeam {
	private String teamName;
	private HashMap<String, DataPlayer> players;
	private HashMap<String, DataPlayer> substitute;
	private String color;
	private int positiononField;
	private int defaultStrategy;
	
	
	public DataTeam(String teamName, int numberPlayers, HashMap<String, DataPlayer> players,
			String color, int positiononField, int defaultStrategy) {
		this.teamName = teamName;
		this.players = players;
		this.color = color;
		this.positiononField = positiononField;
		players = new HashMap<String, DataPlayer>();
		this.defaultStrategy = defaultStrategy;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public HashMap<String, DataPlayer> getPlayers() {
		return players;
	}


	public void setPlayers(HashMap<String, DataPlayer> players) {
		this.players = players;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getPositiononField() {
		return positiononField;
	}


	public void setPositiononField(int positiononField) {
		this.positiononField = positiononField;
	}
	
	public int getDefaultStrategy() {
		return defaultStrategy;
	}
	
	public void setDefaultStrategy(int newStrategy) {
		this.defaultStrategy = newStrategy;
	}


	public String toString() {
		return "" + teamName +  "," + substitute + "," + color + "," + positiononField + "," + defaultStrategy + "\n" + players ;
	}
	
	
	
}
