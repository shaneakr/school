/**
@filename: SortByLengthComparator.java
@date: 7/1/18
@author skingroberson
@purpose: Sorts ships by Length
**/

import java.util.Comparator;

public class SortByLengthComparator  implements Comparator<Ship> {

	public int compare(Ship ship1, Ship ship2) {
		// TODO Auto-generated method stub
		if(ship1.getLength() < ship2.getLength()) {
			return -1;
		}
		else if (ship1.getLength() >ship2.getLength()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	
}
