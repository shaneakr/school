/**
@filename: Dock.java
@date: 7/1/18
@author skingroberson
@purpose: functionality for Dock
**/
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;

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

	public DefaultMutableTreeNode createTree() {
		DefaultMutableTreeNode dockNode = new DefaultMutableTreeNode(name);
		
		dockNode.add(ship.createTree());
		
		return dockNode;
	}

	public void addJobTableRows(String portName, ArrayList<RowData> tableRows) {
		ship.addJobTableRows(portName, name, tableRows);
	}

	public void dockShip() {
		if (ship != null) {
			ship.dock();
		}
	}

	public boolean readyForNewShip() {
		return (ship != null) && ship.areAllJobsDone();
	}

	public Ship getShip() {
		return ship;
	}
}
