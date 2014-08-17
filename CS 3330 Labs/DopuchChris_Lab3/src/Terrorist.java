/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/11/13
 */

// import libraries
import java.util.*;

public class Terrorist {
	
	/* UML - Terrorist
	 * --------------------
	 * - codeName:String
	 * - healthPoints:int
	 * - isAlive:boolean
	 * - ammo:Stack<Bullet>
	 * - actorCount:int (static)
	 * - livingTerrorists:int (static)
	 * --------------------
	 * c Terrorist(String)
	 * - setName(String):void
	 * + getName():String
	 * - setHealth(int):void
	 * + getHealth():int
	 * - setAlive(boolean):void
	 * + getAlive():boolean
	 * + getLivingCount():int (static)
	 * + printIntro():void
	 * + printHealth():void
	 * + printActorCount():void (static)
	 * + printLivingCount():void (static)
	 * + shoot(CounterTerrorist):void
	 * + beingShot(CounterTerrorist, int):void
	 * + beingShot(double): void
	 * - reload():void
	 * - reload(int):void
	 * - die():void
	 * --------------------
	 */

	 /*
	  * Attributes
	  */

	private String codeName;
	private int healthPoints;
	/* MISSING */
	private static int actorCount = 0;
	private static int livingTerrorists = 0;

	 /*
	  * Constructor
	  */

	public Terrorist( String codeName ) {
		this.setName(codeName);
		this.setHealth(100);
		/* MISSING */
		Terrorist.actorCount++;
		Terrorist.livingTerrorists++;
	}

	/*
	 * Getters and Setters
	 */

	private void setName(String codeName) {
		this.codeName = codeName;
	}

	public String getName() {
		return this.codeName;
	}

	private void setHealth(int healthPoints) {
		this.healthPoints = healthPoints;
		if( this.healthPoints <= 0 ) {
			this.healthPoints = 0;
			this.die();
			Terrorist.livingTerrorists--;
		}
	}

	public int getHealth() {
		return this.healthPoints;
	}
	
	/*
	 * MISSING
	 * 
	 * 	Getters and Setters
	 * 
	 * MISSING
	 */
	
	public static int getLivingCount() {
		return Terrorist.livingTerrorists;
	}

	/*
	 * Print Methods
	 */
	
	public void printIntroduction() {
		System.out.println("Terrorist "+this.getName()+" has been created.");
	}

	public void printHealth() {
		System.out.println("Terrorist "+this.getName()+" has "+this.getHealth()+" health.");
	}

	public static void printActorCount() {
		System.out.println("There are "+Terrorist.actorCount+" Terrorists in the game.");
	}

	public static void printLivingCount() {
		System.out.println("There are "+Terrorist.livingTerrorists+" Terrorists still alive.");
	}

	/*
	 * Other Methods
	 */
	
	/*
	 * MISSING
	 * 
	 * 	Shoot Method:
	 * 		If out of ammo, reload
	 * 			10% chance of perfect reload
	 * 		Else shoot the enemy
	 * 			See Output
	 * 
	 * 	BeingShot Method:
	 * 		See Output
	 * 
	 * MISSING
	 */
	
	public void beingShot(double distance) {
		if( this.getHealth() < 0 ) {
			return;
		}
		if( distance <= 5 ) {
			System.out.println(this.getName()+": I was shot for 50 points of damage.");
			this.setHealth(this.getHealth() - 50);
		} else {
			System.out.println(this.getName()+": I was shot for 10 points of damage.");
			this.setHealth(this.getHealth() - 10);
		}
	}
	/*
	 * MISSING
	 * 
	 * 	Reload Method:
	 * 		See Output
	 * 
	 * 	Reload Method (Overload):
	 * 		Load the clip with a random number of bullets
	 * 		Make sure the bullets have random damage!
	 * 
	 * MISSING
	 */

	private void die() {
		System.out.println(this.getName()+" has died.");
		/* MISSING */
	}

}
