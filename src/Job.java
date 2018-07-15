/**
@filename: Job.java
@date: 7/1/18
@author skingroberson
@purpose: functionality for Job
**/
import java.util.ArrayList;
import java.util.Scanner;

public class Job extends Thing implements Runnable {
	private double duration;
	private ArrayList <String> requirements = new ArrayList <String> ();
	private double timeSpent = 0.0;
	private String status = "Waiting";
	private boolean isCanceled = false;
	private Person person;
	private SeaPortProgram gui;
	
	public Job(Scanner scanner, SeaPortProgram gui) {
		super(scanner);
		if(scanner.hasNext()) {
			duration = scanner.nextDouble();
		}
		while (scanner.hasNext()) {
		    String skill = scanner.next();
		    requirements.add(skill);
		}
		
		this.gui = gui;
		
	    new Thread(this, name).start();
	}
	
	public String toString() {
		String string = "Job: " + super.toString() + " " + requirements;
		return string;
	}
	
	public float getProgress() {
		return (float) (timeSpent / duration);
	}
	
	public String getStatus() {
		return status;
	}
	
	public boolean isComplete() {
		return (getProgress() >= 1.0) || isCanceled;
	}
	
	public void dock(Person person) {
		this.person = person;
		status = "Running";
	}
	
	public void cancel() {
		isCanceled = true;
		status = "Canceled";
	}
	
	public void togglePause() {
		if (status == "Paused") {
			status = "Running";
		} else if (status == "Running") {
			status = "Paused";
		}
	}

	@Override
	public void run() {
		while ( (timeSpent < duration) && !isCanceled) {
			long sleepTime = System.currentTimeMillis();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			long wakeTime = System.currentTimeMillis();
		
			if (status == "Running") {
				timeSpent += (wakeTime - sleepTime) / 1000.0;
				gui.refreshTable();
			}
	    }
		
		if (isCanceled) {
			status = "Canceled";
		} else {
			status = "Done!";
		}
		
		if (person != null) {
			person.setAvailable();
		}
		
		// remove job's reference to person
		person = null;
				
		gui.jobDone();
	}

	public ArrayList<String> getSkills() {
		return requirements;
	}
	
	public String getPersonName() {
		if (person != null) {
			return person.getName();
		}
		return "--";
	}
}
