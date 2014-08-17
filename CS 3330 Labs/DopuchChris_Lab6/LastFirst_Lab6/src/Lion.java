/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public class Lion extends Feline{
	//attributes
	private boolean hasMane;

	//constructors
	public Lion() {
		//call super constructor
		super();
		//set the mane to default of false
		this.setHasMane(false);
	}
	
	public Lion(int furThickness, boolean hasPride, boolean hasMane) {
		//call super constructor
		super(2, hasPride);
		//set the mane
		this.setHasMane(hasMane);
	}

	//methods
	
	//method to set the mane, input boolean hasMane
	private void setHasMane(boolean hasMane) { this.hasMane = hasMane; }
	
	//method to return if this object has a mane
	public boolean getHasMane() { return this.hasMane; }

	//method to print the info messages
	public void printInformation() {
		this.stayWarm();
		this.groom();
		this.rulePrideRock();
	}
	
	//method to print info message on staying warm
	public void stayWarm() {
		System.out.println("The lion stays warm by living in a warm environment and basking in the sun. The lion has a fur thickness of "+this.getFurThickness()+".");
	}
	
	//method to print info message on pride rock
	private void rulePrideRock() {
		System.out.println("African lions have a very special ability allowing them to rule the coveted Pride Rock of legend. Only male lions may rule this location, and only male lions have manes. Can this lion rule Pride Rock? "+this.getHasMane()+".");
	}
}
