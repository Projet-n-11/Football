package process.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import databall.DataBall;
import datateam.DataTeam;
import gui.elements.MainFrame;
import process.management.Map;

public class Engine {
	
	private volatile boolean run_flag = true;
	private Map maps = new Map();
	private DataTeam userTeam;
	private DataTeam botTeam;
	private DataBall ball;
	private Match m;
	private Boolean bool;
	private final int TIME_THREAD_SLEEP = 300;
	
	/**
	 * 0: init
	 * 1: menu start
	 * 2: select team
	 * 3: select strategy
	 * 4: match
	 * 5: pause
	 * 8: bug
	 * 9: quit
	 */
	int state = 0 ;
	
	// Tools classes
	/**
	 * Class use to get current entry by keyboard
	 */
	Scanner sc = new Scanner(System.in);

	
	public Engine()
	{
		try {
			main_loop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main execution loop
	 * @throws InterruptedException 
	 */
	public int main_loop() throws InterruptedException
	{
		while(run_flag) 
		{
			
			if(state == 0)  // Init state
			{  
				//MainFrame mf = new MainFrame();
				//Thread.sleep(TIME_THREAD_SLEEP);
				state = 1;
			}
			else if(state == 1) // menu state
			{
			// DISPLAY GRAPHICAL MENU : CHOOSE TEAM / QUIT /... ;
				menu();
				
				String example_choice = "";
				if(example_choice.equals("2")) {
					// go choose a team
					state = 2;
					
				}else if(example_choice.equals("9")) {
					// quit
					state = 9;	
				}
				
			}
			else if(state == 2) // Choose teams, initialise teams/players
			{	
				// initialize both teams
				if (initialisation_function()==false)
				{
					System.out.println("error in state "+state);
					state = 8; // error state
				}
				else
				{
					state = 3; // choose strategy and players
				}				
			}
			
			
			else if (state == 3) // compose team, select strategy
			{
				// select 11 players among all the players available
				// select strategy
				// In Both Case We have titular players and one strategy by Default
				// do not forget a way to go back, to change team -> state = 2
				state = 4;
			}
			
			else if (state == 4) // game state
			{
				display_maps();		// GRAPHICAL DISPLAY
				player_behavior(); // this method calls class Match
				// do not forget timer, which pulls state=4 to 6 (or by choice player)
				// do not forget a pause
			}
			
			
			else if (state == 5) // pause
			{
				String whatDoesPlayerWant = "";
				if (whatDoesPlayerWant.contentEquals("quit")==true)
				{
					state = 9;
				}
				if (whatDoesPlayerWant.contentEquals("re_Start")==true)
				{
					state = 1;
				}
			}
			
			
			else if (state == 6) // end of match
			{
				// display statistics
				
				Boolean example = true;
				if (example)
				{
					state = 2;
				}
			}
			
			
			else if(state == 8) // Error state
			{
				System.out.println("Error detected");
				state = 9;
				
			}else if(state == 9) // Quit state
			{
				System.out.println("Quit");
				run_flag = false;
			}
						
			Thread.sleep(1000);
		}
		return 0;
	}
	
	private void player_behavior() {
		m.matchOneRound(userTeam, botTeam, maps, ball);
	}

	private void display_maps() 
	{
		// the GUI show the actual map
	}

	/**
	 * Engine function
	 * @return
	 */
	public boolean initialisation_function() 
	{
		ArrayList<String> ListOfTeams;
		try 
		{
			ListOfTeams = RecupTeam.getCountriesNames();
			// CHOOSE THE TEAM FROM ListOfTeams -> teamName
			String teamName = "";
			userTeam = CreaTeam.creaTeam(teamName);
			
			int rand;
			String str = "";
			
			do {
				rand = (int)Math.random()*ListOfTeams.size();
				str = ListOfTeams.get(rand);
			} while (teamName.contentEquals(str)==true);
			
			botTeam = CreaTeam.creaTeam(str);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String menu() 
	{
		
		System.out.println("Welcome to football game !");
		System.out.println("****** Menu ******");
		System.out.println("1. launch a game");
		System.out.println("9. quit");

		return sc.nextLine();
	}
	
	

	public static void main(String[] args) {
		new Engine();
	}

}
