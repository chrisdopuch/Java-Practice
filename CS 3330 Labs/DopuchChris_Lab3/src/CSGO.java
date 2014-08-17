/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/11/13
 */

//import libraries
import java.util.*;

public class CSGO {
	
	// Main Method
	public static void main(String[] args) {
		// Create scanner object for any inputs
		Scanner input = new Scanner(System.in);
		
		// Print CS:GO welcome message
		System.out.println("Welcome to Counter-Strike: Global Offensive!!!!!\n");
		
		// Create a Counter Terrorist
		System.out.println("Creating a Counter Terrorist. Please provide a handle:");
		// Read in name from input
		String counterTerroristName = input.nextLine();
		// Create a Counter Terrorist using a Constructor
		CounterTerrorist counterTerroristOne = new CounterTerrorist(counterTerroristName);
		
		// Print counterTerroristOne's introduction
		counterTerroristOne.printIntroduction();
		// Print counterTerroristOne's health
		counterTerroristOne.printHealth();
		// Print Counter Terrorist count
		CounterTerrorist.printActorCount();

		// Create a Terrorist
		System.out.println("Creating a Terrorist. Please provide a handle:");
		// Read in name from input
		String terroristName = input.nextLine();
		// Create a Terrorist using a Constructor
		Terrorist terroristOne = new Terrorist(terroristName);

		// Print terroristOne's introduction
		terroristOne.printIntroduction();
		// Print terroristOne's health
		terroristOne.printHealth();
		// Print Terrorist count
		Terrorist.printActorCount();

		// Start Round
		System.out.println("3...2...1...Get to the bomb site!");
		
		/*
		 * MISSING
		 * 
		 * 	While both are alive
		 * 		Shoot each other
		 * 
		 * MISSING
		 */

		System.out.println("Round Over.");
		// Print number of Counter Terrorists and Terrorists
		// left alive
		CounterTerrorist.printLivingCount();
		Terrorist.printLivingCount();
		
		/*
		 * MISSING
		 * 
		 * 	Print the winner
		 * 
		 * MISSING
		 */
		
		//close the input object
		input.close();
	}
}
