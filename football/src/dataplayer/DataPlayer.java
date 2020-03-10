package dataplayer;

import datafield.AbstractPosition;
public class DataPlayer extends AbstractPosition{
	private String playerName;
	private String playerNumber;
	private AbstractDataPlayerType playerType;
	private DataSuperPowers playerSuperPower;
	private String team;
	private boolean isPhysical;
	private int playerSize;
	private String colorPlayer;
	
	public DataPlayer() {
		super();
		Acceleration a = new Acceleration(10);
		Precision p = new Precision(5);
		PlayerForward pf = null;
		PlayerSpeed ps = new PlayerSpeed(2);
		this.playerName = "DefaultPlayer";
		this.playerNumber = "0";
		this.playerType = pf;
		this.playerType.setSpeed(ps);
		this.playerSuperPower = null;
		this.team = "DefaultTeam";
		this.isPhysical = true;
		this.playerSize = 1;
		this.colorPlayer = "White";
	}
	
	public DataPlayer(String playerName,String playerNumber,AbstractDataPlayerType playerType,DataSuperPowers playerSuperPower,String team,boolean isPhysical,int playerSize,String colorPlayer,int positionx,int positiony) {
		super(positionx, positiony);
		this.playerName = playerName;
		this.playerNumber = playerNumber;
		this.playerType = playerType;
		this.playerSuperPower = playerSuperPower;
		this.team = team;
		this.isPhysical = isPhysical;
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
		return playerName + " N°: " + playerNumber + "," + playerType.toString() + ", Power: " + playerSuperPower.toString() + "," + team + "," + isPhysical +
				"," + playerSize + "," + colorPlayer + ","+ playerType.getTitularPlayer() + "]\n";
	}
	
}
