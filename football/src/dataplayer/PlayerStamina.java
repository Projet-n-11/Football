package dataplayer;

public class PlayerStamina {
	private int stamina;

	public PlayerStamina(int stamina) {
		this.stamina = stamina;
	}
	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public String toString() {
		return "HP = " + stamina;
	}
}
