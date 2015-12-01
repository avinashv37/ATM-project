package atmg;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class PromoSignup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// int chk;
	static ArrayList<ArrayList<Integer>> accountlist = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> cbk;
	Promotion promotion;
	ListedPromotion list;
	// ATM atm;
	private JPanel contentPane;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	private JCheckBox checkBox_5;
	private JCheckBox checkBox_6;
	private JCheckBox checkBox_7;
	private JCheckBox checkBox_8;
	private JCheckBox checkBox_9;
	private JCheckBox checkBox_10;
	ATM atmref;
	private int a;
	// private BankDatabase bank;
	private int accountinfo;
	ArrayList<Integer> currentaccountinfo;
	Integer currentaccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// PromoSignup frame = new PromoSignup();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setpromotion(Promotion obj) {
		this.promotion = obj;
	}

	/**
	 * Create the frame.
	 */
	public PromoSignup(ATM atm) {
		this.atmref = atm;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		checkBox_1 = new JCheckBox("PROMO 1");
		checkBox_1.setBounds(58, 43, 97, 23);
		contentPane.add(checkBox_1);

		checkBox_2 = new JCheckBox("PROMO 2");
		checkBox_2.setBounds(58, 83, 97, 23);
		contentPane.add(checkBox_2);

		checkBox_3 = new JCheckBox("PROMO 3");
		checkBox_3.setBounds(58, 123, 97, 23);
		contentPane.add(checkBox_3);

		checkBox_4 = new JCheckBox("PROMO 4");
		checkBox_4.setBounds(58, 162, 97, 23);
		contentPane.add(checkBox_4);

		checkBox_5 = new JCheckBox("PROMO 5");
		checkBox_5.setBounds(277, 83, 97, 23);
		contentPane.add(checkBox_5);

		checkBox_6 = new JCheckBox("PROMO 6");
		checkBox_6.setBounds(277, 43, 97, 23);
		contentPane.add(checkBox_6);

		checkBox_7 = new JCheckBox("PROMO 7");
		checkBox_7.setBounds(277, 123, 97, 23);
		contentPane.add(checkBox_7);

		checkBox_8 = new JCheckBox("PROMO 8");
		checkBox_8.setBounds(277, 162, 97, 23);
		contentPane.add(checkBox_8);

		checkBox_9 = new JCheckBox("PROMO 9");
		checkBox_9.setBounds(58, 201, 97, 23);
		contentPane.add(checkBox_9);

		checkBox_10 = new JCheckBox("PROMO 10");
		checkBox_10.setBounds(277, 201, 97, 23);
		contentPane.add(checkBox_10);

		JLabel lblPleaseSelect = new JLabel("Please Select 5 Promotions that you would like to prescribe");
		lblPleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelect.setBounds(44, 11, 321, 14);
		contentPane.add(lblPleaseSelect);

		JButton btnSubscribe = new JButton("Subscribe");
		btnSubscribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					

					for (int i = 0; i < accountlist.size(); i++) {
						currentaccountinfo = accountlist.get(i);
						currentaccount = currentaccountinfo.get(0);
						if (currentaccount == atmref.currentAccountNumber) {
							a = a + 1;
							System.out.println(currentaccountinfo);
							System.out.println(accountinfo);
							System.out.println(accountlist);
							JOptionPane.showMessageDialog(null, "You have already subscribed promotion "
									+ "The promotion which you have selected has not been inputed");
							list = new ListedPromotion();
							list.start(currentaccountinfo);
							list.setatm(atmref);
							// promotion = new Promotion();
							// promotion.setpromotion(cbk);
							// promotion.test();

						}

					}
					if (accountlist.isEmpty() || a != 1) {

						cbk = new ArrayList<Integer>();
						if (cbk.isEmpty()) {
							cbk.add(atmref.currentAccountNumber);
							if (checkBox_1.isSelected()) {
								cbk.add(1);
							}
							if (checkBox_2.isSelected()) {
								cbk.add(2);
							}
							if (checkBox_3.isSelected()) {
								cbk.add(3);
							}
							if (checkBox_4.isSelected()) {
								cbk.add(4);
							}
							if (checkBox_5.isSelected()) {
								cbk.add(5);
							}
							if (checkBox_6.isSelected()) {
								cbk.add(6);
							}
							if (checkBox_7.isSelected()) {
								cbk.add(7);
							}
							if (checkBox_8.isSelected()) {
								cbk.add(8);
							}
							if (checkBox_9.isSelected()) {
								cbk.add(9);
							}
							if (checkBox_10.isSelected()) {
								cbk.add(10);
							}
						}

						if (cbk.size() > 6) {
							JOptionPane.showMessageDialog(null, "Click maximum of 5 operations");
							cbk.clear();

						} else {
							accountlist.add(cbk);
							System.out.println(cbk);
							System.out.println(accountinfo);
							System.out.println(accountlist);
							list = new ListedPromotion();
							list.start(cbk);
		
						}
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		btnSubscribe.setBounds(162, 227, 102, 23);
		contentPane.add(btnSubscribe);
	}
	/*
	 * public void setaccount(int accountinfo) { this.accountinfo=accountinfo; }
	 */
}
