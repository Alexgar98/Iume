package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import classes.League;
import classes.Team;

public class Main {
	public static void main(String args[])
	{
		ArrayList<Team> teams = new ArrayList<Team>();
		teams.add(new Team("Team A", (byte) 10));
		teams.add(new Team("Team B", (byte) 10));
		teams.add(new Team("Team C", (byte) 10));
		teams.add(new Team("Team D", (byte) 10));
		teams.add(new Team("Team E", (byte) 10));
		teams.add(new Team("Team F", (byte) 10));
		teams.add(new Team("Team G", (byte) 10));
		teams.add(new Team("Team H", (byte) 10));
		League testLeague = new League(teams);
		testLeague.generateCalendar();
		testLeague.simulateLeague();
		try {
			File exportTable = new File("League.csv");
			if (exportTable.createNewFile()) {
				FileWriter fw = new FileWriter(exportTable);
				fw.write("Name,Wins,Draws,Losses,Goals for,Goals against,Points\n");
				for (byte i = 0; i < teams.size(); i++) {
					Team current = teams.get(i);
					fw.write(current.getName() + "," + current.getWins() + "," + current.getDraws() + "," + current.getLosses() +
							"," + current.getgFor() + "," + current.getgAgainst() + "," + current.getPoints() + "\n");
				}
				fw.close();
				System.out.println("File successfully created at " + exportTable.getAbsolutePath());
			}
			else {
				System.out.println("The csv file already exists and I'm not overwriting it.");
			}
			
			File exportResults = new File("Result_log.txt");
			if (exportResults.createNewFile()) {
				FileWriter fw = new FileWriter(exportResults);
				for (byte i = 0; i < testLeague.getMatches().size(); i++) {
					fw.write(testLeague.getMatches().get(i) + "\n");
				}
				fw.close();
				System.out.println("File successfully created at " + exportResults.getAbsolutePath());
			}
			else {
				System.out.println("The log file already exists and I'm not overwriting it.");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
