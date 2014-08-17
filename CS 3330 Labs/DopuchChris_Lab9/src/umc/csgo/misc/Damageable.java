/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/10/13
 * 
 * Class Description: an interface for players being damaged by a grenade.
 */

//import packages and libraries
package umc.csgo.misc;

import umc.csgo.weapon.Grenade;

public interface Damageable {
	void grenadeExploded(Grenade grenade);
}
