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
	
	public PositionTactics(DataTeam team, Positionning table) throws IOException {
		//whatIsPType(team.getPlayers());
		determinateTypePlayers(team.getPlayers(), team.getDefaultStrategy(), table);
		placePlayers(team, table);
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

	public void determinateTypePlayers(HashMap<String, DataPlayer> players, int teamStrategy, Positionning table) throws NoSuchElementException{
		ArrayList<DataPlayer> values = new ArrayList<>(players.values());
		for (DataPlayer dp : values) {
			if (dp.getPlayerType().getTitularPlayer() == 1) {
				if(dp.getPlayerType().getPlayerTypeName() == "Gardien") {
					valuesGoalie.add(dp);
				}
				else if(dp.getPlayerType().getPlayerTypeName() == "Défenseur") {
					valuesDefender.add(dp);
				}
				else if(dp.getPlayerType().getPlayerTypeName() == "Attaquant") {
					valuesForward.add(dp);
				}
				else if(dp.getPlayerType().getPlayerTypeName() == "Milieu") {
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
	
	public void placePlayers(DataTeam dt, Positionning table) {
		placePlayersGoalie(dt, table);
		placePlayersDefender(dt, table);
		placePlayersMidFielder(dt, table);
		placePlayersForward(dt, table);
	}
	
	public void setPosition(int positionX, int positionY, DataPlayer dp, Positionning table) {
		dp.setPositionX(positionX);
		dp.setPositionY(positionY);
		table.setElement(dp);
	}
	
	public void placePlayersDefender(DataTeam dt, Positionning table) {
		boolean set1 = false;
		boolean set2 = false;
		boolean set3 = false;
		if(dt.getDefaultStrategy(0) == 3 || dt.getDefaultStrategy(1) == 4 || dt.getDefaultStrategy(2) == 3) {
			for(DataPlayer dp : valuesDefender) {
				if(set1 == false) {
					setPosition(ConstantTactics.L_FRONT_DEFENDERX343, ConstantTactics.L_FRONT_DEFENDERY343, dp, table);
					set1 = true;
				}
				else if(set2 == false) {
					setPosition(ConstantTactics.L_LEFT_DEFENDERX343, ConstantTactics.L_LEFT_DEFENDERX343, dp, table);
					set2 = true;
				}
				else if(set3 == false) {
					setPosition(ConstantTactics.L_RIGHT_DEFENDERX343, ConstantTactics.L_RIGHT_DEFENDERY343, dp, table);
				}
			}
		}
		else if(dt.getDefaultStrategy() == 235) {
			for(DataPlayer dp : valuesDefender) {
				
			}
		}
		else if(dt.getDefaultStrategy() == 424) {
			for(DataPlayer dp : valuesDefender) {
				
			}
		}
	}
	
	
	public void placePlayersForward(DataTeam dt, Positionning table) {
		for(DataPlayer dp : valuesForward) {
			
		}
	}
	
	public void placePlayersGoalie(DataTeam dt, Positionning table) {
		for(DataPlayer dp : valuesGoalie) {
			
		}
	}
	
	public void placePlayersMidFielder(DataTeam dt, Positionning table) {
		for(DataPlayer dp : valuesMidFielder) {
			
		}
	}

}
