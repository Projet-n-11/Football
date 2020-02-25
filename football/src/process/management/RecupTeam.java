package process.management;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dataplayer.AbstractDataPlayerType;
import dataplayer.DataPlayer;
import dataplayer.DataSuperPowers;


public class RecupTeam {
	
	private ArrayList<String> userTeam;
	private ArrayList<String> botTeam;
	
	/**
	 * RecupTeam prend en param�tre un nom de pays, le trouve dans teams.txt et en extrait les donn�es associ�es.
	 * Ces donn�es sont consign�es dans son attribut userTeam. Il r�p�te l'op�ration dans botTeam en prenant une autre �quipe au hasard.
	 * Si le nom de pays pass� en param�tre n'existe pas dans le document : les attributs pointent vers null
	 * @param teamName
	 * @throws IOException
	 */
	public RecupTeam (String teamName) throws IOException {	 
		
		userTeam = this.userTeam(teamName);

		if (userTeam!=null) { 		// si on a bien trouv� la userTeam, on peut continuer

		    // choisir random une �quipe pour l�ordi :
			int nbTeams = 2;																		// on compte � partir de 1, ici on n'atteind pas 3 mais c'est corrig� apr�s
			int rand = (int) (1 + Math.random() * nbTeams);
			
			
			botTeam = this.randTeam(rand);

			while ( botTeam.size()==0 || (readCountry(botTeam.get(0)).compareTo(teamName) == 0)) {		// si �quipeBot = �quipeUser : on recommence
				rand = (int) (1 + Math.random() * nbTeams);
				botTeam = this.randTeam(rand);
			}
			
		
		    // instancier les joueurs et les 2 �quipes, 
		    // laisser l�utilisateur choisir sa strat�gie,
			// File fTactics = new File ("tactics.txt");
		    // et choisir les joueurs parmi la liste propos�e dans l��quipe qu�il a choisie
	
			}
		}
	
	private ArrayList<String> userTeam(String teamName) throws IOException {
		File fTeams = new File("teams.csv");
		BufferedReader br = new BufferedReader (new FileReader(fTeams));
		String line = "";
		ArrayList<String> team = new ArrayList<String>();
		int found=0;
		
		while ( ((line = br.readLine()) != null) && found==0) {	// lecture doc
			if (found!=0) break;
			// si line r�v�le une �quipe qui correspond au choix du joueur:
			
			if (readCountry(line).compareTo(teamName)==0) {									
				found=1;
				do {
					team.add(line);
					line = br.readLine();
				} while ((line!=null) && (teamName.compareTo(readCountry(line))==0));
			}
		}
		br.close();
		if (team.size()==0) {
			System.err.println("ERREUR RecupTeam equipe demandee inexistante\nteamName : "+teamName);
			return null;
		}
		return team;
	}
		
	private ArrayList<String> randTeam(int r) throws IOException {
		ArrayList<String> botTeam = new ArrayList<String>();
		String country = "", tmp = "", line = "";

		File fTeams = new File("teams.csv");
		BufferedReader br = new BufferedReader (new FileReader(fTeams));
		line = br.readLine();

		// scroller doc jusqu'avoir l'�quipe demand�e (selon rang r)
		do {
			r--;
			
			if (r==0) {												// si on est au bon rang : prendre l'�quipe;
				// country m�morise le nom du pays de la premi�re ligne
				country = readCountry(line);
				
				//enregistrer chaque ligne jusqu'� avoir chang� de pays
				do {
					botTeam.add(line);
					line = br.readLine();
					if (line == null) break; // si fin de doc atteinte ; quitter (sinon bug)
					tmp = readCountry(line);					
				} while((country.compareTo(tmp)==0));
				
			}
			else {			
				// country m�morise le nom du pays de la ligne actuelle
				country = readCountry(line);
				tmp = readCountry(line);
				// scroller jusqu'� avoir pays diff�rent
				while ((tmp.compareTo(country)==0) && (line!=null)) {
					line = br.readLine();
					tmp = readCountry(line);
				}
					
			}
		} while ( (r!=0) && (line!=null));
		
		br.close();
		return botTeam;
	}
	
	private String readCountry(String line) {
		String country = "";
		int i = 0;
		do {
			country += line.charAt(i);
			i++;
		} while ( line.charAt(i)!=',' );
		
		return country;
	}

	public ArrayList<String> getUserTeamList() {
		return userTeam;
	}
	public ArrayList<String> getBotTeamList() {
		return botTeam;
	}
	
	public int getNumberPlayersUser() {
		return userTeam.size();
	}	
	public int getNumberPlayersBot() {
		return botTeam.size();
	}
	
	public String getUserTeamName() {
		return scrollAndGet(userTeam.get(0),0);
	}
	public String getBotTeamName() {
		return scrollAndGet(botTeam.get(0),0);
	}

	public String getUserTeamColor() {
		return scrollAndGet(userTeam.get(0),1);
	}	
	public String getBotTeamColor() {
		return scrollAndGet(botTeam.get(0),1);
	}

	public String getUserTeamPlayerName(int i) {
		return scrollAndGet(userTeam.get(i),2);
	}	
	public String getBotTeamPlayerName(int i) {
		return scrollAndGet(botTeam.get(i),2);
	}

	public String getUserTeamNumberOfOnePlayer(int j) {
		return scrollAndGet(userTeam.get(j),3);
	}
	public String getBotTeamNumberOfOnePlayer(int j) {
		return scrollAndGet(botTeam.get(j),3);
	}
	
	public String getUserTeamPlayerType(int i) {
		return scrollAndGet(userTeam.get(i),4);
	}	
	public String getBotTeamPlayerType(int i) {
		return scrollAndGet(botTeam.get(i),4);
	}

	public String getUserTeamSpecialStats(int i) {
		return scrollAndGet(userTeam.get(i),8)+scrollAndGet(userTeam.get(i),9);
	}
	public String getBotTeamSpecialStats(int i) {
		return scrollAndGet(botTeam.get(i),8)+scrollAndGet(botTeam.get(i),9);
	}
	
	/**
	 * scrollAndGet parcours la ligne donn�e, et saute k donn�es jusqu'� atteinre la bonne
	 * et la renvoie (la premi�re donn�e = 0). On lui passe donc en param�tre les lignes contenues
	 * dans les ArrayString userTeam et botTeam
	 * @param str
	 * @param k
	 * @return String
	 */
	private String scrollAndGet(String str, int k) {
		String tmp ="";
		int i = 0;
		while (k!=0) {
		while (str.charAt(i)!=',') {i++;}
		i=i+2;
		k--;
		}
		while (str.charAt(i)!=',') {
			tmp += str.charAt(i);
		}
		return tmp;
	}

}
