package atmg;

import java.util.ArrayList;
import java.util.List;

public class clickfunction {

	static List<newguilogin> list = new ArrayList<newguilogin>();
	ATM atmref;
	create cr;

	public clickfunction() {
		// clickfunction.list = new ArrayList<gui1>();

	}

	void setatm(ATM atmobj) {
		this.atmref = atmobj;
	}

	
	/*
	 * static void doAllClicks() { try { for (newguilogin gui : list) {
	 * newguilogin.doClick();
	 * 
	 * }
	 * 
	 * } catch (Exception e) {
	 * 
	 * }
	 * 
	 * }
	 */

	static void setlogin() {
		// gui1 gui = new gui1();
		try {
			if (list.get(0) != null) {
				list.get(0).textArea.setText("12345");
				list.get(0).passwordField.setText("54321");

			}
			if (list.get(1) != null) {
				list.get(1).textArea.setText("98765");
				list.get(1).passwordField.setText("56789");

			}
			if (list.get(2) != null) {
				list.get(2).textArea.setText("11111");
				list.get(2).passwordField.setText("11111");

			}
			if (list.get(3) != null) {
				list.get(3).textArea.setText("22222");
				list.get(3).passwordField.setText("22222");

			}
			if (list.get(4) != null) {
				list.get(4).textArea.setText("33333");
				list.get(4).passwordField.setText("33333");

			}
			if (list.get(5) != null) {
				list.get(5).textArea.setText("44444");
				list.get(5).passwordField.setText("44444");

			}
			if (list.get(6) != null) {
				list.get(6).textArea.setText("55555");
				list.get(6).passwordField.setText("55555");

			}
			if (list.get(7) != null) {
				list.get(7).textArea.setText("66666");
				list.get(7).passwordField.setText("66666");

			}
			if (list.get(8) != null) {
				list.get(8).textArea.setText("77777");
				list.get(8).passwordField.setText("77777");

			}
			if (list.get(9) != null) {
				list.get(9).textArea.setText("88888");
				list.get(9).passwordField.setText("88888");

			}

		} catch (Exception e) {

			// System.out.println(" simple error do nothing");
		}
	}
}
