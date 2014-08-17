/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: 
 * Date: 2/4/2013
 */

// import libraries
import java.util.start


public class CounterTerrorist {
	
	/* UML - Counter Terrorist
	 * --------------------
	 * - codeName: String
	 * - healthPoints: int
	 * - actorCount: int (static)
	 + - livingCounterTerrorists: int (static)
	 * --------------------
	 * c CounterTerrorist(String)
	 * + printActorCount():void (static)
	 * + printLivingCount():void (static)
	 * - setName(String):void
	 * - getName():String
	 * + printName():void
	 * + printIntro():void
	 * - setHealth(int):void
	 * + getHealth():int
	 * + printHealth():void
	 * + beingShot(double):void
	 * - die():void
	 * --------------------
	 */

	 /*
	  * Attributes
		*/

	private String /*MISSING*/;
	private /*MISSING*/;
	private static /*MISSING*/ actorCount = 0;
	/*MISSING*/;

	 /*
	  * Constructor
		*/

	public CounterTerrorist( String name ) {
		// Set name and health
		this.setName(name);
		this./*MISSING*/(100);
		// Update static attributes
		CounterTerrorist./*MISSING*/++;
		/*MISSING*/
	}

	/*
	 * Getters and Setters
	 */

	private void setName(/*MISSING*/ name) {
		/*MISSING*/
	}

	private String getName() {
		/*MISSING*/
	}

	private void setHealth(int healthPoints) {
		this.healthPoints = healthPoints;
		if( this.healthPoints <= 0 ) {
			this.healthPoints = 0;
			this.die();
			CounterTerrorist.livingCounterTerrorists--;
		}
	}

	public int getHealth() {
		/*MISSING*/
	}

	/*
	 * Print Methods
	 */
	
	public void printName() {
		System.out.println("I am a Counter Terrorist named "+/*MISSING*/+".");
	}
	
	public void printIntroduction() {
		// Remember to match the output from the lab on Moodle
		/*MISSING*/
	}

	public void printHealth() {
		System.out.println("Counter Terrorist "+this.getName()+" has "+this.getHealth()+" health.");
	}

	public static void printActorCount() {
		System.out.println("There are "+CounterTerrorist./*MISSING*/+" Counter Terrorists in the game.");
	}

	public static void printLivingCount() {
		/*MISSING*/
	}

	/*
	 * Other Methods
	 */
	
	public void beingShot(double distance) {
		if( this.getHealth() < 0 ) {
			return;
		}
		if( distance <= 5 ) {
			System.out.println(/*MISSING*/+": I was shot for 50 points of damage.");
			this.setHealth(this.getHealth() - 50);
		} else {
			/*MISSING*/(this.getName()+": I was shot for 10 points of damage.");
			this.setHealth(/*MISSING*/ - 10);
		}
	}

	private void die() {
		System.out.println(this.getName()+" has died.");
	}

}
