/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/10/13
 * 
 * Class Description: This class is a grenade, which can explode and hurt players. it has coordinates and max damage and range, and methods for exploding.
 */

//import packages and libraries
package umc.csgo.weapon;

import umc.csgo.misc.*;
import java.util.NoSuchElementException;


public class Grenade {
	//declare variables
	private double xCoordinate;
	private double yCoordinate;
	public static int maximumDamage = 100;
	public static int damageRange = 250;
	
	//constructor
	public Grenade(double x, double y) throws ArithmeticException {
		//error checking to validate the explosion site
		if(x > 800 || x < 0 || y < 0 || y > 800)
			throw new ArithmeticException("Coordinates out of map area!");
		
		//initialization
		this.setXCoordinate(x);
		this.setYCoordinate(y);
	}
	
	//setters and getters
	protected void setXCoordinate(double x) {
		this.xCoordinate = x;
	}
	
	public double getXCoordinate() {
		return this.xCoordinate;
	}
	
	protected void setYCoordinate(double y) {
		this.yCoordinate = y;
	}
	
	public double getYCoordinate() {
		return this.yCoordinate;
	}
	
	public static int getMaxDamage() {
		return Grenade.maximumDamage;
	}
	
	public static int getRange() {
		return Grenade.damageRange;
	}
	
	//explode the grenade
	public void explode(Damageable[] damageable) throws NoSuchElementException {
		for(int k = 0; k < damageable.length; k++) {
			if(damageable[k]==null)
				throw new NoSuchElementException("Damaeagle interface at index "+ k +" doesn't exist!");
			
			Damageable temp = damageable[k];
			temp.grenadeExploded(this);
		}
	}
}
