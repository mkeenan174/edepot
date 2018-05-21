package edepotSystem;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class Depot {

	
	private String Location;
	private LinkedList<Vehicle> assignedVehicles;
	private LinkedList<Driver> assignedDrivers;
	
	// Variables for the Depot class
	public Depot(String Location, LinkedList<Driver> Drivers, LinkedList<Vehicle> Vehicles ){
		this.Location = Location;
		this.assignedDrivers = Drivers;
		this.assignedVehicles = Vehicles;
		
	
	}
	
	public String getLocation(){
		return Location;
	}
	//Creates a linked list of all drivers with assignments
	public LinkedList<Driver> getAssignedDrivers(){
		return assignedDrivers;
	}

	//Creates a linked list of all vehicles with assignments
	public LinkedList<Vehicle> getAssignedVehicles(){
		return assignedVehicles;
	}
	
	
	//Searches for a driver by matching an exact name
	public Driver getDriver(String driverName){
		for(Driver selectedDriver : assignedDrivers){
			if (selectedDriver.getUserName().equals(driverName)){
				return selectedDriver;
			}
				
	}return null;
}
	
	
	
	//Searches for a vehicle by matching an exact reg number
	public Vehicle getVehicle(String regNo){
		for(Vehicle selectedVehicle : assignedVehicles){
			if(selectedVehicle.getRegNo().equals(regNo)){
				return selectedVehicle;
			}
		}return null;
	}
	/**
	 * This little method checks for if a vehicle is available between two dates, if the dates are acceptable it returns the registration number of the vehicle
	 * If the vehicle is not available the system just prints an error message
	 */
	//Checks the schedule to see if a driver has an assignment between the two dates specified 
	public void checkWorkSchedules(LocalDate startDate, LocalDate endDate){
		for(Driver selectedDriver : assignedDrivers){
			if (selectedDriver.isFree(startDate, endDate) == true){
				System.out.println(selectedDriver.getUserName());
			}
		}	
		//Shows search is done
		System.out.println("no more drivers Availible");
		
		//Checks to see if a vehicle has any assignments between the two dates
		for(Vehicle selectedVehicle : assignedVehicles){
			if (selectedVehicle.isFree(startDate, endDate)){
				System.out.println(selectedVehicle.getRegNo());
			}	
		}//Shows search is done
		System.out.println("no more Vehicles Availible");
	}
	public void setLocation(String location) {
		Location = location;
	}

	public void setAssignedVehicles(LinkedList<Vehicle> assignedVehicles) {
		this.assignedVehicles = assignedVehicles;
	}

	public void setAssignedDrivers(LinkedList<Driver> assignedDrivers) {
		this.assignedDrivers = assignedDrivers;
	}

	//login form for a manager or driver logging into the system
	public Driver logOn(String Username, String Password){
		Driver selectedDriver = getDriver(Username);
		if(selectedDriver != null){
			if(selectedDriver.checkPassword(Password) == true){
				return selectedDriver;
			}
		}
		return null;
	}
	//shows the vehicle is being relocated
	public void reLocateVehicle(){
		System.out.println("Re-Locating Vehicle");
	}
	//Informs the user they are viewing archives
	public void viewArchives(){
		System.out.println("viewing archive");
	}

}



