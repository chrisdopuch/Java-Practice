/*
 /*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public abstract class Canine extends Mammal{
	//attributes
	protected final boolean tameable;
	
	//constructors
	public Canine() {
		//call super constructor
		super();
		//set if the canine is tameable
		this.tameable = false;
	}
	
	public Canine(int furThickness, boolean tameable) {
		//call super constructor
		super(furThickness);
		//set if the canine is tameable
		this.tameable = tameable;
	}
	
	//method to return if the canine is tameable
	public boolean getTameable() {
		return this.tameable; 
	}
	
	//abstract methods
	public abstract void printInformation();
	public abstract void stayWarm();
	public abstract void beTrained();
}
