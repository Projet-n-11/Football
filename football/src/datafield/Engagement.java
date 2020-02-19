package datafield;

public class Engagement extends AbstractPosition {
	private boolean engagementPoint;

	public Engagement(boolean engagementPoint, int position) {
		super(position);
		this.engagementPoint = engagementPoint;
	}
	public boolean isEngagementPoint() {
		return engagementPoint;
	}

	public void setEngagementPoint(boolean engagementPoint) {
		this.engagementPoint = engagementPoint;
	}
	
	public String toString() {
		return "Is the ball on engagementPoint ? Answer :" + engagementPoint;
	}
}
