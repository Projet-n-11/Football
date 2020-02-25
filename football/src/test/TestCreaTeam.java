package test;

import java.io.IOException;

import process.management.CreaTeam;

public class TestCreaTeam {
	public static void main() throws IOException {
		System.out.println("CreaTeam(String teamName) avec teamname = France");
		CreaTeam a = new CreaTeam("France");
		System.out.println(a);
	}
}
