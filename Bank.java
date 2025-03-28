//Bank.java

import java.util.*;
import java.io.*;

class Bank implements HasMenu, Serializable {
	private static final long serialVersionUID = 1L;
	protected Admin admin = new Admin();
//	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	class CustomerList extends ArrayList<Customer>{};
	protected CustomerList customers = new CustomerList();

	public static void main(String[] args){
		Bank wellsFargo = new Bank();
	//	wellsFargo.start();
	} //End main()

	public Bank(){
		this.loadSampleCustomers();
		this.saveCustomers();
		this.loadCustomers();
		this.start();
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
				this.loginAsCustomer();
			} //End login as customer condition
		} //End while loop
	} //End start()
	
	public void loadSampleCustomers(){
		customers.add(new Customer("Alice", "0000"));
		customers.add(new Customer("Bob", "0000"));
		customers.add(new Customer("Cindy", "0000"));
	} //End loadSampleCustomers()

	public void saveCustomers(){
		try {
			FileOutputStream fo = new FileOutputStream("customerArray.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(customers);
			obOut.close();
			fo.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		} //End try
	} //End saveCustomers()

	public void loadCustomers(){
		try {
			FileInputStream fIn = new FileInputStream("customerArray.dat");
			ObjectInputStream obIn = new ObjectInputStream(fIn);
			customers = (CustomerList)obIn.readObject();
			obIn.close();
			fIn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} //End try
	} //End loadCustomers()

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
				this.applyInterest();
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
			
			//Testing harness to figure out null userName issue
			//System.out.println(currentCustomer.getUserName());
			System.out.println(currentCustomer.getReport());
		} 
	} //End fullCustomerReport()
	
	public void applyInterest(){
		Iterator<Customer> it = customers.iterator();
		while (it.hasNext()){
			Customer currentCustomer = it.next();
			currentCustomer.savings.calcInterest();
			//System.out.println("New Balance: " + currentCustomer.savings.getBalance());
			//Testing harness to check if calcInterest() working in this scope
		} //End while loop
	} //End applyInterest()
	
	public void loginAsCustomer(){
		java.util.Scanner customerInput = new java.util.Scanner(System.in);
		Customer currentCustomer = null;

		System.out.print("Username: ");
		String sUserName = customerInput.nextLine();

		System.out.print("PIN: ");
		String sPIN = customerInput.nextLine();
		
		Iterator<Customer> it = customers.iterator();
		Customer iterCustomer;
		boolean keepGoing = true;
		while (keepGoing){
			while (it.hasNext()){
				iterCustomer = it.next();
				if (iterCustomer.login(sUserName, sPIN)){
					currentCustomer = iterCustomer;
					currentCustomer.start();
					keepGoing = false;
				} //User found condition
			} //End iterator
			if (currentCustomer == null){
				System.out.println("User not found.");
				keepGoing = false;
			} //End user not found
		} //End while loop
	} //End loginAsCustomer()

} //End class def
