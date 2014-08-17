/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 2/27/2013
 */

package umc.csgo.game;

/* Imports */
import java.util.*;

public abstract class Actor extends Object{
	
	/* UML
	 * --Class-------------
	 * 
	 *   Actor (Abstract)
	 * 
	 * --Attributes--------
	 * 
	 * - x:int
	 * - y:int
	 * - map:Map
	 * - actorCount:int (static default=0)
	 * 
	 * --Methods-----------
	 * 
	 * c Actor()
	 * c Actor(int,int)
	 * c Actor(int,int,Map)
	 * 
	 * # setX(int):void
	 * + getX():int
	 * # setY(int):void
	 * + getY():int
	 * # setMap(Map):void
	 * + getMap(Map):void
	 * + getActorCount():int (static)
	 * # incActorCount():void (static)
	 * # decActorCount():void (static)
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * Functions:
	 * 	# setX(int):void
	 * 		Checks to make sure the provided x
	 * 		exists within the confines of the map,
	 * 		constraining x between 0 and the map's
	 * 		width
	 * 
	 * 	# setY(int):void
	 * 		Checks to make sure the provided y
	 * 		exists within the confines of the map,
	 * 		constraining y between 0 and the map's
	 * 		height
	 * 
	 * 	# incActorCount:void (static)
	 * 		Increments the actorCount by 1
	 * 
	 * 	# decActorCount:void (static)
	 * 		Decrements the actorCount by 1
	 */

	/* Attributes - Instanced */
	private int x;
	private int y;
	private Map map;
	
	/* Attributes - Static */
	private static int actorCount = 0;
	
	/* Constructors */
	public Actor(){
		this.setMap(Map.MEDIUM);
		this.setX(0);
		this.setY(0);
	}
	
	/* overloaded constructors */
	public Actor(int x, int y){
		this.setMap(Map.MEDIUM);
		this.setX(x);
		this.setY(y);
	}
	
	public Actor(int x, int y, Map map){
		this.setMap(map);
		this.setX(x);
		this.setY(y);
	}
	/* Getters and Setters - Instanced */
	
	//method to set x coordinate
	//input x value, sets x of this object
	protected void setX(int x){
		if(0 <= x  && x <= this.getMap().getWidth()){
			this.x = x;
		}
		else if (x < 0){
			this.x = 0;
		}
		else {
			this.x = this.getMap().getWidth();
		}
		
	}
	
	//method to set Y coordinate
	//input y value, sets y of this object
	protected void setY(int y){
		if(0 <= y  && y <= this.getMap().getHeight()){
			this.y = y;
		}
		else if (y < 0){
			this.y = 0;
		}
		else {
			this.y = this.getMap().getHeight();
		}
		
	}
	
	//method to get x coordinate of object
	//input none, output int x
	public int getX(){
		return this.x;
	}
	
	//method to get y coordinate of object
	//input none, output int y
	public int getY(){
		return this.y;
	}
	
	//method to set map of object
	//input map, sets to that map
	protected void setMap(Map map){
		this.map = map;
	}
	
	//method to set map of object
	//input map, sets to that map
	public Map getMap(){
		return this.map;
	}
	
	/* Getters and Setters - Static */
	
	//method to get number of actors
	//input none, returns int actorCount
	public static int getActorCount(){
		return Actor.actorCount;
	}
	
	//method to increment actor count by one
	//inut none, output void
	protected static void incActorCount(){
		Actor.actorCount++;
	}
	
	//method to decrement the actor count of this class
	//input none, output void
	protected static void decActorCount(){
		Actor.actorCount--;
	}
	/* Methods - Instanced */
	
	/* Methods - Static */
	
	/* Methods - Abstract */

}
