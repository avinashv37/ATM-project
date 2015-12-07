package atmg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class create extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static int user;
	static int pass;
	private JLabel lblUserName;
	private JLabel lblPassword;
	create cr;
	ATM atm= new ATM();
	clickfunction click;
	static int j = 10;

	/**
	 * Launch the application.
	 */

	void setcreate(create cr) {
		this.cr = cr;
	}

	void setclick(clickfunction click) {
		this.click = click;
	}
	/*void setatm(ATM obj)
	{
		this.atm=obj;
	}*/

	/**
	 * Create the frame.
	 */
	public create() {
		super("Sign up form");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(207, 33, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(207, 94, 113, 20);
		contentPane.add(textField_1);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try {
					String TA1 = textField.getText();
					user = Integer.parseInt(TA1);
					String PA1 = textField.getText();
					pass = Integer.parseInt(PA1);
					System.out.println("not entered ");
					atm.createlog();
//					/j++;
					cr.setVisible(false);
				//} catch (Exception e1) {
					//System.err.println(e);
					
				//}
			}
		});
		btnCreate.setBounds(172, 175, 89, 23);
		contentPane.add(btnCreate);

		lblUserName = new JLabel("User name");
		lblUserName.setBounds(65, 36, 64, 14);
		contentPane.add(lblUserName);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(65, 97, 64, 14);
		contentPane.add(lblPassword);
	}
}
