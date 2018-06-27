import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class World extends Thing{
	private PortTime time;
	private ArrayList<SeaPort> ports = new ArrayList<SeaPort>();
	
	public World() {
		super(new Scanner("TheWorld 1 0"));
	}
	
	public void addPort(SeaPort port) {
		ports.add(port);
	}
	
	
	public String toString() {
		String string = ">>>>> The world:\n";
		for (SeaPort port : ports) {
			string += "\n\n\n" + port.toString();
		}
		return string;
	}

	public ArrayList<Thing> searchByIndex(int index) {
		ArrayList<Thing> results = new ArrayList<Thing>();
		
		for (SeaPort port : ports) {
			// if the port matches, add it to the results
			if (port.getIndex() == index) {
				results.add(port);
			}
			
			// search all things in this port, and add matches to the results
			ArrayList<Thing> portSearchResults = port.searchByIndex(index);
			results.addAll(portSearchResults);
		}
		
		return results;
	}

	public ArrayList<Thing> searchByName(String name) {
		ArrayList<Thing> results = new ArrayList<Thing>();
		
		for (SeaPort port : ports) {
			// if the port matches, add it to the results
			if (port.getName() == name) {
				results.add(port);
			}
			
			// search all things in this port, and add matches to the results
			ArrayList<Thing> portSearchResults = port.searchByName(name);
			results.addAll(portSearchResults);
		}
		
		return results;
		
	}

	public ArrayList<Thing> searchBySkill(String skill) {
		ArrayList<Thing> results = new ArrayList<Thing>();
		
		for (SeaPort port : ports) {			
			// search all things in this port, and add matches to the results
			ArrayList<Thing> portSearchResults = port.searchBySkill(skill);
			results.addAll(portSearchResults);
		}
		
		return results;
		
	}
	
	public void sort(String thingString, String choiceString) {
        if(thingString.equals("Queue")) {
        		System.out.println(choiceString);

        		switch (choiceString) {
        		case "Name":
        			for(SeaPort port : ports) {
        				ArrayList <Ship> queue = port.getQueue();
            			Collections.sort(queue, new ThingNameComparator());
            			System.out.println(queue);
        			}
        			break;
        		
        		case "Weight":
        			for (SeaPort port : ports) {
        				ArrayList <Ship> queue = port.getQueue();
            			Collections.sort(queue, new SortByWeightComparator());
        			}
        			break;
        		
        		case "Length":
        			for (SeaPort port : ports) {
        				ArrayList <Ship> queue = port.getQueue();
            			Collections.sort(queue, new SortByLengthComparator());
        			}
        			break;
        			
        		case "Width":
        			for (SeaPort port : ports) {
        				ArrayList <Ship> queue = port.getQueue();
            			Collections.sort(queue, new SortByWidthComparator());
        			}
        			break;
        			
        		case "Draft":
        			for (SeaPort port : ports) {
        				ArrayList <Ship> queue = port.getQueue();
            			Collections.sort(queue, new SortByDraftComparator());
        			}
        			break;
        			
        		default:
        			break;
        		}
        }
        if(!thingString.equals("Queue")) {
        		switch(thingString) {
        		case "Port":
        			Collections.sort(ports, new ThingNameComparator());
        			break;
        		case "Dock":
        			for (SeaPort dock : ports) {
        				ArrayList <Dock> docks = dock.getDocks();
            			Collections.sort(docks, new ThingNameComparator());
        			}
        			break;
        		case "Person":
        			for (SeaPort person : ports) {
        				ArrayList <Person> people = person.getPeople();
            			Collections.sort(people, new ThingNameComparator());
        			}
        			break;
        		
        		case "Ship":
        			for(SeaPort ship : ports) {
        				ArrayList <Ship> ships = ship.getShips();
            			Collections.sort(ships, new ThingNameComparator());
        			}
        		case "Job":
        			
        			break;
        		}
        }
	}
}
