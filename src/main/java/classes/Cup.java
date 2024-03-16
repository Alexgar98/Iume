package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
		Random rd = new Random();
		Team bye = new Team("Bye", (byte) 0);
		
		//In case the number of teams is odd
		if (nTeams % 2 != 0) {
			teams.add(bye);
			nTeams++;
		}
		
		Collections.shuffle(teams);
		
		for (int i = 0; i < nTeams/2; i++) {
			Team home;
			Team away;
			
			do {
				home = teams.get(rd.nextInt(nTeams));
			} while (used.contains(home));
			used.add(home);
			
			do {
				away = teams.get(rd.nextInt(nTeams));
			} while (used.contains(away));
			used.add(away);
			
			if (!home.equals(bye) && !away.equals(bye)) {
				matches.add(new Match(home, away));
			}
		}
		teams.remove(bye);
	}
	
	//Penalty shootout. Works with at least a 5d4 for each team; 1 fails the penalty, other numbers score
	public Team simulatePenalties(Match drawn) {
		Random rd = new Random();
		byte pHome = 0;
		byte pAway = 0;
		byte dice;
		
		//5 first shoots
		for (byte i = 0; i < 5; i++) {
			dice = (byte) (rd.nextInt(4) + 1);
			if (dice != 1) {
				pHome++;
			}
			dice = (byte) (rd.nextInt(4) + 1);
			if (dice != 1) {
				pAway++;
			}
		}
		
		//Sudden death
		while (pHome == pAway) {
			dice = (byte) (rd.nextInt(4) + 1);
			if (dice != 1) {
				pHome++;
			}
			dice = (byte) (rd.nextInt(4) + 1);
			if (dice != 1) {
				pAway++;
			}
		}
		
		Team loser;
		if (pHome > pAway) {
			loser = drawn.getAway();
		}
		else {
			loser = drawn.getHome();
		}
		return loser;
	}
	
	public void simulateRound() {
		for (int i = 0; i < matches.size(); i++) {
			Match current = matches.get(i);
			if (teams.contains(current.getHome()) && teams.contains(current.getAway())) { //Not simulating an already done match
				current.simulateNeutralField();
				if (current.getgHome() > current.getgAway()) {
					teams.remove(current.getAway());
				}
				else if (current.getgAway() > current.getgHome()) {
					teams.remove(current.getHome());
				}
				else {
					teams.remove(simulatePenalties(current));
				}
			}
		}
	}

}
