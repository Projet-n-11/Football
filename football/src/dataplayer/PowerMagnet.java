package dataplayer;

public class PowerMagnet extends AbstractSpecsSP {
	private final float RADIUSMAGNETIC = 6;

	public PowerMagnet(int durationTime, boolean activation) {
		super(durationTime, activation);
	}
	
	public float getRadiusMagnetic() {
		return RADIUSMAGNETIC;
	}
	public String toString() {
		return "RADIUS MAGNETIC FIELD : " + RADIUSMAGNETIC;
	}
}
