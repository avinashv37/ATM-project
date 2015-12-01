package atmg;

import java.awt.Menu;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

// ATM.java
// Represents an automated teller machine

public class ATM {

	private boolean userAuthenticated; // whether user is authenticated
	public int currentAccountNumber; // current user's account number
	// private Screen screen; // ATM's screen
	// private Keypad keypad; // ATM's keypad
	private CashDispenser cashDispenser; // ATM's cash dispenser
	private DepositSlot depositSlot; // ATM's deposit slot
	private BankDatabase bankDatabase; // account information database

	// constants corresponding to main menu options
	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int DEPOSIT = 3;
	private static final int EXIT = 4;

	public newguilogin nw;
	public Promotion promo;
	Table table;
	Promotion p;
	Thread t;
	Thread customer;
	threadinglogin logt = new threadinglogin();
	ArrayList<StringBuilder> listb;
	Date d1,d2;
	ArrayList<Long> Threadarray;
	int Threadcount;
	public newguilogin windowlog;
	public newguimenu windowmenu;
	newgui gui;
	WOEIDfinder WOEID = new WOEIDfinder();
	// no-argument ATM constructor initializes instance variables
	public ATM() {
		userAuthenticated = false; // user is not authenticated to start
		currentAccountNumber = 0; // no current account number to start
		// screen = new Screen(); // create screen
		// keypad = new Keypad(); // create keypad
		cashDispenser = new CashDispenser(); // create cash dispenser
		depositSlot = new DepositSlot(); // create deposit slot
		bankDatabase = new BankDatabase(); // create acct info database
		//window = new gui1();
		newguilogin nw;
		//clickfunction.list.add(window);
		listb = new ArrayList<StringBuilder>();
		//window.setATM(this);
		windowlog = new newguilogin();
		table = new Table();
		windowmenu = new newguimenu();
		windowmenu.setatm(this, table);
		p = new Promotion(this);
		

		// promo = new Promotion(this);
	} // end no-argument ATM constructor

	public void setgui(newgui gui,Thread t)
	{
		this.gui=gui;
		this.t=t;
	}
	public void setbuild(StringBuilder build,ArrayList<Long> Threadarray)
	{
		this.Threadarray=Threadarray;
		
		listb.add(build);
		if(listb.size()==9)
		{
			JOptionPane.showMessageDialog(null, listb.get(0));
		}
	}
	public void closeTransGUI() {
		Threadarray.remove(Threadcount-1);
		gui.Tabs.setSelectedIndex(0);
		int j = gui.Tabs.indexOfTab("Thread: "+String.valueOf(t.getId()));
		gui.Tabs.removeTabAt(j);
	}

	
	// start ATM
	public void run() {
		gui.textArea.append("thread"+t.getId()+"\n");
		Threadcount++;
		nw = new newguilogin();
		nw.setATM(this,gui,t);
		nw.initialize();
		//window.setVisible(true);
		//windowthread.Tabs.addTab("panel2",gui);
		this.t= Thread.currentThread();
		Thread.currentThread().suspend();
		System.out.println("thread out");
		//Time difference calculation
	//	gui.Tabs.
		System.out.println(Threadarray.size());
		d2= new Date();// end time
		long a =(d2.getTime()-d1.getTime()/1000%60);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Integer diff = (int) (d2.getTime()-d1.getTime())/1000;
		String diffstring = diff.toString();
		gui.textArea.append("***************************************\n");
		gui.textArea.append("\n"+"Thread: "+t.getId());
		gui.textArea.append("\n"+"Service time            : "+diffstring+" Second's\n");
		System.out.println(diff/1000);
		/*gui.textArea.append("***************************************\n"+"Present Threads running \n");
		for(int i=0;i<Threadarray.size();i++)
		{

			gui.textArea.append("Thread                     : "+Threadarray.get(i)+"\n");
		}*/
		/*try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		gui.textArea.append("***************************************\n");
		closeTransGUI();
		//window.setThread(Thread.currentThread());

	} // end method run

	// attempts to authenticate user against database
	public void authenticateUser(int accountNumber, int pin) {
		gui.textArea.append("\n\n"+"Cutomer Interface: "+t.getId()+"\n");
		customer = Thread.currentThread();
		userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
		//System.out.println(Thread.currentThread().getId());
		// check whether authentication succeeded
		if (userAuthenticated) {
			
			Threading.Threadlist.add(t.getId());
			gui.textArea.append("Customer Logs in     : " + t.getId()+"\n" );
			gui.textArea.append("Present running threads \n");
			for(int i=0;i<Threadarray.size();i++)
			{
				
				gui.textArea.append("Thread                     : "+Threadarray.get(i)+"\n");
			}
			gui.textArea.append("***************************************\n");
			d1 = new Date();// start time
			currentAccountNumber = accountNumber;// save user's account #
			//getClass().window.setVisible(false);
			//windowT.setVisible(true);
			//windowmenu.initialize();
			logt.setatm(this, table);
			logt.start();
			logt.setlogin( gui, t,windowlog);
			//System.out.println("authentication atm"+t.getId());
			//windowT.setthread(t);
			p.displaypromo();
		} // end if
		else
			JOptionPane.showMessageDialog(null, "Invalid account number or PIN. Please try again.");
	} // end method authenticateUser

	// display the main menu and perform transactions
	public void performTransactions(int mainMenuSelection) {
		// local variable to store transaction currently being processed
		Transaction currentTransaction = null;

		// loop while user has not chosen option to exit system
		// show main menu and get user selection
		System.out.println("Main " + mainMenuSelection);

		// decide how to proceed based on user's menu selection
		switch (mainMenuSelection) {
		// user chose to perform one of three transaction types
		case BALANCE_INQUIRY:
		case WITHDRAWAL:
		case DEPOSIT:

			// initialize as new object of chosen type
			currentTransaction = createTransaction(mainMenuSelection);

			currentTransaction.execute(); // execute transaction
			break;
		case EXIT: // user chose to terminate session
			JOptionPane.showInternalMessageDialog(null, "\nExiting the system...");
			break;
		default: // user did not enter an integer from 1-4
			JOptionPane.showInternalMessageDialog(null, "\nYou did not enter a valid selection. Try again.");
			break;
		} // end switch
	} // end method performTransactions
		// return object of specified Transaction subclass

	private Transaction createTransaction(int type) {

		Transaction temp = null; // temporary Transaction variable

		// determine which type of Transaction to create
		switch (type) {
		case BALANCE_INQUIRY: // create new BalanceInquiry transaction
			temp = new BalanceInquiry(currentAccountNumber, bankDatabase);
			break;
		case WITHDRAWAL: // create new Withdrawal transaction
			temp = new Withdrawal(currentAccountNumber, bankDatabase, cashDispenser, this.table);
			break;
		case DEPOSIT: // create new Deposit transaction
			temp = new Deposit(currentAccountNumber, bankDatabase, depositSlot, this.table);
			break;
		} // end switch

		return temp; // return the newly created object
	} // end method createTransaction
} // end class ATM

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