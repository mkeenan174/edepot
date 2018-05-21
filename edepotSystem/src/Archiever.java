/**
*The status checker for the edepot system which checks each work schedule and changes its ststus with the passing of time
* 
*
* @author  cmpmkeen
* @since   2018-04-23
*/

import java.time.LocalDate;
import java.util.LinkedList;

import edepotSystem.Depot;
import edepotSystem.Driver;
import edepotSystem.Status;
import edepotSystem.WorkSchedule;

public class Archiever implements Runnable{
	
	
	public void run(){
		
		while(true){
			statusChecker();
		}
		
	}
	/**
	 * This checks through the resources available in a selected depot for the driver assigned to a work schedule 
	 * and checks status of the schedule to see if it is pending, this operation the checks the start date of the schedule against the current date
	 * if the current date is after or equal to the current date and if so it switches the schedule to active 
	 */
	public synchronized void statusChecker(){
		System.out.println("Checking.....");
		for(Depot selectedDepot : edepotSys.getDepotList()){
			for(Driver selectedDriver : selectedDepot.getAssignedDrivers()){
				for(WorkSchedule selectedSchedule : selectedDriver.getMySchedules()){
					if(selectedSchedule.getStatus().equals(Status.pending)  && selectedSchedule.getStartDate().isBefore(LocalDate.now())){
						selectedSchedule.setActive();
						System.out.println(selectedSchedule.getClient() +" -Set Active");
					}
					/**
					 * This operation like the one above checks the selected depot for work schedules but this one looks for active status schedules
					 * Then it checks the end date of these schedules against the current date and if the end date is before the end date then it archives the schedule 
					 */
					if(selectedSchedule.getStatus().equals(Status.active) &&  selectedSchedule.getEndDate().isBefore(LocalDate.now())){
						selectedSchedule.setArchived();
						System.out.println(selectedSchedule.getClient() +" -Archived");
					}
			}
		}
			try{
			Thread.sleep(100000);
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	

	}
}
