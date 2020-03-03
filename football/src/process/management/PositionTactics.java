package process.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataplayer.DataPlayer;
import datateam.DataTeam;

public class PositionTactics {

	public PositionTactics(DataTeam team) throws IOException {
		whatIsPType(team.getPlayers());
	}
	
	public void whatIsPType(HashMap<String, DataPlayer> players) {
		Map<String, DataPlayer> map = players;
		List<DataPlayer> values = new ArrayList<>(map.values());
		for(DataPlayer dp : values) {
            System.out.println(dp.getPlayerName() +" : " +  dp.getPlayerType());
        }
	}
	
	public void placePlayer(DataPlayer player) {
		
	}
}
