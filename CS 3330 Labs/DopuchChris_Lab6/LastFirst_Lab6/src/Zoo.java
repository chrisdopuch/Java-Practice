/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/*
Why were some of the classes and attributes final? - We’re looking for your reasoning behind it to try and see if you understand final’s usefulness.
a final class is a class that can't be extended, so it is good for a class that will never have any child objects. The final attributes were used so that they can't be changed later on in the code

Why were some methods abstract in the parent instead of implemented in the parent class?  
- Again, we aren’t looking for a “right answer,” we’re looking to see your reasoning and understanding of the abstract concept.
sometimes the methods do different things in the children classes, but they need to be accessed at the superclass level, like printInformation()
*/
/* Imports */
import java.util.*;

//class declaration
public class Zoo {
	//main
	public static void main(String[] args) {
		//attributes
		ArrayList<Mammal> animals; //array list of mammals
		Random rand; //randomizer
		
		//print welcome message
		System.out.println("Hello Visitor, Welcome to the Zoo!\n");
			
		//make animals a new array list
		animals = new ArrayList<Mammal>();
		
		//add one of each kind of animal
		animals.add(new Gorilla(2, false, true));
		animals.add(new Chimp(1, true, true));
		animals.add(new Tiger(5, false, "Bengal"));
		animals.add(new Lion(2, true, true));
		animals.add(new Weimaraner(1, true, Weimaraner.ESIZE.small));
		animals.add(new GrayFox(3, true, "Southern California"));
		animals.add(new Gorilla(2, false, false));
		animals.add(new Chimp(1, true, false));
		animals.add(new Tiger(5, false, "Siberia"));
		animals.add(new Lion(2, true, false));
		animals.add(new Weimaraner(1, true, Weimaraner.ESIZE.large));
		animals.add(new GrayFox(3, true, "Arizona"));
		
		//print message
		System.out.println("Below are the facts about some of our animals:\n");
		
		//initialize randomizer
		rand = new Random();
		
		//print the facts on 5 random animals
		for (int i = 0; i < 5; i++) {
			int randomIndex = rand.nextInt(animals.size());
			
			/* Print all the facts about the animal based on a random array index
			 * Look at Lab 4 and 5 Solution if you get lost
			 * Hint: Missing a SINGLE line of code
			 */
			
			//randomly pick a mammal and call their print info function
			animals.get(randomIndex).printInformation();
			
			System.out.println();
		}
		
		System.out.println("Hope you had a good day at the zoo. Come back soon! :)");
	}
}
