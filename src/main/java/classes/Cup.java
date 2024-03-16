package classes;

import java.util.ArrayList;
import java.util.Collections;

public class Cup {
	
	private ArrayList<Team> teams;
	private ArrayList<Match> matches;
	
	public Cup(ArrayList<Team> teams) {
		this.teams = teams;
		this.matches = new ArrayList<Match>();
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public ArrayList<Match> getMatches() {
		return matches;
	}
	
	public void generateRound() {
		int nTeams = teams.size();
		ArrayList<Team> used = new ArrayList<Team>();
		
		//In case the number of teams is odd
		if (nTeams % 2 != 0) {
			teams.add(new Team("Bye", (byte) 0));
			nTeams++;
		}
		
		Collections.shuffle(teams);
		
	}

}
