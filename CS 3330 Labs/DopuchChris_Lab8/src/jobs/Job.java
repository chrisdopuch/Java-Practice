/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/20/13
 */

package jobs;

import enums.*;
import entities.*;

public class Job extends Entity {

	/*
	 * Attributes
	 */
	private int id;
	private Difficulty difficulty;
	private static int numJobs;
	
	/*
	 * Constructor
	 */
	public Job(){
		super();
		Job.incrementNumJobs();
		this.setId(Job.getNumJobs());
	}
	
	//overloaded constructor
	public Job(Difficulty difficulty){
		super();
		Job.incrementNumJobs();
		this.setId(Job.getNumJobs());
		this.difficulty = difficulty;
	}
	
	/*
	 * methods
	 */
	static private void incrementNumJobs(){
		Job.numJobs += 1;
	}
	static public int getNumJobs(){
		return Job.numJobs;
	}
	public Difficulty getDifficulty(){
		return this.difficulty;
	}
	protected void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void print(){
		System.out.print(this.getId() + "," + this.getDifficulty());
	}
}

