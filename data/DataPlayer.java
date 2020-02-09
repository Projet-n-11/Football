package data;

public class DataPlayer {
	private String playerName;
	private String playerNumber;
	private AbstractDataPlayerType playerType;
	private DataSuperPowers playSuperPower;
	private String Team;
	private boolean isPhysical;
	private int position	// A VERIFIER
	private int playerSize;
	private String colorPlayer;
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}
	public AbstractDataPlayerType getPlayerType() {
		return playerType;
	}
	public void setPlayerType(AbstractDataPlayerType playerType) {
		this.playerType = playerType;
	}
	public DataSuperPowers getPlaySuperPower() {
		return playSuperPower;
	}
	public void setPlaySuperPower(DataSuperPowers playSuperPower) {
		this.playSuperPower = playSuperPower;
	}
	public String getTeam() {
		return Team;
	}
	public void setTeam(String team) {
		Team = team;
	}
	public boolean isPhysical() {
		return isPhysical;
	}
	public void setPhysical(boolean isPhysical) {
		this.isPhysical = isPhysical;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getPlayerSize() {
		return playerSize;
	}
	public void setPlayerSize(int playerSize) {
		this.playerSize = playerSize;
	}
	public String getColorPlayer() {
		return colorPlayer;
	}
	public void setColorPlayer(String colorPlayer) {
		this.colorPlayer = colorPlayer;
	}
	
	
}
