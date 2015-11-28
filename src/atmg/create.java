package atmg;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

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
	clickfunction click;
	static int j=10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create frame = new create();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void setcreate(create cr)
	{
		this.cr = cr;
	}
	void setclick(clickfunction click)
	{
		this.click = click;
	}
	/**
	 * Create the frame.
	 */
	public create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				String TA1 = textField.getText();
				user = Integer.parseInt(TA1);
				String PA1 = textField.getText();
				pass = Integer.parseInt(PA1);
				click.createlog(j);
				j++;
				cr.setVisible(false);
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
