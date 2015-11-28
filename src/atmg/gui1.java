package atmg;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;

public class gui1 {

	protected JFrame frame;
	public JPasswordField passwordField;
	public JTextField textArea;
	private ATM atmRef;
	public Threading threader;
	public Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	JButton btnNewButton;
	StringBuilder builder;
	int text1;
	int pass1;
	static ArrayList<StringBuilder> dstart = new ArrayList<StringBuilder>();
	Thread t;

	/**
	 * Launch the application.
	 */
	/*
	 * public void setThread(Thread t) { this.t =t;
	 * 
	 * }
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui1 window = new gui1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui1() {
		initialize();
	}

	public void setATM(ATM obj) {
		this.atmRef = obj;
	}

	public void setVisible(boolean b) {
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 11));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAccountNumber.setBounds(29, 13, 104, 26);
		frame.getContentPane().add(lblAccountNumber);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(29, 75, 104, 26);
		frame.getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(229, 75, 165, 26);
		frame.getContentPane().add(passwordField);

		textArea = new JTextField();
		textArea.setBounds(229, 13, 165, 26);
		frame.getContentPane().add(textArea);

		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));

		System.out.println("gui" + Thread.currentThread().getId());

		// System.out.println(Thread.currentThread().getId());

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// ATM atm = new ATM();
				// System.out.println("login"+Thread.currentThread().getId());
				String TA1 = textArea.getText();
				text1 = Integer.parseInt(TA1);
				@SuppressWarnings("deprecation")
				String PF1 = passwordField.getText();
				pass1 = Integer.parseInt(PF1);
				// System.out.println(t.getId());
				atmRef.authenticateUser(text1, pass1);
				// promotion.setaccount(text1);
				// promo.setaccount(text1);
				// builder = threader.build;
			}
		});
		btnNewButton.setBounds(124, 158, 182, 43);
		frame.getContentPane().add(btnNewButton);

		JLabel lblClickTheBelow = new JLabel("    Thread " + Thread.currentThread().getId() + " is running ");
		lblClickTheBelow.setBounds(124, 200, 182, 43);
		frame.getContentPane().add(lblClickTheBelow);

	}

	public void end() {
		textArea.setText(null);
		passwordField.setText(null);

	}

}
