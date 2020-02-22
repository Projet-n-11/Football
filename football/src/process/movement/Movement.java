package process.movement;

import databall.DataBall;
import dataplayer.DataPlayer;

public interface Movement {
	
	public void move(DataBall db, DataPlayer dp);
	
	public Boolean limits(DataPlayer dp);
}
