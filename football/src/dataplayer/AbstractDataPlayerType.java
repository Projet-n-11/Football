package dataplayer;

public abstract class AbstractDataPlayerType{
	private PlayerHealth health;
	private PlayerStress stress;
	private PlayerSpeed speed;
	private String playerTypeName;
	private int titularPlayer;
	
	public PlayerHealth getHeath() {
		return health;
	}
	public void setHeath(PlayerHealth health) {
		this.health = health;
	}
	public PlayerStress getStress() {
		return stress;
	}
	public void setStress(PlayerStress stress) {
		this.stress = stress;
	}
	public PlayerSpeed getSpeed() {
		return speed;
	}
	public void setSpeed(PlayerSpeed speed) {
		this.speed = speed;
	}
	public int getTitularPlayer() {
		return titularPlayer;
	}
	public void setTitularPlayer(int titularPlayer) {
		this.titularPlayer = titularPlayer;
	}
	public String getPlayerTypeName() {
		return playerTypeName;
	}
	public void setPlayerTypeName(String playerTypeName) {
		this.playerTypeName = playerTypeName;
	}
	public String toString() {	// inutile : redéfini dans les classes concrètes
		return "Health =" + health + ", stress=" + stress + ", speed=" + speed;
	}
}
