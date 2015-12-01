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
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/