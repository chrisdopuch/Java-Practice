/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 4/3/13
 */

package enums;

public enum ExperienceLevel {
	/*
	 * enums
	 */
	SENIOR(1),
	MID(2),
	ENTRY(3);
	
	/*
	 * attributes 
	 */
	int timeMultiplier;
	
	/*
	 * constructor
	 */
	private ExperienceLevel(int timeMultiplier){
		this.timeMultiplier = timeMultiplier;
	}
	
	/*
	 * methods
	 */
	public int getTimeMultiplier(){
		return this.timeMultiplier;
	}
}
