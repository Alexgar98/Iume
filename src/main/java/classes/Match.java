package classes;

import java.util.Random;

public class Match {
	
	private Team home;
	private Team away;
	private byte gHome;
	private byte gAway;
	
	public Match (Team home, Team away) {
		this.home = home;
		this.away = away;
		this.gHome = 0;
		this.gAway = 0;
	}

	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getAway() {
		return away;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	public byte getgHome() {
		return gHome;
	}

	public void setgHome(byte gHome) {
		this.gHome = gHome;
	}

	public byte getgAway() {
		return gAway;
	}

	public void setgAway(byte gAway) {
		this.gAway = gAway;
	}
	
	public String toString() {
		return home + " " + gHome + "-" + gAway + " " + away;
	}
	
	public void simulateHomeAway() {
		Random rd = new Random();
		byte diceHome = (byte) (rd.nextInt(100) + 1);
		byte diceAway = (byte) (rd.nextInt(100) + 1);
		//Sistema de prueba, habrá que retocarlo supongo
		//ª
		diceAway = (byte) (diceAway / (home.getLvl() / away.getLvl()));
	}
	
	public void simulateNeutralField() {
		//Campo neutral
	}
}
