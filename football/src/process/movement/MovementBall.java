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
import process.management.ConstantValues;
import process.management.Map;
/**
 * @author quitt
 *
 */
public class MovementBall {

	private DataBall ball;
	private Map table;
	private Score score;
	private PositionTactics pt;
	private PositionTactics pt2;
	private DataTeam PTeam;
	private DataTeam IATeam;
	private PositionBall pb;
	
	public MovementBall(DataBall ball, Map table, Score score,
			PositionTactics pt, PositionTactics pt2, DataTeam PTeam, DataTeam IATeam, PositionBall pb){
		
		this.ball = ball;
		this.table = table;
		this.score = score;
		this.pt = pt;
		this.pt2 = pt2;
		this.PTeam = PTeam;
		this.IATeam = IATeam;
		this.pb = pb;
	}
	
	public void roll() {
		if (ball.getSpeedX()!=0 || ball.getSpeedY()!=0)
		{
			//ball.setCanIt(0);
			table.removeElement(ball.getPositionX(), ball.getPositionY());
			//we decelerate slowly
			int deceleration = 0;
			//if(deceleration == 2) {
				if (ball.getSpeedX()>1) {
					ball.setPositionX(ball.getPositionX()+1);
					ball.setSpeedX(ball.getSpeedX()-1);
				}
				else if (ball.getSpeedX()==1)
				{
					ball.setPositionX(ball.getPositionX()+1);
				}
				else if (ball.getSpeedX()<-1){
					ball.setPositionX(ball.getPositionX()-1);
					ball.setSpeedX(ball.getSpeedX()+1);
				}
				else if (ball.getSpeedX()==-1) {
					ball.setPositionX(ball.getPositionX()-1);
				}
				
				
				if (ball.getSpeedY()>1) {
					ball.setPositionY(ball.getPositionY()+1);
					ball.setSpeedY(ball.getSpeedY()-1);
				}
				else if (ball.getSpeedY()==1) {
					ball.setPositionY(ball.getPositionY()+1);
				}
				else if (ball.getSpeedY()<-1){
					ball.setPositionY(ball.getPositionY()-1);
					ball.setSpeedY(ball.getSpeedY()+1);
				}
				else if (ball.getSpeedY()==-1) {
					ball.setPositionY(ball.getPositionY()-1);
				}
				deceleration++;
			//}
			table.setElement(ball);
		}
		else 
		{
			ball.setCanIt(ball.getCanIt()+1);
		}

		try {
			move(pb, table, pt, pt2, PTeam, IATeam);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// checker ball's exit limits
	}
	
	public void setPositionBall(int x, int y) {
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
			score.setScoreTeam1(score.getScoreTeam2()+1);
			pt.placePlayers(PTeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = true;
			pt2.placePlayers(IATeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = false;
			pb.placeBallEngagement(ball, table);
			ball.setSpeedX(0);
			ball.setSpeedY(0);
		}

		else if(limitsGoalRight()) {
			System.out.println("GOAL !!! Congratulations team1");
			score.setScoreTeam2(score.getScoreTeam2()+1);
			pt.placePlayers(PTeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = true;
			pt2.placePlayers(IATeam, table, alreadyPlacedLeft);
			alreadyPlacedLeft = false;
			pb.placeBallEngagement(ball, table);
		}
		else if (limitsSideLineTop()) {
			System.out.println("THROW (top)!!!");
			pb.setPositionBall(ball.getPositionX(), ConstantPosition.INITIAL_POINT, ball, table);
		}
		else if (limitsSideLineBottom()) {
			System.out.println("THROW (bottom)!!!");
			pb.setPositionBall(ball.getPositionX(), ConstantPosition.HEIGHT, ball, table);
		}
		else if(limitsCornersLeft()) {
			System.out.println("Corner Left");
			pb.setPositionBall(ConstantPosition.SIXYARD1X, ConstantPosition.SIXYARD1Y, ball, table);
		}
		else if(limitsCornersRight()) {
			System.out.println("Corner Right");
			pb.setPositionBall(ConstantPosition.SIXYARD2X, ConstantPosition.SIXYARD2Y, ball, table);
		}
	}

	public boolean limitsGoalLeft () {

		if(ball.getPositionX()<ConstantPosition.GOAL1X) {
			//if(ball.getPositionY()>ConstantPosition.GOALY1 && ball.getPositionY()<ConstantPosition.GOALY2) {
				return true;
			/*}
			else {
				return false;
			}*/
		}
		else {
			return false;
		}

	}

	public boolean limitsGoalRight() {
		if(ball.getPositionX()>ConstantPosition.GOAL2X) {
			//if(ball.getPositionY()>ConstantPosition.GOALY1 && ball.getPositionY()<ConstantPosition.GOALY2) {
				return true;
			/*}
			else {
				return false;
			}*/
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
