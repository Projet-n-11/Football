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
		userTeam = CreaTeam.creaTeam("France"); // � remplacer par le processus normal de choix d'�quipe
		
		// choisir l'autre team de mani�re al�atoire
		// en ne prenant pas la m�me �quipe que le joueur;
		String brazil = "Brazil";
		userTeam = CreaTeam.creaTeam(brazil); // � remplacer par le processus de choix al�atoire d'�quipe
	}
	
	
	public void match() { // � changer de nom pour " run() " ? car c'est un processus � lancer
									// v�rifier l'histoire des thread, run simultan� pour ne pas planter le logiciel
		int i = 0;
		while (!goal || !outOfField || !falt) {
			
			// les joueurs font une action,	essayer une alternance entre les joueurs de chaque �quipe
			// on balaye les 11 joueurs de l'�quipe;
			for (i=0; i<11; i++) {
				if (true) {} // si c'est un gardien ;
				//userTeam.getPlayers().getPlayer(i);
				
			}
			
			// v�rifier la situation : ballon sorti ? Joueurs en faute ?
		}
	}
	
}
