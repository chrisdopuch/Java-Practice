/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

/*
 * TODO:
 * Comment the code in natural language, meaning
 * describe what is going on as if you were explaining
 * it to someone who has no clue what code is. We
 * should be able to know what everything in this file
 * does just from reading the comments and never have
 * to figure anything out ourselves!
 * 
 * There is nothing here that is new, you have used
 * everything written here before.
 * 
 * Hint: Use the documentation if there are any functions
 * you are unsure of.
 */

/* Imports */
import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
import java.util.Iterator;

import umc.csgo.game.EWEAPON;
import umc.csgo.game.Player;
import umc.csgo.game.CounterTerrorist;
import umc.csgo.game.Terrorist;
import umc.csgo.game.Map;

public class CSGO {
	
	private final static Map map = Map.MEDIUM;
	// Play with this to test out different situations!
	
	public static void main(String[] args) {
		
		/* Declare Variables */
		
		ArrayList players;
		Stack ctNames;
		Stack tNames;
		String name;
		int weaponCount;
		int weaponIndex;
		EWEAPON weapon;
		int randomX;
		int randomY;
		Iterator iter;
		
		Player current;
		int randomDistance;
		int randomTarget;
		Player target;
		
		/* Start Code */
		//print welcome message
		System.out.println("Welcome to Counter Strike: Global Offensive!");
		
		System.out.println();
		//make players a new array list
		players = new ArrayList();
		
		//make ctNames a new stack, and fill it with names
		ctNames = new Stack();
		ctNames.push("John");
		ctNames.push("Jose");
		ctNames.push("Mark");
		ctNames.push("Cindy");
		ctNames.push("Bjorn");
		
		//make tNames a new stack, and fill it with names
		tNames = new Stack();
		tNames.push("Carlos");
		tNames.push("Sean");
		tNames.push("Sven");
		tNames.push("Zheng");
		tNames.push("Ankil");
		
		//create a randomizer variable
		Random rand = new Random();
		//get the number of weapon types
		weaponCount = EWEAPON.values().length;
		
		//do while there are still names in the stack
		while( !tNames.empty() ) {
			//get a name from the stack
			name = (String)ctNames.pop();
			//get a random index number for weapons
			weaponIndex = rand.nextInt(weaponCount);
			//assign a weapon based on the index
			weapon = EWEAPON.values()[weaponIndex];
			//randomize x and y values
			randomX = rand.nextInt(map.getWidth());
			randomY = rand.nextInt(map.getHeight());
			//create new player with the above info
			players.add(new CounterTerrorist(name, weapon, randomX, randomY, map));
			
			name = (String)tNames.pop();
			//get a name from the stack
			weaponIndex = rand.nextInt(weaponCount);
			//assign a weapon based on the index
			weapon = EWEAPON.values()[weaponIndex];
			//randomize x and y values
			randomX = rand.nextInt(map.getWidth());
			randomY = rand.nextInt(map.getHeight());
			//create new player with the above info
			players.add(new Terrorist(name, weapon, randomX, randomY, map));
		}
		
		//set iter to be the iterator for players
		iter = players.iterator();
		//iterate through the list of players and print their intros
		while( iter.hasNext() ) {
			((Player)iter.next()).printIntroduction();
		}
		
		//print round start messages
		System.out.println();
		
		System.out.println("3...2...1...Get to the bomb site!");
		
		System.out.println();
		
		//do while there is at least one person alive on each team
		while( CounterTerrorist.getCounterTerroristLivingCount() > 0 &&
				Terrorist.getTerroristLivingCount() > 0 ) {
			//set iter to iterate players
			iter = players.iterator();
			//while there is something to iterate to next
			while( iter.hasNext() ) {
				//set the current player to the next player in players
				current = (Player)iter.next();
				//if the current player is dead, skip to the next iteration of this loop
				if( !current.getIsAlive() ) continue;
				//randomly generate number from 0 to 3 and do something
				switch(rand.nextInt(4)) {
				case 0:
					//set the random distance that the payer will move by
					randomDistance = rand.nextInt(map.getWidth())/2;
					//move in a direction by that distance
					current.moveEast(randomDistance);
					break;
				case 1:
					//set the random distance that the payer will move by
					randomDistance = rand.nextInt(map.getWidth())/2;
					//move in a direction by that distance
					current.moveWest(randomDistance);
					break;
				case 2:
					//set the random distance that the payer will move by
					randomDistance = rand.nextInt(map.getHeight())/2;
					//move in a direction by that distance
					current.moveNorth(randomDistance);
					break;
				case 3:
					//set the random distance that the payer will move by
					randomDistance = rand.nextInt(map.getHeight())/2;
					//move in a direction by that distance
					break;
				}
				
				//randomly pick a target from the list of players
				randomTarget = rand.nextInt(players.size());
				target = (Player)players.get(randomTarget);
				//if we didn't pick the current player
				if( current != target ) {
					//shoot at the player we picked
					current.shoot(target);
					System.out.println();
				}
			}
		}
		
		//print message for end of round
		System.out.println("***Round Over***");
		
		System.out.println();
		
		//print the number of remaining players of each type
		System.out.println("Counter Terrorists Remaining: "+CounterTerrorist.getCounterTerroristLivingCount());
		System.out.println("Terrorists Remaining: "+Terrorist.getTerroristLivingCount());
		
		System.out.println();
		
		//determine who won and print the according message
		if(CounterTerrorist.getCounterTerroristLivingCount() > Terrorist.getTerroristLivingCount()) { 
			System.out.println("Congratulations, Counter Terrorists Have Won!");
		} else {
			System.out.println("Terrorists Have Won! Better Luck Next Time!");
		}
		
		System.out.println();
		
		//make two new stacks for cts and ts
		Stack cts = new Stack();
		Stack ts = new Stack();
		//set iterator to players
		iter = players.iterator();
		//while there is a player to iterate to next
		while( iter.hasNext() ) {
			//select the next player as current
			current = (Player)iter.next();
			//if they are a counter terrorist, push them onto the cts stack
			if( current.getClass() == CounterTerrorist.class ) cts.push(current);
			//else they are a terrorist, so push them onto the ts stack
			else ts.push(current);
		}
		
		//print the counter terrorists and their health
		System.out.println("Counter Terrorists:");
		//while there are cts in the stack
		while( !cts.empty() ) {
			((CounterTerrorist)cts.pop()).printHealth();
		}
		
		System.out.println();
		//print the terrorists and their health
		System.out.println("Terrorists:");
		//while there are ts in the stack
		while( !ts.empty() ) {
			((Terrorist)ts.pop()).printHealth();
		}
		
	}

}
