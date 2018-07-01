/**
@filename: CargoShip.java
@date: 7/1/18
@author skingroberson
@purpose: defines cargo ship
**/
import java.util.Scanner;

public class CargoShip extends Ship{
	private double cargoValue, cargoVolume, cargoWeight;

	public CargoShip(Scanner scanner) {
		super(scanner);
		if(scanner.hasNextDouble()) {
			cargoValue = scanner.nextDouble();
		}
		if(scanner.hasNextDouble()) {
			cargoVolume = scanner.nextDouble();
		}
		if(scanner.hasNextDouble()) {
			cargoWeight = scanner.nextDouble();
		}
		
	}
	public String toString() {
		String string = "Cargo Ship: " + super.toString();
		return string;
	}

}
