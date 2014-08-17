/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public abstract class Primate extends Mammal{
	//atributes
	protected final boolean canBrachiates;
	
	//constructors
	public Primate() {
		//call super constructor
		super();
		//set if it can brachiate
		this.canBrachiates = false;
	}
	
	public Primate(int furThickness, boolean canBrachiates) {
		//call super constructor
		super(furThickness);
		//set if it can brachiate
		this.canBrachiates = canBrachiates;
	}
	
	//method to return if the primate can brachiate
	public boolean getCanBrachiates() {
		return this.canBrachiates; 
	}
	
	//abstract methods
	public abstract void printInformation();
	public abstract void stayWarm();
	public abstract void useThumbs();
}
