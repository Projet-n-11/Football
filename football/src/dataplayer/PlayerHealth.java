package dataplayer;

public class PlayerHealth {
	private int health;

	public PlayerHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public String toString() {
		return "HP = " + health;
	}
}
