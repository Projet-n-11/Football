package process.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import dataplayer.DataPlayer;
import datateam.DataTeam;

public class PositionTactics {

	/*
	 * This class will place each players from a team into the field, by changing his coordinates (x and y) and
	 * placing them into the field following their coordinates.
	 * 
	 * @author Aladdine Ben Romdhane
	 * 
	 */
	
	//Theses 4 ArrayList symbolize each role and will be filled with players following their role
	private ArrayList<DataPlayer> valuesDefender = new ArrayList<>();
	private ArrayList<DataPlayer> valuesForward = new ArrayList<>();
	private ArrayList<DataPlayer> valuesGoalie = new ArrayList<>();
	private ArrayList<DataPlayer> valuesMidFielder = new ArrayList<>();
	
	public PositionTactics(DataTeam team, Map table, Boolean alreadyPlacedLeft){
		determinateTypePlayers(team.getPlayers(), table);
	}

	/*
	 * This method will be the one who will fill the previous Arrays following the player's role and 
	 * by determining if they are titular or not
	 */
	
	public void determinateTypePlayers(HashMap<String, DataPlayer> players, Map table) throws NoSuchElementException{
		ArrayList<DataPlayer> values = new ArrayList<>(players.values());
		for (DataPlayer dp : values) {
			if (dp.getPlayerType().getTitularPlayer() == 1) {
				if(dp.getPlayerType().getPlayerTypeName() == "Goalie") {
					valuesGoalie.add(dp);
				}
				else if(dp.getPlayerType().getPlayerTypeName() == "Defender") {
					valuesDefender.add(dp);
				}
				else if(dp.getPlayerType().getPlayerTypeName() == "Forward") {
					valuesForward.add(dp);
				}
				else if(dp.getPlayerType().getPlayerTypeName() == "Midfielder") {
					valuesMidFielder.add(dp);
				}
				else {
					throw new NoSuchElementException("Ce type de joueur n'existe pas, réinstallez le jeu.");
				}
			}
			
		}
	}
	
	//This method will be the one which will change the player coordinates and placement into the Array
	public void setPosition(int positionX, int positionY, DataPlayer dp, Map table) {
		dp.setPositionX(positionX);
		dp.setPositionY(positionY);
		table.setElement(dp);
	}
	
	//placePlayers will regroup each next method placing every player into the field.
	public void placePlayers(DataTeam dt, Map table, Boolean alreadyPlacedLeft) {
		placePlayersGoalie(table, alreadyPlacedLeft);
		placePlayersDefender(dt, table, alreadyPlacedLeft);
		placePlayersMidFielder(dt, table, alreadyPlacedLeft);
		placePlayersForward(dt, table, alreadyPlacedLeft);
	}
	
	//placePlayersGoalie will place the goalie player into the field
	public void placePlayersGoalie(Map table, Boolean alreadyPlacedLeft) {
		for(DataPlayer dp : valuesGoalie) {
			if(alreadyPlacedLeft == false) {
				setPosition(ConstantTactics.L_GOALKEEPERX, ConstantTactics.L_GOALKEEPERY, dp, table);
			}
			else {
				setPosition(ConstantTactics.R_GOALKEEPERX, ConstantTactics.R_GOALKEEPERY, dp, table);
			}
		}
	}
	
