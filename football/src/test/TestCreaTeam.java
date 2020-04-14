package test;

import java.io.IOException;

import datateam.DataTeam;
import process.management.CreaTeam;
import process.management.RecupTeam;

public class TestCreaTeam {
	public static void main(String[] args) throws IOException {
		System.out.println("Teams available : ");
		System.out.println(RecupTeam.getCountriesNames());
		
		System.out.println("CreaTeam(String teamName) with teamname = France\n");
		DataTeam a = CreaTeam.creaTeam("France");

		System.out.println(a);
	}
} 
