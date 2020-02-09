package data;

public class Goal extends AbstractPosition {
	private boolean insideBall;

	public boolean isInsideBall() {
		return insideBall;
	}

	public void setInsideBall(boolean insideBall) {
		this.insideBall = insideBall;
	}
}
