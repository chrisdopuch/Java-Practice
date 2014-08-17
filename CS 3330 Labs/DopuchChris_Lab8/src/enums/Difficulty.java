/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 4/3/13
 */

package enums;

public enum Difficulty {
	/*
	 * Enums
	 */
	EASY(1),
	MEDIUM(2),
	HARD(4);
	
	/*
	 * Attributes
	 */
	private final int daysRequired;
	
	/*
	 * Constructor
	 */
	private Difficulty(int daysRequired){
		this.daysRequired = daysRequired;
	}
	
	/*
	 * Methods
	 */
	public int getDaysRequired(){
		return this.daysRequired;
	}
}