	//placePlayersDefender will place each defender into the field following the team's tactics
	public void placePlayersDefender(DataTeam dt, Map table, Boolean alreadyPlacedLeft) {
		boolean set1 = false;
		boolean set2 = false;
		boolean set3 = false;
		boolean set4 = false;
		if(alreadyPlacedLeft == false) {
			if(dt.getDefaultStrategy(0) == 3 && dt.getDefaultStrategy(1) == 4 && dt.getDefaultStrategy(2) == 3) {
				for(DataPlayer dp : valuesDefender) {
					if(set1 == false) {
						setPosition(ConstantTactics.L_FRONT_DEFENDERX343, ConstantTactics.L_FRONT_DEFENDERY343, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.L_LEFT_DEFENDERX343, ConstantTactics.L_LEFT_DEFENDERY343, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.L_RIGHT_DEFENDERX343, ConstantTactics.L_RIGHT_DEFENDERY343, dp, table);
						set3 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 2 && dt.getDefaultStrategy(1) == 3 && dt.getDefaultStrategy(2) == 5) {
				for(DataPlayer dp : valuesDefender) {
					if(set1 == false) {
						setPosition(ConstantTactics.L_LEFT_DEFENDERX_235, ConstantTactics.L_LEFT_DEFENDERY_235, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.L_RIGHT_DEFENDERX_235, ConstantTactics.L_RIGHT_DEFENDERY_235, dp, table);
						set2 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 4 && dt.getDefaultStrategy(1) == 2 && dt.getDefaultStrategy(2) == 4) {
				for(DataPlayer dp : valuesDefender) {
					if(set1 == false) {
						setPosition(ConstantTactics.L_LEFTCENTERBACKX_424, ConstantTactics.L_LEFTCENTERBACKY_424, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.L_RIGHTCENTERBACKX_424, ConstantTactics.L_RIGHTCENTERBACKY_424, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.L_LEFTFULLBACKX_424, ConstantTactics.L_LEFTFULLBACKY_424, dp, table);
						set3 = true;
					}
					else if(set4 == false) {
						setPosition(ConstantTactics.L_RIGHTFULLBACKX_424, ConstantTactics.L_RIGHTFULLBACKY_424, dp, table);
						set4 = true;
					}
				}
			}
		}
		else {
			if(dt.getDefaultStrategy(0) == 3 && dt.getDefaultStrategy(1) == 4 && dt.getDefaultStrategy(2) == 3) {
				for(DataPlayer dp : valuesDefender) {
					if(set1 == false) {
						setPosition(ConstantTactics.R_FRONT_DEFENDERX343, ConstantTactics.R_FRONT_DEFENDERY343, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.R_LEFT_DEFENDERX343, ConstantTactics.R_LEFT_DEFENDERY343, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.R_RIGHT_DEFENDERX343, ConstantTactics.R_RIGHT_DEFENDERY343, dp, table);
						set3 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 2 && dt.getDefaultStrategy(1) == 3 && dt.getDefaultStrategy(2) == 5) {
				for(DataPlayer dp : valuesDefender) {
					if(set1 == false) {
						setPosition(ConstantTactics.R_LEFT_DEFENDERX_235, ConstantTactics.R_LEFT_DEFENDERY_235, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.R_RIGHT_DEFENDERX_235, ConstantTactics.R_RIGHT_DEFENDERY_235, dp, table);
						set2 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 4 && dt.getDefaultStrategy(1) == 2 && dt.getDefaultStrategy(2) == 4) {
				for(DataPlayer dp : valuesDefender) {
					if(set1 == false) {
						setPosition(ConstantTactics.R_LEFTCENTERBACKX_424, ConstantTactics.R_LEFTCENTERBACKY_424, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.R_RIGHTCENTERBACKX_424, ConstantTactics.R_RIGHTCENTERBACKY_424, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.R_LEFTFULLBACKX_424, ConstantTactics.R_LEFTFULLBACKY_424, dp, table);
						set3 = true;
					}
					else if(set4 == false) {
						setPosition(ConstantTactics.R_RIGHTFULLBACKX_424, ConstantTactics.R_RIGHTFULLBACKY_424, dp, table);
						set4 = true;
					}
				}
			}
		}
	}
	
	//placePlayersMidFielder will place each mid fielder into the field following the team's tactics
	public void placePlayersMidFielder(DataTeam dt, Map table, Boolean alreadyPlacedLeft) {
		boolean set1 = false;
		boolean set2 = false;
		boolean set3 = false;
		boolean set4 = false;
		if(alreadyPlacedLeft == false) {
			if(dt.getDefaultStrategy(0) == 3 && dt.getDefaultStrategy(1) == 4 && dt.getDefaultStrategy(2) == 3) {
				for(DataPlayer dp : valuesMidFielder) {
					if(set1 == false) {
						setPosition(ConstantTactics.L_LEFT_MIDFIELDERX343, ConstantTactics.L_LEFT_MIDFIELDERY343, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.L_MIDLEFT_MIDFIELDERX343, ConstantTactics.L_MIDLEFT_MIDFIELDERY343, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.L_MIDRIGHT_MIDFIELDERX343, ConstantTactics.L_MIDRIGHT_MIDFIELDERY343, dp, table);
						set3 = true;
					}
					else if(set4 == false) {
						setPosition(ConstantTactics.L_RIGHT_MIDFIELDERX343, ConstantTactics.L_RIGHT_MIDFIELDERY343, dp, table);
						set4 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 2 && dt.getDefaultStrategy(1) == 3 && dt.getDefaultStrategy(2) == 5) {
				for(DataPlayer dp : valuesMidFielder) {
					if(set1 == false) {
						setPosition(ConstantTactics.L_MID_HALFBACKX_235, ConstantTactics.L_MID_HALFBACKY_235, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.L_LEFT_HALFBACKX_235, ConstantTactics.L_LEFT_HALFBACKY_235, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.L_RIGHT_HALFBACKX_235, ConstantTactics.L_RIGHT_HALFBACKY_235, dp, table);
						set3 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 4 && dt.getDefaultStrategy(1) == 2 && dt.getDefaultStrategy(2) == 4) {
				for(DataPlayer dp : valuesMidFielder) {
					if(set1 == false) {
						setPosition(ConstantTactics.L_LEFTHALFBACKX_424, ConstantTactics.L_LEFTHALFBACKY_424, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.L_RIGHTHALFBACKX_424, ConstantTactics.L_RIGHTHALFBACKY_424, dp, table);
						set2 = true;
					}
				}
			}
		}
		else {
			if(dt.getDefaultStrategy(0) == 3 && dt.getDefaultStrategy(1) == 4 && dt.getDefaultStrategy(2) == 3) {
				for(DataPlayer dp : valuesMidFielder) {
					if(set1 == false) {
						setPosition(ConstantTactics.R_LEFT_MIDFIELDERX343, ConstantTactics.R_LEFT_MIDFIELDERY343, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.R_MIDLEFT_MIDFIELDERX343, ConstantTactics.R_MIDLEFT_MIDFIELDERY343, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.R_MIDRIGHT_MIDFIELDERX343, ConstantTactics.R_MIDRIGHT_MIDFIELDERY343, dp, table);
						set3 = true;
					}
					else if(set4 == false) {
						setPosition(ConstantTactics.R_RIGHT_MIDFIELDERX343, ConstantTactics.R_RIGHT_MIDFIELDERY343, dp, table);
						set4 = true;
					}
					
				}
			}
			else if(dt.getDefaultStrategy(0) == 2 && dt.getDefaultStrategy(1) == 3 && dt.getDefaultStrategy(2) == 5) {
				for(DataPlayer dp : valuesMidFielder) {
					if(set1 == false) {
						setPosition(ConstantTactics.R_MID_HALFBACKX_235, ConstantTactics.R_MID_HALFBACKY_235, dp, table);
						set1 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.R_LEFT_HALFBACKX_235, ConstantTactics.R_LEFT_HALFBACKY_235, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.R_RIGHT_HALFBACKX_235, ConstantTactics.R_RIGHT_HALFBACKY_235, dp, table);
						set3 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 4 && dt.getDefaultStrategy(1) == 2 && dt.getDefaultStrategy(2) == 4) {
				for(DataPlayer dp : valuesMidFielder) {
					if(set1 == false) {
						setPosition(ConstantTactics.R_LEFTHALFBACKX_424, ConstantTactics.R_LEFTHALFBACKY_424, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.R_RIGHTHALFBACKX_424, ConstantTactics.R_RIGHTHALFBACKY_424, dp, table);
						set2 = true;
					}
				}
			}
		}
	}
	
	//placePlayersForward will place the forward player into the field following the team's tactics
	public void placePlayersForward(DataTeam dt, Map table, Boolean alreadyPlacedLeft) {
		boolean set1 = false;
		boolean set2 = false;
		boolean set3 = false;
		boolean set4 = false;
		if(alreadyPlacedLeft == false) {
			if(dt.getDefaultStrategy(0) == 3 && dt.getDefaultStrategy(1) == 4 && dt.getDefaultStrategy(2) == 3) {
				for(DataPlayer dp : valuesForward) {
					if(set1 == false) {
						setPosition(ConstantTactics.L_RIGHT_FORWARDX343, ConstantTactics.L_RIGHT_FORWARDY343, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.L_LEFT_FORWARDX343, ConstantTactics.L_LEFT_FORWARDY343, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.L_MID_FORWARDX343, ConstantTactics.L_MID_FORWARDY343, dp, table);
						set3 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 2 && dt.getDefaultStrategy(1) == 3 && dt.getDefaultStrategy(2) == 5) {
				for(DataPlayer dp : valuesForward) {
					if(set1 == false) {
						setPosition(ConstantTactics.L_LEFT_FORWARDX_235, ConstantTactics.L_LEFT_FORWARDY_235, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.L_RIGHT_FORWARDX_235, ConstantTactics.L_RIGHT_FORWARDY_235, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.L_MID_FORWARDX_235, ConstantTactics.L_MID_FORWARDY_235, dp, table);
						set3 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 4 && dt.getDefaultStrategy(1) == 2 && dt.getDefaultStrategy(2) == 4) {
				for(DataPlayer dp : valuesForward) {
					if(set1 == false) {
						setPosition(ConstantTactics.L_LEFTWINGERX_424, ConstantTactics.L_LEFTWINGERY_424, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.L_RIGHTWINGERX_424, ConstantTactics.L_RIGHTWINGERY_424, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.L_LEFTFOWARDX_424, ConstantTactics.L_LEFTFOWARDY_424, dp, table);
						set3 = true;
					}
					else if(set4 == false) {
						setPosition(ConstantTactics.L_RIGHTFOWARDX_424, ConstantTactics.L_RIGHTFOWARDY_424, dp, table);
						set4 = true;
					}
				}
			}
		}
		else {
			if(dt.getDefaultStrategy(0) == 3 && dt.getDefaultStrategy(1) == 4 && dt.getDefaultStrategy(2) == 3) {
				for(DataPlayer dp : valuesForward) {
					if(set1 == false) {
						setPosition(ConstantTactics.R_RIGHT_FORWARDX343, ConstantTactics.R_RIGHT_FORWARDY343, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.R_LEFT_FORWARDX343, ConstantTactics.R_LEFT_FORWARDY343, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.R_MID_FORWARDX343, ConstantTactics.R_MID_FORWARDY343, dp, table);
						set3 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 2 && dt.getDefaultStrategy(1) == 3 && dt.getDefaultStrategy(2) == 5) {
				for(DataPlayer dp : valuesForward) {
					if(set1 == false) {
						setPosition(ConstantTactics.R_LEFT_FORWARDX_235, ConstantTactics.R_LEFT_FORWARDY_235, dp, table);
						set1 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.R_RIGHT_FORWARDX_235, ConstantTactics.R_RIGHT_FORWARDY_235, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.R_MID_FORWARDX_235, ConstantTactics.R_MID_FORWARDY_235, dp, table);
						set3 = true;
					}
				}
			}
			else if(dt.getDefaultStrategy(0) == 4 && dt.getDefaultStrategy(1) == 2 && dt.getDefaultStrategy(2) == 4) {
				for(DataPlayer dp : valuesForward) {
					if(set1 == false) {
						setPosition(ConstantTactics.R_LEFTWINGERX_424, ConstantTactics.R_LEFTWINGERY_424, dp, table);
						set1 = true;
					}
					else if(set2 == false) {
						setPosition(ConstantTactics.R_RIGHTWINGERX_424, ConstantTactics.R_RIGHTWINGERY_424, dp, table);
						set2 = true;
					}
					else if(set3 == false) {
						setPosition(ConstantTactics.R_LEFTFOWARDX_424, ConstantTactics.R_LEFTFOWARDY_424, dp, table);
						set3 = true;
					}
					else if(set4 == false) {
						setPosition(ConstantTactics.R_RIGHTFOWARDX_424, ConstantTactics.R_RIGHTFOWARDY_424, dp, table);
						set4 = true;
					}
				}
			}
		}
	}

	
	public String getValuesDefender() {
		return valuesDefender.toString();
	}


	public String getValuesForward() {
		return valuesForward.toString();
	}
	


	public String getValuesGoalie() {
		return valuesGoalie.toString();
	}


	public String getValuesMidFielder() {
		return valuesMidFielder.toString();
	}


}
