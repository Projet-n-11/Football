package dataplayer;

public class Dive {
	private int valueDive;

	public Dive(int valueDive) {
		this.valueDive = valueDive;
	}
	
	public int getValueDive() {
		return valueDive;
	}

	public void setValueDive(int valueDive) {
		this.valueDive = valueDive;
	}
	
	public String toString() {
		return "valueDive = " + valueDive;
	}
}
