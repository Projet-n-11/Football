package dataplayer;

public class PlayerStress {
	private int stress;

	public PlayerStress(int stress) {
		this.stress = stress;
	}
	public int getStress() {
		return stress;
	}

	public void setStress(int stress) {
		this.stress = stress;
	}
	
	public String toString() {
		return "Stress = " + stress;
	}
}
