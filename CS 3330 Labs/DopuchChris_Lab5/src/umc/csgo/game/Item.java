/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

package umc.csgo.game;

/* Imports */
import java.util.*;

public abstract class Item extends Actor{
	
	/* UML
	 * --Class-------------
	 * 
	 *   Item (Abstract)
	 * 
	 * --Attributes--------
	 * 
	 * - itemCount:int (static default=0)
	 * 
	 * --Methods-----------
	 * 
	 * c Item()
	 * c Item(int,int)
	 * + getItemCount():int (static)
	 * # incItemCount():void (static)
	 * # decItemCount():void (static)
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * Functions:
	 * 	# incItemCount():void
	 * 		Increments the itemCount by 1
	 * 	# decItemCount():void
	 * 		Decrements the itemCount by 1
	 */
	
	/* Attributes - Instanced */
	
	/* Attributes - Static */
	
	private static int itemCount = 0;
	
	/* Constructors */
	
	public Item(){
		super();
		incItemCount();
	}
	
	public Item(int x, int y){
		super(x, y);
		incItemCount();
	}
	
	/* Getters and Setters - Instanced */
	
	/* Getters and Setters - Static */
	
	/* Methods - Instanced */
	
	/* Methods - Static */
	
	//method to increase item count by 1
	//input none, output void
	protected static void incItemCount(){
		Item.itemCount++;
	}
	
	//method to dencrease item count by 1
	//input none, output void
	protected static void decItemCount(){
		Item.itemCount--;
	}
	
	
	//method to return item count
	//input none, output void
	public static int getItemCount(){
		return Item.itemCount;
	}
	
	/* Methods - Abstract */

}
