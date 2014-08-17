/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

package umc.csgo.game;

/* Imports */
import java.util.*;

public enum EWEAPON{
	
	/*
	 * Weapons:
	 * 	KNIFE:
	 * 		damage:		10
	 * 		clipSize:	3
	 * 		accuracy:	100%
	 * 	M4A4:
	 * 		damage:		40
	 * 		clipSize:	30
	 * 		accuracy:	60%
	 * 	AK47:
	 * 		damage:		50
	 * 		clipSize:	30
	 * 		accuracy:	40%
	 * 	P2000:
	 * 		damage:		20
	 * 		clipSize:	12
	 * 		accuracy:	60%
	 * 	GLOCK18:
	 * 		damage:		10
	 * 		clipSize:	20
	 * 		accuracy:	50%
	 */
	
	KNIFE(10,3,100), M4A4(40,30,60), AK47(50,30,40), P2000(20,12,60), GLOCK18(10,20,50);
	
	/* UML
	 * --Enum--------------
	 * 
	 *   EWEAPON
	 * 
	 * --Attributes--------
	 * 
	 * - damage:int (final)
	 * - clipSize:int (final)
	 * - accuracy:double (final)
	 * 
	 * --Methods-----------
	 * 
	 * c EWEAPON(int,int,double)
	 * + getDamage():int
	 * + getClipSize():int
	 * + getAccuract():double
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */

	/* Attributes - Instanced */
	
	private final int damage;
	private final int clipSize;
	private final double accuracy;
	
	/* Attributes - Static */
	
	/* Constructor */
	
	private EWEAPON(int damage, int clipSize, double accuracy){
		this.damage = damage;
		this.accuracy = accuracy;
		this.clipSize = clipSize;
	}
	
	/* Getters and Setters - Instanced */
	
	//method to get EWEAPON damage
	//input none, returns int damage
	public int getDamage(){
		return this.damage;
	}
	
	//method to get EWEAPON clipSize
	//input none, returns int clipSize
	public int getClipSize(){
		return this.clipSize;
	}
	
	//method to get the accuracy of the EWEAPON
	//input none, returns double accuracy
	public double getAccuracy(){
		return this.accuracy;
	}
	
	/* Getters and Setters - Static */
	
	/* Methods - Instanced */
	
	/* Methods - Static */
	
	/* Methods - Abstract */

}
