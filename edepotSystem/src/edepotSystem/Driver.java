package edepotSystem;

import java.time.LocalDate;
import java.util.LinkedList;

public class Driver implements Scheduleable{
protected String userName;
protected String Password;
protected LinkedList<WorkSchedule> mySchedules;
protected boolean update;


	public Driver(String userName, String Password, LinkedList<WorkSchedule> mySchedules) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.Password = Password;
		this.mySchedules = mySchedules;
		this.update = false;
	}
	
	// gets user name 
	public String getUserName(){
		return userName;
	}
	//gets password
	public String getPassword(){
		return Password;
	}
	//gets linked list of work schedules
	public LinkedList<WorkSchedule> getMySchedules(){
		return mySchedules;
	}
	//Password check against the one stored in the system
	public boolean checkPassword(String P){
		if (Password.equals(P)  ){
			return true ;
		}
		else {
		return false;	
		}
		
	}
	//Checks to see if the dates are conflicting with any current jobs and checks the dates are valid, start date is before end date
	public boolean isFree(LocalDate startDate, LocalDate endDate){
		for (WorkSchedule selectedSchedule : mySchedules ){
				if(startDate.isAfter(selectedSchedule.getStartDate()) && startDate.isBefore(selectedSchedule.getEndDate())){
					return false;
				}
				if(endDate.isAfter(selectedSchedule.getStartDate()) && endDate.isBefore(selectedSchedule.getEndDate())){
					return false;
				}
				if(startDate.isBefore(selectedSchedule.getStartDate()) && endDate.isAfter(selectedSchedule.getEndDate())){
					return false;
				}
				if(startDate.isAfter(selectedSchedule.getStartDate()) && endDate.isBefore(selectedSchedule.getEndDate())){
					return false;
				}
				if(startDate.equals(selectedSchedule.getStartDate()) || startDate.equals(selectedSchedule.getEndDate())){
					return false;

				}
				if(endDate.equals(selectedSchedule.getStartDate()) || endDate.equals(selectedSchedule.getEndDate())){
					return false;

				}
				
			
		}
		
		return true;
	}
	// Gets all the jobs submitted by a single client
	public WorkSchedule getWorkSchedule(String clientName){
		for(WorkSchedule selectedSchedule : mySchedules){
			if(selectedSchedule.getClient().equals(clientName)){
				return selectedSchedule;
			}
		}
		return null;
	}
	
	
	public void setUpdate(){
		this.update = true;
	}
	
	public boolean  getUpdate(){
		return update;
	}
	
	public void viewUpdates(){
		System.out.println("viewing updates ");
	}

	@Override
	public void setSchedule(WorkSchedule addedSchdedule) {
		// TODO Auto-generated method stub
		mySchedules.add(addedSchdedule);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setMySchedules(LinkedList<WorkSchedule> mySchedules) {
		this.mySchedules = mySchedules;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	
	
}
