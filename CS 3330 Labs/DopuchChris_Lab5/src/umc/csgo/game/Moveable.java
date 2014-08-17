/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

package umc.csgo.game;

/* Imports */
import java.util.*;

public interface Moveable {
	
	/* UML
	 * --Interface---------
	 * 
	 *   Moveable
	 * 
	 * --Attributes--------
	 * 
	 * --Methods-----------
	 * 
	 *   moveEast(int):boolean
	 *   moveWest(int):boolean
	 *   moveNorth(int):boolean
	 *   moveSouth(int):boolean
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * Functions:
	 * 	move<N/E/S/W>(int):void
	 * 		Move x number of units north, east
	 * 		south or west
	 * 		These are interface methods, so they
	 * 		must be implemented in whatever class
	 * 		implements Moveable using the description
	 * 		above
	 */
	boolean moveEast(int distance);
	boolean moveWest(int distance);
	boolean moveNorth(int distance);
	boolean moveSouth(int distance);
}
