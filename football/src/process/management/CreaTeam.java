package process.management;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CreaTeam {
	
	private ArrayList<String> team;
	private ArrayList<String> botTeam;
	
	public CreaTeam (String teamName) throws IOException {	
		
		team = this.recupTeam(teamName);

		if (team.size()!=0) { 		// si on a bien trouvé la team, on peut continuer

		    // choisir random une équipe pour l’ordi :
			int nbTeams = 2;																		// on compte à partir de 1, ici on n'atteind pas 3 mais c'est corrigé après
			int rand = (int) (1 + Math.random() * nbTeams);
			
			
			botTeam = this.randTeam(rand);

			while ( botTeam.size()==0 || (readCountry(botTeam.get(0)).compareTo(teamName) == 0)) {		// si équipeBot = équipeUser : on recommence
				rand = (int) (1 + Math.random() * nbTeams);
				botTeam = this.randTeam(rand);
			}
			
		
		    // instancier les joueurs et les 2 équipes, 
		    // laisser l’utilisateur choisir sa stratégie,
			// File fTactics = new File ("tactics.txt");
		    // et choisir les joueurs parmi la liste proposée dans l’équipe qu’il a choisie
	
			}
		}
	
	public ArrayList<String> recupTeam(String teamName) throws IOException {
		File fTeams = new File("equipes.csv");
		BufferedReader br = new BufferedReader (new FileReader(fTeams));
		String line = "";
		ArrayList<String> team = new ArrayList<String>();
		int found=0;
		
		while ( ((line = br.readLine()) != null) && found==0) {	// lecture doc
			
			if (found!=0) break;
			// si line révèle une équipe qui correspond au choix du joueur:
			
			if (readCountry(line).compareTo(teamName)==0) {									
				found=1;
				do {
					team.add(line);
					line = br.readLine();
				} while ((line==null) && (teamName.compareTo(readCountry(line))==0));
			}
		}
		br.close();
		if (team.size()==0) {
			System.err.println("ERREUR CreaTeams equipe demandee inexistante\nteamName : "+teamName);
		}
		return team;
	}
		
	public ArrayList<String> randTeam(int r) throws IOException {
		ArrayList<String> botTeam = new ArrayList<String>();
		String country = "", tmp = "", line = "";

		File fTeams = new File("equipes.csv");
		BufferedReader br = new BufferedReader (new FileReader(fTeams));
		line = br.readLine();

		// scroller doc jusqu'avoir l'équipe demandée (selon rang r)
		do {
			r--;
			
			if (r==0) {												// si on est au bon rang : prendre l'équipe;
				// country mémorise le nom du pays de la première ligne
				country = readCountry(line);
				
				//enregistrer chaque ligne jusqu'à avoir changé de pays
				do {
					botTeam.add(line);
					line = br.readLine();
					if (line == null) break; // si fin de doc atteinte ; quitter (sinon bug)
					tmp = readCountry(line);					
				} while((country.compareTo(tmp)==0));
				
			}
			else {			
				// country mémorise le nom du pays de la ligne actuelle
				country = readCountry(line);
				tmp = readCountry(line);
				// scroller jusqu'à avoir pays différent
				while ((tmp.compareTo(country)==0) && (line!=null)) {
					line = br.readLine();
					tmp = readCountry(line);
				}
					
			}
		} while ( (r!=0) && (line!=null));
		
		br.close();
		return botTeam;
	}
	
	public String readCountry(String line) {
		String country = "";
		int i = 0;
		do {
			country += line.charAt(i);
			i++;
		} while ( line.charAt(i)!=',' );
		
		return country;
	}

	public ArrayList<String> getTeam() {
		return team;
	}

	public void setTeam (ArrayList<String> team) {
		this.team = team;
	}

	public ArrayList<String> getBotTeam() {
		return botTeam;
	}

	public void setBotTeam(ArrayList<String> botTeam) {
		this.botTeam = botTeam;
	}
}
