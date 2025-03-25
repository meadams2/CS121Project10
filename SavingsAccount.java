//SavingsAccount.java

import java.util.Scanner;

class SavingsAccount extends CheckingAccount{
	private double interestRate;

	public static void main(String[] args){
		SavingsAccount account = new SavingsAccount(1000, 5);
		account.start();
	} //end main test harness

	public SavingsAccount(double balance, double interestRate){
		super(balance);
		this.interestRate = interestRate;
	} //End constructor
//When I get to admin, test interest rate methods
	public void setInterestRate(double interestRate){
		this.interestRate = interestRate;
	} //End interestRate setter

	public double getInterestRate(){
		return interestRate;
	} //End interestRate getter


	public void calcInterest(){
		//Assuming interest is not time based for ease of programming
		double balance = getBalance();
		double interest = balance * (interestRate/100);
		setBalance(balance + interest);
	} //End calcInterest
} //End class definition
	
