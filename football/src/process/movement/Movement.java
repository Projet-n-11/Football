package process.movement;

import dataplayer.Acceleration;
import dataplayer.PlayerSpeed;

public interface Movement {
	
	void Move(Acceleration acceleration, PlayerSpeed speed);
	
	Boolean limits();
}
