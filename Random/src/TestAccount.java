import java.util.Scanner;

/////////////////////////////////////////////////
/// Name: Ayomitunde Fafore ///
/// CSc 2010, Principles of Computer Science ///
/// Spring 2014 ///
/// Assignment 5; TestAccount ///
/// Submitted: 03/4/2014 ///
/////////////////////////////////////////////////



public class TestAccount {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	
		
		// The account is set to account one and a value, name and account number is given.
		// Customer name, account number and balance is printed. 
			Account acct1 = new Account(1000.00, "Ayo", "4521745449164966");
			System.out.println("Customer Name: " +
			 acct1.getCustomerName());
			System.out.println("Account Number: " + acct1.getAccountNumber());
		    System.out.println("Balance in account 1: " +
		                       acct1.getBalance());
		    acct1.deposit(100.00);
		    System.out.println("Balance in account 1: " +
		                       acct1.getBalance());
		    acct1.withdraw(150.00);
		    System.out.println("Balance in account 1: " +
		                       acct1.getBalance());
		    acct1.close();
		    System.out.println("Balance in account 1: " +
		                       acct1.getBalance());
		    
		 // The account is set to account two and a value, name and account number is also given.
			// Customer name, account number and balance is printed. 
		    System.out.println("");
		    Account acct2 = new Account(500.00, "Person1", "5551616468669757");
		    Scanner sc = new Scanner(System.in);
		    System.out.println("Enter name of account");
		    String accountName = sc.nextLine();
		    Account ac = (Account) Class.forName(accountName).newInstance();
		    System.out.println(ac.getAccountNumber());
		    //System.out.println(account+" has balance of "+acct2.getBalance());
//		    System.out.println("Customer Name: " +
//acct2.getCustomerName());
//		    System.out.println("Account Number: " + acct2.getAccountNumber());
//		    System.out.println("Balance in account 2: " +
//		                       acct2.getBalance());
//		    acct2.deposit(500.00);
//		    System.out.println("Balance in account 2: " +
//		                       acct2.getBalance());
//		    acct2.withdraw(350.00);
//		    System.out.println("Balance in account 2: " +
//		                       acct2.getBalance());
//		    acct2.close();
//		    System.out.println("Balance in account 2: " +
//		                       acct2.getBalance());
	}

}
