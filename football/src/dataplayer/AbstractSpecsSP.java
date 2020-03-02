package dataplayer;

public abstract class AbstractSpecsSP{
	private int durationTime;
	private boolean activation;
	
	public AbstractSpecsSP(int durationTime, boolean activation) {
		this.durationTime = durationTime;
		this.activation = activation;
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

	@Override
	public String toString() {
		return "" + durationTime + "," + activation;
	}
	
}
