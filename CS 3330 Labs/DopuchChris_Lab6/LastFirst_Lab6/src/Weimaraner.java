/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/6/13
 */

/* Imports */

//class declaration
public final class Weimaraner extends Canine {
	//make an enum for the sizes
	public enum ESIZE {
		small,
		medium,
		large;
	}
	
	//attributes
	private final ESIZE size;

	
	//constructors
	public Weimaraner() {
		super();
		this.size = ESIZE.small;
	}
	
	public Weimaraner(int furThickness, boolean tameable, ESIZE size) {
		super(1, tameable);
		this.size = size;
	}
	
	//methods

	//method to return the size of the object
	public ESIZE getSize() { return this.size; }

	//method to print the info messages
	public void printInformation() {
		this.stayWarm();
		this.beTrained();
		this.huntLargeGame();
	}
	
	//method to print info message on staying warm
	public void stayWarm() {
		System.out.println("The weimaraner is a domesticated animal that stays warm by relying on its human master. The weimaraner has a fur thickness of "+this.getFurThickness()+".");
	}
	
	//method to print info message on being trained
	public void beTrained() {
		System.out.println("The weimaraner is inheritntly tame, coming from a long line of german hunting dogs. Only tameable animals can be traind. Is this canine trainable? "+this.getTameable()+".");
	}
	
	//method to print info message on hunting
	private void huntLargeGame() {
		System.out.println("Earlier in their history weimaraners were used to hunt large game such as boars alongside members of the German court. Only the largest such dogs were capable of such a feat, the smaller dogs being used to hunt foxes and rabbits. This dog is a "+this.getSize()+" weimaraner.");
	}
	
}
