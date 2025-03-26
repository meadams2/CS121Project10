//Bank.java

import java.util.*;
import java.io.*;

class Bank implements HasMenu {
	protected Admin admin = new Admin();
//	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	class CustomerList extends ArrayList<Customer>{};
	protected CustomerList customers = new CustomerList();

	public static void main(String[] args){
		Bank wellsFargo = new Bank();
		wellsFargo.start();
	} //End main()

	public Bank(){
		this.loadSampleCustomers();
		this.saveCustomers();
	} //End constructor

	public String menu(){
		java.util.Scanner menuInput = new java.util.Scanner(System.in);
		String menuResponse;

		System.out.println("Bank Menu");
		System.out.println("0) Exit system");
		System.out.println("1) Login as admin");
		System.out.println("2) Login as customer");
		System.out.print("Action: ");

		menuResponse = menuInput.nextLine();
		return menuResponse;
	} //End menu()

	public void start(){
		boolean keepGoing = true;

		while(keepGoing){
			String menuInput = this.menu();
		
			if(menuInput.equals("0")){
				System.out.println("Exiting.");
				keepGoing = false;
			} //End exit condition
			
			if(menuInput.equals("1")){
			 	System.out.println("Logging in as admin.");
				if(admin.login()){
					this.startAdmin();
				} 
				else {
					System.out.println("Not authorized.");
				} 
			} //End login as admin condition

			if(menuInput.equals("2")){
				System.out.println("Logging in as customer.");
			} //End login as customer condition
		} //End while loop
	} //End start()
	
	public void loadSampleCustomers(){
		customers.add(new Customer("Alice", "0000"));
		customers.add(new Customer("Bob", "0000"));
		customers.add(new Customer("Cindy", "0000"));
	} //End loadSampleCustomers()

	public void saveCustomers(){

	}

	public void startAdmin(){
		boolean keepGoing = true;
		while(keepGoing){
			String menuResponse = admin.menu();
			if (menuResponse.equals("0")){
				System.out.println("Exiting to Bank Menu.");
				keepGoing = false;
			} //End exit admin condition
			
			else if (menuResponse.equals("1")){
				System.out.println("Printing Full Customer Report.");
				this.fullCustomerReport();
			} //Customer report condition

			else if (menuResponse.equals("2")){
				System.out.println("Adding user.");
				this.addUser();
			} //Add user condition

			else if (menuResponse.equals("3")){
				System.out.println("Adding interest to savings accounts.");
			} //Add interest condition
		} //End while loop
	} //End startAdmin()
	
	public void addUser(){
		java.util.Scanner userInput = new java.util.Scanner(System.in);
		String userName;
		String PIN;

		System.out.print("New User Username: ");
		userName = userInput.nextLine();

		System.out.print("New User PIN: ");
		PIN = userInput.nextLine();
		
		customers.add(new Customer(userName, PIN));
	} //End addUser()

	public void fullCustomerReport(){
		Iterator<Customer> it = customers.iterator();

		while (it.hasNext()){
			Customer currentCustomer = it.next();
			System.out.println(currentCustomer.getReport());
		} 
	} //End fullCustomerReport()



} //End class def
