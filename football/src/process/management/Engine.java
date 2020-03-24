package process.management;

import java.util.Scanner;
import process.scores.Chronometer;
import process.scores.Score;
import process.management.Map;

public class Engine 
{
	
	volatile boolean run_flag = true;
	Map maps = new Map();
	
	/**
	 * 0: init
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
			
			if(state == 0) // Init state
			{  
				System.out.println("Initialisation_state");
				boolean tmp_bool = initialisation_function();
				
				if(tmp_bool != true) {
					state = 8;
				}
				state = 1;
						
			}
			else if(state == 1) // menu state
			{
				String command = menu();
				if(command.equals("1")) {
					System.out.println("Launch a new game");
					state = 2;
					
				}else if(command.equals("9")) {
					System.out.println("Good bye !!!");
					state = 9;
					
				}
				
			}
			else if(state == 2) // Game state
			{
				display_maps();
				player_behavior();
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
		// TODO Auto-generated method stub
		
	}

	private void display_maps() {
		System.out.println("GAME iteration");
		System.out.println("-------------------------");
		for(int x = 0; x< ConstantPosition.WIDTH;x++) {
			
			for(int y = 0; y< ConstantPosition.HEIGHT;y++) {
				if(maps.getElement(x,y).getClass().getName().equals("datafield.Grass") ) {
					System.out.print("o");
				}
				if(maps.getElement(x,y).getClass().getName().equals("datafield.Goal") ) {
					System.out.print("-");
				}
			}
			System.out.print("\n");
		}
		System.out.println("-------------------------");
		
	}

	/**
	 * Engine function
	 * @return
	 */
	public boolean initialisation_function() 
	{
		System.out.println("Initialisation accomplie !");
		
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
	
	/**
	 * Non-used !
	 * @return
	 */
	public boolean game() 
	{
		return false;
	}
	
	

	public static void main(String[] args) {
		new Engine();
	}

}
