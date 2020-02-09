package data;

public class PlayerForward extends AbstractDataPlayerType {
	private Acceleration acceleration;
	private Precision precision;
	
	public Acceleration getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(Acceleration acceleration) {
		this.acceleration = acceleration;
	}
	public Precision getPrecision() {
		return precision;
	}
	public void setPrecision(Precision precision) {
		this.precision = precision;
	}
}
