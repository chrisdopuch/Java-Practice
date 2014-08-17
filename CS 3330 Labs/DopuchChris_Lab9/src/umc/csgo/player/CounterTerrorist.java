/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/10/13
 * 
 * Class Description: This class if for players who are counter terrorists. It extends player class. Keeps track of how many CTs there are alive
 */

//import packages and libraries
package umc.csgo.player;

import umc.csgo.weapon.Weapon;

public class CounterTerrorist extends Player{
	//declare variable
	private static int aliveCTs = 0;
	
	//constructor
	public CounterTerrorist(String playerName, Weapon playerWeapon, double x, double y, int hp){
		super(playerName, playerWeapon, x, y, hp);
		this.incrementPlayer();
	}
	
	//increment CounterTerrorists
	public void incrementPlayer() {
		CounterTerrorist.aliveCTs++;
	}
	
	//decrement CounterTerrorists 
	public void decrementPlayer() {
		CounterTerrorist.aliveCTs--;
	}
	
	//get number of alive CounterTerrorists
	public static int getAliveCTs() {
		return CounterTerrorist.aliveCTs;
	
	}
	
	//override the die method so we can decrement the number of alive CTs
	@Override
	protected void die(){
		super.die();
		this.decrementPlayer();
	}
}
