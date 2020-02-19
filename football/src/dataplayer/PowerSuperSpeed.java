package dataplayer;

public class PowerSuperSpeed extends AbstractSpecsSP {
	final int MULTIPLICATIONSPEED = 4;
	
	public PowerSuperSpeed(int durationTime, boolean activation) {
		super(durationTime, activation);
	}
	
	public int getMultiplicationSpeed() {
		return MULTIPLICATIONSPEED;
	}
	
	public String toString() {
		return "Speed will be multiplied by : " + MULTIPLICATIONSPEED;
	}
	
}
