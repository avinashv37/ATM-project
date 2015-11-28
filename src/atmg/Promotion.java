package atmg;

import java.util.ArrayList;

public class Promotion {

	public ArrayList<Integer> promotion_Subscribed;
	public PromoSignup promosignup;
	public int accountinfo;
	public ListedPromotion list = new ListedPromotion();
	ArrayList<Integer> currentaccountinfo;
	int currentaccount;
	public ATM atmref;

	public Promotion() {
		// promosignup = new PromoSignup();
		// promosignup.setpromotion(this);
	}
	public Promotion(ATM Atmref)
	{
		this.atmref = Atmref;
	}
	/*
	 * public Promotion(ATM obj) { this.atm = obj;
	 * this.accountinfo=atm.currentAccountNumber;
	 * System.out.println(atm.currentAccountNumber); }
	 */

	public void setpromotion(ArrayList<Integer> promotion_Subscribed) {
		// promotion_Subscribed.set(0, accountinfo);
		this.promotion_Subscribed = promotion_Subscribed;

		// displaypromo();

	}
	public void displaypromo()
	{
		try
		{
		for (int i = 0; i < PromoSignup.accountlist.size(); i++) {
			currentaccountinfo = PromoSignup.accountlist.get(i);
			currentaccount = currentaccountinfo.get(0);
			if (currentaccount == atmref.currentAccountNumber) {
				System.out.println(currentaccountinfo);
				System.out.println(accountinfo);
				System.out.println(PromoSignup.accountlist);
				list.start(currentaccountinfo);

				// promotion = new Promotion();
				// promotion.setpromotion(cbk);
				// promotion.test();

			}

		}
		}
		catch(Exception e)
		{
			System.out.println("");
		}
	}


	public Integer getaccountnumber() {
		return null;

	}
	/*
	 * public void setaccount() { this.accountinfo =atm.currentAccountNumber; }
	 * public void test() { System.out.println(atm.currentAccountNumber); }
	 */

}
