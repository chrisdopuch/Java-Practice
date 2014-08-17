/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/10/13
 * 
 * Class Description: this is the class for players in the game. It implements damageable and comparable. It's children are CounterTerrorist and Terrorist.
 */

//import packages and libraries
package umc.csgo.player;

import umc.csgo.misc.*;
import umc.csgo.weapon.*;


public class Player implements Damageable, Comparable<Object> {
	//attributes
	private String name;
	private Weapon weapon;
	private double xCoordinate;
	private double yCoordinate;
	private int health;
	private static final int maxHealth = 100;

	//constructor
	Player(String playerName, Weapon playerWeapon, double x, double y, int hp) throws NullPointerException,ArithmeticException {
		//if no name is passed
		if(playerName == null)
			throw new NullPointerException("Player name can not be null, please provide a name!");
		//if no weapon is passed
		if(playerWeapon == null)
			throw new NullPointerException("Weapon can not be null, please provide a valid weapon!");
		//if the coordinates given are out of bounds
		if(x > 800 || x < 0 || y < 0 || y > 800)
			throw new ArithmeticException("Coordinate out of boundary");
		//if hp is invalid number (less than 1)
		if(hp <= 0)
			throw new ArithmeticException("Health Point must be between 1 and 100!");
		//set the new attributes
		this.setName(playerName);
		this.setWeapon(playerWeapon);
		this.setXCoordinate(x);
		this.setYCoordinate(y);
		this.health = hp;
		
		//print intro message
		this.printInformation();
	}
	
	//function to print information about the player, name, and weapon
	void printInformation() {
		System.out.println("Player "+name+" was created. Player currently have " + this.getWeapon() + " weapon.");
	}
	
	//sets the name, input string
	protected void setName(String playerName) {
		this.name = playerName;
	}
	
	//returns the name
	public String getName() {
		return this.name;
	}
	
	//sets the weapon
	protected void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	//gets the weapon being used
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	//sets x coordinate, input double
	protected void setXCoordinate(double x) {
		this.xCoordinate = x;
	}
	
	//gets the x cordinate
	public double getXCoordinate() {
		return this.xCoordinate;
	}
	
	//sets the y coordinate, input double
	protected void setYCoordinate(double y) {
		this.yCoordinate = y;
	}
	
	//gets the y cordinate
	public double getYCoordinate() {
		return this.yCoordinate;
	}
	
	//sets the player's health, input int lost health
	protected void setHealth(int lostHealth) {
		this.health = health - lostHealth;
		if( this.health <= 0) {
			this.health = 0;
			this.die();
		}
	}
	
	//gets the players health
	public int getHealth(){
		return this.health;
	}
	
	//method for taking in which players are shooting and which is opponent
	public void beingShot(Player shooter)
	{
		//transfers this info to an overloaded function
		this.beingShot(shooter.getXCoordinate(), shooter.getYCoordinate(), shooter.getWeapon().getAccuracy());
	}
	
	//overloaded function to actually damage player being shot, input double x, double y, double accuracy
	private void beingShot(double x, double y, double accuracy){
		//calculate the distance between players
		double dist = CalcDistance.calDistance(x, y, this.getXCoordinate(), this.getYCoordinate());
		
		//calculate the accuracy
		double theta =  accuracy * (1 / (Math.log(Math.pow(Math.sqrt(CalcDistance.alpha), Math.log(dist))) / Math.log(10)));
		
		//determine how much health was lost
		int lostHealth = (int)(maxHealth * theta);
        
		//set the new health value
		this.setHealth(lostHealth);

	}

	//method for getting hit with a grenade explosion, input grenade
	public void grenadeExploded(Grenade grenade) {
		//calculate the distance between player and grenade
		double dist = CalcDistance.calDistance(grenade.getXCoordinate(), grenade.getYCoordinate(), this.getXCoordinate(), this.getYCoordinate());
		
		//if player in range
		if(dist <= Grenade.getRange()) {
			//determine lost health
			int lostHealth = (int)((dist / Grenade.getRange()) * Grenade.getMaxDamage());
			
			System.out.println("Player "+ this.getName() +" lost "+ lostHealth +" health.");
			
			//set new health value
			this.setHealth(lostHealth);
		} else {
			//player is out of range
			System.out.println("Player "+ this.getName() +" is out of explosion range.");
		}
	}

	//overwritten compare to function from comparable interface, sorts by health ascending
	public int compareTo(Object o1) {
		if (this.getHealth() == ((Player) o1).getHealth())
            return 0;
        else if ((this.getHealth()) > ((Player) o1).getHealth())
            return 1;
        else
            return -1;
	}
	
	//method for when a player dies
	protected void die() {
		System.out.println("Player " + this.getName() + " has died.");
	}
}
