package edepotSystem;

import java.util.LinkedList;
/**
 * The tanker class is an extension of the vehicle class, it contains many of the the same details as the vehicle class but it contains only the details for the tankers that are 
 * available in each depot specifying their makes and models which are separate from those of trucks, this class also contains the variables liquid type and liquid capacity of the tankers  
 * these variables are unique to the tankers and so have to be recorded in their own class 
 */
public class Tanker extends Vehicle {
	private String liquidType;
	private int liquidCapacity;
	
	//Variables of the tanker class, extension of vehicle 
	public Tanker(String Make, String Model, String Reg, int weight, LinkedList<WorkSchedule> Schedules,String liquidType, int liquidCapacity) {
		super(Make, Model, Reg, weight, Schedules);
		this.liquidCapacity = liquidCapacity;
		this.liquidType = liquidType;
			// TODO Auto-generated constructor stub
	}
	
	public String getLiquidType(){
		return liquidType;
	}
	
	public int getLiquidCapacity(){
		return liquidCapacity;
	}
	

}
