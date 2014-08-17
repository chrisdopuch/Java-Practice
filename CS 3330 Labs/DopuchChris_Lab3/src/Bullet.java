/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/11/13
 */

// import libraries
import java.util.*;

public class Bullet {
	
	/* UML - Bullet
	 * --------------------
	 * - damage:int
	 * - damageArray:int[]
	 * --------------------
	 * c Bullet(int)
	 * - setDamage(int):void
	 * + getDamage():int
	 * --------------------
	 */
	
	/*
	 * Attributes
	 */
	
	private int damage;
	private int[] damageArray = {5,10,15,20,25};
	
	/*
	 * Constructor
	 */
	
	public Bullet(int damage) {
		this.setDamage(damage);
	}
	
	/*
	 * Getters and Setters
	 */
	
	private void setDamage(int damageIndex) {
		this.damage = damageArray[damageIndex];
	}
	
	public int getDamage() {
		return this.damage;
	}
	
}
