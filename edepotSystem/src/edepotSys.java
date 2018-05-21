/**
* The menu system for the edepot which handles all input output and error catching
* 
*
* @author  cmpmkeen, cmphduncalf, cmprirvine
* @version 1.0
* @since   2018-04-24
*/

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

import edepotSystem.Depot;
import edepotSystem.Driver;
import edepotSystem.Manager;
import edepotSystem.Tanker;
import edepotSystem.Truck;
import edepotSystem.Vehicle;
import edepotSystem.WorkSchedule;

public class edepotSys implements Runnable {
	private static LinkedList<Depot> arrayDepots;
	private LinkedList<WorkSchedule> schedBenny;
	private LinkedList<WorkSchedule> schedRonald;
	private LinkedList<WorkSchedule> schedC2456;
	private LinkedList<WorkSchedule> schedC3764;
	private LinkedList<WorkSchedule> schedJenny;
	private LinkedList<WorkSchedule> schedD6971;
	private LinkedList<WorkSchedule> schedD7671;
	private LinkedList<WorkSchedule> schedG3651;
	private LinkedList<WorkSchedule> schedG9821;
	private LinkedList<WorkSchedule> schedW2233;
	private LinkedList<WorkSchedule> schedW6184;
	private LinkedList<WorkSchedule> schedJohn;
	private LinkedList<WorkSchedule> schedStuart;
	private LinkedList<WorkSchedule> schedMr;
	private LinkedList<WorkSchedule> schedBen;
	private LinkedList<WorkSchedule> schedDwayne;
	private LinkedList<WorkSchedule> schedMark;
	private LinkedList<WorkSchedule> schedClyde;
	private LinkedList<WorkSchedule> schedSedi;
	private LinkedList<Driver> corkDrivers;
	private LinkedList<Driver> dublinDrivers;
	private LinkedList<Driver> galwayDrivers;
	private LinkedList<Driver> waterfordDrivers;
	private LinkedList<Vehicle> corkVehicles;
	private LinkedList<Vehicle> dublinVehicles;
	private LinkedList<Vehicle> galwayVehicles;
	private LinkedList<Vehicle> waterfordVehicles;
	private static Depot currentDepot;
	private static Driver currentUser;
	private final static Scanner S = new Scanner(System.in);
	
	
	

	
	
public void populateSystem(){
		
		//All the work schedules, followed by which drive has which jobs assigned
		WorkSchedule a = new WorkSchedule("BingoLtd",LocalDate.of(2018, 04, 20) ,LocalDate.of(2018, 04, 21),"benny","C-2456" );
		WorkSchedule b = new WorkSchedule("BingoLtd",LocalDate.of(2018, 04, 23) ,LocalDate.of(2018, 04, 24),"Ronald","C-2456" );
		WorkSchedule c = new WorkSchedule("dongbowLtd",LocalDate.of(2018, 04, 22) ,LocalDate.of(2018, 04, 24),"benny","C-3764" );
		WorkSchedule d = new WorkSchedule("BingoLtd",LocalDate.of(2018, 04, 25) ,LocalDate.of(2018, 04, 26),"Jenny","C-3764" );
		WorkSchedule e = new WorkSchedule("BingoLtd",LocalDate.of(2019, 04, 26) ,LocalDate.of(2019, 04, 27),"benny","C-2456" );
		WorkSchedule f = new WorkSchedule("BingoLtd",LocalDate.of(2018, 04, 27) ,LocalDate.of(2018, 04, 29),"Jenny","C-3764" );
		WorkSchedule g = new WorkSchedule("dongbowLtd",LocalDate.of(2018, 04, 28) ,LocalDate.of(2018, 05, 01),"Ronald","C-2456" );
		WorkSchedule h = new WorkSchedule("GuinnessLtd", LocalDate.of(2018, 04, 19) ,LocalDate.of(2018, 04, 22), "John", "D-6971");
		WorkSchedule i = new WorkSchedule("OrchardThievesLtd", LocalDate.of(2018, 04, 19) ,LocalDate.of(2018, 04, 20), "stuart", "D-7671");
		WorkSchedule j = new WorkSchedule("Orchard ThievesLtd", LocalDate.of(2018, 04, 21) ,LocalDate.of(2018, 04, 22), "Mr", "D-7671");
		WorkSchedule k = new WorkSchedule("GuinnessLtd", LocalDate.of(2018, 04, 23) ,LocalDate.of(2018, 04, 25), "Ben", "D-6971");
		WorkSchedule l = new WorkSchedule("GuinnessLtd", LocalDate.of(2018, 04, 26) ,LocalDate.of(2018, 04, 28), "John", "D-6971");
		WorkSchedule m = new WorkSchedule("Orchard ThievesLtd", LocalDate.of(2018, 04, 26) ,LocalDate.of(2018, 04, 27), "Ben", "D-7671");
		WorkSchedule n = new WorkSchedule("OrchardThievesLtd", LocalDate.of(2018, 04, 28) ,LocalDate.of(2018, 04, 29), "stuart", "D-7671");
		WorkSchedule o = new WorkSchedule("OrchardThieves", LocalDate.of(2018, 04, 29) ,LocalDate.of(2018, 05, 01), "Mr", "D-6971");
		WorkSchedule p = new WorkSchedule("FaiweLtd", LocalDate.of(2018, 05, 02) ,LocalDate.of(2018, 05, 03), "Dwayne", "G-3651");
		WorkSchedule q = new WorkSchedule("FlibbletLtd", LocalDate.of(2018, 05, 02) ,LocalDate.of(2018, 05, 04), "mark", "D-9821");
		WorkSchedule r = new WorkSchedule("FlibbletLtd", LocalDate.of(2018, 05, 04) ,LocalDate.of(2018, 05, 05), "Dwayne", "D-9821");
		WorkSchedule s = new WorkSchedule("FaiweLtd", LocalDate.of(2018, 05, 04) ,LocalDate.of(2018, 05, 06), "mark", "D-3651");
		WorkSchedule t = new WorkSchedule("FLufflLtd", LocalDate.of(2018, 05, 01) ,LocalDate.of(2018, 05, 02), "Clyde", "W-2233");
		WorkSchedule u = new WorkSchedule("JelloLtd", LocalDate.of(2018, 05, 01) ,LocalDate.of(2018, 05, 03), "Sedi", "W-6184");
		WorkSchedule v = new WorkSchedule("FlufflLtd", LocalDate.of(2018, 05, 04) ,LocalDate.of(2018, 05, 05), "Sedi", "W-6184");
		WorkSchedule w = new WorkSchedule("JelloLtd", LocalDate.of(2018, 05, 05) ,LocalDate.of(2018, 05, 07), "Clyde", "W-2233");
		WorkSchedule x = new WorkSchedule("JelloLtd", LocalDate.now().plusDays((long) 0.0137) ,LocalDate.now().plusDays((long) 0.0267), "Clyde", "W-2233");
		WorkSchedule y = new WorkSchedule("FlufflLtd", LocalDate.of(2018, 05, 04) ,LocalDate.of(2018, 05, 05), "Ben", "D-6184");

		
		schedBenny = new LinkedList<WorkSchedule>();
		schedBenny.add(a);
		schedBenny.add(c);
		schedBenny.add(e);
		schedBenny.add(x);

		
		schedRonald = new LinkedList<WorkSchedule>();
		schedRonald.add(b);
		schedRonald.add(g);
		
		schedJenny = new LinkedList<WorkSchedule>();
		schedJenny.add(f);
		schedJenny.add(d);
		
		schedC2456 = new LinkedList<WorkSchedule>();
		schedC2456.add(a);
		schedC2456.add(b);
		schedC2456.add(e);
		schedC2456.add(g);
		
		schedC3764 = new LinkedList<WorkSchedule>();
		schedC3764.add(c);
		schedC3764.add(d);
		schedC3764.add(f);
		
		schedJohn = new LinkedList<WorkSchedule>();
		schedJohn.add(h);
		schedJohn.add(l);
		
		schedStuart = new LinkedList<WorkSchedule>();
		schedStuart.add(i);
		schedStuart.add(n);
		
		schedMr = new LinkedList<WorkSchedule>();
		schedMr.add(j);
		schedMr.add(o);
		
		schedBen = new LinkedList<WorkSchedule>();
		schedBen.add(k);
		schedBen.add(m);
		schedBen.add(y);
		
		schedD6971 = new LinkedList<WorkSchedule>();
		schedD6971.add(h);
		schedD6971.add(k);
		schedD6971.add(l);
		schedD6971.add(o);
		
		schedD7671 = new LinkedList<WorkSchedule>();
		schedD7671.add(i);
		schedD7671.add(j);
		schedD7671.add(m);
		schedD7671.add(n);
		
		schedDwayne = new LinkedList<WorkSchedule>();
		schedDwayne.add(p);
		schedDwayne.add(r);
		
		schedMark = new LinkedList<WorkSchedule>();
		schedMark.add(q);
		schedMark.add(s);
		
		schedG3651 = new LinkedList<WorkSchedule>();
		schedG3651.add(p);
		schedG3651.add(s);
		
		schedG9821 = new LinkedList<WorkSchedule>();
		schedG9821.add(q);
		schedG9821.add(r);
		
		schedClyde = new LinkedList<WorkSchedule>();
		schedClyde.add(t);
		schedClyde.add(w);
		
		schedW2233 = new LinkedList<WorkSchedule>();
		schedW2233.add(t);
		schedW2233.add(w);
		
		schedSedi = new LinkedList<WorkSchedule>();
		schedSedi.add(u);
		schedSedi.add(v);
		
		schedW6184 = new LinkedList<WorkSchedule>();
		schedW6184.add(u);
		schedW6184.add(v);
		
		corkVehicles = new LinkedList<Vehicle>();
		corkVehicles.add(new Truck("Man","XZ1","C-2456",2500, schedC2456, 83));
		corkVehicles.add( new Tanker("Man","XZ2","C-3764",2500, schedC3764, "fuel", 3400));
		
		dublinVehicles = new LinkedList<Vehicle>();
		dublinVehicles.add( new Truck("Man","XZ1","D-6971",2500, schedD6971, 83));
		dublinVehicles.add( new Tanker("Man","XZ2","D-7671",2500, schedD7671,"fuel", 3400));
		
		galwayVehicles = new LinkedList<Vehicle>();
		galwayVehicles.add( new Truck("Man","XZ1","G-3651",2500, schedG3651, 83));
		galwayVehicles.add( new Tanker("Man","XZ2","G-3764",2500, schedG9821,"fuel", 3400));
		
		waterfordVehicles = new LinkedList<Vehicle>();
		waterfordVehicles.add( new Truck("Man","XZ1","W-2233",2500, schedW2233, 83));
		waterfordVehicles.add( new Tanker("Man","XZ2","W-6184",2500, schedW6184, "fuel", 3400));
		
		corkDrivers = new LinkedList<Driver>();
		corkDrivers.add( new Manager("benny", "blue",schedBenny));
		corkDrivers.add( new Driver("Ronald ", "red",schedRonald));
		corkDrivers.add( new Driver("Jenny", "jumping", schedJenny));
		
		dublinDrivers = new LinkedList<Driver>();
		dublinDrivers.add( new Driver("John", "JJ", schedJohn));
		dublinDrivers.add( new Driver("stuart", "little", schedStuart));
		dublinDrivers.add( new Driver("Mr", "Potateo", schedMr));
		dublinDrivers.add( new Manager("Ben", "Swolo", schedBen));

		galwayDrivers = new LinkedList<Driver>();
		galwayDrivers.add( new Manager("Dwayne ", "The rock", schedDwayne));
		galwayDrivers.add( new Driver("mark", "ohHi", schedMark));
		
		waterfordDrivers = new LinkedList<Driver>();
		waterfordDrivers.add( new Driver("Clyde", "mcree", schedClyde));
		waterfordDrivers.add( new Driver("Sedi ", "rock", schedSedi));
		
		
		arrayDepots = new LinkedList<Depot>();
		arrayDepots.add( new Depot ("CORK", corkDrivers, corkVehicles));
		arrayDepots.add( new Depot ("DUBLIN", dublinDrivers, dublinVehicles));
		arrayDepots.add( new Depot ("GALWAY", galwayDrivers, galwayVehicles));
		arrayDepots.add( new Depot ("WATERFORD", waterfordDrivers, waterfordVehicles));
		System.out.println("Sample data generated");
}


/**
 * This method starts when the system is opened it starts up the system and populates it by calling the select depot method
 */
	public void run(){
		populateSystem();
		selectDepot();
	
	}	
		
		
			
