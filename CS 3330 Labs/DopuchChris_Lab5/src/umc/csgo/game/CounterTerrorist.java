/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

package umc.csgo.game;

/* Imports */
import java.util.*;

@SuppressWarnings("unused")
public class CounterTerrorist extends Player{
	
	/* UML
	 * --Class-------------
	 * 
	 *   CounterTerrorist
	 * 
	 * --Attributes--------
	 * 
	 * - counterTerroristLivingCount:int (static default=0)
	 * 
	 * --Methods-----------
	 * 
	 * c CounterTerrorist()
	 * c CounterTerrorist(String)
	 * c CounterTerrorist(String,EWEAPON)
	 * c CounterTerrorist(String,EWEAPON,int,int,Map)
	 * + printIntroduction():void
	 * + getLivingCount():int
	 * # incLivingCount():void
	 * # decLivingCount():void
	 * + getCounterTerroristLivingCount():int (static)
	 * - incCounterTerroristLivingCount():void (static)
	 * - decCounterTerroristLivingCount():void (static)
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * HINT: Remember to use super!
	 * 
	 * Functions:
	 * 	+ printIntroduction():void
	 * 		Prints the player introduction, visible in the
	 * 		output provided
	 * 
	 * 	+ getLivingCount():int
	 * 		Returns this class's living count
	 */

	/* Attributes - Instanced */
	
	/* Attributes - Static */
	
	private static int counterTerroristLivingCount = 0;
	
	/* Constructor */
	
	public CounterTerrorist(){
		super();
		this.incLivingCount();
		this.printIntroduction();
	}
	
	public CounterTerrorist(String name){
		super(name);
		this.incLivingCount();
		this.printIntroduction();
	}
	
	public CounterTerrorist(String name, EWEAPON weapon){
		super(name, weapon);
		this.incLivingCount();
		this.printIntroduction();
	}
	
	public CounterTerrorist(String name, EWEAPON weapon, int x, int y, Map map){
		super(name, weapon, x, y, map);
		this.incLivingCount();
		this.printIntroduction();
	}
	
	/* Getters and Setters - Instanced */
	
	//method to get living count of this subclass
	//input none, output living count int
	@SuppressWarnings("static-access")
	public int getLivingCount(){
		return this.getCounterTerroristLivingCount();
	}
	
	/* Getters and Setters - Static */
	
	/* Methods - Instanced */
	
	//method to print introduction
	//input none, output void
	public void printIntroduction(){
		System.out.println("Counter Terrorist "+this.getName()+" has entered the game.");
	}
	
	//method to increment living count of this subclass by 1
	//input none, output void
	@SuppressWarnings("static-access")
	protected  void incLivingCount(){
		this.incCounterTerroristLivingCount();
	}
	
	//method to decrement living count of this subclass by 1
	//input none, output void
	@SuppressWarnings("static-access")
	protected  void decLivingCount(){
		this.decCounterTerroristLivingCount();
	}
	
	/* Methods - Static */
	
	//method to return the living count of the class counter terrorist
	//input none, output int
	public static int getCounterTerroristLivingCount(){
		return CounterTerrorist.counterTerroristLivingCount;
	}
	
	//method to increase living counter terrorists by 1
	//input none, output void
	private static void incCounterTerroristLivingCount(){
		CounterTerrorist.counterTerroristLivingCount++;
	}
	
	//method to increase living counter terrorists by 1
	//input none, output void
	private static void decCounterTerroristLivingCount(){
		CounterTerrorist.counterTerroristLivingCount--;
	}
	
	
	/* Methods - Abstract */

}
