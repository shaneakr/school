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
		
		
		
		return shipNode;
	} 
}


