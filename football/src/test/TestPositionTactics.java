package test;

import java.io.IOException;

import datateam.DataTeam;
import process.management.CreaTeam;
import process.management.PositionTactics;

public class TestPositionTactics {
	public static void main(String[] args) throws IOException {
		DataTeam team = CreaTeam.creaTeam("France");
		PositionTactics pt = new PositionTactics(team);
	}
}
