/*
 * Name: Chris Dopuch
 * Class: CS 3330
 * Lab: B
 * Date: 4/3/13
 */

//package declaration
package run;

//imports
import jobs.*;
import workers.*;
import enums.*;
import java.util.*;
import java.lang.*;

public class Runner {

	public static void main(String[] args) {
		/*
		 * Attributes
		 */
		int daysWorked = 0;
		//arraylists are used for completed jobs/workers and workers because it makes it easy to iterate through them without losing the elements
		//multidimensional arrays are used for completed workers/jobs so I can store info on time completed and the job or worker
		ArrayList completedWorkers  = new ArrayList();
		ArrayList<Worker> workers = new ArrayList<Worker>();
		ArrayList completedJobs = new ArrayList();
		//a stack is used for jobs, as I no longer need the list once the jobs are assigned
		Stack<Job> jobs = new Stack<Job>();
		Job currentJob;
		//I need an iterator for use with the arraylists later
		Iterator iter;
		//random number generator
		Random rand = new Random();
		//boolean flag value for use later in the code
		boolean flag = false;
		//indexes useful for accessing multidimensional arrays
		int workerIndex = 0;
		int jobIndex = 0;
		//list object for use in iteration
		ArrayList list;
		
		System.out.println("STARTING SIMULATION");
		
		System.out.println("Creating Workers...");
		
		//initialize workers
		workers.add(new Worker("Bob", ExperienceLevel.SENIOR));
		workers.add(new Worker("Sally", ExperienceLevel.MID));
		workers.add(new Worker("Matt", ExperienceLevel.MID));
		workers.add(new Worker("Eric", ExperienceLevel.ENTRY));
		workers.add(new Worker("Jen", ExperienceLevel.ENTRY));
		workers.add(new Worker("Frank", ExperienceLevel.ENTRY));
		workers.add(new Worker("Borris", ExperienceLevel.ENTRY));
		
		//print out statements
		for(Worker worker : workers){
			worker.print();
			System.out.println("");
		}
		
		System.out.println("Creating Workers - COMPLETE");
		
		System.out.println("Creating Jobs...");
		
		//initialize jobs
		jobs.push(new Job(Difficulty.EASY));
		jobs.push(new Job(Difficulty.EASY));
		jobs.push(new Job(Difficulty.EASY));
		jobs.push(new Job(Difficulty.EASY));
		jobs.push(new Job(Difficulty.EASY));
		jobs.push(new Job(Difficulty.EASY));
		jobs.push(new Job(Difficulty.EASY));
		jobs.push(new Job(Difficulty.EASY));
		jobs.push(new Job(Difficulty.MEDIUM));
		jobs.push(new Job(Difficulty.MEDIUM));
		jobs.push(new Job(Difficulty.MEDIUM));
		jobs.push(new Job(Difficulty.MEDIUM));
		jobs.push(new Job(Difficulty.MEDIUM));
		jobs.push(new Job(Difficulty.MEDIUM));
		jobs.push(new Job(Difficulty.HARD));
		jobs.push(new Job(Difficulty.HARD));
		
		//print out statements
		for(Job job : jobs){
			job.print();
			System.out.println("");
		}

		System.out.println("Creating Jobs - COMPLETE");
		
		System.out.println("Assigning Jobs...");
		
		//assign jobs to workers
		//do while there are jobs left in the jobs stack
		while(!jobs.empty()){
			//pick a worker at random and assign them the next job
			workers.get(rand.nextInt(workers.size())).addJob(jobs.pop());
		}
		
		System.out.println("Assigning Jobs - COMPLETE");
		
		System.out.println("Simulating Jobs...");
		
		//check if any workers still have jobs remaining to do
		for(Worker worker : workers){
			if(!worker.checkAllJobsComplete())
				flag = true;
		}
		while(flag){
			//do for each worker in the list
			for(Worker worker : workers){
				//if this worker has no jobs, skip to the next worker
				if(worker.checkAllJobsComplete())
					continue;
				//see if the current job is completed
				currentJob = worker.checkJobComplete(daysWorked);
				if(currentJob != null){
					//add the job to the completed jobs list
					completedJobs.add(new ArrayList());
					((ArrayList)completedJobs.get(jobIndex)).add(currentJob);
					((ArrayList)completedJobs.get(jobIndex)).add(worker);
					jobIndex++;
					
					//check if that was their last job to do
					if(worker.checkAllJobsComplete()){
						//add the worker to the completed workers list
						completedWorkers.add(new ArrayList());
						((ArrayList)completedWorkers.get(workerIndex)).add(worker);
						((ArrayList)completedWorkers.get(workerIndex)).add(daysWorked);
						workerIndex++;
					}
				}
			}
			
			//increment days worked
			daysWorked++;
			
			//reset the flag
			flag = false;
			
			//check if any workers still have jobs remaining to do
			for(Worker worker : workers){
				if(!worker.checkAllJobsComplete())
					flag = true;
			}
		}
		
		System.out.println("Simulating Jobs - COMPLETE");
		
		//print out workers finished
		System.out.println("Workers Finished, first to complete to last to complete:");
		iter = completedWorkers.iterator();
		while(iter.hasNext()){
			list = ((ArrayList)iter.next());
			((Worker)list.get(0)).print();
			System.out.print(" - ");
			System.out.print(list.get(1) + " days");
			System.out.println("");
		}
		
		
		//print out jobs finished
		System.out.println("Jobs Completed, most recently completed to least recently completed:");
		iter = completedJobs.iterator();
		while(iter.hasNext()){
			list = ((ArrayList)iter.next());
			((Job)list.get(0)).print();
			System.out.print(" - ");
			((Worker)list.get(1)).print();
			System.out.println("");
		}
		
		System.out.println("END SIMULATION");
	}
	
	

}
