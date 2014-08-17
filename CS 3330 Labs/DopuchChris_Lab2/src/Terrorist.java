/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: 
 * Date: 2/4/2013
 */

// import libraries


public class Terrorist {
	
	/* UML - Terrorist
	 * --------------------
	 * - codeName: String
	 * - healthPoints: int
	 * - actorCount: int (static)
	 * - livingTerrorists:int (static)
	 * --------------------
	 * c Terrorist(String)
	 * + printCount():void (static)
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

	/*MISSING*/

	 /*
	  * Constructor
		*/

	public Terrorist( /*MISSING*/ ) {
		/*MISSING*/
	}

	/*
	 * Getters and Setters
	 */

	/*MISSING*/

	/*MISSING*/

	private void setHealth(int healthPoints) {
		this.healthPoints = healthPoints;
		if( this.healthPoints <= 0 ) {
			this.healthPoints = 0;
			this.die();
			Terrorist.livingTerrorists--;
		}
	}

	/*MISSING*/

	/*
	 * Print Methods
	 */
	
	public void printName() {
		/*MISSING*/
	}
	
	public void printIntroduction() {
		/*MISSING*/
	}

	public void printHealth() {
		/*MISSING*/
	}

	public static void printActorCount() {
		/*MISSING*/("There are "+Terrorist.actorCount+" Terrorists in the game.");
	}

	public static void printLivingCount() {
		/*MISSING*/("There are "+/*MISSING*/+" Terrorists still alive.");
	}

	/*
	 * Other Methods
	 */
	
	public void beingShot(/*MISSING*/) {
		if( /*MISSING*/ < 0 ) {
			return;
		}
		if( distance <= 5 ) {
			/*MISSING*/
			/*MISSING*/
		} else {
			/*MISSING*/
			/*MISSING*/
		}
	}

	private void die() {
		/*MISSING*/(/*MISSING*/+" has died.");
	}

}
