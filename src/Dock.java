import java.util.Scanner;

public class Dock extends Thing{
	private Ship ship;

	public Dock (Scanner scanner) {
		super(scanner);
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public String toString() {
		String string = "Dock: " + super.toString() + "\n";
		if (ship != null) 
			string += "  Ship: " + ship.toString();
		
		return string;
	}
}
