package process.management;

import databall.DataBall;
import dataplayer.DataPlayer;

public class PositionBall {

	public PositionBall(DataBall db, Map table) {
		placeBallEngagement(db, table);
	}
	
	public void setPositionBall(int positionX, int positionY, DataBall db, Map table) {
		db.setPositionX(positionX);
		db.setPositionY(positionY);
		table.setElement(db);
	}
	
	public void placeBallEngagement(DataBall db, Map table) {
		setPositionBall(ConstantTactics.L_GOALKEEPERX, ConstantTactics.L_GOALKEEPERY, db, table);
	}
	
}
