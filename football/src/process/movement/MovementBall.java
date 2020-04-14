package process.movement;

import databall.DataBall;
import dataplayer.DataPlayer;
import dataplayer.PlayerSpeed;
import datateam.DataTeam;
import datafield.Corner;
import datafield.Goal;
import datafield.Grass;
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

	private static DataBall ball;
	private static Map table;
	private Score score;

	public MovementBall(DataBall ball, Map table, Score score,
			PositionTactics pt, PositionTactics pt2, DataTeam PTeam, DataTeam IATeam){
		
		MovementBall.ball = ball;
		MovementBall.table = table;
		this.score = score;
		PositionBall pb;
		pb = new PositionBall(ball, table);
		try {
			move(pb, table, pt, pt2, PTeam, IATeam);
		} catch (InterruptedException e) {
			System.err.println("Movement problem, reinstall the game!");
		}

	}
	
	public void roll() {
		if (ball.getSpeedX()!=0 || ball.getSpeedY()!=0)
		{
			System.out.println("roll !");
			Grass grass = new Grass(ball.getPositionX(), ball.getPositionY());
			table.setElement(grass);
			ball.setPositionX(ball.getPositionX()+ball.getSpeedX());
			ball.setPositionY(ball.getPositionY()+ball.getSpeedY());
			table.setElement(ball);
		}
	}
	
	public static void setPositionBall(int x, int y) {
		table.removeElement(ball.getPositionX(), ball.getPositionY());
		ball.setPositionX(x);
		ball.setPositionY(y);
		table.setElement(ball);		
	}

	public void move(PositionBall pb, Map table,
			PositionTactics pt, PositionTactics pt2, DataTeam PTeam, DataTeam IATeam) throws InterruptedException {
		
		boolean alreadyPlacedLeft = false;
		
		if(limitsGoalLeft()) {
			System.out.println("GOAL !!! Congratulations team2");
			Thread.sleep(500);
			score.setScoreTeam1(score.getScoreTeam2()+1);
			pt.placePlayers(PTeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = true;
			pt2.placePlayers(IATeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = false;
			Thread.sleep(200);
			pb.placeBallEngagement(ball, table);
		}

		else if(limitsGoalRight()) {
			System.out.println("GOAL !!! Congratulations team1");
			Thread.sleep(500);
			score.setScoreTeam2(score.getScoreTeam2()+1);
			pt.placePlayers(PTeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = true;
			pt2.placePlayers(IATeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = false;
			Thread.sleep(200);
			pb.placeBallEngagement(ball, table);
		}
		else if (limitsSideLineTop()) {
			System.out.println("THROW (top)!!!");
			Thread.sleep(200);
			pb.setPositionBall(ball.getPositionX(), ConstantPosition.INITIAL_POINT, ball, table);
		}
		else if (limitsSideLineBottom()) {
			System.out.println("THROW (bottom)!!!");
			Thread.sleep(200);
			pb.setPositionBall(ball.getPositionX(), ConstantPosition.HEIGHT, ball, table);
		}
		else if(limitsCornersLeft()) {
			System.out.println("Corner Left");
			Thread.sleep(200);
			pb.setPositionBall(ConstantPosition.SIXYARD1X, ConstantPosition.SIXYARD1Y, ball, table);
		}
		else if(limitsCornersRight()) {
			System.out.println("Corner Right");
			Thread.sleep(200);
			pb.setPositionBall(ConstantPosition.SIXYARD2X, ConstantPosition.SIXYARD2Y, ball, table);
		}
	}

	public boolean limitsGoalLeft () {

		if(ball.getPositionX()<ConstantPosition.GOAL1X) {
			if(ball.getPositionY()>ConstantPosition.GOALY1 && ball.getPositionY()<ConstantPosition.GOALY2) {
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

	public boolean limitsGoalRight() {
		if(ball.getPositionX()>ConstantPosition.GOAL2X) {
			if(ball.getPositionY()>ConstantPosition.GOALY1 && ball.getPositionY()<ConstantPosition.GOALY2) {
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

	public boolean limitsSideLineTop() {
		if(ball.getPositionX()>ConstantPosition.INITIAL_POINT && ball.getPositionX()<ConstantPosition.WIDTH) {
			if(ball.getPositionY()<ConstantPosition.INITIAL_POINT) {
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
	public boolean limitsSideLineBottom() {
		if(ball.getPositionX()>ConstantPosition.INITIAL_POINT && ball.getPositionX()<ConstantPosition.WIDTH) {

			if(ball.getPositionY()>ConstantPosition.HEIGHT) {
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

	public boolean limitsCornersLeft() {

		if(ball.getPositionX()<ConstantPosition.CORNER1X) {
			if(ball.getPositionY()>ConstantPosition.CORNER1Y && ball.getPositionY()<ConstantPosition.GOALY1) {
				return true;
			}
			else if (ball.getPositionY()<ConstantPosition.CORNER2Y && ball.getPositionY()>ConstantPosition.GOALY2) {
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

	public boolean limitsCornersRight() {

		if(ball.getPositionX()>ConstantPosition.CORNER3X) {
			if(ball.getPositionY()>ConstantPosition.CORNER3Y && ball.getPositionY()<ConstantPosition.GOALY1) {
				return true;
			}
			else if (ball.getPositionY()<ConstantPosition.CORNER4Y && ball.getPositionY()>ConstantPosition.GOALY2) {
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
