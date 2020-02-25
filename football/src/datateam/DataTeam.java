package datateam;
import java.util.HashMap;
import dataplayer.DataPlayer;

public class DataTeam {
	private String teamName;
	private HashMap<String, DataPlayer> players;
	private HashMap<String, DataPlayer> substitute;
	private String color;
	private int positiononField;
	
	
	public DataTeam(String teamName, int numberPlayers, HashMap<String, DataPlayer> players,
			String color, int positiononField) {
		this.teamName = teamName;
		this.players = players;
		this.color = color;
		this.positiononField = positiononField;
		players = new HashMap<String, DataPlayer>();
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public int getNumberPlayers() {
		return numberPlayers;
	}


	public void setNumberPlayers(int numberPlayers) {
		this.numberPlayers = numberPlayers;
	}


	public int getSubstitute() {
		return substitute;
	}


	public void setSubstitute(int substitute) {
		this.substitute = substitute;
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


	public String toString() {
		return "DataTeam [teamName=" + teamName + ", numberPlayers=" + numberPlayers + ", substitute=" + substitute
				+ ", players=" + players + ", color=" + color + ", positiononField=" + positiononField + "]";
	}
	
	
	
}
