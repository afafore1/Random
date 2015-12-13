/////////////////////////////////////////////////
/// Name: Ayomitunde Fafore ///
/// CSc 2010, Principles of Computer Science ///
/// Spring 2014 ///
/// Assignment 5; Account ///
/// Submitted: 03/4/2014 ///
/////////////////////////////////////////////////





public class Account {
	
		
		// Instance variables
		  private double balance;
		  private String CustomersName;
		  private String accountNumber;

		  // Constructors
		  public Account(double initialBalance, String Name, String Number) {
		   balance = initialBalance;
		   CustomersName = Name;
		   accountNumber = Number;
		    
		    	 
		  }

		  // Set balance to 0.0
		  public Account() {
		    balance = 0.0;
		    
		  }

		  // Instance methods.
		  // String getCustomerName returns the customer's name
		  public String getCustomerName() {
			    return CustomersName;
			    }

		  // String getAccountNumber returns the customer's account Number
			public String getAccountNumber(){
				return accountNumber;
			    	
			  }
		  
			// deposit adds a certain amount to the balance
		  public void deposit(double amount) {
		    balance += amount;
		    
		    }

		  // withdraw subtracts a certain amount from the balance
		  public void withdraw(double amount) {
		    balance -= amount;
		    
		    	
		  }

		  // getBalance returns the account balance
		  public double getBalance() {
		    return balance;
		  }

		  // ends it and returns balance to be 0.0
		  public void close() {
		    balance = 0.0;
		  }
		


	}

