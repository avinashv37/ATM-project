package atmg;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class threadclick extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	clickfunction click=new clickfunction();
	create cr= new create();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					threadclick frame = new threadclick();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public threadclick() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClickThisLogin = new JLabel("Test threading");
		lblClickThisLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickThisLogin.setBounds(100, 92, 272, 14);
		contentPane.add(lblClickThisLogin);

		/*
		 * JButton btnLoginForThreading = new JButton("Thread Login");
		 * btnLoginForThreading.addActionListener(new ActionListener() { public
		 * void actionPerformed(ActionEvent e) {
		 * 
		 * click = new clickfunction(); click.doAllClicks(); } });
		 * btnLoginForThreading.setBounds(172, 188, 125, 23);
		 * contentPane.add(btnLoginForThreading);
		 */

		JLabel lblFillLoginInfo = new JLabel("fill login info in gui and click login here");
		lblFillLoginInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFillLoginInfo.setBounds(100, 117, 259, 14);
		contentPane.add(lblFillLoginInfo);

		JButton btnNewButton = new JButton("Fill log info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click.setlogin();
			}
		});
		btnNewButton.setBounds(172, 143, 125, 23);
		contentPane.add(btnNewButton);

		JButton btnLoginPage = new JButton("Login Page");
		btnLoginPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Threading threader = new Threading();
				threader.start();
			}
		});
		btnLoginPage.setBounds(172, 58, 125, 23);
		contentPane.add(btnLoginPage);
		
		JButton btnNewButton_1 = new JButton("Create login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cr.setVisible(true);
				cr.setcreate(cr);
				cr.setclick(click);
			}
		});
		btnNewButton_1.setBounds(172, 193, 125, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
