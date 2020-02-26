package test;

import java.io.IOException;

import process.management.CreaTeam;
import process.management.RecupTeam;

public class TestCreaTeam {
	public static void main(String[] args) throws IOException {
		System.out.println("CreaTeam(String teamName) avec teamname = France");
		//CreaTeam a = new CreaTeam("France");
		//System.out.println(a);
		
		RecupTeam rt = new RecupTeam("France");
	}
}
