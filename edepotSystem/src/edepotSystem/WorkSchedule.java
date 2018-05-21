package edepotSystem;

import java.time.LocalDate;
import java.util.Date;

public class WorkSchedule {
	private String Client;
	private LocalDate startDate;
	private LocalDate endDate;
	private String scheduledDriver;
	private String scheduledVehicle;
	private Status  scheduledStatus;
	// variables of the work schedule
	public WorkSchedule(String Client, LocalDate string, LocalDate string2, String scheduledDriver, String scheduledVehicle){
		this.Client = Client;
		this.startDate = string;
		this.endDate = string2;
		this.scheduledDriver = scheduledDriver;
		this.scheduledVehicle = scheduledVehicle;
		this.scheduledStatus = Status.pending;
		
	}

	public String getClient(){
		return Client;
	}
	
	public LocalDate getStartDate(){
		return startDate;
	}

	public LocalDate getEndDate(){
		return endDate;
	}
	
	public String getScheduledDriver(){
		return scheduledDriver;
	}
	
	public String getScheduledVehicle() {
		return scheduledVehicle;
	}

	public void setScheduledVehicle(String scheduledVehicle) {
		this.scheduledVehicle = scheduledVehicle;
	}

	public Status getScheduledStatus() {
		return scheduledStatus;
	}

	public void setScheduledStatus(Status scheduledStatus) {
		this.scheduledStatus = scheduledStatus;
	}

	public void setClient(String client) {
		Client = client;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setScheduledDriver(String scheduledDriver) {
		this.scheduledDriver = scheduledDriver;
	}

	public String getscheduledVehicle(){
		return scheduledVehicle;
	}
	
	public void setActive(){
		this.scheduledStatus = Status.active;
	}
	
	public void setArchived(){
		this.scheduledStatus = Status.archived;
	}
	
	public Status getStatus(){
		return scheduledStatus;
	}

}
