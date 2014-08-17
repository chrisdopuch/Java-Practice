/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public final class Chimp extends Primate {
	//attributes
	private final boolean bornInWild;

	//constructors
	public Chimp() {
		//call the super constructor
		super();
		//set if it was born in the wild to default of false
		this.bornInWild = false;
	}
	
	public Chimp(int furThickness, boolean canBrachiates, boolean bornInWild) {
		//call the super constructor
		super(1, canBrachiates);
		//set born in the wild
		this.bornInWild = bornInWild;
	}

	//method to return if the chimp was born in the wild
	public boolean getBornInWild() { return this.bornInWild; }
	
	//method to print the info messages
	public void printInformation() {
		this.stayWarm();
		this.useThumbs();
		this.takeOverTheWorld();
	}
	
	//method to print info message on staying warm
	public void stayWarm() {
		System.out.println("The chimp stays warm by living in a warm environment. It has a fur thickness of "+this.getFurThickness()+".");
	}
	
	//method to print info message on thumbs
	public void useThumbs() {
		System.out.println("The chimp uses its thumbs to help it swing through trees and use tools when hunting and eating. Can the chimp brachiate? "+this.getCanBrachiates()+".");
	}
	
	//method to print info message on world takeover
	private void takeOverTheWorld() {
		System.out.println("A chimp born in captivity has the uncanny ability to greatly increase its intellect through drug use, leading to it taking over the world. Once the process has started, it cannot be stopped. Will this chimp bring upon the downfall of humanity? "+!(this.getBornInWild())+".");
	}
}
