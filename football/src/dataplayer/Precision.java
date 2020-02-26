package dataplayer;

public class Precision {
	private int valuePrecision;

	public Precision(int valuePrecision) {
		this.valuePrecision = valuePrecision;
	}
	public int getValuePrecision() {
		return valuePrecision;
	}

	public void setValuePrecision(int valuePrecision) {
		this.valuePrecision = valuePrecision;
	}
	
	public String toString() {
		return "PRECISION : " + valuePrecision;
	}
}
