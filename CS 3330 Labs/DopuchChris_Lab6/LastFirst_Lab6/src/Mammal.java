/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public abstract class Mammal {
	//attributes
	protected final int furThickness;

	//contructors
	public Mammal() {
		//set fur thickness to default of 0
		this.furThickness = 0;
	}
	
	public Mammal(int furThickness) {
		//set fur thickness
		this.furThickness = furThickness;
	}

	//method to return fur thickness
	public int getFurThickness() {
		return this.furThickness; 
	}
	
	//abstract methods
	public abstract void printInformation();
	public abstract void stayWarm();
}
