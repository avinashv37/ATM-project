package atmg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import javafx.embed.swing.SwingNode;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Set;
import java.awt.event.ActionEvent;

public class TransGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ATM atm;
	public static TransGUI frame;
	private PromoSignup promo;
	private Table data;
	JButton btnExit;
	JTextArea textArea;
	threadtransgui tr = new threadtransgui();
	Thread gt;
	Thread t;

	// String a = String.valueOf(t.getId());
	// ArrayList<String> stringer= new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	public void setThread(Thread t) {
		this.t = t;
		// stringer.add(a);
		// textArea.setText(stringer.get(0));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// TransGUI frame = new TransGUI();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TransGUI(ATM atmObj, Table table) {
		SwingUtilities.invokeLater(tr);
		System.out.println("transgui " + Thread.currentThread().getId());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.atm = atmObj;
		this.data = table;

		JButton btnConfirm = new JButton("BALANCE_INQUIRY\r\n");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ATM atm = new ATM();
				// tr = new threadtransgui(1);
				gt = new Thread(tr);
				tr.setthread(1);
				gt.start();

				// atm.performTransactions(1);
				// gui1 gui=new gui1();

			}
		});
		btnConfirm.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnConfirm.setBounds(102, 11, 199, 39);
		contentPane.add(btnConfirm);

		JButton btnWithdrawl = new JButton("WITHDRAWL\r\n");
		btnWithdrawl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ATM atm = new ATM();
				// tr = new threadtransgui(2);
				gt = new Thread(tr);
				// System.out.println("withdrawl"+Thread.currentThread().getId());
				tr.setthread(2);
				gt.start();

			}
		});
		btnWithdrawl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnWithdrawl.setBounds(102, 76, 199, 39);
		contentPane.add(btnWithdrawl);

		JButton btnDeposit = new JButton("DEPOSIT\r\n");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ATM atm = new ATM();
				// tr = new threadtransgui(3);
				gt = new Thread(tr);
				tr.setthread(3);
				gt.start();
				// System.out.println("deposit"+Thread.currentThread().getId());
			}
		});
		btnDeposit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDeposit.setBounds(102, 143, 199, 39);
		contentPane.add(btnDeposit);

		JButton btnreport = new JButton("REPORT\r\n");
		btnreport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ATM atm = new ATM();
				// DataStructure data = new DataStructure();
				// tr = new threadtransgui(4);
				gt = new Thread(tr);
				tr.setthread(4);
				gt.start();

			}
		});
		btnreport.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnreport.setBounds(102, 211, 199, 39);
		contentPane.add(btnreport);

		JButton btnpromo = new JButton("PROMO\r\n");
		btnpromo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ATM atm = new ATM();

				// DataStructure data = new DataStructure();
				// tr = new threadtransgui(5);
				tr.setthread(5);
				gt = new Thread(tr);
				// System.out.println("promo"+Thread.currentThread().getId());
				gt.start();

			}
		});
		btnpromo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnpromo.setBounds(102, 281, 199, 39);
		contentPane.add(btnpromo);

		btnExit = new JButton("LOG OUT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// tr = new threadtransgui(6);
				gt = new Thread(tr);
				tr.setthread(6);
				// System.out.println("logout"+Thread.currentThread().getId());
				gt.start();

			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(102, 353, 199, 39);
		contentPane.add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 440, 280, 200);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblClickTheBelow = new JLabel("    Thread " + Thread.currentThread().getId() + " is running ");
		lblClickTheBelow.setBounds(102, 500, 199, 39);
		contentPane.add(lblClickTheBelow);
		/*
		 * JTextArea textbox = new JTextArea(); textbox.setEditable(false);
		 * textbox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		 * textbox.setBounds(102, 453, 199, 39); contentPane.add(new
		 * JScrollPane(textbox));
		 */

	}

	class threadtransgui implements Runnable {
		Threading threadobj;
		private int i;

		void setthread(int i) {
			this.i = i;
		}

		public void run() {
			if (i == 1) {
				textArea.append("Balance Thread: " + Thread.currentThread().getId() + "\n");
				atm.performTransactions(1);

			} else if (i == 2) {
				textArea.append("Withdrwal Thread: " + Thread.currentThread().getId() + "\n");
				atm.performTransactions(2);
			} else if (i == 3) {
				textArea.append("Deposit Thread: " + Thread.currentThread().getId() + "\n");

				atm.performTransactions(3);
			} else if (i == 4) {
				textArea.append("Report Thread: " + Thread.currentThread().getId() + "\n");
				try {
					data.report();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (i == 5) {
				textArea.append("Promo Thread: " + Thread.currentThread().getId() + "\n");
				try {
					promo = new PromoSignup(atm);
					promo.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (i == 6) {
				t.resume();
				// textArea.append("Logout thread:
				// "+Thread.currentThread().getId()+"\n");
				/*
				 * try { textArea.append("Thread "+t.getId()+
				 * " sleeps for 10 sec before logout"); t.sleep(10000); } catch
				 * (InterruptedException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); } atm.closeTransGUI();
				 */
				/// data = new DataStructure();
				// data.a1.clear();
				// Threading w = new Threading();

			}
		}
	}
}
