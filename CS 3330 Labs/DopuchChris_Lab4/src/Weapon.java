/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/19/2013
 */

// import libraries
import java.util.*;

public enum Weapon {
	
	/* UML - Weapon
	 * --------------------
	 * - damage:int
	 * --------------------
	 * c Weapon(int)
	 * - setDamage(int):void
	 * + getDamage():int
	 * --------------------
	 */
	
	/*
	 * Weapons
	 */
	M4A4(1), AK47(2), P2000(3), GLOCK18(4);

	/*
	 * Weapons: M4A4, AK47, P2000, GLOCK18
	 * Damage: 40, 50, 20, 15
	 * Hint: See the link to Enums in the Lab 4 Slides
	 * Basic enum:
	 * 	public enum Test {
	 * 		One,
	 * 		Two,
	 * 		Three;
	 * 	}
	 */
	
	 /*
	  * Attributes
	  */
	
	private int damage;
	
	 /*
	  * Constructor
	  */
	private Weapon(int num){
		this.setDamage(num);
	}
	
	/*
	 * Getters and Setters
	 */
	
	//input integer, sets damage of the enum
	private void setDamage(int num){
		switch(num){
		case 1:
			this.damage = 40;
		case 2:
			this.damage = 50;
		case 3:
			this.damage = 20;
		case 4:
			this.damage = 15;
		}
	}
	
	//no input, returns the damage of the enum
	public int getDamage(){
		return this.damage;
	}
}
