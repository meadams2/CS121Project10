//CheckingAccount.java

import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable{
	private static final long serialVersionUID = 1L;

	double balance;
//	private static final java.util.Scanner input = new java.util.Scanner(System.in);

	//Create constructors
	
	public CheckingAccount(){
		this.balance = 1000d; 
	//	this.start();
	}//End constructor 

	public CheckingAccount(double balance){
		this.balance = balance;
	//	this.start();
	}//End double constructor

	//Implementing methods of HasMenu
	
	public String menu(){
		java.util.Scanner menuInput = new java.util.Scanner(System.in);
		System.out.println("0) Quit");
		System.out.println("1) Check balance");
		System.out.println("2) Make a deposit");
		System.out.println("3) Make a withdrawal");
		System.out.print("Please enter 0-3: ");

		String checkingResponse = menuInput.nextLine();
		return checkingResponse;
	} //end menu

	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String menuResponse = menu();
			if (menuResponse.equals("0")){
				System.out.println("Exiting...");
				keepGoing = false;
			} //end exit condition
			else if (menuResponse.equals("1")){
				System.out.println("Checking balance...");
				checkBalance();
			} //end checkBalance condition
			else if (menuResponse.equals("2")){
				System.out.println("Making a deposit...");
				makeDeposit();
			} //end makeDeposit condition
			else if (menuResponse.equals("3")){
				System.out.println("Making a withdrawal...");
				makeWithdrawal();
			} //end makeWithdrawal condition
		} //end while loop
	} //end start()

	public static void main(String[] args){
		CheckingAccount c = new CheckingAccount();
	} //end main()

	public double getBalance(){
		return balance;
	} //end balance getter

	public String getBalanceString(){
		return String.format("$%.2f", balance); 
	} //end getBalanceString
	
	public double getDouble(){
		java.util.Scanner doubleInput = new java.util.Scanner(System.in);
		String sResult = doubleInput.nextLine();
		double result;
		try {
			result = Double.parseDouble(sResult);
		} catch(Exception e){
			System.out.println("Not a legal input. Changing to 0.");
			result = 0d;
		} 
		return result;
	} //end getDouble()

	public void setBalance(double balance){
		this.balance = balance;
	} //end setBalance()

	public void checkBalance(){
		String sBalance = getBalanceString();
		System.out.println("Current Balance: " + sBalance);
	} //end checkBalance
	
	public void makeDeposit(){
		System.out.println("How much to deposit? ");
		double deposit = this.getDouble();
		this.balance += deposit;
		System.out.println("New Balance: " +  this.getBalanceString());
	} //end makeDeposit()

	public void makeWithdrawal(){
		System.out.println("How much to withdrawal? ");
		double withdrawal = this.getDouble();
		if (withdrawal > balance){
			System.out.println("Not enough money...");
		} //end overdraft condition
		else {
			this.balance -= withdrawal;
			System.out.println("New Balance: " + getBalanceString());
		} //end withdraw
	} //end makeWithdrawal
} //end checkingAccount class

