package test;

import java.io.IOException;
import java.util.Scanner;

import datateam.DataTeam;
import process.management.CreaTeam;
import process.management.RecupTeam;

public class CLIgame {

	public static void main(String[] args) throws InterruptedException, IOException {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Boolean badchoice = false;
		String choice = "";
		while(badchoice == false) {
			System.out.println("―――――――――――――――");
			System.out.println("Football Simulator V0.5" + "\t \t \t");
			System.out.println("1 : Kick-off");
			System.out.println("2 : Available teams");
			System.out.println("3 : Credits");
			System.out.println("What will be your choice ?") ;
			System.out.println("―――――――――――――――");
			choice = scan.nextLine();
			System.out.println("You've chosen : " + choice);
			Thread.sleep(700);
			switch(choice) {
			case "1" : badchoice = true;
			break;
			case "2": badchoice = true;
			break;
			case "3": badchoice = true;
			break;
			default: System.out.println("Bad option !");
			break;
			}
		}
		
		if(choice.equals("1")) {
			System.out.println("Please choose a team.");
			System.out.println("YOU vs IA");
			System.out.println("Teams available : \n" + RecupTeam.printNameTeams());
			choice = scan.nextLine();
			System.out.println("Your choice is : " + choice);
			DataTeam team1 = CreaTeam.creaTeam(choice);
			System.out.println(team1.toString());
		}
		else if (choice.equals("2")) {
			System.out.println("The available teams are :");
			System.out.println(RecupTeam.printNameTeams());
		}
		else if(choice.contentEquals("3")) {
			System.out.println("Made by Aladdine Ben Romdhane - Quitterie Pilon - Laura Fustinoni");
			System.out.println("For the University of Cergy-Pontoise / CY-Tech campus");
		}
	}
}
