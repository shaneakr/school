/**
@filename: Ship.java
@date: 7/1/18
@author skingroberson
@purpose: Defines Ship
**/
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;

public class Ship extends Thing{
	private PortTime arrivalTime, dockTime;
	private double draft, length, weight, width;
	private ArrayList <Job> jobs = new ArrayList <Job>();

	public Ship (Scanner scanner) {
			super(scanner);
			if(scanner.hasNextDouble()) {
				weight = scanner.nextDouble();
			}
			if(scanner.hasNextDouble()) {
				length = scanner.nextDouble();
			}
			if(scanner.hasNextDouble()) {
				width = scanner.nextDouble();
			}
			if(scanner.hasNextDouble()) {
				draft = scanner.nextDouble();
			}
	}
	
	public String toString() {
		String string = String.format ("%s %10.2f D %10.2f L %10.2f W %10.2f", 
	             name, draft, length, weight, width);
		return string;
	}
	public double getLength() {
		return length;
	}
	public double getWeight() {
		return weight;
	}
	public double getWidth() {
		return width;
	}
	public double getDraft() {
		return draft;
	}

	public DefaultMutableTreeNode createTree() {
		DefaultMutableTreeNode shipNode = new DefaultMutableTreeNode(name);
		
		for(Job job : jobs) {
			DefaultMutableTreeNode jobNode = new DefaultMutableTreeNode(job.getName());
			shipNode.add(jobNode);
		}
		
		return shipNode;
	}

	public void addJob(Job job) {
		jobs.add(job);
	}

	public void addJobTableRows(String portName, String dockName, ArrayList<RowData> tableRows) {
		for (Job job : jobs) {
			tableRows.add(new RowData(portName, dockName, name, job));
		}
	}

	public void findPeopleForJobs(SeaPort port) {
		for (Job job : jobs) {
			// if the job is not canceled or done
			String status = job.getStatus();
			if (status.equals("Waiting")) {
				
				// if there are no people in the port at all with the required skill
				if (port.noPeopleWithSkillForJob(job)) {
					// cancel the job
					job.cancel();
				}
				
				// find an available person with the required skill
				Person person = port.findPersonForJob(job);
				
				// if we find a person
				if (person != null) {
					// start the job
					job.dock(person);
				}
			}
		}
	}

	public boolean areAllJobsDone() {
		boolean done = true;
		
		for (Job job : jobs) {
			if (!job.isComplete() ) {
				done = false;
			}
		}
		
		return done;
	}
}


