/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public abstract class Feline extends Mammal{
	//atributes
	protected final boolean hasPride;
	
	//constructors
	public Feline() {
		//call super constructor
		super();
		//set if it has a pride
		this.hasPride = false;
	}
	
	public Feline(int furThickness, boolean hasPride) {
		//call super constructor
		super(furThickness);
		//set if it has a pride
		this.hasPride = hasPride;
	}
	
	//method to return if the object has a pride
	public boolean getHasPride() {
		return this.hasPride; 
	}
	
	//method to display information on grooming
	public void groom() {
		System.out.println("Felines groom themselves and others using their tounge. If a feline has no pride it must groom itself. Does this feline enjoy the grooming of a pridemate? "+this.getHasPride()+".");
	}
	
	
	//abstract methods
	public abstract void printInformation();
	public abstract void stayWarm();
}
