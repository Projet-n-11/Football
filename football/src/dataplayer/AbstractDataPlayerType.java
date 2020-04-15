package dataplayer;

import dataplayer.PlayerStamina;

public abstract class AbstractDataPlayerType{
	private PlayerStamina stamina;
	private PlayerStress stress;
	private PlayerSpeed speed;
	private int canHe;
	private String playerTypeName;
	private int titularPlayer;
	
	public AbstractDataPlayerType() {
		stamina = new PlayerStamina(100);
		stress = new PlayerStress(0);
		speed = new PlayerSpeed(1);
		canHe = 0;
	}
	
	public int getStamina() {
		return stamina.getStamina();
	}
	public void setStamina(int stamina) {
		if (stamina>=0 && stamina<=100)
		this.stamina.setStamina(stamina);
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
		return "stamina =" + stamina + ", stress=" + stress + ", speed=" + speed;
	}

	public int getCanHe() {
		return canHe;
	}

	public void setCanHe(int canHe) {
		this.canHe = canHe;
	}
}
