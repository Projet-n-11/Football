package data;

public abstract class AbstractDataPlayerType{
	private PlayerHealth heath;
	private PlayerStress stress;
	private PlayerSpeed speed;
	
	public AbstractDataPlayerType() {
		
	}
	
	public PlayerHealth getHeath() {
		return heath;
	}
	public void setHeath(PlayerHealth heath) {
		this.heath = heath;
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
	
}
