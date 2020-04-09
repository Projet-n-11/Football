package test;

import java.io.IOException;

import java.util.Iterator;

import databall.DataBall;
import dataplayer.DataPlayer;
import datateam.DataTeam;
import gui.elements.DrawField;
import process.management.CreaTeam;
import process.management.Map;
import process.management.Match;

public class TestMatch {

	public static void main(String[] args) throws IOException {
		
		
		DataTeam teamA = CreaTeam.creaTeam("France");
		DataTeam teamB = CreaTeam.creaTeam("Brazil");
		
		//DrawField df = new DrawField(teamA, teamB, );
		//df.run();
		/*
		DataPlayer tmp;
		
		Map map = new Map();
		Iterator<DataPlayer> iteratorUser = teamA.getPlayers().values().iterator();
		Iterator<DataPlayer> iteratorBot = teamB.getPlayers().values().iterator();
		
		while (iteratorUser.hasNext()) {
			tmp = iteratorUser.next();
			map.setElement(tmp);
		}
		
		while (iteratorBot.hasNext()) {
			map.setElement(iteratorBot.next());
		}
		
		// POSITIONS PAR DEFAUTS :	(0,0) => il n'y aura qu'un joueur sur le terrain
		
		
		
		
		Match m = new Match();
		DataBall ball = new DataBall(5,5);
		map.setElement(ball);
		
		map.printAllElementsFromTable();

		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		m.matchOneRound(teamA, teamB, map, ball);
		// stratégies : 424 et 343
		
		map.printAllElementsFromTable();
		*/
	}

}
