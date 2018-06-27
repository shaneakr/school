import java.util.Comparator;

public class SortByDraftComparator  implements Comparator<Ship> {

	public int compare(Ship ship1, Ship ship2) {
		// TODO Auto-generated method stub
		if(ship1.getDraft() < ship2.getDraft()) {
			return -1;
		}
		else if (ship1.getDraft() >ship2.getDraft()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	
}
