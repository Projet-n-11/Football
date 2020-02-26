package dataplayer;

public class Reflex {
	private float valueAcceleration;

	public Reflex(int valueAcceleration) {
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
