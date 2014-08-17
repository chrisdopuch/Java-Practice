/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/10/13
 * 
 * Class Description: An enumeration for different types of weapons. Stores the accuracy and name of the weapon.
 */

//import packages and libraries
package umc.csgo.weapon;

import java.util.Random;

public enum Weapon {
	//available weapons with accuracy
	M4A1("Colt M4A1 Carbine", 0.45),
	AUG("Steyr AUG", 0.4),
	AK47("AK-47", 0.3),
	SG552("Sauer SG-552 Commando", 0.35);
	
	//declare variables
	private final double minAccuracy;
	private final String weaponName;
	private double accuracy;
	
	//constructor
	private Weapon(String name, double accuracy) {
		//initialize
		this.minAccuracy = accuracy;
		this.calculateAccuracy(accuracy);
		this.weaponName = name;
	}
	
	private void calculateAccuracy(double accuracy) {
		Random myRandy = new Random();
		this.accuracy = ((myRandy.nextDouble()) * (1 - minAccuracy)) + minAccuracy;
	}

	//get accuracy
	public double getAccuracy() {
		return this.accuracy;
	}
}


