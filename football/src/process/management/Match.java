package process.management;
import java.io.IOException;
import java.util.ArrayList;

import datateam.DataTeam;
import process.scores.Chronometer;
import process.scores.Score;
import process.management.CreaTeam;

public class Match {
	
	
	public Boolean goal, outOfField, falt;
	public DataTeam userTeam;
	public DataTeam botTeam;
	public final int NB_TEAMS = 2;
	
	public void initiateObjectsForTheMatch(DataTeam userTeam, DataTeam botTeam) throws IOException {
		
		// à remplacer par le processus normal de choix d'équipe
		userTeam = CreaTeam.creaTeam("France");
		
		// on récupère les noms de toutes les équipes
		ArrayList<String> list = RecupTeam.getCountriesNames();
		int rand = 0;
		String otherTeamCurrentlyBrazil = "";
		
		
		/*
		 * while team randomly choosen is user team;
		 * generate random number <= number of teams
		 * then use it to collect the name of the team in the list
		 */
		do {
			rand = (int)Math.random() * ( NB_TEAMS );
			otherTeamCurrentlyBrazil = list.get(rand);
		} while (otherTeamCurrentlyBrazil.compareTo(userTeam.getTeamName())==0);
		
		botTeam = CreaTeam.creaTeam(otherTeamCurrentlyBrazil);
	}
	
	public void match() { // à changer de nom pour " run() " ? car c'est un processus à lancer
									// vérifier l'histoire des thread / runs simultanés, pour ne pas planter le logiciel
		
		
		
		int i = 0;
		while (!goal || !outOfField || !falt) {
			
			// les joueurs font une action,	essayer une alternance entre les joueurs de chaque équipe
			// on balaye les 11 joueurs de l'équipe;
			for (i=0; i<11; i++) {
				
				/**
				 * this loop is about all players that aren't Goalies.
				 */
				/*if (userTeam.getPlayers(i).getPlayerTypeName().compareTo("Gardien")!=0) {
					} // si c'est un gardien ;*/
				//userTeam.getPlayers().getPlayer(i);
				
			}
			
			// vérifier la situation : ballon sorti ? Joueurs en faute ?
		}
	}
	
}
