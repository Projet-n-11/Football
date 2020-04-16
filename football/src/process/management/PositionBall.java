package process.management;

import databall.DataBall;
import dataplayer.DataPlayer;

public class PositionBall {

	private DataBall db;
	private Map table;
	
	public static PositionBall pb = new PositionBall();

	public void setPositionBall(int positionX, int positionY, DataBall db, Map table) {
		db.setPositionX(positionX);
		db.setPositionY(positionY);
		table.setElement(db);
	}
	
	public void placeBallEngagement(DataBall db, Map table) {
		setPositionBall(ConstantPosition.ENGAGEMENTX, ConstantPosition.ENGAGEMENTY, db, table);
	}
	
	public static PositionBall getInstance() {
		return pb;
	}
	
}
