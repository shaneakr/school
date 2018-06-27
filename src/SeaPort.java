import java.util.ArrayList;
import java.util.Scanner;

public class SeaPort extends Thing{
	private ArrayList <Dock> docks = new ArrayList <Dock>();
	private ArrayList <Ship> queue = new ArrayList <Ship>();
	private ArrayList <Ship> ships = new ArrayList <Ship>();
	private ArrayList <Person> persons = new ArrayList <Person>();

	public SeaPort (Scanner scanner) {
		super(scanner);
	}
	
	public void addDock(Dock dock) {
		getDocks().add(dock);
	}
	
	public void addPerson(Person person) {
		persons.add(person);
	}

	public void addShipToQue(Ship ship) {
		queue.add(ship);
		addShip(ship);
	}
	
	public void addShip(Ship ship) {
		ships.add(ship);
	}

	public ArrayList <Dock> getDocks() {
		return docks;
	}
	
	public ArrayList <Ship> getQueue(){
		return queue;
	}
	public ArrayList <Person> getPeople(){
		return persons;
	}
	public ArrayList <Ship> getShips(){
		return ships;
	}
	public String toString() {
		String string = "SeaPort: " + super.toString() + "\n";
		
		for (Dock dock : docks) {
			string += "\n" + dock.toString();
		}
		
		string += "\n\n--- List of all ships in que:\n";
		for (Ship ship : queue) {
			string += "\n  > " + ship.toString();
		}
		
		string += "\n\n--- List of all ships:\n";
		for (Ship ship : ships) {
			string += "\n  > " + ship.toString();
		}

		string += "\n\n--- List of all persons:\n";
		for (Person person : persons) {
			string += "\n  > " + person.toString();
		}

		return string;
	}

	public ArrayList<Thing> searchByIndex(int index) {
		ArrayList<Thing> results = new ArrayList<Thing>();
		
		for (Dock dock : docks) {
			if (dock.getIndex() == index) {
				results.add(dock);
			}
		}
		
		for (Ship ship : ships) {
			if (ship.getIndex() == index) {
				results.add(ship);
			}
		}
		
		for (Person person : persons) {
			if (person.getIndex() == index) {
				results.add(person);
			}
		}
		
		return results;
	}

	public ArrayList<Thing> searchByName(String name) {
		ArrayList<Thing> results = new ArrayList<Thing>();
		
		for (Dock dock : docks) {
			if (dock.getName().equals(name)) {
				results.add(dock);
			}
		}
		
		for (Ship ship : ships) {
			if (ship.getName().equals(name)) {
				results.add(ship);
			}
		}
		
		for (Person person : persons) {
			if (person.getName().equals(name)) {
				results.add(person);
			}
		}
		
		return results;
	}

	public ArrayList<Thing> searchBySkill(String skill) {
		ArrayList<Thing> results = new ArrayList<Thing>();
		
		for (Person person : persons) {
			if (person.getSkill().equals(skill)) {
				results.add(person);
			}
		}
		
		return results;
	}
}
