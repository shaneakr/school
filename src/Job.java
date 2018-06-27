import java.util.ArrayList;
import java.util.Scanner;

public class Job extends Thing{
	private double duration;
	private ArrayList <String> requirements = new ArrayList <String> ();
	
	public Job(Scanner scanner) {
		super(scanner);
		if(scanner.hasNext()) {
			duration = scanner.nextDouble();
		}
		while (scanner.hasNext()) {
		    String skill = scanner.nextLine();
		    requirements.add(skill);
		}
	}
	
	public String toString() {
		String string = "Job: " + super.toString() + " " + requirements;
		return string;
	}
}
