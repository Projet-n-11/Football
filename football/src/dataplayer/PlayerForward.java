package dataplayer;

public class PlayerForward extends AbstractDataPlayerType {
	private Acceleration acceleration;
	private Precision precision;
	
	public PlayerForward(Acceleration acceleration, Precision precision, int titularPlayer) {
		this.acceleration = acceleration;
		this.precision = precision;
		this.setTitularPlayer(titularPlayer);
		this.setPlayerTypeName("Forward");
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
		return "Attaquant," + acceleration.toString() + "," + precision.toString();
	}
}
