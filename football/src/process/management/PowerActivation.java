package process.management;

import databall.DataBall;
import dataplayer.DataPlayer;
import dataplayer.PowerSuperSpeed;
import datateam.DataTeam;

public class PowerActivation {
	private int duration=10;
	private boolean activation=true;
	
	PowerActivation(DataBall ball){
		DataPlayer player=ball.getOwnedBy();
		
		int i=(int)(Math.random() * 5);
		for(int j=0;j<10;j++) {
			switch (i){
			case '0':
				activationSuperSpeed(player);
			case '1':
				activationMagnet(player);
			case '2':
				activationForceField(player);
			case '3':
				activationDodge(player);
			case '4':
				activationCorruption(player);
			}
		}
		
	}
	
	public void activationSuperSpeed(DataPlayer player) {
		int speed=player.getPlayerType().getSpeed().getSpeedX();
		PowerSuperSpeed superSpeed=(PowerSuperSpeed)player.getPlaySuperPower().getSuperSpeed();
		player.getPlayerType().setSpeed(superSpeed.getMultiplicationSpeed());
		
	}

	public void activationMagnet(DataPlayer player) {
		
	}
	public void activationForceField(DataPlayer player) {
		
	}
	public void activationDodge(DataPlayer player) {
		
	}
	public void activationCorruption(DataPlayer player) {
		
	}

}
