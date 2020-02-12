package dataplayer;

public class PowerForceField extends AbstractSpecsSP {
	private String whichTeam;
	private final String COLORFIELD = "BLUE";
	private final float RAYONCAGE = 4;
	
	public String getWhichTeam() {
		return whichTeam;
	}
	public void setWhichTeam(String whichTeam) {
		this.whichTeam = whichTeam;
	}
	public String getColorField() {
		return colorField;
	}
	public void setColorField(String colorField) {
		this.colorField = colorField;
	}
	public float getRayonCage() {
		return rayonCage;
	}
	public void setRayonCage(float rayonCage) {
		this.rayonCage = rayonCage;
	}
}
