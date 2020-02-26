package dataplayer;

public class Acceleration {
	private float valueAcceleration;

	public Acceleration(float valueAcceleration) {
		this.valueAcceleration = valueAcceleration;
	}
	
	public float getValueAcceleration() {
		return valueAcceleration;
	}

	public void setValueAcceleration(float valueAcceleration) {
		this.valueAcceleration = valueAcceleration;
	}
	
	public String toString() {
		return "" + valueAcceleration;
	}
}
