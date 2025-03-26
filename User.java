//User.java

import java.util.Scanner;

public abstract class User implements HasMenu {
	protected String userName = "";
	protected String PIN = "";
	java.util.Scanner input = new java.util.Scanner(System.in);	
	public User(){
		this.userName = "";
		this.PIN = "";
	} //end constructor

	public User(String userName, String PIN){
		this.userName = userName;
		this.PIN = PIN;
	} //End dual parameter constructor
		
	public boolean login(){
		boolean login; 
		String sUsername;
		String sPIN;
		System.out.print("Username: ");
		sUsername = input.nextLine();
		System.out.print("PIN: ");
		sPIN = input.nextLine();

		if (sUsername.equalsIgnoreCase(userName)){
			if (sPIN.matches("^\\d{4}$")){
				if (sPIN.equals(PIN)){
					login = true;
//					System.out.println("Login Successful");
				} //Correct PIN
				else {
					System.out.println("Incorrect PIN");
					login = false;
				} //Incorrect PIN
			} //End PinLength
			else {
				System.out.println("Incorrect PIN Length");
				login = false;
			} //End Incorrect PinLength
		} //End correct userName
		else {
			login = false;
		} //End incorrect userName	

		return login;
	} //End login() 

	public boolean login(String userName, String PIN){
		boolean login;
		if (userName.equals(userName)){
			if(PIN.equals(PIN)){
				login = true;
//				System.out.println("Login Successful");
			} //Correct PIN
			else {
				login = false;
			} //Incorrect PIN
		} //End correct userName
		else {
			login = false;
		} //Incorrect userName


		return login;
	} //End login(userName, PIN)
	
	public String menu(){
		String menuResponse;

		System.out.println("0) Exit");
		System.out.println("1) Manage Checking Account");
		System.out.println("2) Manage Savings Account");
		System.out.println("3) Change PIN");
		System.out.print("Action (0-3):");
		
		menuResponse = input.nextLine();

		return menuResponse;
	} //End menu()

	public void setUserName(String userName){
		this.userName = userName;
	} //End setUserName()

	public String getUserName(){
		return userName;
	} //End getUserName()

	public void setPIN(String sPIN){
		if (sPIN.matches("^\\d{4}$")){
			PIN = sPIN;
		}
		else{
			System.out.println("PIN must be numeric with 4 digits. Changing PIN to 0000.");
		} 
	} //End setPIN()

	public String getPIN(){
		return PIN;
	} //End getPIN()

	public abstract String getReport();
} //End class definition
