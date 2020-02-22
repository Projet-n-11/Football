package dataplayer;

public class PlayerForward extends AbstractDataPlayerType {
	private Acceleration acceleration;
	private Precision precision;
	
	public PlayerForward(Acceleration acceleration, Precision precision) {
		this.acceleration = acceleration;
		this.precision = precision;
	}
	
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
	
	public String toString() {
		return "Acceleration = " + acceleration.toString() + " and Precision = " + precision.toString();
	}
}
