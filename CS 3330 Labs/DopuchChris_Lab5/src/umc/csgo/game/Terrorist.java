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
public class Terrorist extends Player{
	
	/* UML
	 * --Class-------------
	 * 
	 *   Terrorist
	 * 
	 * --Attributes--------
	 * 
	 * - terroristLivingCount:int (static default=0)
	 * 
	 * --Methods-----------
	 * 
	 * c Terrorist()
	 * c Terrorist(String)
	 * c Terrorist(String,EWEAPON)
	 * c Terrorist(String,EWEAPON,int,int,Map)
	 * + printIntroduction():void
	 * + getLivingCount():int
	 * # incLivingCount():void
	 * # decLivingCount():void
	 * + getTerroristLivingCount():int (static)
	 * - incTerroristLivingCount():void (static)
	 * - decTerroristLivingCount():void (static)
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
	
	private static int terroristLivingCount = 0;
	
	/* Constructor */
	
	public Terrorist(){
		super();
		this.incLivingCount();
		this.printIntroduction();
	}
	
	public Terrorist(String name){
		super(name);
		this.incLivingCount();
		this.printIntroduction();
	}
	
	public Terrorist(String name, EWEAPON weapon){
		super(name, weapon);
		this.incLivingCount();
		this.printIntroduction();
	}
	
	public Terrorist(String name, EWEAPON weapon, int x, int y, Map map){
		super(name, weapon, x, y, map);
		this.incLivingCount();
		this.printIntroduction();
	}
	
	/* Getters and Setters - Instanced */
	
	//method to get living count of this subclass
	//input none, output living count int
	@SuppressWarnings("static-access")
	public int getLivingCount(){
		return this.getTerroristLivingCount();
	}
	
	/* Getters and Setters - Static */
	
	/* Methods - Instanced */
	
	//method to print introduction
	//input none, output void
	public void printIntroduction(){
		System.out.println("Terrorist "+this.getName()+" has entered the game.");
	}
	
	//method to increment living count of this subclass by 1
	//input none, output void
	@SuppressWarnings("static-access")
	protected  void incLivingCount(){
		this.incTerroristLivingCount();
	}
	
	//method to decrement living count of this subclass by 1
	//input none, output void
	@SuppressWarnings("static-access")
	protected  void decLivingCount(){
		this.decTerroristLivingCount();
	}
	
	/* Methods - Static */
	
	//method to return the living count of the class terrorist
	//input none, output int
	public static int getTerroristLivingCount(){
		return Terrorist.terroristLivingCount;
	}
	
	//method to increase living terrorists by 1
	//input none, output void
	private static void incTerroristLivingCount(){
		Terrorist.terroristLivingCount++;
	}
	
	//method to increase living terrorists by 1
	//input none, output void
	private static void decTerroristLivingCount(){
		Terrorist.terroristLivingCount--;
	}
	
	
	/* Methods - Abstract */

}
