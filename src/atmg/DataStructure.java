package atmg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

class Table
{
	public List<DataStructure> a1 = new ArrayList<DataStructure>();
	
	public List<DataStructure> setreport(DataStructure dataStr) {
		a1.add(dataStr
			//	new DataStructure(accountnumber, transamount, totalamount, amount, transdate, type)
				);
		return a1;
	}
	
	public void report() throws ParseException {

		StringBuilder build = new StringBuilder("");
		for (int i = 0; i < a1.size(); i++) {
			try {
				if (i <= 20) {
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// JOptionPane.showInputDialog(null, "Enter the
					// start date
					// of your transaction");
					Date date1 = sdf.parse("2015-09-28");
					Date date = sdf.parse("2016-10-30");
					Date datel1 = (a1.get(i).transdate);
					System.out.println(sdf.format(date1));
					System.out.println(sdf.format(date));
					if ((datel1.after(date1)) && (datel1.before(date))) {
						// String
						// transdate=DateFormat.format(a1.get(i).transdate);
						build.append("Account number             : " + a1.get(i).accountnumber + "\n"
								+ "Transfer type                   : " + a1.get(i).type + "\n"
								+ "Amount Transfered        : " + a1.get(i).transamount + " $" + "\n"
								+ "Date of transfer               : " + a1.get(i).transdate + "\n"
								+ "Account Balance             : " + a1.get(i).amount + " $" + "\n"
								+ "Total Account Balance   : " + a1.get(i).totalamount + " $" + "\n\n");

					}
				} else
					throw new LimitException("Limit exceededs");
			} catch (LimitException e) {
				JOptionPane.showMessageDialog(null, "\nabove 20 statements cannot be dispayed");
			}
		}

		JOptionPane.showMessageDialog(null, build, "Balance Transaction Statement", JOptionPane.INFORMATION_MESSAGE);

	}

	public class LimitException extends Exception {

		private static final long serialVersionUID = 1L;

		public LimitException(String message) {
			super(message);
		}

	}
}

public class DataStructure {
	int accountnumber;
	double amount;
	Date transdate;
	double transamount;
	String type;
	double totalamount;
	

	public DataStructure(int accountnumber, double transamount, double totalamount, double amount, Date transdate,
			String type) {
		this.accountnumber = accountnumber;
		this.transamount = transamount;
		this.amount = amount;
		this.totalamount = totalamount;
		this.transdate = transdate;
		this.type = type;
	}

	public DataStructure() {

	}

/*	public List<DataStructure> setreport() {
		a1.add(new DataStructure(accountnumber, transamount, totalamount, amount, transdate, type));
		return a1;
	}
	*/

/*	public void report() throws ParseException {

		StringBuilder build = new StringBuilder("");
		for (int i = 0; i < a1.size(); i++) {
			try {
				if (i <= 20) {
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// JOptionPane.showInputDialog(null, "Enter the
					// start date
					// of your transaction");
					Date date1 = sdf.parse("2015-09-28");
					Date date = sdf.parse("2016-10-30");
					Date datel1 = (a1.get(i).transdate);
					System.out.println(sdf.format(date1));
					System.out.println(sdf.format(date));
					if ((datel1.after(date1)) && (datel1.before(date))) {
						// String
						// transdate=DateFormat.format(a1.get(i).transdate);
						build.append("Account number             : " + a1.get(i).accountnumber + "\n"
								+ "Transfer type                   : " + a1.get(i).type + "\n"
								+ "Amount Transfered        : " + a1.get(i).transamount + " $" + "\n"
								+ "Date of transfer               : " + a1.get(i).transdate + "\n"
								+ "Account Balance             : " + a1.get(i).amount + " $" + "\n"
								+ "Total Account Balance   : " + a1.get(i).totalamount + " $" + "\n\n");

					}
				} else
					throw new LimitException("Limit exceededs");
			} catch (LimitException e) {
				JOptionPane.showMessageDialog(null, "\nabove 20 statements cannot be dispayed");
			}
		}

		JOptionPane.showMessageDialog(null, build, "Balance Transaction Statement", JOptionPane.INFORMATION_MESSAGE);

	}

	public class LimitException extends Exception {

		private static final long serialVersionUID = 1L;

		public LimitException(String message) {
			super(message);
		}

	}
*/
}
