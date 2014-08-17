/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/10/13
 * 
 * Class Description: This class if for players who are terrorists. It extends player class. Keeps track of how many Ts there are alive
 */

//import packages and libraries
package umc.csgo.player;

import umc.csgo.weapon.Weapon;

public class Terrorist extends Player{
	//declare variable
	private static int aliveTs = 0;
	
	//constructor
	public Terrorist(String playerName, Weapon playerWeapon, double x, double y, int hp){
		super(playerName, playerWeapon, x, y, hp);
		this.incrementPlayer();
	}
	
	//increment Terrorists
	public void incrementPlayer() {
		Terrorist.aliveTs++;
	}
	
	//decrement Terrorists 
	public void decrementPlayer() {
		Terrorist.aliveTs--;
	}
	
	//get number of alive Terrorists
	public static int getAliveTs() {
		return Terrorist.aliveTs;
	
	}
	
	//override the die method so we can decrement the number of alive Ts
	@Override
	protected void die(){
		super.die();
		this.decrementPlayer();
	}
}
