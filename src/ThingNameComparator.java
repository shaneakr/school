import java.util.Comparator;
public class ThingNameComparator implements Comparator <Thing>{

	@Override
	public int compare(Thing thing1, Thing thing2) {
		return thing1.getName().compareToIgnoreCase(thing2.getName());
	}
	
}
