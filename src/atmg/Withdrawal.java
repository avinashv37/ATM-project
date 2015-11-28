package atmg;

import java.util.Date;

import javax.swing.JOptionPane;

import atmg.BalanceInquiry;

// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Withdrawal extends Transaction {
	private int amount; // amount to withdraw
	private CashDispenser cashDispenser; // reference to cash dispenser
	
	Table d1;

	// constant corresponding to menu option to cancel
	private final static int CANCELED = 6;
	CurrentDate Date = new CurrentDate();
	Date date = Date.getDate();

	// Withdrawal constructor
	public Withdrawal(int userAccountNumber, BankDatabase atmBankDatabase, CashDispenser atmCashDispenser, Table d1) {
		// initialize superclass variables
		super(userAccountNumber, atmBankDatabase);

		cashDispenser = atmCashDispenser;
		this.d1 = d1;
	} // end Withdrawal constructor

	// perform transaction
	public void execute() {
		boolean cashDispensed = false; // cash was not dispensed yet
		double availableBalance; // amount available for withdrawal

		// get references to bank database and screen
		BankDatabase bankDatabase = getBankDatabase();
		// loop until cash is dispensed or the user cancels
		do {
			// obtain a chosen withdrawal amount from the user
			amount = displayMenuOfAmounts();

			// check whether user chose a withdrawal amount or canceled
			if (amount != CANCELED) {
				// get available balance of account involved
				availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

				// check whether the user has enough money in the account
				if (amount <= availableBalance) {
					// check whether the cash dispenser has enough money
					if (cashDispenser.isSufficientCashAvailable(amount)) {
						try {

							if (amount > 0) {
								// update the account involved to reflect
								// withdrawal
								bankDatabase.debit(getAccountNumber(), amount);

								cashDispenser.dispenseCash(amount); // dispense
																	// cash
								cashDispensed = true; // cash was dispensed
								String type = "Withdraw";
								BalanceInquiry balance = new BalanceInquiry(accountNumber, bankDatabase);
								double accamount = bankDatabase.getAvailableBalance(getAccountNumber());
								double totalamount = bankDatabase.getTotalBalance(getAccountNumber());

//								DataStructure d1 = new DataStructure();
								d1.a1.add(new DataStructure(accountNumber, amount, totalamount, accamount, date, type));
								// d.setreport();

								// instruct user to take cash
								JOptionPane.showMessageDialog(null, "\nPlease take your cash now.");

								System.out.println(cashDispensed);
								balance.execute();
							} else
								throw new InsufficientBalanceException("no balance");
						} catch (InsufficientBalanceException e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "\n nil balance");
						}
					} // end if
					else // cash dispenser does not have enough cash
						JOptionPane.showMessageDialog(null,
								"\nInsufficient cash available in the ATM." + "\n\nPlease choose a smaller amount.");
				} // end if
				else // not enough money available in user's account
				{
					JOptionPane.showMessageDialog(null,
							"\nInsufficient funds in your account." + "\n\nPlease choose a smaller amount.");
				} // end else
			} // end if
			else // user chose cancel menu option
			{
				JOptionPane.showMessageDialog(null, "\nCanceling transaction...");
				return; // return to main menu because user canceled
			} // end else
		} while (!cashDispensed);

	} // end method execute

	// display a menu of withdrawal amounts and the option to cancel;
	// return the chosen amount or 0 if the user chooses to cancel
	private int displayMenuOfAmounts() {
		int userChoice = 0; // local variable to store return value

		// array of amounts to correspond to menu numbers
		int amounts[] = { 0, 20, 40, 60, 100, 200 };
		try {
			// loop while no valid choice has been made
			while (userChoice == 0) {
				// display the menu
				String value = JOptionPane.showInputDialog(null,
						"\nWithdrawal Menu:" + "\n" + "1 - $20" + "\n" + "2 - $40" + "\n" + "3 - $60" + "\n"
								+ "4 - $100" + "\n" + "5 - $200" + "\n" + "6 - Cancel transaction" + "\n\n"
								+ "\nChoose a withdrawal amount: ");

				int input = Integer.parseInt(value); // get user input through
														// keypad

				// determine how to proceed based on the input value
				switch (input) {
				case 1: // if the user chose a withdrawal amount
				case 2: // (i.e., chose option 1, 2, 3, 4 or 5), return the
				case 3: // corresponding amount from amounts array
				case 4:
				case 5:
					userChoice = amounts[input]; // save user's choice
					break;
				case CANCELED: // the user chose to cancel
					userChoice = CANCELED; // save user's choice
					break;
				default: // the user did not enter a value from 1-6
					JOptionPane.showMessageDialog(null, "\nIvalid selection. Try again.");
				} // end switch

				System.out.println(userChoice);
			} // end while
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "\nIvalid selection. Try again.");
		}
		return userChoice; // return withdrawal amount or CANCELED
	} // end method displayMenuOfAmounts

	public class InsufficientBalanceException extends Exception {

		/**
		* 
		*/
		private static final long serialVersionUID = 1L;

		public InsufficientBalanceException(String message) {
			super(message);
		}
	}
} // end class Withdrawal

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