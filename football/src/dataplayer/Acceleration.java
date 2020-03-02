package dataplayer;

public class Acceleration {
	private int valueAcceleration;

	public Acceleration(int valueAcceleration) {
		this.valueAcceleration = valueAcceleration;
	}
	
	public float getValueAcceleration() {
		return valueAcceleration;
	}

	public void setValueAcceleration(int valueAcceleration) {
		this.valueAcceleration = valueAcceleration;
	}
	
	public String toString() {
		return "" + valueAcceleration;
	}
}
