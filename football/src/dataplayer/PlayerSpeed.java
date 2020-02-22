package dataplayer;

public class PlayerSpeed {
	private float speed;

	public PlayerSpeed() {
		this.speed = 1;
	}
	public PlayerSpeed(float speed) {
		this.speed = speed;
	}
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public String toString() {
		return "Speed = " + speed;
	}
}
