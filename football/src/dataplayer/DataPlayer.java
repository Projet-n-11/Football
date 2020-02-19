package dataplayer;

public class DataPlayer {
	private String playerName;
	private String playerNumber;
	private AbstractDataPlayerType playerType;
	private DataSuperPowers playerSuperPower;
	private String team;
	private boolean isPhysical;
	private int position;
	private int playerSize;
	private String colorPlayer;
	
	public DataPlayer(String playerName, String playerNumber, AbstractDataPlayerType playerType, DataSuperPowers playerSuperPower, String team, boolean isPhysical, int position, int playerSize, String colorPlayer) {
		this.playerName = playerName;
		this.playerNumber = playerNumber;
		this.playerType = playerType;
		this.playerSuperPower = playerSuperPower;
		this.team = team;
		this.isPhysical = isPhysical;
		this.position = position;
		this.playerSize = playerSize;
		this.colorPlayer = colorPlayer;
	}
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
		return playerSuperPower;
	}
	public void setPlaySuperPower(DataSuperPowers playerSuperPower) {
		this.playerSuperPower = playerSuperPower;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
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
	public String toString() {
		return "DataPlayer [playerName=" + playerName + ", playerNumber=" + playerNumber + ", playerType=" + playerType.toString()
				+ ", playerSuperPower=" + playerSuperPower.toString() + ", team=" + team + ", isPhysical=" + isPhysical
				+ ", position=" + position + ", playerSize=" + playerSize + ", colorPlayer=" + colorPlayer + "]";
	}
	
}
