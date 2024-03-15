package classes;

import java.util.ArrayList;
import java.util.Collections;

public class League {
	
	private ArrayList<Team> teams;
	private ArrayList<Match> matches;
	
	public League(ArrayList<Team> teams) {
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
	
	public ArrayList<Match> generateCalendar() {
		ArrayList<Match> toReturn = new ArrayList<Match>();
		int nTeams = teams.size();
		
		//In case the number of teams is odd
		if (nTeams % 2 != 0) {
			teams.add(new Team("Bye", (byte) 0));
			nTeams++;
		}
		
		//Shuffle teams randomly, including the bye if needed
		Collections.shuffle(teams);
		
		int fixtures = nTeams - 1;
		int matchesPerFixture = nTeams / 2;
		
		for (int round = 0; round < fixtures; round++) {
			for (int match = 0; match < matchesPerFixture; match++) {
				int homeIndex = (round + match) % (nTeams - 1);
				int awayIndex = (nTeams - 1 - match + round) % (nTeams - 1);
				
				if (match == 0) {
					awayIndex = nTeams - 1;
				}
				
				Team home = teams.get(homeIndex);
				Team away = teams.get(awayIndex);
				
				if (!home.getName().equals("Bye") && !away.getName().equals("Bye")) {
					toReturn.add(new Match(home, away));
				}
			}
		}
		//I think this is actually a single round-robin not double
		//TODO check and fix is needed; should be just duplicate the loop
		return toReturn;
	}

}
