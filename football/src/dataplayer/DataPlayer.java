package dataplayer;

public class DataPlayer {
	private String playerName;
	private String playerNumber;
	private AbstractDataPlayerType playerType;
	private DataSuperPowers playerSuperPower;
	private String team;
	private boolean isPhysical;
	private int positionx,positiony;
	private int playerSize;
	private String colorPlayer;
	
	public DataPlayer() {
		Acceleration a = new Acceleration(10);
		Precision p = new Precision(5);
		PlayerForward pf = new PlayerForward(a,p);
		PlayerSpeed ps = new PlayerSpeed(2);
		this.playerName = "DefaultPlayer";
		this.playerNumber = "0";
		this.playerType = pf;
		this.playerType.setSpeed(ps);
		this.playerSuperPower = null;
		this.team = "DefaultTeam";
		this.isPhysical = true;
		this.positionx = 40;
		this.positiony = 0;
		this.playerSize = 1;
		this.colorPlayer = "White";
	}
	
	public DataPlayer(String playerName,String playerNumber,AbstractDataPlayerType playerType,DataSuperPowers playerSuperPower,String team,boolean isPhysical,int playerSize,String colorPlayer,int positionx,int positiony) {
		this.playerName = playerName;
		this.playerNumber = playerNumber;
		this.playerType = playerType;
		this.playerSuperPower = playerSuperPower;
		this.team = team;
		this.isPhysical = isPhysical;
		this.positionx = positionx;
		this.positiony = positiony;
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
	
	public int getPositionX() {
		return positionx;
	}
	
	public void setPositionX(int positionx) {
		this.positionx = positionx;
	}
	
	public int getPositionY() {
		return positiony;
	}
	
	public void setPositionY(int positiony) {
		this.positiony = positiony;
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
		return " NUMBER," + playerNumber + ",PLAYERTYPE," + playerType.toString()
				+ ",PLAYERSUPERPOWER," + playerSuperPower.toString() + ",TEAM," + team + ",ISPHYSICAL," + isPhysical
				+ ",POSITION,X=" + positionx + ",Y=" + positiony + ",PLAYERSIZE," + playerSize + ",COLORPLAYER," + colorPlayer + "]\n";
	}
	
}
