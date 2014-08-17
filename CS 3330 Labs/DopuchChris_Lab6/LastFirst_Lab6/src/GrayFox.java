/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public final class GrayFox extends Canine {
	//attributes
	private final String region;

	//constructors
	public GrayFox() {
		//call the super constructor
		super();
		//set the region default of SoCo
		this.region = "Southern California";
	}
	
	public GrayFox(int furThickness, boolean tameable, String region) {
		//call the super constructor
		super(3, tameable);
		//set the region
		this.region = region;
	}

	//method to return the region of the object
	public String getRegion() { return this.region; }
	
	//method to print the info messages
	public void printInformation() {
		this.stayWarm();
		this.beTrained();
		this.dominantSpecies();
	}
	
	//method to print info message on staying warm
	public void stayWarm() {
		System.out.println("The gray fox stays warm by putting on an extra undercoat of fur in the winter as well as putting on fat and sleeping in a den. The gray fox has a fur thickness of "+this.getFurThickness()+".");
	}
	
	//method to print info message on being trained
	public void beTrained() {
		System.out.println("The gray fox is a wild animal but in some occassions has been tamed and trained. Only tameable animals can be trained. Can this canine be trained? "+this.getTameable()+".");
	}
	
	//method to print info message on being the dominant species
	private void dominantSpecies() {
		System.out.println("Though once a more prominant species, the gray fox has been outcompeted in the eastern United States by its cousin the red fox. It is still dominant in the deserts of the southwest, such as arid southern California. This fox was taken in from the "+this.getRegion()+".");
	}
	
}
