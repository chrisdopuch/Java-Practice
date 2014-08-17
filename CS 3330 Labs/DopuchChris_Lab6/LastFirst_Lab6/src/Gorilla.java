/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public final class Gorilla extends Primate{
	//attributes
	private boolean isSilverback;

	//constructors
	public Gorilla() {
		//call the super constructor
		super();
		//default silverback false
		this.setIsSilverback(false);
	}
	
	public Gorilla(int furThickness, boolean canBrachiates, boolean isSilverback) {
		//call the super constructor
		super(2, canBrachiates);
		//set if it's a silverback
		this.setIsSilverback(isSilverback);
	}
	
	//method sets if the gorilla's a silver back, input boolean isSilverBack
	private void setIsSilverback(boolean isSilverback) { this.isSilverback = isSilverback; }
	
	//method to return if this gorilla is a silver back
	public boolean getIsSilverback() { return this.isSilverback; }
	
	//method to print the info messages
	public void printInformation() {
		this.stayWarm();
		this.useThumbs();
		this.climbEmpireStateBuilding();
	}
	
	//method to print info message on staying warm
	public void stayWarm() {
		System.out.println("The gorilla puts on fat to stay warm. The gorilla has a fur thickness of "+this.getFurThickness()+".");
	}
	
	//method to print info message on using thumbs
	public void useThumbs() {
		System.out.println("The gorilla uses its thumbs to pick up food and climb trees, but cannot swing through the trees. Can the gorilla brachiate? "+this.getCanBrachiates()+".");
	}
	
	//method to print info message on climbing
	private void climbEmpireStateBuilding() {
		System.out.println("The gorilla's special ability is climbing the Empire State Building and kidnapping beautiful women. Only silverback gorillas have this ability. Can this gorilla get the girl? "+this.getIsSilverback()+".");
	}
}
