/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 4/3/13
 */

package entities;

//this is an abstract class that is implemented by the Worker and Job classes
public abstract class Entity extends Object {
	/*
	 * Attributes
	 */
	int id;
	
	/*
	 * constructor
	 */
	public Entity(){
		
	}
	
	/*
	 * abstract methods
	 */
	public abstract int getId();
	
	protected abstract void setId(int id);
	
	public abstract void print();
}
