package classes;

import java.util.Random;

public class Match {
	
	private Team home;
	private Team away;
	private byte gHome;
	private byte gAway;
	private byte fixture;
	
	//Initialized as a 0-0
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
	
	public byte getFixture() {
		return fixture;
	}
	
	public void setFixture(byte fixture) {
		this.fixture = fixture;
	}
	
	//Reporting like this for a log
	public String toString() {
		return home + " " + gHome + "-" + gAway + " " + away;
	}
	
	public void simulateHomeAway() {
		Random rd = new Random();
		byte diceHome = (byte) (rd.nextInt(100) + 1);
		byte diceAway = (byte) (rd.nextInt(100) + 1);
		//Test system, might need a change in the future
		
		//Critical failures
		if (diceHome == 1) {
			gAway++;
		}
		if (diceAway == 1) {
			gHome++;
		}
		
		//Critical successes
		if (diceHome == 100) {
			gHome++;
		}
		if (diceAway == 100) {
			gAway++;
		}
		
		//Level difference
		diceAway = (byte) (diceAway / (home.getLvl() / away.getLvl()));
		
		//Bonus, in the case they're needed
		byte bonusHome = (byte) (rd.nextInt(4) + 1);
		byte bonusAway = (byte) (rd.nextInt(4) + 1);
		
		//Home team result
		if (diceHome < 19) {
			gHome += 0;
		}
		else if (diceHome < 44) {
			gHome += 1;
		}
		else if (diceHome < 69) {
			gHome += 2;
		}
		else if (diceHome < 85) {
			gHome += 3;
		}
		else if (diceHome < 93) {
			gHome += 4;
		}
		else if (diceHome < 97) {
			gHome += (byte) (4 + bonusHome);
		}
		else {
			gHome += (byte) (5 + bonusHome);
		}
		
		//Away team result
		if (diceAway < 33) {
			gAway += 0;
		}
		else if (diceAway < 69) {
			gAway += 1;
		}
		else if (diceAway < 88) {
			gAway += 2;
		}
		else if (diceAway < 95) {
			gAway += 3;
		}
		else if (diceAway < 99) {
			gAway += 4;
		}
		else {
			gAway += (byte) (4 + bonusAway);
		}
	}
	
	public void simulateNeutralField() {
		Random rd = new Random();
		byte diceHome = (byte) (rd.nextInt(100) + 1);
		byte diceAway = (byte) (rd.nextInt(100) + 1);
		
		//Critical failures
		if (diceHome == 1) {
			gAway++;
		}
		if (diceAway == 1) {
			gHome++;
		}
		
		//Critical successes
		if (diceHome == 100) {
			gHome++;
		}
		if (diceAway == 100) {
			gAway++;
		}
		
		//Level difference
		diceAway = (byte) (diceAway / (home.getLvl() / away.getLvl()));
		
		//Bonus, in the case they're needed
		byte bonusHome = (byte) (rd.nextInt(4) + 1);
		byte bonusAway = (byte) (rd.nextInt(4) + 1);
		
		//Home team result
		if (diceHome < 27) {
			gHome += 0;
		}
		else if (diceHome < 58) {
			gHome += 1;
		}
		else if (diceHome < 81) {
			gHome += 2;
		}
		else if (diceHome < 92) {
			gHome += 3;
		}
		else if (diceHome < 98) {
			gHome += 4;
		}
		else if (diceHome < 100) {
			gHome += (byte) (4 + bonusHome);
		}
		else {
			gHome += (byte) (5 + bonusHome);
		}
		
		//Away team result
		if (diceAway < 27) {
			gAway += 0;
		}
		else if (diceAway < 58) {
			gAway += 1;
		}
		else if (diceAway < 81) {
			gAway += 2;
		}
		else if (diceAway < 92) {
			gAway += 3;
		}
		else if (diceAway < 98) {
			gAway += 4;
		}
		else if (diceAway < 100) {
			gHome += (byte) (4 + bonusAway);
		}
		else {
			gHome += (byte) (5 + bonusAway);
		}
	}
}
