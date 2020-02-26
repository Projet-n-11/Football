package test;

import java.io.IOException;

import datateam.DataTeam;
import process.management.CreaTeam;
import process.management.RecupTeam;

public class TestCreaTeam {
	public static void main(String[] args) throws IOException {
		System.out.println("CreaTeam(String teamName) avec teamname = France");
		DataTeam a = CreaTeam.creaTeam("France");
		//System.out.println(a);
		
		System.out.println(RecupTeam.getCountriesNames());
	}
}
