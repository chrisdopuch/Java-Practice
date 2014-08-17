/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/19/2013
 */

// import libraries
import java.util.Random;

public class Bullet {
	
	/* UML - Bullet
	 * --------------------
	 * - damage:int
	 * --------------------
	 * c Bullet(Weapon)
	 * - setDamage(int):void
	 * + getDamage():int
	 * --------------------
	 */
	
	/*
	 * Attributes
	 */
	
	private int damage;
	
	/*
	 * Constructor
	 */
	
	public Bullet(Weapon weapon) {
		// Bullet damage should be the base weapon damage +/-5
		Random rand = new Random();
		int damage = weapon.getDamage() + ( rand.nextInt(11) - 5 );
		this.setDamage(damage);
	}
	
	/*
	 * Getters and Setters
	 */
	
	private void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
}

