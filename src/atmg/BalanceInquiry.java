package atmg;
// BalanceInquiry.java

// Represents a balance inquiry ATM transaction

import javax.swing.JOptionPane;

public class BalanceInquiry extends Transaction {
	// BalanceInquiry constructor
	public BalanceInquiry(int userAccountNumber, atmg.BankDatabase bankDatabase) {
		super(userAccountNumber, bankDatabase);
		System.out.println("balance thread "+Thread.currentThread().getId());
	} // end BalanceInquiry constructor

	// performs the transaction
	public void execute() {
		// get references to bank database and screen
		atmg.BankDatabase bankDatabase = getBankDatabase();

		// get the available balance for the account involved
		double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

		// get the total balance for the account involved
		double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

		// display the balance information on the screen
		int input = JOptionPane.showOptionDialog(null,
				"\nBalance Information:" + "\n" + " - Available balance: " + availableBalance + "\n - Total balance:"
						+ totalBalance + "\n\n",
				null, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				new String[] { "OK"}, "default");
		if (input == JOptionPane.OK_OPTION) {
			

		} else {
			//windowT.disable();
		}

	} // end method execute
} // end class BalanceInquiry

/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and * Pearson Education,
 * Edited by Avinash.*
 *************************************************************************/