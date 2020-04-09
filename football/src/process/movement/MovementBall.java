package process.movement;

import databall.DataBall;
import dataplayer.DataPlayer;
import dataplayer.PlayerSpeed;
import datateam.DataTeam;
import datafield.Corner;
import datafield.Goal;
import datafield.SpecialPosition;
import process.management.PositionBall;
import process.management.PositionTactics;
import process.scores.Score;
import process.management.ConstantPosition;
import process.management.Map;
/**
 * @author quitt
 *
 */
public class MovementBall {

	private DataBall db;
	private Map table;
	private Score score;

	public MovementBall(DataBall db, Map table, Score score,
			PositionTactics pt, PositionTactics pt2, DataTeam PTeam, DataTeam IATeam){
		
		this.db = db;
		this.table = table;
		this.score = score;
		PositionBall pb;
		pb = new PositionBall(db, table);
		try {
			move(db, pb, table, score, pt, pt2, PTeam, IATeam);
		} catch (InterruptedException e) {
			System.err.println("Movement problem, reinstall the game!");
		}

	}

	public void move(DataBall db, PositionBall pb, Map table, Score score,
			PositionTactics pt, PositionTactics pt2, DataTeam PTeam, DataTeam IATeam) throws InterruptedException {
		
		boolean alreadyPlacedLeft = false;
		
		if(limitsGoalLeft(db)) {
			System.out.println("GOAL !!! Congratulations team2");
			Thread.sleep(500);
			score.setScoreTeam1(score.getScoreTeam2()+1);
			pt.placePlayers(PTeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = true;
			pt2.placePlayers(IATeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = false;
			Thread.sleep(200);
			pb.placeBallEngagement(db, table);
		}

		else if(limitsGoalRight(db)) {
			System.out.println("GOAL !!! Congratulations team1");
			Thread.sleep(500);
			score.setScoreTeam2(score.getScoreTeam2()+1);
			pt.placePlayers(PTeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = true;
			pt2.placePlayers(IATeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = false;
			Thread.sleep(200);
			pb.placeBallEngagement(db, table);
		}
		else if (limitsSideLineTop(db)) {
			System.out.println("THROW (top)!!!");
			Thread.sleep(200);
			pb.setPositionBall(db.getPositionX(), ConstantPosition.INITIAL_POINT, db, table);
		}
		else if (limitsSideLineBottom(db)) {
			System.out.println("THROW (bottom)!!!");
			Thread.sleep(200);
			pb.setPositionBall(db.getPositionX(), ConstantPosition.HEIGHT, db, table);
		}
		else if(limitsCornersLeft(db)) {
			System.out.println("Corner Left");
			Thread.sleep(200);
			pb.setPositionBall(ConstantPosition.SIXYARD1X, ConstantPosition.SIXYARD1Y, db, table);
		}
		else if(limitsCornersRight(db)) {
			System.out.println("Corner Right");
			Thread.sleep(200);
			pb.setPositionBall(ConstantPosition.SIXYARD2X, ConstantPosition.SIXYARD2Y, db, table);
		}
	}

	public boolean limitsGoalLeft (DataBall db) {

		if(db.getPositionX()<ConstantPosition.GOAL1X) {
			if(db.getPositionY()>ConstantPosition.GOALY1 && db.getPositionY()<ConstantPosition.GOALY2) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}

	}

	public boolean limitsGoalRight(DataBall db) {
		if(db.getPositionX()>ConstantPosition.GOAL2X) {
			if(db.getPositionY()>ConstantPosition.GOALY1 && db.getPositionY()<ConstantPosition.GOALY2) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public boolean limitsSideLineTop(DataBall db) {
		if(db.getPositionX()>ConstantPosition.INITIAL_POINT && db.getPositionX()<ConstantPosition.WIDTH) {
			if(db.getPositionY()<ConstantPosition.INITIAL_POINT) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}

	}
	public boolean limitsSideLineBottom(DataBall db) {
		if(db.getPositionX()>ConstantPosition.INITIAL_POINT && db.getPositionX()<ConstantPosition.WIDTH) {

			if(db.getPositionY()>ConstantPosition.HEIGHT) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public boolean limitsCornersLeft(DataBall db) {

		if(db.getPositionX()<ConstantPosition.CORNER1X) {
			if(db.getPositionY()>ConstantPosition.CORNER1Y && db.getPositionY()<ConstantPosition.GOALY1) {
				return true;
			}
			else if (db.getPositionY()<ConstantPosition.CORNER2Y && db.getPositionY()>ConstantPosition.GOALY2) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public boolean limitsCornersRight(DataBall db) {

		if(db.getPositionX()>ConstantPosition.CORNER3X) {
			if(db.getPositionY()>ConstantPosition.CORNER3Y && db.getPositionY()<ConstantPosition.GOALY1) {
				return true;
			}
			else if (db.getPositionY()<ConstantPosition.CORNER4Y && db.getPositionY()>ConstantPosition.GOALY2) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
