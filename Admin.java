//Admin.java
import java.util.Scanner;

class Admin extends User {
	public static void main(String[] args){
		Admin admin = new Admin();
		admin.menu();
		System.out.println(admin.getReport());
	} //End main. Main used for testing harness.
	
	public Admin(){
		super("admin", "0000");
	} //End Constructor

	public String menu(){
		java.util.Scanner menuInput = new java.util.Scanner(System.in);
		String menuResponse;

		System.out.println("0) Exit this menu");
		System.out.println("1) Full Customer Report");
		System.out.println("2) Add User");
		System.out.println("3) Apply interest to savings accounts");
		System.out.print("Action: ");
		
		menuResponse = menuInput.nextLine();
		return menuResponse;
	} //End menu()
	
	public void start(){
	
	} //End empty start()

	public String getReport(){
		String report = "Username:" + this.userName + ", PIN:" + this.PIN;
		return report;
	} //End getReport
} //End class def
