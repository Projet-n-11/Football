package process.movement;

import databall.DataBall;
import dataplayer.DataPlayer;

public interface Movement {
	
	public Boolean Move(DataBall db, DataPlayer dp);
	
	public void Limits(DataPlayer dp);
}
