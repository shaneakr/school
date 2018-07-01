/**
@filename: SortByWeightComparator.java
@date: 7/1/18
@author skingroberson
@purpose: Sorts ships by Weight
**/
import java.util.Comparator;

public class SortByWeightComparator  implements Comparator<Ship> {

	public int compare(Ship ship1, Ship ship2) {
		if(ship1.getWeight() < ship2.getWeight()) {
			return -1;
		}
		else if (ship1.getWeight() >ship2.getWeight()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	
}
