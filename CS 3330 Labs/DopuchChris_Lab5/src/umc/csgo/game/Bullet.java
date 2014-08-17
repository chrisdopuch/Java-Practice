/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

package umc.csgo.game;

/* Imports */
import java.util.*;

import umc.csgo.utils.DamageUtils;

public class Bullet{
	
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
	 * c Bullet(int)
	 * + getDamage():int
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * Functions:
	 * 	c Bullet(int)
	 * 		Takes in a damage and augments it
	 * 		by +/-5
	 */

	/* Attributes - Instanced */
	private final int damage;
	
	/* Constructor */
	public Bullet(int damage){
		// Bullet damage should be the base weapon damage +/-5
		Random rand = new Random();
		int modifiedDamage = damage + ( rand.nextInt(11) - 5 );
		this.damage = modifiedDamage;
	}
	
	/* Getters and Setters - Instanced */
	
	//method to get the damage of this object
	//input none, returns the dmage
	public int getDamage(){
		return this.damage;
	}
	
	/* Getters and Setters - Static */
	
	/* Methods - Instanced */
	
	/* Methods - Static */
	
	/* Methods - Abstract */
	
}