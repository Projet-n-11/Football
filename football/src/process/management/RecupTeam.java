package process.management;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class RecupTeam {
	
	private ArrayList<String> team;
	
	/**
	 * recupTeam takes a country name and return all the data of the players in an arrayList.
	 * If the country does not exist : the attribute = null
	 * @param teamName
	 * @throws IOException
	 */
	public RecupTeam(String teamName) throws IOException {
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
		}
		this.team = team;
	}
	
	private static String readCountry(String line) {
		String country = "";
		int i = 0;
		do {
			country += line.charAt(i);
			i++;
		} while ( line.charAt(i)!=',' );
		
		return country;
	}

	public int getNumberPlayers() {
		return team.size();
	}	
	
	public String getTeamName() {
		return scrollAndGet(team.get(0),0);
	}

	public String getTeamColor() {
		return scrollAndGet(team.get(0),1);
	}

	public String getTeamPlayerName(int i) {
		return scrollAndGet(team.get(i),2);
	}

	public String getTeamNumberOfOnePlayer(int j) {
		return scrollAndGet(team.get(j),3);
	}
	
	public String getTeamPlayerType(int i) {
		return scrollAndGet(team.get(i),4);
	}	

	public String getTeamSpecialStats(int i) {
		return scrollAndGet(team.get(i),8)+scrollAndGet(team.get(i),9);
	}
	
	/**
	 * scrollAndGet checks the line, skips k datas until it reachs the good one and returns it
	 * first data = 0.
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
