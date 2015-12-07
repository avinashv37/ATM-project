package atmg;
// BankDatabase.java

import java.util.ArrayList;

// Represents the bank account information database 

public class BankDatabase extends Thread {
	//private Account accounts[]; // array of Accounts
//	/public Account accounts[] = new Account[100];
	public static ArrayList<Account> accounts=new ArrayList<Account>();
	public int accountinfo;
	Thread t;
	// no-argument BankDatabase constructor initializes accounts
	public BankDatabase() {
		accounts.add(new Account(12345, 54321, 1000.0, 1200.0));
		accounts.add(new Account(98765, 56789, 200.0, 200.0));
		accounts.add(new Account(22222, 22222, 6200.0, 6200.0));
		accounts.add(new Account(33333, 33333, 2500.0, 2500.0));
		accounts.add(new Account(44444, 44444, 4200.0, 4200.0));
		accounts.add(new Account(55555, 55555, 3200.0, 3200.0));
		accounts.add(new Account(66666, 66666, 1200.0, 1200.0));
		accounts.add(new Account(77777, 77777, 9200.0, 9200.0));
		accounts.add(new Account(88888, 88888, 2500.0, 2500.0));
		accounts.add(new Account(11111, 11111, 2000.0, 2000.0));
		
		 // just 2 accounts for testing
		/*accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
		accounts[1] = new Account(98765, 56789, 200.0, 200.0);
		accounts[2] = new Account(22222, 22222, 6200.0, 6200.0);
		accounts[3] = new Account(33333, 33333, 2500.0, 2500.0);
		accounts[4] = new Account(44444, 44444, 4200.0, 4200.0);
		accounts[5] = new Account(55555, 55555, 3200.0, 3200.0);
		accounts[6] = new Account(66666, 66666, 1200.0, 1200.0);
		accounts[7] = new Account(77777, 77777, 9200.0, 9200.0);
		accounts[8] = new Account(88888, 88888, 2500.0, 2500.0);
		accounts[9] = new Account(11111, 11111, 2000.0, 2000.0);*/
	} // end no-argument BankDatabase constructor

	// retrieve Account object containing specified account number
	public Account getAccount(int accountNumber) {

		// loop through accounts searching for matching account number
		for (Account currentAccount : accounts) {
			// return current account if match found
			if (currentAccount.getAccountNumber() == accountNumber)
				// System.out.println(currentAccount);
				return currentAccount;
		} // end for

		return null; // if no matching account was found, return null
	} // end method getAccount

	// determine whether user-specified account number and PIN match
	// those of an account in the database
	public boolean authenticateUser(int userAccountNumber, int userPIN) {
		// attempt to retrieve the account with the account number
		this.accountinfo = userAccountNumber;
		Account userAccount = getAccount(userAccountNumber);

		// if account exists, return result of Account method validatePIN
		if (userAccount != null)
			return userAccount.validatePIN(userPIN);
		else
			return false; // account number not found, so return false
	} // end method authenticateUser

	// return available balance of Account with specified account number
	public double getAvailableBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getAvailableBalance();
	} // end method getAvailableBalance

	// return total balance of Account with specified account number
	public double getTotalBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getTotalBalance();
	} // end method getTotalBalance

	// credit an amount to Account with specified account number
	public void credit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).credit(amount);
	} // end method credit

	// debit an amount from of Account with specified account number
	public void debit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).debit(amount);
	} // end method debit
} // end class BankDatabase

/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and * Pearson Education,
 * Edited by Avinash. *
 *************************************************************************/