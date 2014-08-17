/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 4/10/13
 * 
 * Class Description: This is the main class tat runs the game. All the user interface is done here, as well as creation of new objects and running those objects' methods. 
 */

//import packages and libraries
package umc.csgo.run;

import umc.csgo.misc.*;
import umc.csgo.player.*;
import umc.csgo.weapon.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class CSGO {
	//create a hashmap for storing players by name
	private static HashMap<String, Player> player = new HashMap<String, Player>();		
	public static void main(String[] args) {
		String line = null;
		
		System.out.println("Welcome to the CS:GO! Let's have some action!!\n");
		
		System.out.println("Please enter your Command or -1 to end the game:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			//read the first line
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (line != null) {
			Scanner scanner = new Scanner(line);
			
			//change the command to all lowercase
			String command = scanner.next().toLowerCase();
			
			//handle create command
			if (command.equals("create")) {
				//get all required parameters
				String type = scanner.next();
				String name = scanner.next();
				String weapon = scanner.next();
				
				double x = Double.valueOf(scanner.next());
				double y = Double.valueOf(scanner.next());
				
				int hp = Integer.valueOf(scanner.next());
				
				//for CounterTerrorist
				if (type.equals("CounterTerrorist")) {
					try {
						CounterTerrorist ct = new CounterTerrorist(name, Weapon.valueOf(weapon), x, y, hp);
						//add player to hashmap
						player.put(name, ct);
					} catch (NullPointerException e) {
						System.out.println(e.getClass().getName() + " was thrown when creating a CounterTerrorist:" + e.getMessage());
					} catch (ArithmeticException e) {
						System.out.println(e.getClass().getName() + " was thrown when creating a CounterTerrorist:" + e.getMessage());
					} catch (EnumConstantNotPresentException e) {
						System.out.println(e.getClass().getName() + " was thrown when creating a CounterTerrorist:" + e.getMessage());
					}
				}

				if (type.equals("Terrorist")) {
					try {
						Terrorist t = new Terrorist(name, Weapon.valueOf(weapon), x, y, hp);
						//add player to hashmap
						player.put(name, t);
					} catch (NullPointerException e) {
						System.out.println(e.getClass().getName() + " was thrown when creating a Terrorist:" + e.getMessage());
					} catch (ArithmeticException e) {
						System.out.println(e.getClass().getName() + " was thrown when creating a Terrorist:" + e.getMessage());
					} catch (IllegalArgumentException e) {
						System.out.println(e.getClass().getName() + " was thrown when creating a Terrorist:" + e.getMessage());
					}
				}
			}
			
			//shoot command
			if (command.equals("shoot")) {
				String first = scanner.next();
				String second = scanner.next();
				
				Player shooter = player.get(first);
				Player opponent = player.get(second);
				
				//check if both players exist
				if (shooter != null && opponent != null) {
					if (shooter.getClass().equals(opponent.getClass()))
						System.out.println("Don't shoot your team member! Don't be a betrayer.");
					else {
						//call being shot method
						opponent.beingShot(shooter);
						//print shoot message
						System.out.println("Player "+ opponent.getName() + " has been shot by " + shooter.getName() + ". " + opponent.getName() + " now have " + opponent.getHealth() + " health remaining.");
					}
				} else {
					System.out.println("One of the player's name doesn't exist");
				}
			}
			
			//explode grenade command
			if (command.equals("explodegrenade")) {
				//get required parameters
				double x = Double.valueOf(scanner.next());
				double y = Double.valueOf(scanner.next());
				
				try {
					Grenade grenade = new Grenade(x, y);
					Damageable[] damageable = new Damageable[player.size()];
					player.values().toArray(damageable);
					grenade.explode(damageable);
				} catch (ArithmeticException e) {
					System.out.println(e.getClass().getName() + " was thrown when creating Grenade:" + e.getMessage());
				} catch (InputMismatchException e) {
					System.out.println(e.getClass().getName() + " was thrown when creating Grenade:" + e.getMessage());
				}
			}
			
			//print command
			if (command.equals("print")) {
				Object[] arr;
				arr = player.values().toArray();
				Arrays.sort(arr);

				System.out.println("Printing the player's health info in ascending order...");
				for (int i=0;i<player.size();i++) {
					Player temp = (Player)arr[i];
					if(temp.getHealth() <= 0){
						System.out.println("Player " + temp.getName() + " is dead.");
					}
					else {
						System.out.println("Player " + temp.getName() + ": " + temp.getHealth() + " health points.");
					}
				}
			}
			
			//end the program
			if (command.equals("-1")) {
				System.out.println("Good Bye! Hope you enjoyed playing.");
				System.exit(0);
			}
			
			try {
				//read next line
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			/* close scanner object */
			scanner.close();
		}
	}
}
