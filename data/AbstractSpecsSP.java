package data;

public abstract class AbstractSpecsSP extends PowerMagnet, PowerForceField, PowerSuperSpeed, PowerDodge, PowerCorruption {
	private int durationTime;
	private boolean activation;
	
	public int getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(int durationTime) {
		this.durationTime = durationTime;
	}
	public boolean isActivation() {
		return activation;
	}
	public void setActivation(boolean activation) {
		this.activation = activation;
	}
}
