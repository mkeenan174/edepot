package edepotSystem;

import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Vehicle implements Scheduleable{
	protected String Make;
	protected String Model;
	protected String regNo;
	protected int Weight;
	protected LinkedList<WorkSchedule> mySchedules;

	//Variables of a vehicle
	public Vehicle(String Make, String Model, String Reg, int weight, LinkedList<WorkSchedule> Schedules){
		this.Make = Make;
		this.Model = Model;
		this.regNo = Reg;
		this.Weight = weight;
		this.mySchedules = Schedules;
		
	}
	
	public String getRegNo(){
		return regNo;
	}
	
	public String getMake(){
		return Make;
	}
	
	public String getModel(){
		return Model;
	}
	
	public int getWeight(){
		return Weight;
	}
	
	public LinkedList<WorkSchedule> getMySchedules(){
		return mySchedules;
	}
	
	public WorkSchedule getWorkSchedule(String clientName){
		for(WorkSchedule selectedSchedule : mySchedules){
			if(selectedSchedule.getClient().equals(clientName)){
				return selectedSchedule;
			}
		}
		return null;
	}
	//checks and validates the dates are free and not  in the incorrect format
	public boolean isFree(LocalDate startDate, LocalDate endDate){
		for (WorkSchedule selectedSchedule : mySchedules ){
			if(startDate.isAfter(selectedSchedule.getStartDate()) && startDate.isBefore(selectedSchedule.getEndDate())){
				break;
			}
			if(endDate.isAfter(selectedSchedule.getStartDate()) && endDate.isBefore(selectedSchedule.getEndDate())){
				break;
			}
			if(startDate.isBefore(selectedSchedule.getStartDate()) && endDate.isAfter(selectedSchedule.getEndDate())){
				break;
			}
			if(startDate.isAfter(selectedSchedule.getStartDate()) && endDate.isBefore(selectedSchedule.getEndDate())){
				break;
			}
			if(startDate.equals(selectedSchedule.getStartDate()) || startDate.equals(selectedSchedule.getEndDate())){
				break;
			}
			if(endDate.equals(selectedSchedule.getStartDate()) || endDate.equals(selectedSchedule.getEndDate())){
				break;
			}
			
			return true;
		}
		
		return false;
	}
	
	
	public boolean moveable(LocalDate moveDate){
		for(WorkSchedule selectedSchedule : mySchedules){
			if(moveDate.isAfter(selectedSchedule.getEndDate())){
				return true;
			}
		
				
		}	
		return false;		
	}
	
	
	@Override
	public void setSchedule(WorkSchedule addedSchdedule) {
		// TODO Auto-generated method stub
		mySchedules.add(addedSchdedule);
	}

	public void setMake(String make) {
		Make = make;
	}

	public void setModel(String model) {
		Model = model;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public void setMySchedules(LinkedList<WorkSchedule> mySchedules) {
		this.mySchedules = mySchedules;
	}
}
