package atmg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class weathergui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	WOEIDfinder WOEID = new WOEIDfinder();
	JTextArea formattedTextField ;
	
	/**
	 * Launch the application.
	 */

	
	/**
	 * Create the frame.
	 */
	
	public weathergui() {
		WOEID.setweathergui(this);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(217, 51, 142, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Location/Zipcode");
		lblNewLabel.setBounds(23, 54, 151, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Check Weather");
		btnNewButton.setBounds(156, 110, 121, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						WOEID.generateXML(textField.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
			}
		});
		contentPane.add(btnNewButton);
		
		//formattedTextField.setBounds(15, 158, 405, 96);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(414, 100);
		scrollPane.setLocation(10, 151);
		contentPane.add(scrollPane);
		
		formattedTextField = new JTextArea();
		scrollPane.setViewportView(formattedTextField);
	}
}
