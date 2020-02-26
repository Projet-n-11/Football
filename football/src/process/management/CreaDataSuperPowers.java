package process.management;

import dataplayer.AbstractSpecsSP;
import dataplayer.DataSuperPowers;
import dataplayer.PowerForceField;
import dataplayer.PowerSuperSpeed;
import dataplayer.PowerDodge;
import dataplayer.PowerCorruption;
import dataplayer.PowerMagnet;

public class CreaDataSuperPowers {
	
	/**
	 * standart instanciator of DataSuperPowers with no powers
	 * @return DataSuperPowers
	 */
	public static DataSuperPowers creaDataSuperPowers () {
		
		AbstractSpecsSP forceField = new PowerForceField(0, false, "noTeam");
		AbstractSpecsSP superSpeed = new PowerSuperSpeed(0, false);
		AbstractSpecsSP dodge = new PowerDodge(0, false, false, false);
		AbstractSpecsSP corruption = new PowerCorruption(0, false);
		AbstractSpecsSP magnet = new PowerMagnet(0, false);
		
		// tous des AbstractSpecsSP
		DataSuperPowers dataPowers = new DataSuperPowers(forceField, superSpeed, dodge, corruption, magnet) ;
		return dataPowers;
	}
}
