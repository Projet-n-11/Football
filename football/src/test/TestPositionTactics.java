package test;

import java.io.IOException;

import datateam.DataTeam;
import process.management.CreaTeam;
import process.management.PositionTactics;
import process.management.Map;

/*
 * This class is used to test if the Positioning class works
 */
public class TestPositionTactics {
	public static void main(String[] args) throws IOException {
		DataTeam team1 = CreaTeam.creaTeam("France");
		DataTeam team2 = CreaTeam.creaTeam("Brazil");
		Map p = new Map();
		Boolean alreadyPlacedLeft = false;
		PositionTactics pt = new PositionTactics(team1, p, alreadyPlacedLeft);
		alreadyPlacedLeft=true;
		PositionTactics pt2 = new PositionTactics(team2, p, alreadyPlacedLeft);
		p.printAllElementsFromTable();
	}
}
