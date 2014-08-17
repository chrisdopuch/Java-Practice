/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public class Tiger extends Feline{
	//attributes
	private final String region;
	
	//constructors
	public Tiger() {
		//call the super constructor
		super();
		//set the region to default of bengal
		this.region = "Bengal";
	}
	
	public Tiger(int furThickness, boolean hasPride, String region) {
		//call the super constructor
		super(5, hasPride);
		//set the region
		this.region = region;
	}

	//methods
	
	//method to return the region of the object
	public String getRegion() { return this.region; }
	
	//method to print the information messages
	public void printInformation() {
		this.stayWarm();
		this.groom();
		this.joinTheCircus();
	}
	
	//method to print info message on staying warm
	public void stayWarm() {
		System.out.println("The tiger stays warm by putting on fat or finding a cave during the winter. The tiger has an average fur thickness of "+this.getFurThickness()+".");
	}
	
	//method to print info message on joining the circus
	private void joinTheCircus() {
		System.out.println("Most familiar of the tigers is the white tiger, made famous by the shows in Las Vegas. Only tigers from the Bengal region have the chance to be born a white tiger. This tiger is from:	"+this.getRegion()+".");
	}
}
