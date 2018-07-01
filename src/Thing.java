/**
@filename: Thing.java
@date: 7/1/18
@author skingroberson
@purpose: defines a Thing
**/
import java.util.Scanner; 
public class Thing implements Comparable<Thing>{
	
	private int index;
	protected String name;
	private int parent;
	
	public Thing(Scanner scanner) {
		if(scanner.hasNext()) 
			name = scanner.next();
		if(scanner.hasNextInt())
			index = scanner.nextInt();
		if(scanner.hasNextInt())
			parent = scanner.nextInt();
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getParent() {
		return parent;
	}
	public String getName() {
		return name;
	}
	
	public int compareTo(Thing thing) {
		if(index == thing.index)
			return 0;
		
		else if(index > thing.index)
			return 1;
		
		else
			return -1;
	}
	
	public String toString () {
		String string = name + " " + index;
		return string;
	}
	
	public String toSimpleString() {
		return this.getClass().getName() + ": " + name + " " + index;
	}
}
