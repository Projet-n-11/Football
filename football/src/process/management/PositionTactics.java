package process.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import dataplayer.DataPlayer;
import datateam.DataTeam;

public class PositionTactics {

	private ArrayList<DataPlayer> valuesDefender = new ArrayList<>();
	private ArrayList<DataPlayer> valuesForward = new ArrayList<>();
	private ArrayList<DataPlayer> valuesGoalie = new ArrayList<>();
	private ArrayList<DataPlayer> valuesMidFielder = new ArrayList<>();
	
	public PositionTactics(DataTeam team) throws IOException {
		//whatIsPType(team.getPlayers());
		determinateTypePlayers(team.getPlayers(), team.getDefaultStrategy());
	}

	public void whatIsPType(HashMap<String, DataPlayer> players) {
		ArrayList<DataPlayer> values = new ArrayList<>(players.values());
		for (DataPlayer dp : values) {
			if (dp.getPlayerType().getTitularPlayer() == 1) {
				System.out.println(dp.getPlayerType().getPlayerTypeName());
				System.out.println(dp.getPlayerName() + " : " + dp.getPlayerType());
			}
		}
		
	}

	public void determinateTypePlayers(HashMap<String, DataPlayer> players, int teamStrategy) throws NoSuchElementException{
		ArrayList<DataPlayer> values = new ArrayList<>(players.values());
		for (DataPlayer dp : values) {
			if (dp.getPlayerType().getTitularPlayer() == 1) {
				if(dp.getPlayerType().getPlayerTypeName() == "Gardien") {
					//System.out.println("Gardien");
					valuesGoalie.add(dp);
				}
				else if(dp.getPlayerType().getPlayerTypeName() == "Défenseur") {
					//System.out.println("Défenseur");
					valuesDefender.add(dp);
				}
				else if(dp.getPlayerType().getPlayerTypeName() == "Attaquant") {
					//System.out.println("Attaquant");
					valuesForward.add(dp);
				}
				else if(dp.getPlayerType().getPlayerTypeName() == "Milieu") {
					//System.out.println("Milieu");
					valuesMidFielder.add(dp);
				}
				else {
					throw new NoSuchElementException("Ce type de joueur n'existe pas, réinstallez le jeu.");
				}
			}
		}
		String str = valuesForward.toString().replace("[", "").replace("]", "");
		System.out.println(str);
	}
	
	public void placePlayers() {
		placePlayersGoalie();
		placePlayersDefender();
		placePlayersMidFielder();
		placePlayersForward();
	}
	
	public void placePlayersDefender() {
		for(DataPlayer dp : valuesDefender) {
			
		}
	}
	
	
	public void placePlayersForward() {
		for(DataPlayer dp : valuesForward) {
			
		}
	}
	
	public void placePlayersGoalie() {
		for(DataPlayer dp : valuesGoalie) {
			
		}
	}
	
	public void placePlayersMidFielder() {
		for(DataPlayer dp : valuesMidFielder) {
			
		}
	}

}
