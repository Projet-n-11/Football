package process.management;

import databall.DataBall;
import dataplayer.DataPlayer;

public class PositionBall {

	public PositionBall(DataBall db, Positioning table) {
		placeBallEngagement(db, table);
	}
	
	public void setPositionBall(int positionX, int positionY, DataBall db, Positioning table) {
		db.setPositionX(positionX);
		db.setPositionY(positionY);
		table.setElement(db);
	}
	
	public void placeBallEngagement(DataBall db, Positioning table) {
		setPositionBall(ConstantTactics.L_GOALKEEPERX, ConstantTactics.L_GOALKEEPERY, db, table);
	}
	
}
