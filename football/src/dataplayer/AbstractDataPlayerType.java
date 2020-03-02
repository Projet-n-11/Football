package dataplayer;

public abstract class AbstractDataPlayerType{
	private PlayerHealth health;
	private PlayerStress stress;
	private PlayerSpeed speed;
	
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
	public String toString() {
		return "Health =" + health + ", stress=" + stress + ", speed=" + speed;
	}
}
