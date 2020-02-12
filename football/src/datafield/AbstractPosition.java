package datafield;

public abstract class AbstractPosition{
	private int position;
	
	public AbstractPosition(int position) {
		this.position = position;
	}
	
	public int getPositionX() {
		return position;
	}
	public void setPositionX(int position) {
		this.position = position;
	}
}
