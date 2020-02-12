package dataplayer;

public abstract class AbstractSpecsSP{
	private int durationTime;
	private boolean activation;
	
	public AbstractSpecsSP() {
		
	}
	
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
