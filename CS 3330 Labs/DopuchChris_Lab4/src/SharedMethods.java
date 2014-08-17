/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/19/2013
 */

// import libraries
import java.util.*;

public final class SharedMethods {
	
	/* UML - SharedMethods
		 * --------------------
		 * --------------------
		 * + get2dDistance(int, int, int, int): int (static final)
		 * + getDamage(int, int): int (static final)		 
		 * --------------------
	 */
	
	/*
	 * Get2dDistance:
	 * 	Calculate the distance between two 2D points
	 */
	public static final int get2dDistance( int x1, int y1, int x2, int y2 ) {
		double distance;
		distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);
		// Hint: Remember how to find the distance between two points...?
		return (int)distance;
	}
	
	/*
	 * GetDamage:
	 * 	If the distance is greater than a specified amount,
	 * 		then reduce it by half and round. Otherwise, return
	 * 		the given damage.
	 */
	public static final int getDamage( int damage, int distance ) {
		double modifier = (distance < 8 ? 1.0 : 0.5);
		return (int)Math.round(modifier * (double)damage);
		// Hint: Remember how to cast, and the Math class
		//	has some good methods as well
	}

}
