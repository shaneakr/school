/**
@filename: SortByWidthComparator.java
@date: 7/1/18
@author skingroberson
@purpose: sorts ships by width
**/
import java.util.Comparator;

public class SortByWidthComparator  implements Comparator<Ship> {

	public int compare(Ship ship1, Ship ship2) {
		// TODO Auto-generated method stub
		if(ship1.getWidth() < ship2.getWidth()) {
			return -1;
		}
		else if (ship1.getWidth() >ship2.getWidth()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	
}
