package atmg;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class ListedPromotion {
	ArrayList<Integer> Listpromo = new ArrayList<Integer>(10);
	ArrayList<Integer> Randompromolist;
	Integer Randompromo;
	int randompromoposition;
	int promo1 = 1, promo2 = 2, promo3 = 3, promo4 = 4, promo5 = 5, promo6 = 6, promo7 = 7, promo8 = 8, promo9 = 9,
			promo10 = 10;
	StringBuilder build = new StringBuilder("");
	public PromoSignup promo = new PromoSignup(null);
	// Promotion promotion = new Promotion();

	/*
	 * ListedPromotion(ArrayList<Integer> passvalue) { this.Randompromolist =
	 * passvalue; }
	 */
	ListedPromotion() {
		setListedPromotion();
		getListedPromotion();
	}

	public void setListedPromotion() {

		Listpromo.add(0, promo1);
		Listpromo.add(1, promo2);
		Listpromo.add(2, promo3);
		Listpromo.add(3, promo4);
		Listpromo.add(4, promo5);
		Listpromo.add(5, promo6);
		Listpromo.add(6, promo7);
		Listpromo.add(7, promo8);
		Listpromo.add(8, promo9);
		Listpromo.add(9, promo10);

	}

	public static int randInt(int min, int max) {

		Random rand = new Random();
		int rn = rand.nextInt((max - min) + 1) + min;
		return rn;
	}

	public void getListedPromotion() {
		Randompromo = Listpromo.get(randInt(0, 9));
		// randompromoposition=Listpromo.indexOf(Randompromo);
		// Randompromolist=new ArrayList<Integer>(10);
		// Randompromolist.add(randompromoposition);
		// return Randompromo;
	}

	public void start(ArrayList<Integer> promotion_Subscribed) {
		for (int i = 0; i < promotion_Subscribed.size(); i++) {
			if (promotion_Subscribed.get(i) == Randompromo) {
				build.append("Your subscribed promotion " + Randompromo + " is now available");
				
			}
		}
		if (build.length() > 0) {
			JOptionPane.showMessageDialog(null, build);
		} else {
			JOptionPane.showMessageDialog(null, "Your Subscribed promotion is not available at this time");
		}

		promo.setVisible(false);
		// prints the list of promotion in the console.
		System.out.println(Listpromo);
		// prints the random promotion chose by the random algorithm.
		System.out.println(Randompromo);
	}
}
