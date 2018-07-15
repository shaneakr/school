/**
@filename: Person.java
@date: 7/1/18
@author skingroberson
@purpose: Defines Person class
**/
import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;

public class Person extends Thing{
	private String skill;
	private Job job;
	
	public Person(Scanner scanner) {
		super(scanner);
		if(scanner.hasNext()) {
			skill = scanner.next();
		}
	}
	
	public String toString() {
		String string = "Person: " + super.toString() + " " + skill;
		return string;
	}

	public String getSkill() {
		return skill;
	}

	public DefaultMutableTreeNode createTree() {
		DefaultMutableTreeNode personNode = new DefaultMutableTreeNode(name);
		return personNode;
	}

	public boolean isBusy() {
		return job != null;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getJobName() {
		if (job != null) {
			return job.getName();
		}
		return "--";
	}

	public void setAvailable() {
		job = null;
	}
}
