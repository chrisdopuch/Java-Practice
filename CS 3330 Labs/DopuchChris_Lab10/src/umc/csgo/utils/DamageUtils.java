/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/17/2013
 */

package umc.csgo.utils;

/* Imports */

public final class DamageUtils {
	/*
	 * GetDamage:
	 * 	If the distance is greater than a specified amount,
	 * 		then reduce it by half and round. Otherwise, return
	 * 		the given damage.
	 */
	public static final int getDamage( int damage, int distance ) {
		double modifier = (distance < 8 ? 1.0 : 0.5);
		return (int)Math.round(damage*modifier);
	}
}
