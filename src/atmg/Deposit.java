package atmg;
// Deposit.java

// Represents a deposit ATM transaction

import java.util.Date;

import javax.swing.JOptionPane;
import atmg.BalanceInquiry;

public class Deposit extends Transaction {
	private double amount; // amount to deposit
	private DepositSlot depositSlot; // reference to deposit slot
	private final static int CANCELED = 0; // constant for cancel option
	CurrentDate Date = new CurrentDate();
	Date date = Date.getDate();
	private Table data;

	// Deposit constructor
	public Deposit(int userAccountNumber, BankDatabase atmBankDatabase, DepositSlot atmDepositSlot,Table table) {
		// initialize superclass variables
		super(userAccountNumber, atmBankDatabase);

		depositSlot = atmDepositSlot;
		this.setup(table);
	} // end Deposit constructor

	public void setup(Table dataobj) {
		this.data = dataobj;
	}

	// perform transaction
	public void execute() {
		BankDatabase bankDatabase = getBankDatabase(); // get reference
		amount = promptForDepositAmount(); // get deposit amount from user

		// check whether user entered a deposit amount or canceled
		if (amount != CANCELED) {
			try {
				if (amount > 0) {
					// request deposit envelope containing specified amount
					String opamount = String.format("%.2f", amount);
					JOptionPane.showMessageDialog(null,
							"\nPlease insert a deposit envelope containing " + "\n" + opamount + ".");

					// receive deposit envelope
					boolean envelopeReceived = depositSlot.isEnvelopeReceived();

					// check whether deposit envelope was received
					if (envelopeReceived) {

						// d.report();
						JOptionPane.showMessageDialog(null,
								"\nYour envelope has been " + "received.\nNOTE: The money just deposited will not "
										+ "be available until we verify the amount of any "
										+ "enclosed cash and your checks clear.");

						// credit account to reflect the deposit
						bankDatabase.credit(getAccountNumber(), amount);
						String type = "Deposit";
						BalanceInquiry balance = new BalanceInquiry(accountNumber, bankDatabase);
						double accamount = bankDatabase.getAvailableBalance(getAccountNumber());
						double totalamount = bankDatabase.getTotalBalance(getAccountNumber());
						// DataStructure d = new DataStructure(accountNumber,
						// amount, totalamount, accamount, date, type);
						// d.setreport();
		//				DataStructure d1 = new DataStructure();
						data.a1.add(new DataStructure(accountNumber, amount, totalamount, accamount, date, type));
						balance.execute();
					} // end if
					else // deposit envelope not received
					{
						JOptionPane.showMessageDialog(null,
								"\nYou did not insert an " + "envelope, so the ATM has canceled your transaction.");
					} // end else
				} else
					throw new NegativeAmountException("negative balance");
			} catch (NegativeAmountException e) {
				JOptionPane.showMessageDialog(null, "\nDeposit Amount Dont Enter Negative Amount");
			}
		} // end if
		else // user canceled instead of entering amount
		{
			JOptionPane.showMessageDialog(null, "\nCanceling transaction...");
		} // end else
	} // end method execute

	// prompt user to enter a deposit amount in cents
	private double promptForDepositAmount() {
		// display the prompt
		int input = 0;
		try {
			String value = JOptionPane.showInputDialog(null,
					"\nPlease enter a deposit amount in " + "CENTS (or 0 to cancel): ");
			input = Integer.parseInt(value); // receive input of deposit amount
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "\nCanceling transaction...");
		}
		// check whether the user canceled or entered a valid amount
		if (input == CANCELED)
			return CANCELED;
		else {
			return (double) input / 100; // return dollar amount
		} // end else
	} // end method promptForDepositAmount

	public class NegativeAmountException extends Exception {

		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		public NegativeAmountException(String message) {
			super(message);
		}
	}
} // end class Deposit

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