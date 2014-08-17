/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/20/13
 * 
 * Player.java
 * 	Description:
 * 	This is the class where name, team, state, and id are all kept and processed.
 */

// Declare the package the file exists in
package umc.csgo.actor;


//Import any classes needed from outside this package
/*
 * 1. You need the actor and enum packages.
 * How do you access these?
 * Import the enums, you already are in the actors package
 */
/*
 * TODO
 * 1 - MISSING CODE
 * */

import umc.csgo.enums.*;

public abstract class Player {
	
	private final int pid;
	private String name;
	private State state;
	private Team team;
	private static int playerCount = 0;
	/*
	 * 1. Why is pid final?
	 * because the player id shouldn't change after it's been initialized
	 * 2. What does final do in this case?
	 * it means the variable can only be initialized once
	 * 3. Why is playerCount static?
	 * because it belongs to the player class
	 * 4. What does static do in this case?
	 * it means there's only one playercount no matter how many player objects are created
	 * 5. What is the difference between final
	 * and static?
	 * final means it can only be initialized once, static means it can only be declared once
	 */
	/*
	 * TODO
	 * 1 - ANSWER
	 * 2 - ANSWER
	 * 3 - ANSWER
	 * 4 - ANSWER
	 * 5 - ANSWER
	 */
	
	public Player(int pid, String name) {
		this.pid = pid;
		this.setName(name);
		Player.incPlayerCount();
		this.state = State.CONNECTING;
	}
	
	public int getPID() { return this.pid; }
	
	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	
	public void setState(State state) { this.state = state; }
	public State getState() { return this.state; }
	
	public void setTeam(Team team) { this.team = team; }
	public void setTeam(int team) {
		switch(team) {
		case 1:
			setTeam(Team.CT);
			break;
		case 2:
			setTeam(Team.T);
			break;
		case 3:
		default:
			setTeam(Team.O);
		}
	}
	public Team getTeam() { return this.team; }
	
	public abstract void setSkin(int skin);
	public String getSkinName() { return ""; }
	/*
	 * 1. Looking at CSGO, why is setSkin abstract?
	 * So the Terrorist and CounterTerrorist classes can call it in their own ways
	 * 2. What would happen if getSkinName was abstract?
	 * probably nothing would happen, because you're not going to call getSkinName on a player, you'll call it on a subclass
	 * 3. Given the following code, which function would
	 * be called, Player's getSkinName or Terrorist's?
	 * 		Player p = new Terrorist(1,"John");
	 * 		print(p.getSkinName());
	 * the Terrorist's
	 * 4. What is the concept in question 3 called?
	 * polymorphism
	 */
	/*
	 * TODO
	 * 1 - ANSWER
	 * 2 - ANSWER
	 * 3 - ANSWER
	 * 4 - ANSWER
	 */
	
	private static void incPlayerCount() { setPlayerCount(Player.playerCount + 1); }
	private static void decPlayerCount() { setPlayerCount(Player.playerCount - 1); }
	private static void setPlayerCount(int playerCount) {
		if(playerCount >= 0) {
			Player.playerCount = playerCount;
		}
	}
	public static int getPlayerCount() { return Player.playerCount; }
	
	private boolean join() {
		this.state = State.CONNECTED;
		boolean success = true;
		System.out.println("Player "+this.name+" has connected.");
		return success;
	}
	private boolean join(String msg) {
		boolean success = this.join();
		System.out.println(this.name+": "+msg);
		return success;
	}
	public boolean join(int team, int skin) {
		this.setTeam(team);
		this.setSkin(skin);
		boolean success = this.join();
		if(success) {
			System.out.println("Player "+this.name+" successfully joined the "+this.team+" team.");
		} else {
			System.out.println("Player "+this.name+" failed to join the "+this.team+" team.");
		}
		return success;
	}
	public boolean join(int team, int skin, String msg) {
		this.setTeam(team);
		this.setSkin(skin);
		boolean success = this.join(msg);
		if(success) {
			System.out.println("Player "+this.name+" successfully joined the "+this.team+" team.");
		} else {
			System.out.println("Player "+this.name+" failed to join the "+this.team+" team.");
		}
		return success;
	}

}
