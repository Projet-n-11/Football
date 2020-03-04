package process.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import dataplayer.DataPlayer;
import datateam.DataTeam;

public class PositionTactics {

	public PositionTactics(DataTeam team) throws IOException {
		whatIsPType(team.getPlayers());
	}

	public void whatIsPType(HashMap<String, DataPlayer> players) {
		ArrayList<DataPlayer> values = new ArrayList<>(players.values());
		for (DataPlayer dp : values) {
			if (dp.getPlayerType().getTitularPlayer() == 1)
				System.out.println(dp.getPlayerName() + " : " + dp.getPlayerType());
		}
	}

	public void placePlayer(HashMap<String, DataPlayer> players, int teamStrategy) {
		ArrayList<DataPlayer> values = new ArrayList<>(players.values());
		for (DataPlayer dp : values) {
			if (dp.getPlayerType().getTitularPlayer() == 1) {
				switch (teamStrategy) {
				case 343:
					
					break;
				}
			}
		}
	}
}
