package datafield;

public class Engagement extends Position {
	private boolean engagementPoint;

	public Engagement(boolean engagementPoint, int positionX, int positionY) {
		super(positionX, positionY);
		this.engagementPoint = engagementPoint;
	}
	public boolean getEngagementPoint() {
		return engagementPoint;
	}

	public void setEngagementPoint(boolean engagementPoint) {
		this.engagementPoint = engagementPoint;
	}
	
	public String toString() {
		return "Is the ball on engagementPoint ? Answer :" + engagementPoint;
	}
	
}
