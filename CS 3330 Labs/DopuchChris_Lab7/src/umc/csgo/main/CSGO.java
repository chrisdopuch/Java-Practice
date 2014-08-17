/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/20/13
 * 
 * CSGO.java
 * 	Description:
 *  This is the main class which runs the game. This is where players are created and input from the user is handled.
 */

// Declare the package the file exists in
package umc.csgo.main;

// Import any classes needed from outside this package
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;
/*
 * 1. You need the actor and enum packages.
 * How do you access these?
 * Use the import statement
 */
/*
 * TODO
 * 1 - MISSING CODE
 * */

import umc.csgo.actor.*;
import umc.csgo.enums.*;

public class CSGO {

	/*
	 * Attributes
	 */
	
	public static void main(String[] args) {
		/*
		 * CSGO Starts Here
		 */
		
		print("Welcome to Counter Strike: Global Offensive!");
		
		ArrayList players;
		// TODO: Make a list of players
		players = new ArrayList();
		
		Scanner scanner = new Scanner(System.in);
		int i_arg = 0;
		String s_arg = "";
		
		Player player;
		int pid = 1;
		String playerName = "";
		int playerTeam = 0;
		int playerSkin = 0;
		
		while(true) {
			/*
			 * What does the user want to do?
			 */
			while(true) {
				// See what the user wants to do
				print("What do you want to do?\n" +
					"1. Add a player\n" +
					"2. Quit\n");
				
				try {
					i_arg = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					/*
					 * 1. What does this exception do?
					 * It catches if the string that the user entered doesn't conform to the format required to make it numeric
					 * 2. Print out a message to the user
					 * informing them of what they should
					 * do.
					 */
					/* 
					 * TODO
					 * 1 - ANSWER
					 * 2 - MISSING CODE
					 * */
					print("ERROR: Invalid input, please enter either 1 or 2.");
					print();
					continue;
				} catch (InputMismatchException e) {
					/*
					 * 1. What does this exception do?
					 * This catches if the input received doesn't match what is expected, in this case a line. So if it's blank, it will throw this exception.
					 * 2. Print out a message to the user
					 * informing them of what they should
					 * do.
					 */
					/* 
					 * TODO
					 * 1 - ANSWER
					 * 2 - MISSING CODE
					 * */
					print("ERROR: Please enter a line of input.");
					print();
					continue;
				}
				
				if(i_arg != 1 && i_arg != 2) {
					print("Unknown selection "+i_arg+". "+
						"Please select one of the options.");
					print();
					continue;
				}
				break;
			}
			
			/*
			 * The user is done adding players.
			 * Quit the loop
			 */
			if(i_arg == 2) { break; }
			
			/*
			 * The user decided to add a player.
			 * What name does the user want for the player?
			 */
			while(true) {
				print("Please enter the name for your player:\n");
				
				/*
				 * Get the name for the player using scanner.nextLine()
				 * 
				 * Remember that this operation is prone to
				 * exceptions!
				 */
				try {
					s_arg = scanner.nextLine();
				} catch(NoSuchElementException e) {
					/*
					 * 1. What does this exception do?
					 * It is thrown if an enum tries to get the next elemtn and there is none
					 * 2. Print out a message to the user
					 * informing them of what they should
					 * do.
					 */
					/* 
					 * TODO
					 * 1 - ANSWER
					 * 2 - MISSING CODE
					 * */
					print("ERROR: Please enter valid input.");
					print();
					continue;
				} catch(IllegalStateException e) {
					/*
					 * 1. What does this exception do?
					 * This is thrown if a method has been evoked at an illegal time, when the system is not ready
					 * 2. Print out a message to the user
					 * informing them of what they should
					 * do.
					 */
					/* 
					 * TODO
					 * 1 - ANSWER
					 * 2 - MISSING CODE
					 * */
					print("ERROR: Method call at illegal time, program will now terminate, please restart.");
					print();
					System.exit(-1);
				}
				/*
				 * Make sure they actually entered something
				 */
				if(s_arg.isEmpty()) {
					print("Please enter a name.");
					print();
					continue;
				}
				break;
			}
			playerName = s_arg;
			
			/*
			 * What team does the user want the player to be on?
			 */
			while(true) {
				print("Please select a team.\n" +
					"1. Counter Terrorist\n" +
					"2. Terrorist\n" +
					"3. Observer\n");
				
				/*
				 * Get the option number using scanner.nextInt()
				 * 
				 * Remember that this operation is prone to
				 * exceptions!
				 */
				try{
				i_arg = Integer.parseInt(scanner.nextLine());
				} catch (InputMismatchException e) {
					print("ERROR: Please enter a line of input.");
					print();
					continue;
				}
				catch (NumberFormatException e) {
				print("ERROR: Invalid input, please enter either 1 or 2 or 3.");
				print();
				continue;
				}
				
				if(i_arg != 1 && i_arg != 2 && i_arg != 3) {
					print("Unknown selection "+i_arg+". "+
						"Please select one of the options.");
					print();
					continue;
				}
				/*
				 * TODO
				 * 1 - MISSING CODE
				 */
				break;
			}
			playerTeam = i_arg;
			
			/*
			 * Create a new player from the information gathered
			 */
			switch(playerTeam) {
			case 1:
				player = new CounterTerrorist(pid, playerName);
				break;
			case 2:
				player = new Terrorist(pid, playerName);
				break;
			case 3:
			default:
				player = new Observer(pid, playerName);
			}
			player.setTeam(playerTeam);

			if(player.getTeam() != Team.O){ 
				/*
				 * Create the list of available skins for the new player
				 */
				String skins = "";
				switch(playerTeam) {
				case 1:
					for(int i = 0 ; i < CTSkin.values().length ; i++) {
						skins += (i+1)+". "+CTSkin.values()[i]+"\n";
					}
					break;
				case 2:
					for(int i = 0 ; i < TSkin.values().length ; i++) {
						skins += (i+1)+". "+TSkin.values()[i]+"\n";
					}
					break;
				default:
				}
				/*
				 * What player skin does the user want the player to use?
				 */
				while(true) {
					print("Please select a skin.\n" + skins);
					
					/*
					 * Get the option number using scanner.nextInt()
					 * 
					 * Remember that this operation is prone to
					 * exceptions!
					 */
					try{
						i_arg = Integer.parseInt(scanner.nextLine());
					} catch (InputMismatchException e) {
						print("ERROR: Please enter a line of input.");
						print();
						continue;
					}
					catch (NumberFormatException e) {
					print("ERROR: Invalid input, please enter either 1 or 2.");
					print();
					continue;
					}
					
					if(i_arg != 1 && i_arg != 2 && i_arg != 3) {
						print("Unknown selection "+i_arg+". "+
							"Please select one of the options.");
						print();
						continue;
					}
					/*
					 * TODO
					 * 1 - MISSING CODE
					 */
					break;
				}
				playerSkin = i_arg;
			} else {
				playerSkin = 0;
			}
			
			/*
			 * Check if player joined the game successfully
			 */
			if(!player.join(playerTeam, playerSkin)) {
				/*
				 * Player wasn't able to join the team.
				 * Inform the player and return to the
				 * beginning
				 */
				print("Error: Player was not successfully created. Please try again.");
				print();
				continue;
			}
			
			/*
			 * Player was successfully created. Add it to the
			 * current list of players
			 */
			players.add(player);
			/*
			 * 1. What is the class of the objects in the
			 * array list "players"?
			 * Player
			 * 2. What is the class of player before and
			 * after adding it to the "players" array list?
			 * Either CounterTerrorist, Terrorist, or Observer
			 * Player
			 */
			/*
			 * TODO:
			 * 1 - ANSWER
			 * 2 - ANSWER
			 */
			
			/*
			 * Increment the player id
			 */
			pid++;
		}
		
		/*
		 * Make sure and close the scanner
		 */
		scanner.close();
		
		print();
		
		/*
		 * Print out the current players before quitting
		 */
		print("List of players:\nTeam,Name,Skin");
		Iterator it = players.iterator();
		while(it.hasNext()) {
			player = (Player) it.next();
			print(player.getTeam() + ", " + player.getName() + ", " + player.getSkinName());
			/*
			 * 1. Get the next item from the iterator.
			 * 2. What is the class of the object iterator returns?
			 * object
			 * 3. What do you do with the object to get
			 * the team, name and skin?
			 * cast it then call the player methods
			 * 4. Which methods are overloaded, which are
			 * overriden, and which use polymorphism?
			 * getSkinName() is overriden and uses polymorphism
			 * 5. Print the (team,name,skin) in that order,
			 * comma separated
			 */
			/*
			 * TODO
			 * 1 - MISSING CODE
			 * 2 - ANSWER
			 * 3 - ANSWER
			 * 4 - ANSWER
			 * 5 - MISSING CODE
			 */
		}
		
		print("All players have joined! This demo" +
			" is complete. Please purchase the" +
			" full copy to join in on the action!");
	}
	
	private static void print(String msg) {
		System.out.println(msg);
	}
	
	private static void print() {
		System.out.println();
	}

}
