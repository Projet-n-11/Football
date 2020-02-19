package dataplayer;

public class Strength {
	private int valueStrength;

	public Strength(int valueStrength) {
		this.valueStrength = valueStrength;
	}
	public int getValueStrength() {
		return valueStrength;
	}

	public void setValueStrength(int valueStrength) {
		this.valueStrength = valueStrength;
	}
	
	public String toString() {
		return "Strength value is : " + valueStrength;
	}
}
