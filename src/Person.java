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
}
