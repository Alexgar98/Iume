package classes;

public class Team {
	
	private String name;
	private byte lvl;
	private byte wins;
	private byte draws;
	private byte losses;
	private short gFor;
	private short gAgainst;
	private short points;
	
	public Team (String name, byte lvl) {
		this.name = name;
		this.lvl = lvl;
		this.wins = 0;
		this.draws = 0;
		this.losses = 0;
		this.gFor = 0;
		this.gAgainst = 0;
		this.points = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getLvl() {
		return lvl;
	}

	public void setLvl(byte lvl) {
		this.lvl = lvl;
	}

	public byte getWins() {
		return wins;
	}

	public void setWins(byte wins) {
		this.wins = wins;
	}

	public byte getDraws() {
		return draws;
	}

	public void setDraws(byte draws) {
		this.draws = draws;
	}

	public byte getLosses() {
		return losses;
	}

	public void setLosses(byte losses) {
		this.losses = losses;
	}

	public short getgFor() {
		return gFor;
	}

	public void setgFor(short gFor) {
		this.gFor = gFor;
	}

	public short getgAgainst() {
		return gAgainst;
	}

	public void setgAgainst(short gAgainst) {
		this.gAgainst = gAgainst;
	}

	public short getPoints() {
		return points;
	}

	public void setPoints(short points) {
		this.points = points;
	}
	
	public String toString() {
		return name;
	}
}
