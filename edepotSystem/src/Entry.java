import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import edepotSystem.Depot;
import edepotSystem.Driver;
import edepotSystem.Vehicle;

public class Entry {
/**
 * The methods on this page are used for creating the methods that the systems needs to work, the few lines here at the top create the threads for the overall system that the users interact with edepotsys
 * and the thread for the archiver which works in the background in real time as the user uses the system, the two threads need to run in parallel with each other so that the systemn can check on the status
 * of workschedules whilst the user is online so the user does not have to be regularly stopped from using the system whilst it checks the system  
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		edepotSys edepot = new edepotSys();
		Archiever A = new Archiever();
		
		Thread t1 = new Thread(edepot);
		Thread t2 = new Thread(A);
		/**
		 * the executors below run the threads mentioned above after a regular set delay of a couple of seconds at a time
		 */
		ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
		es.scheduleWithFixedDelay(t1, 0, 2, TimeUnit.SECONDS);
		es.scheduleWithFixedDelay(t2, 2,  10, TimeUnit.SECONDS);
		
	
		
	}

}
