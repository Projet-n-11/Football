package dataplayer;

public class PowerCorruption extends AbstractSpecsSP {

	private final float RADIUSCORRUPTION = 10;

	public PowerCorruption(int durationTime, boolean activation) {
		super(durationTime, activation);
	}
	
	public float getRayonCorruption() {
		return RADIUSCORRUPTION;
	}
	
	public String toString() {
		return "CORRUPTION_RADIUS" + RADIUSCORRUPTION;
	}
}
