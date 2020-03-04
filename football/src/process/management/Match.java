package process.management;
import java.io.IOException;

import datateam.DataTeam;
import process.scores.Chronometer;
import process.scores.Score;
import process.management.CreaTeam;

public class Match {
	
	
	public Boolean goal, outOfField, falt;
	public DataTeam userTeam;
	public DataTeam botTeam;
	
	public void initiateObjectsForTheMatch(DataTeam userTeam, DataTeam botTeam) throws IOException {
		userTeam = CreaTeam.creaTeam("France"); // à remplacer par le processus normal de choix d'équipe
		
		// choisir l'autre team de manière aléatoire
		// en ne prenant pas la même équipe que le joueur;
		String brazil = "Brazil";
		userTeam = CreaTeam.creaTeam(brazil); // à remplacer par le processus de choix aléatoire d'équipe
	}
	
	
	public void match() { // à changer de nom pour " run() " ? car c'est un processus à lancer
									// vérifier l'histoire des thread, run simultané pour ne pas planter le logiciel
		int i = 0;
		while (!goal || !outOfField || !falt) {
			
			// les joueurs font une action,	essayer une alternance entre les joueurs de chaque équipe
			// on balaye les 11 joueurs de l'équipe;
			for (i=0; i<11; i++) {
				if (true) {} // si c'est un gardien ;
				//userTeam.getPlayers().getPlayer(i);
				
			}
			
			// vérifier la situation : ballon sorti ? Joueurs en faute ?
		}
	}
	
}
