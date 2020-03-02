package dataplayer;

public class Reflex {
	private int valueAcceleration;

	public Reflex(int valueAcceleration) {
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
