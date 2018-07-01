/**
@filename: PassangerShip.java
@date: 7/1/18
@author skingroberson
@purpose: Defines Passenger ship
**/
import java.util.Scanner;

public class PassangerShip extends Ship{
	private int numOfOccupiedRooms, numOfPassangers, numOfRooms;
	
	public PassangerShip(Scanner scanner) {
		super(scanner);
		if(scanner.hasNextDouble()) {
			numOfOccupiedRooms = scanner.nextInt();
		}
		if(scanner.hasNextDouble()) {
			numOfPassangers = scanner.nextInt();
		}
		if(scanner.hasNextDouble()) {
			numOfRooms = scanner.nextInt();
		}
		
	}
	public String toString() {
		String string = "Passenger Ship: " + super.toString();
		return string;
	}
}
