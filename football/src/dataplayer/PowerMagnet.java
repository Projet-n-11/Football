package dataplayer;

public class PowerMagnet extends AbstractSpecsSP {
	private final float RADIUSMAGNETIC = 6;

	public PowerMagnet(int durationTime, boolean activation) {
		super(durationTime, activation);
	}
	
	public float getRadiusMagnetic() {
		return RADIUSMAGNETIC;	//radius magnetic field
	}
	public String toString() {
		return "" + RADIUSMAGNETIC;
	}
}
