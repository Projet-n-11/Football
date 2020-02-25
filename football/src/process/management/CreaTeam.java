package process.management;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import dataplayer.*;
import dataplayer.DataPlayer;
import datateam.DataTeam;

public class CreaTeam {
	
	public CreaTeam(String teamName) throws IOException {
		int i =0;
		
		// r�cup�rer dans teamsLists en 2 arrayList : un String par joueur avec tous ses data
		RecupTeam teamsLists = new RecupTeam(teamName);
		
		// pr�parer un hashmap qui associe chaque nom de joueur � ses donn�es
		HashMap<String, DataPlayer> userPlayers = new HashMap<String, DataPlayer>();
		
		// A RETIRER QUAND CREAPLAYER SERA LA
		DataPlayer dataplayer;
		
			// on parcours avec i : chaque ligne repr�sentant les donn�es des joueurs
			while (i<=teamsLists.getNumberPlayersUser()) {
				
				// cr�er l'objet data player .... (A REMPLACER PAR DATA PLAYER)
				dataplayer = new DataPlayer(teamsLists.getUserTeamPlayerName(i),teamsLists.getUserTeamNumberOfOnePlayer(i),convertToPlayerType(teamsLists.getUserTeamPlayerType(i)),teamsLists.getUserTeamName(),true,2,teamsLists.getUserTeamColor(),0,0);	
	
				// ... pour l'ajouter en tant que valeur dans le hashmap
				userPlayers.put(teamsLists.getUserTeamPlayerName(i),dataplayer );
				i++;
				System.gc();
			}
			
			// ajouter : userPlayers.put(key, value);
		
		DataTeam userTeam = new DataTeam (teamName, teamsLists.getNumberPlayersUser(), userPlayers,
				teamsLists.getColorUserTeam(), 0);
		
		// r�p�ter pour la team du bot
		
		
		public AbstractDataPlayerType convertToPlayerType(String str) {
			switch (str) {
			case "goalie":
				return new PlayerGoalie(new Reflex(), new Dive());
				break;
			}
		}
	
	
	// NOTES;
    // instancier les joueurs et les 2 �quipes, 
    // laisser l�utilisateur choisir sa strat�gie : File fTactics = new File ("tactics.txt");
    // choisir les joueurs parmi la liste propos�e dans l��quipe qu�il a choisie
}
