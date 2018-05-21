package edepotSystem;

import java.util.LinkedList;
/**
 * The manager class is an extension of the driver class meaning it does the same as the driver class but is accessed via a different set of user names
 */
public class Manager extends Driver {
	//Extension of the driver class
	public Manager(String userName, String Password, LinkedList<WorkSchedule> schedules) {
		super(userName, Password, schedules);
		// TODO Auto-generated constructor stub
	}

	
	
}