	/**
	 * This method opens as soon as the system is opened, this method is a menu where the user has to enter which depot they are a part of at this moment in time
	 * the user enters the first letter of the depot they are in or a number 1 to 4 and the system calls the log on method for the selected depot
	 * if the user presses the Q key the system will close entirely 
	 */
	public static void selectDepot(){	
		String choice = "";
		
		
		
		//The menu before the log in stage
			System.out.println("---Select Depot---");
			System.out.println("1 - [C]ork");
			System.out.println("2 - [D]ublin");
			System.out.println("3 - [G]alway");
			System.out.println("4 - [W]aterford");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");

			choice = S.nextLine().toUpperCase();

			switch (choice) {
				case "C" :
				case "1" : {
					currentDepot = getDepot("CORK");
					logOn();
					break;
				}
				case "D" :
				case "2" : {
					currentDepot = getDepot("DUBLIN");
					logOn();
					break;
				}
				case "G" :
				case "3" : {
					currentDepot = getDepot("GALWAY");
					logOn();
					break;
				}
				case "4" :
				case "W" : {
					currentDepot = getDepot("WATERFORD");
					logOn();
					break;
				}
				case "Q":{
					S.close();
					System.exit(0);
				}
				
			}
		
	}
	
	/**
	 * The driver menu below is called after the user has logged on, and the menu selector method has determined that user is a driver not a manager, system greets them with a printed hello and 
	 * calls has an input menu for the driver to decide what they would like to do, if the user enters v or 1 the system calls the view work schedule method, if the user presses U or 4 
	 * the system calls the view updates method for the logged in user, unlike the menus mentioned above if the Q button is entered the system will first log the user out and then shut down 
	 */
	public static void driverMenu(){
		//Menu that drivers see once logged in
		System.out.print("--Hello Driver--");
		updateChecker();
		String choice = "";
		
		System.out.println("---Main Menu---");
		System.out.println("1 - [V]iew Work Schedule");
		System.out.println("4 - [U]pdates");
		System.out.println("Q - Quit");
		System.out.print("Pick : ");

		choice = S.nextLine().toUpperCase();
		do {
			switch (choice) {
				case "V" :
				case "1" : {
					viewWorkSchedule();
					break;
				}

				case "4" :
				case "U" : {
					currentUser.viewUpdates();
					break;
				}
				
			}
		}while(!choice.equals("Q"));
		logout();
		S.close();
	}
/**
 * The manager menu below is an extension of the driver menu documented above, the schedule viewer and updates and quit options are the same as in the driver menu
 * this method is called if menu selector method has determined that the user is part of the manager linked list, this menu has other permissions that 
 * the driver menu does not, the c or 2 key calls the create work schedule as the manager has the authority to make new schedules, the 3 or R key calls the 
 * re-locate vehicles method, the U or 5 key will call the view archives method for the selected depot, finally the V or 6 key will call the view vehicles method for the selected depot  
 */
	public static void managerMenu(){
		System.out.println("---Hello Manager---");
		updateChecker();
		String choice = "";
		//Menu that mangers see once logging in
		System.out.println("---Main Menu---");
		System.out.println("1 - [S]chedule Viewer");
		System.out.println("2 - [C]reate Work Schdeule");
		System.out.println("3 - [R]e-Locate Vehicle");
		System.out.println("4 - [U]pdates");
		System.out.println("5 - [A]rchives");
		System.out.println("6 - [V]ehicle Viewer");
		System.out.println("Q - Quit");
		System.out.print("Pick : ");

		choice = S.nextLine().toUpperCase();
		do {
			switch (choice) {
				case "S" :
				case "1" : {
					viewWorkSchedule();
					break;
				}
				case "C" :
				case "2" : {
					createWorkSchedule();
					break;
				}
				case "R" :
				case "3" : {
					reLocateVehicle();
					break;
				}
				case "4" :
				case "U" : {
					currentUser.viewUpdates();
					break;
				}
				case "5" :
				case "A" : {
					currentDepot.viewArchives();
					break;
				}
				case "6" :
				case "V" : {
					viewVehicles();
					break;
				}
			}
		}while(!choice.equals("Q"));
		logout();
		S.close();
	}
	
	
/**
 * The getDepot string below inputs a string calling for a depot object from the depot linked list and if it finds a matching depot in the linked list
 * it will return that depot as an object with which it's resources can be viewed if the string does not find a matching depot it returns a null   
 */
	public static Depot getDepot(String Location){
		for (Depot selectedDepot : arrayDepots){
			if (selectedDepot.getLocation().equals(Location)){
				System.out.println(selectedDepot.getLocation());
				return selectedDepot;
			}
		}
		return null;
	}
	/**
	 * This log on method has the user enter their user name which is then checked against the linked list 
	 * containing all the users at the depot that was selected before reaching the log on stage, the user must also
	 * input their password, these are then checked against the entries in the driver linked list for the selected depot
	 * if the user name and password are recognised from the linked list the system prints login successful and calls the menuselector method
	 * if not the system prints that the user must try again and calls this log on method again
	 */
	//This does  work
	public static void logOn(){
		System.out.println("enter username");
		String userInput = S.nextLine().trim();
		System.out.println("enter password");
		String userPassword = S.nextLine().trim();
		currentUser = currentDepot.logOn(userInput, userPassword); 
		if(currentUser != null){
		System.out.println(currentUser.getUserName() + "login successful");
		menuSelector();
		}else{
			System.out.println("Error wrong password or username enterd please try again ");
			logOn();
		}
		
		
	}
	/**
	 * The create work schedule method is only accessible through the manager menu, this method has the user enter details about creating a new work schedule 
	 * the user enters the clients name, the start date of the job and the end date of the job the system then calls a different part of the method   
	 */
	//Menu system for creating work schedule 
	public synchronized static void createWorkSchedule(){
		System.out.println("Please enetr client name" );
		String clientInput = S.nextLine();
		System.out.println("Please enter schedule startdate in the format 'yyyy-mm-dd'");
		String startDateInput = S.nextLine();
		System.out.println("Please enter schdule enddate in the format 'yyyy-mm-dd'");
		String endDateInput = S.nextLine();
		LocalDate startDate = null;
		try{	
		startDate = LocalDate.parse(startDateInput);
		}catch(Exception e){
			System.out.println(e);
			createWorkSchedule();
		}
		LocalDate endDate = null;
		try{
		endDate = LocalDate.parse(endDateInput);
		}catch(Exception e){
			System.out.println(e);
			createWorkSchedule();
		}
		if(startDate.isAfter(LocalDate.now().plusDays(2)) && endDate.isBefore(startDate.plusDays(3)) && endDate.isAfter(startDate)){
		/**
		 * This part of the method returns the drivers that are available in the selected depot and the user must choose a driver from the returned list
		 * after the user has selected the driver and they are available on those dates the system will ask the user to select a vehicle to assign for the job
		 * if the vehicle is also available then the system will add these details to the drivers work schedule and set an update to let the driver know of the change and then calls the menu selectr method
		 * if at any point the user chooses a driver or vehicle that is unavailable then the system will print and error message
		 */
		System.out.println("fetching availible drivers and vehicles at your depot :)");
		currentDepot.checkWorkSchedules(startDate, endDate);
		System.out.println("Please enter your selected driver from the list");
		String driverInput = S.nextLine();
		Driver selectedDriver = currentDepot.getDriver(driverInput);
		if (selectedDriver != null && selectedDriver.isFree(startDate, endDate) == true){
			System.out.println("Please enter your selected Vehicle from the list");
			String vehicleInput = S.nextLine();
			Vehicle selectedVehicle = currentDepot.getVehicle(vehicleInput);
			if (selectedVehicle != null && selectedVehicle.moveable(startDate) == true){
				selectedDriver.setSchedule(new WorkSchedule(clientInput,startDate,endDate,selectedDriver.getUserName(), selectedVehicle.getRegNo()));
				selectedVehicle.setSchedule(selectedDriver.getWorkSchedule(clientInput));
				 selectedDriver.setUpdate();
				 menuSelector();
				 
			}else {
				System.out.println("Sorry you seem to have entered a vehicle that either isnt in your depot or not free on your selected dates ");
				createWorkSchedule();
			}
		}else{
			System.out.println("Sorry you seem to have entered a driver that either isnt in your depot or not free on your selected dates ");
			createWorkSchedule();

		}
		
		}else{
			System.out.println("Sorry the dates youve entered are either too too close together ");
			createWorkSchedule();

		}
		
		
	}
	/**
	 * This below method takes the details of the currently logged on user and fetches the workschedules related to them from the workschedules linked list and prints out the details
	 * then once the user is done the system calls the menu selector method and that takes the user back to the menu they are able to access 
	 */
	// Displays the work schedule 
	public synchronized static void viewWorkSchedule(){
		for( WorkSchedule selectedSchedule : currentUser.getMySchedules()){
			System.out.println("-Client-" + selectedSchedule.getClient() + "start date :" + selectedSchedule.getStartDate() + "end date :"  + selectedSchedule.getEndDate() + "vehicle" + selectedSchedule.getscheduledVehicle());
		}
		menuSelector();
	}
	/**
	 * This method has the user input a depot which they would like to relocate the vehicle to, this returns the details of the selected depot, next the user will have to enter the date 
	 * that they would be relocating the vehicle on so as to ensure it does not get assigned a job on that date, once this is doen if it is acceptable the system calls the relocate vehicle method
	 */
	//Vehicle relocation section of the menu
	public  synchronized static void reLocateVehicle(){
		System.out.println("please enter which depot you want to relocate vehicle to");
		String depotInput = S.nextLine().toUpperCase();
		Depot selectedDepot = getDepot(depotInput);
		if(selectedDepot != null && selectedDepot != currentDepot){
		System.out.println("please enter the date for vehicle relocation");
		String startDateInput = S.nextLine();
		LocalDate startDate = null;
		try{	
		startDate = LocalDate.parse(startDateInput);
		}catch(Exception e){
			System.out.println(e);
			reLocateVehicle();
		}
		/**
		 * This part of the method creates a new end date using the current date and adding another day to it, after this the system calls up the available drivers and vehicles from the 
		 * vehicles and drivers in the currently selected depot, once both resources have been selected the system adds the relocation as a new work schedule to the workschedule linked list for the assigned driver
		 * the system then sets and update for the assigned driver, then the system calls the menu selector method   
		 */
		LocalDate endDate = startDate.plusDays(1);
		System.out.println("fetching availible drivers and vehicles at your depot :)");
		currentDepot.checkWorkSchedules(startDate, endDate);
		System.out.println("Please enter your selected driver from the list");
		String driverInput = S.nextLine();
		Driver selectedDriver = currentDepot.getDriver(driverInput);
		if (selectedDriver != null && selectedDriver.isFree(startDate, endDate) == true){
			System.out.println("Please enter your selected Vehicle from the list");
			String vehicleInput = S.nextLine();
			Vehicle selectedVehicle = currentDepot.getVehicle(vehicleInput);
			if (selectedVehicle != null && selectedVehicle.isFree(startDate, endDate) == true){
				selectedDriver.setSchedule(new WorkSchedule("relocation",startDate,endDate,selectedDriver.getUserName(), selectedVehicle.getRegNo()));
				selectedVehicle.setSchedule(selectedDriver.getWorkSchedule("relocation"));
				 currentDepot.getAssignedVehicles().remove(selectedVehicle);
				 selectedDriver.setUpdate();
				 selectedDepot.getAssignedVehicles().add(selectedVehicle);
				 menuSelector();
			}
			System.out.println("Sorry bu the selected vehicle is either not free or not at your depot");
			reLocateVehicle();
		}
			
		System.out.println("Sorry you seem to have entered a driver that either isnt in your depot or not free on your selected dates ");
		reLocateVehicle();
		
		}
		System.out.println("Sorry the depot you entered does not exist or you have entered the depot the vehicle is already at");
	}
	/**
	 * This view vehicles method takes the linked list of the vehicles for the depot that has currently been selected and prints out the registration number and type of vehicle
	 * The system then calls the menu selector method 
	 */
	public synchronized static void viewVehicles(){
		for( Vehicle selectedVehicles : currentDepot.getAssignedVehicles()){
			System.out.println("Vehicle reg number:" + selectedVehicles.getRegNo());	
		}
		menuSelector();
	}
	/**
	 * The menu selector is called when a user logs on, the method checks the users credentials against the manager linked list and 
	 * if the users credentials match with ones on this list the system calls the manager menu method otherwise it calls the driver menu method 
	 */
	public static void menuSelector(){
		if(currentUser.getClass() == Manager.class){
			managerMenu();
		}else {
			driverMenu();
		}
	}
	/**
	 * The update checker checks is called when a manager assigns a driver a new a work schedule, it takes the details of the driver who was assigned and prints them a message 
	 * telling them they have an update
	 */
	public static void updateChecker(){
		if(currentUser.getUpdate() == true){
			System.out.println("---You have an update---");
		}
	}
	
	/**
	 * this method calls for the depot linked list 
	 * @returns the depot linked list 
	 */
	public  static LinkedList<Depot> getDepotList(){
		return arrayDepots;
	}
	/**
	 * The method below logs the user out by returning their value to null and calling the select depot method again  
	 */
	public static void logout(){
		currentUser = null;
		currentDepot = null;
		selectDepot();
		
	}
	
	
	
}
