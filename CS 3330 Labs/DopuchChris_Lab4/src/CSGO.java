/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/19/2013
 */

//import libraries
import java.util.Random;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;

public class CSGO {
	
	// Main Method
	public static void main(String[] args) {
		// Create Method Attributes
		Random rand = new Random();
		//variables to be assigned to newly created objects
		int x, y;
		Weapon weapon;
		CounterTerrorist counterTerrorist;
		Terrorist terrorist;
		//create array of weapon enums
		Weapon[] weapons = new Weapon[4];
		weapons[0] = Weapon.M4A4;
		weapons[1] = Weapon.AK47;
		weapons[2] = Weapon.P2000;
		weapons[3] = Weapon.GLOCK18;
		//iterator
		Iterator itr;
		
		// Print CS:GO welcome message
		System.out.println("Welcome to Counter-Strike: Global Offensive!!!!!\n");
		
		/*
		 * Create the Counter Terrorists
		 */
		
		// Create a Stack of CT names (String)
		// Hint: Remember to initialize with new
		
		Stack<String> CTNames = new Stack<String>();
		
		// *Push* the following names onto the stack
		// Names: John, Jose, Mark, Cindy
		
		CTNames.push("John");
		CTNames.push("Jose");
		CTNames.push("Mark");
		CTNames.push("Cindy");
		
		// Create an ArrayList of CTs
		// Hint: An ArrayList<Type> is created just like a Stack
		// Hint: Use the link in the Lab 4 slides to learn about
		//	ArrayList and it's methods
		
		ArrayList<CounterTerrorist> counterTerrorists = new ArrayList<CounterTerrorist>();
		
		// Fill the ArrayList with Counter Terrorists
		// Hint: empty() and pop() are both useful methods for a Stack
		while(!CTNames.empty()) {
			// Choose a random Weapon from the Weapons enum
			// Hint: Enums can be made into an array, which has a length variable
			
			weapon = weapons[rand.nextInt(3)];
			
			// Choose a random location between (0,0) and (10,10)
			
			x = rand.nextInt(10);
			y = rand.nextInt(10);
			
			// Create a new Counter Terrorist with the above Weapon and location
			
			counterTerrorist = new CounterTerrorist(CTNames.pop(), weapon, x, y);
			
			// then print general info about the new Counter Terrorist
			
			counterTerrorist.printIntroduction();
			counterTerrorist.printHealth();
			
			// finally, add them to the list
			// Hint: Look at ArrayList's methods in the documentation for
			// 	a method you can use to *add* elements to an ArrayList.
			
			counterTerrorists.add(counterTerrorist);
		}
		
		// Line Break for Output Readability
		System.out.println("");
		
		// Print how many Counter Terrorists are in the game
		
		CounterTerrorist.printActorCount();

		// Line Break for Output Readability
		System.out.println("");
		
		/*
		 * Create the Terrorists
		 */
		// Hint: If you made the CTs, this should all look familiar
		
		Stack<String> TNames = new Stack<String>();
		
		// *Push* the following names onto the stack
		// Names: Carlos, Tim, Sven, Zheng
		
		TNames.push("Carlos");
		TNames.push("Tim");
		TNames.push("Sven");
		TNames.push("Zheng");
		
		// Create an ArrayList of Ts
		
		ArrayList<Terrorist> terrorists = new ArrayList<Terrorist>();
		
		// Fill the ArrayList with Terrorists
		while(!TNames.empty()) {
			// Choose a random Weapon from the Weapons enum
			// Hint: Enums can be made into an array, which has a length variable
			
			weapon = weapons[rand.nextInt(3)];
			
			// Choose a random location between (0,0) and (10,10)
			
			x = rand.nextInt(10);
			y = rand.nextInt(10);
			
			// Create a new Terrorist with the above Weapon and location
			
			terrorist = new Terrorist(TNames.pop(), weapon, x, y);
			
			// then print general info about the new Terrorist
			
			terrorist.printIntroduction();
			terrorist.printHealth();
			
			// finally, add them to the list
			
			terrorists.add(terrorist);
		}
		
		// Line Break for Output Readability
		System.out.println("");

		// Print how many Terrorists are in the game
		
		Terrorist.printActorCount();
		
		// Line Break for Output Readability
		System.out.println("");

		// Start Round
		System.out.println("3...2...1...Get to the bomb site!\n");
		
		// While both sides have at least one living player, fight
		while((Terrorist.getLivingCount() > 0) && (CounterTerrorist.getLivingCount() > 0)) {
			
			int chanceToShoot = rand.nextInt(100);
			int ctAtIndex = rand.nextInt(counterTerrorists.size());
			int tAtIndex = rand.nextInt(terrorists.size());
			// Hint: You can use a method to get the number of elements
			//	in an ArrayList
			
			// 60% chance the Counter Terrorist gets to shoot
			if(chanceToShoot < 60) {
				// Only living players can shoot
				// Hint: You can grab an element from an ArrayList by its
				// 	index using an easy to remember method
				if(counterTerrorists.get(ctAtIndex).getAlive()) {
					// Counter Terrorist shoots the Terrorist
					
					counterTerrorists.get(ctAtIndex).shoot(terrorists.get(tAtIndex));

					// Line Break for Output Readability
					System.out.println("");
				}
			// Otherwise, the Terrorist gets to shoot
			} else {
				// Only living players can shoot
				if(terrorists.get(tAtIndex).getAlive()) {
					// Terrorist shoots the Counter Terrorist
					
					terrorists.get(tAtIndex).shoot(counterTerrorists.get(ctAtIndex));
					
					// Line Break for Output Readability
					System.out.println("");
				}
			}
		}

		// The round has ended
		System.out.println("Round Over.\n");
		// Print number of Counter Terrorists and Terrorists left alive
		CounterTerrorist.printLivingCount();
		Terrorist.printLivingCount();
		
		// Determine who won the game and print the winning message accordingly
		if( CounterTerrorist.getLivingCount() > 0 ) {
			System.out.println("\nYAY!!!!! Counter Terrorists Won!\n");
		} else {
			System.out.println("\nYUCK!!!!! Terrorists Won! Better Luck Next Time!\n");
		}
		
		// Print each Counter Terrorist's health
		// Hint: Use an iterator
		// http://www.java-samples.com/showtutorial.php?tutorialid=235
		
		itr = counterTerrorists.iterator();
		while(itr.hasNext()){
			Object element = itr.next();
			((CounterTerrorist) element).printHealth();
			
		}

		// Line Break for Output Readability
		System.out.println("");
		
		// Print each Terrorist's health
		// Hint: Look at the iterator above
		
		itr = terrorists.iterator();
		while(itr.hasNext()){
			Object element = itr.next();
			((Terrorist) element).printHealth();
			
		}
	}
}
