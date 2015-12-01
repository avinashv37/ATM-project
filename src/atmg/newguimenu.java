package atmg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import atmg.newguilogin.actionListener;

public class newguimenu {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ATM atm;
	private PromoSignup promo;
	private Table data;
	JButton Withdraw, Deposit,Balance,Report, Promotion,Logout;
	JTextArea textArea;
	Thread gt;
	Thread t;
	newgui window; 
	newguilogin login;
	int i;
	Thread customer;
	JPanel guimenu = new JPanel();
	
	public newguimenu() {
		// TODO Auto-generated constructor stub
		//initialize();
	}
	public void setlogin(newgui window,Thread t,Thread customer,newguilogin login )
	{
		this.login = login;
		//this.i=i;
		this.t=t;
		this.customer=customer;
		this.window =window;
	}

	public void setatm(ATM obj, Table table)
	{
		this.atm=obj;
		this.data = table;
	}
	
	

	public void initialize()
	{
		System.out.println(i);
		window.Tabs.setSelectedIndex(i);
		System.out.println("thread mainmenu: "+t.getId());
		int j = window.Tabs.indexOfTab("Thread: "+String.valueOf(t.getId()));
		window.Tabs.removeTabAt(j);
		window.Tabs.add("Thread: "+String.valueOf(t.getId()), guimenu);
		Balance = new JButton("BALANCE_INQUIRY\r\n");
		guimenu.add(Balance);
		
		Withdraw = new JButton("WITHDRAW\r\n");
		guimenu.add(Withdraw);
		
		Deposit = new JButton("DEPOSIT\r\n");
		guimenu.add(Deposit);
		
		Report = new JButton("REPORT\r\n");
		guimenu.add(Report);
		
		Promotion = new JButton("PROMOTION\r\n");
		guimenu.add(Promotion);
		
		Logout = new JButton("LOG OUT\r\n");
		guimenu.add(Logout);
		
	actionListener b1 = new actionListener(); 
		
		Balance.addActionListener(b1);
		Withdraw.addActionListener(b1);
		Deposit.addActionListener(b1);
		Report.addActionListener(b1);
		Promotion.addActionListener(b1);
		Logout.addActionListener(b1);
	}

	public class actionListener implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton src = (JButton)e.getSource();
			if(src.equals(Balance))
			{
				System.out.println("balance");
				atm.performTransactions(1);
			}
			if(src.equals(Withdraw))
			{
				atm.performTransactions(2);
			}
			if(src.equals(Deposit))
			{
				atm.performTransactions(3);
			}
			if(src.equals(Report))
			{
				try {
					data.report();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(src.equals(Promotion))
			{
				try {
					promo = new PromoSignup(atm);
					promo.setLocation(500,200);
					promo.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(src.equals(Logout))
			{
				
				
				System.out.println("thread end "+t);
				t.resume();
				data.a1.clear();
			}
		}
	}
	

}
