package dataplayer;

public class PowerForceField extends AbstractSpecsSP {
	private String whichTeam;
	private final String COLORFIELD = "BLUE";
	private final float RADIUSCAGE = 4;
	
	public PowerForceField(int durationTime, boolean activation, String whichTeam) {
		super(durationTime, activation);
		this.whichTeam = whichTeam;
	}
	
	public String getColorField() {
		return COLORFIELD;
	}
	
	public float getRadiusCage() {
		return RADIUSCAGE;
	}
	
	public String getWhichTeam() {
		return whichTeam;
	}
	
	public void setWhichTeam(String whichTeam) {
		this.whichTeam = whichTeam;
	}
	
	public String toString() {
		return "" + COLORFIELD + "," + RADIUSCAGE + "," + whichTeam; 
	}
}
