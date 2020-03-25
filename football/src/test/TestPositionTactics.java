package test;

import java.io.IOException;

import databall.DataBall;
import datateam.DataTeam;
import gui.elements.MatchScreen;
import process.management.ConstantPosition;
import process.management.CreaTeam;
import process.management.PositionTactics;
import process.movement.MovementBall;
import process.management.Map;
import process.management.PositionBall;

/*
 * This class is used to test if the Positioning class works
 */
public class TestPositionTactics {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		DataTeam team1 = CreaTeam.creaTeam("France");
		DataTeam team2 = CreaTeam.creaTeam("Brazil");
		DataBall ball = new DataBall(ConstantPosition.ENGAGEMENTX, ConstantPosition.ENGAGEMENTY);
		MatchScreen match = new MatchScreen(team1, team2, ball);
	}
}
