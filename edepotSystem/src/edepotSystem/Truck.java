package edepotSystem;

import java.util.LinkedList;
/**
 * The truck class is an extension of the vehicle class, it contains many of the the same details as the vehicle class but it contains only the details for the trucks that are 
 * available in each depot specifying their makes and models which are separate from those of tankers, this class also contains the cargo capacity of the trucks which is 
 * different from the capacity of the tankers so it has to be recorded in a different way
 */
public class Truck extends Vehicle {
	private int cargoCapacity;
	//variables of the truck class, extension of vehicle
	public Truck(String Make, String Model, String Reg, int weight,LinkedList<WorkSchedule> Schedules, int cargoCapacity) {
		super(Make, Model, Reg, weight, Schedules);
		
		this.cargoCapacity = cargoCapacity;
		// TODO Auto-generated constructor stub
	}
	
	public int getCargoCapacity(){
		return cargoCapacity;
	}

}
