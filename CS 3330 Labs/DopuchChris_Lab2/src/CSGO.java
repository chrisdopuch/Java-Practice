/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: 
 * Date: 2/4/2013
 */

//import libraries
import /*MISSING*/;

public class CSGO {
	
	// Main Method
	public static void main(String[] args) {
		// Create scanner object for any inputs
		Scanner input = new Scanner(System.in);
		
		// Print CS:GO welcome message
		/*MISSING*/("Welcome to Counter-Strike: Global Offensive!!!!!\n");
		
		// Create a Counter Terrorist
		System.out.println("Creating a Counter Terrorist. Please provide a handle:");
		// Read in name from input
		/*MISSING*/ = input.nextLine();
		// Create Counter Terrorist using a Constructor
		CounterTerrorist counterTerroristOne = new /*MISSING*/;
		
		// Print counterTerroristOne's introduction
		counterTerroristOne.printIntroduction();
		// Print counterTerroristOne's health
		/*MISSING*/
		// Print Counter Terrorist count
		CounterTerrorist.printActorCount();

		// Create a Terrorist
		System.out.println("Creating a Terrorist. Please provide a handle:");
		// Read in name from input
		/*MISSING*/
		// Create a Terrorist using a Constructor
		/*MISSING*/

		// Print terroristOne's introduction
		terroristOne./*MISSING*/;
		// Print terroristOne's health
		/*MISSING*/
		// Print Terrorist count
		/*MISSING*/.printActorCount();

		// Start Round
		System.out.println("3...2...1...Get to the bomb site!");

		// terroristOne shot
		terroristOne.beingShot(5);
		// Print terroristOne's health
		/*MISSING*/

		// counterTerroristOne shot
		counterTerroristOne.beingShot(5);
		counterTerroristOne./*MISSING*/;

		for( int i = 0 ; i < 5 ; i++ ) {
			if( terroristOne.getHealth() > 0 ) {
				terroristOne.beingShot(10 + i);
				// Print something here
				/*MISSING*/
			}
		}

		System.out.println("Round Over.");
		// Print number of Counter Terrorists and Terrorists
		// left alive
		/*MISSING*/
		/*MISSING*/
		System.out.println("Counter Terrorists Win.");
		
		//close the input object
		input.close();
	}
}
