/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

package umc.csgo.game;

/* Imports */
import java.util.*;

public enum Map{
	
	/*
	 * Maps:
	 * 	SMALL:
	 * 		width:	10
	 * 		height:	10
	 * 	MEDIUM:
	 * 		width:	25
	 * 		height:	25
	 * 	LARGE:
	 * 		width:	50
	 * 		height:	50
	 */
	
	SMALL(10, 10), MEDIUM(25, 25), LARGE(50, 50);
	
	/* UML
	 * --Enum-------------
	 * 
	 *   Map
	 * 
	 * --Attributes--------
	 * 
	 * - width:int (final)
	 * - height:int (final)
	 * 
	 * --Methods-----------
	 * 
	 * c Map(int,int)
	 * + getWidth():int
	 * + getHeight():int
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */

	/* Attributes - Instanced */
	final int width;
	final int height;
	
	/* Attributes - Static */
	
	/* Constructor */
	private Map(int h, int w){
		this.height = h;
		this.width = w;
	}
	/* Getters and Setters - Instanced */
	
	//method to get the width of the map
	//input none, returns int width
	public int getWidth(){
		return this.width;
	}
	
	//method to get the height of the map
	//input none, returns int height
	public int getHeight(){
		return this.height;
	}
	/* Getters and Setters - Static */
	
	/* Methods - Instanced */
	
	/* Methods - Static */
	
	/* Methods - Abstract */
	
}
