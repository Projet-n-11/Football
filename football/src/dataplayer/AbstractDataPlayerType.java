package dataplayer;

public abstract class AbstractDataPlayerType{
	private PlayerHealth health;
	private PlayerStress stress;
	private PlayerSpeed speed;
	private String playerTypeName;
	private int titularPlayer;
	
	public AbstractDataPlayerType() {
		health = new PlayerHealth(100);
		stress = new PlayerStress(0);
		speed = new PlayerSpeed(1);
	}
	
	public int getHealth() {
		return health.getHealth();
	}
	public void setHealth(int health) {
		if (health>=0 && health<=100)
		this.health.setHealth(health);
	}
	public int getStress() {
		return stress.getStress();
	}
	public void setStress(int stress) {
		if (stress>=0 && stress<=100)
		this.stress.setStress(stress);
	}
	public PlayerSpeed getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed.setSpeedX(speed);
		this.speed.setSpeedY(speed);
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
