package data;

public class DataSuperPowers {
	private AbstractSpecsSP forceField;
	private AbstractSpecsSP superSpeed;
	private AbstractSpecsSP dodge;
	private AbstractSpecsSP corruption;
	private AbstractSpecsSP magnet;
	
	public DataSuperPowers() {
	}
	public AbstractSpecsSP getForceField() {
		return forceField;
	}
	public void setForceField(AbstractSpecsSP forceField) {
		this.forceField = forceField;
	}
	public AbstractSpecsSP getSuperSpeed() {
		return superSpeed;
	}
	public void setSuperSpeed(AbstractSpecsSP superSpeed) {
		this.superSpeed = superSpeed;
	}
	public AbstractSpecsSP getDodge() {
		return dodge;
	}
	public void setDodge(AbstractSpecsSP dodge) {
		this.dodge = dodge;
	}
	public AbstractSpecsSP getCorruption() {
		return corruption;
	}
	public void setCorruption(AbstractSpecsSP corruption) {
		this.corruption = corruption;
	}
	public AbstractSpecsSP getMagnet() {
		return magnet;
	}
	public void setMagnet(AbstractSpecsSP magnet) {
		this.magnet = magnet;
	}
}
