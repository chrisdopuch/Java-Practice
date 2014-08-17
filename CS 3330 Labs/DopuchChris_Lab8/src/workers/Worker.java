/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 3/20/13
 */

package workers;

import jobs.*;
import java.util.*;
import enums.*;
import entities.*;


public class Worker extends Entity {

	/*
	 * Attributes
	 */
	String name;
	private int id;
	private Stack<Job> jobQueue;
	private int currentJobStartDay;
	private ExperienceLevel experienceLevel;
	public static int numWorkers;
	
	/*
	 * Constructor
	 */
	public Worker(){
		super();
		Worker.incrementNumWorkers();
		jobQueue = new Stack<Job>();
		this.setId(Worker.getNumWorkers());
		currentJobStartDay = 0;
	}
	
	//overloaded constructors
	public Worker(String name){
		super();
		Worker.incrementNumWorkers();
		jobQueue = new Stack<Job>();
		this.setId(Worker.getNumWorkers());
		currentJobStartDay = 0;
		this.setName(name);
	}
	
	public Worker(String name, ExperienceLevel experienceLevel){
		super();
		Worker.incrementNumWorkers();
		jobQueue = new Stack<Job>();
		this.setId(Worker.getNumWorkers());
		currentJobStartDay = 0;
		this.setName(name);
		this.setExperienceLevel(experienceLevel);
	}
	
	/* methods
	 * 
	 */
	static private void incrementNumWorkers(){
		Worker.numWorkers += 1;
	}
	static public int getNumWorkers(){
		return Worker.numWorkers;
	}
	protected void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	private void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void addJob(Job job){
		this.jobQueue.push(job);
	}
	//method to check if a job has been completed
	public Job checkJobComplete(int daysWorked){
		if(this.currentJobStartDay + (this.jobQueue.peek().getDifficulty().getDaysRequired() * this.getExperienceLevel().getTimeMultiplier()) <= daysWorked)
			//return the job
			return this.jobQueue.pop();
		else
			return null;
	}
	public boolean checkAllJobsComplete(){
		if(this.jobQueue.empty())
			return true;
		else
			return false;
	}
	private void setExperienceLevel(ExperienceLevel experienceLevel){
		this.experienceLevel = experienceLevel;
	}
	public ExperienceLevel getExperienceLevel(){
		return this.experienceLevel;
	}
	public void print(){
		System.out.print(this.getId() + "," + this.getName() + "," + this.getExperienceLevel());
	}

}
