package dataplayer;

public class PowerDodge extends AbstractSpecsSP{
	private boolean haveBall;
	private boolean isnotPhysical = false;
	
	public PowerDodge(int durationTime, boolean activation, boolean haveBall, boolean isnotPhysical) {
		super(durationTime, activation);
		this.haveBall = haveBall;
		this.isnotPhysical = isnotPhysical;
	}
	
	public boolean getIsnotPhysical() {
		return isnotPhysical;
	}

	public void setIsnotPhysical(boolean isnotPhysical) {
		this.isnotPhysical = isnotPhysical;
	}
	
	public boolean getHaveBall() {
		return haveBall;
	}

	public void setHaveBall(boolean haveBall) {
		this.haveBall = haveBall;
	}
	
	public String toString() {
		return "" + haveBall + "," + isnotPhysical;
	}
}
