/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/17/2013
 */

package umc.csgo.assets;

/* Imports */
import java.util.Random;

public class Bullet {
	
	/* UML
	 * --Class-------------
	 * 
	 *   Bullet
	 * 
	 * --Attributes--------
	 * 
	 * - damage:int (final)
	 * 
	 * --Methods-----------
	 * 
	 * c Bullet(int,int)
	 * + getDamage():int
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * Functions:
	 * 	c Bullet()
	 * 		Takes in a damage and augments it
	 * 		by +/-5
	 */

	/* Attributes - Instanced */
	
	private final int damage;
	
	/* Constructor */
	
	public Bullet(int damage) {
		// Bullet damage should be given damage +/-5
		Random rand = new Random();
		damage = damage + ( rand.nextInt(11) - 5 );
		this.damage = damage;
	}
	
	/* Getters and Setters - Instanced */
	
	public int getDamage() {
		return this.damage;
	}
	
	/* Getters and Setters - Static */
	
	/* Methods - Instanced */
	
	/* Methods - Static */
	
	/* Methods - Abstract */
	
}