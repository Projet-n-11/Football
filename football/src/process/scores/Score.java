package process.scores;

public class Score {
	
	private int scoreTeam1;
	private int scoreTeam2;
	
	public Score() {
		scoreTeam1=0;
		scoreTeam2=0;
	}

	/**
	 * @return the scoreTeam1
	 */
	public int getScoreTeam1() {
		return scoreTeam1;
	}

	/**
	 * @param scoreTeam1 the scoreTeam1 to set
	 */
	public void setScoreTeam1(int scoreTeam1) {
		this.scoreTeam1 = scoreTeam1;
	}

	/**
	 * @return the scoreTeam2
	 */
	public int getScoreTeam2() {
		return scoreTeam2;
	}

	/**
	 * @param scoreTeam2 the scoreTeam2 to set
	 */
	public void setScoreTeam2(int scoreTeam2) {
		this.scoreTeam2 = scoreTeam2;
	}

	@Override
	public String toString() {
		return "Score [scoreTeam1=" + scoreTeam1 + ", scoreTeam2=" + scoreTeam2 + "]";
	}
	
}
