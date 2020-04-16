package dataplayer;

import dataplayer.PlayerStamina;

public abstract class AbstractDataPlayerType{
	private PlayerStamina stamina;
	private PlayerStress stress;
	private PlayerSpeed speed;
	private int canHeAct;
	private int canHePass;
	private String playerTypeName;
	private int titularPlayer;
	
	public AbstractDataPlayerType() {
		stamina = new PlayerStamina(100);
		stress = new PlayerStress(0);
		speed = new PlayerSpeed(1);
		canHeAct = 0;
		setCanHePass(0);
	}
	
	public int getStamina() {
		return stamina.getStamina();
	}
	public void setStamina(int stamina) {
		if (stamina<0)
		{
			this.stamina.setStamina(0);
		}
		else if (stamina>=100)
		{
			this.stamina.setStamina(100);
		}
		else this.stamina.setStamina(stamina);
	}
	public int getStress() {
		return stress.getStress();
	}
	public void setStress(int stress) {
		if (stress<0)
		{
			this.stress.setStress(0);
		}
		else if (stress>=100)
		{
			this.stress.setStress(100);
		}
		else this.stress.setStress(stress);
	}
	
	public PlayerSpeed getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed.setSpeedX(speed);
		this.speed.setSpeedY(speed);
	}
	
	public void setSpeedX(int speed) {
		this.speed.setSpeedX(speed);
	}
	
	public void setSpeedY(int speed) {
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

	public int getCanHeAct() {
		return canHeAct;
	}

	public void setCanHeAct(int canHe) {
		this.canHeAct = canHe;
	}

	public int getCanHePass() {
		return canHePass;
	}

	public void setCanHePass(int canHePass) {
		this.canHePass = canHePass;
	}
}
