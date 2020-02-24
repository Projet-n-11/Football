package dataplayer;

public class PlayerSpeed {
	private int speedX;
	private int speedY;

	public PlayerSpeed() {
		this.speedX = 1;
		this.speedY=1;
	}
	public PlayerSpeed(int speed) {
		this.speedX = speed;
		this.speedY=speed;
	}
	
	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speed) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY=speedY;
	}
	public String toString() {
		return "Speed X = " + speedX+"Speed Y"+speedY;
	}
}
