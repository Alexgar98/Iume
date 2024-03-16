package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	public void generateCalendar() {
		int nTeams = teams.size();
		
		//In case the number of teams is odd
		if (nTeams % 2 != 0) {
			teams.add(new Team("Bye", (byte) 0));
			nTeams++;
		}
		
		//Shuffle teams randomly, including the bye if needed
		Collections.shuffle(teams);
		
		int fixtures = (nTeams - 1) * 2;
		int matchesPerFixture = nTeams / 2;
		
		for (int round = 0; round < fixtures; round++) {
			for (int match = 0; match < matchesPerFixture; match++) {
				int homeIndex = (round + match) % (nTeams - 1);
				int awayIndex = (nTeams - 1 - match + round) % (nTeams - 1);
				
				if (match == 0) {
					awayIndex = nTeams - 1;
				}
				
				Team home;
				Team away;
				if (round % 2 == 0)
				{
					home = teams.get(homeIndex);
					away = teams.get(awayIndex);
				}
				else
				{
					home = teams.get(awayIndex);
					away = teams.get(homeIndex);
				}
				
				if (!home.getName().equals("Bye") && !away.getName().equals("Bye")) {
					Match newMatch = new Match(home, away);
					newMatch.setFixture((byte) (round + 1));
					matches.add(newMatch);
				}
			}
		}
	}
	
	public void simulateLeague() {
		for (int i = 0; i < matches.size(); i++) {
			matches.get(i).simulateHomeAway();
		}
		Collections.sort(teams, Comparator.comparing(Team::getPoints));
		Collections.reverse(teams);
	}

}
