package atmg;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class newguilogin {
	public JPasswordField passwordField;
	public JTextField textArea;
	private ATM atmRef;
	public JButton login;
	StringBuilder builder;
	static ArrayList<StringBuilder> dstart = new ArrayList<StringBuilder>();
	int text1;
	int pass1;
	newgui window;
	JPanel gui = new JPanel();
	int i;
	newguimenu menu = new newguimenu();
	Thread t;

	public newguilogin() {
		// TODO Auto-generated constructor stub
		// initialize();
	}

	public void setATM(ATM obj, newgui nwgui, Thread t) {
		this.atmRef = obj;
		this.window = nwgui;
		this.t = t;
	}

	public void initialize() {
		// TODO Auto-generated method stub
		i = window.Tabs.indexOfTab("Thread: " + String.valueOf(t.getId()));
		System.out.println(i);
		window.Tabs.addTab("Thread: " + String.valueOf(t.getId()), gui);
		System.out.println("login thread" + t.getId());
		gui.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		textArea = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(0, 100, 0, 100);
		gui.add(textArea, c);

		passwordField = new JPasswordField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridheight = 2;
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(100, 100, 0, 100);
		gui.add(passwordField, c);

		login = new JButton("login");
		c.weightx = 0.5;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 16;
		c.insets = new Insets(100, 250, 0, 250);
		gui.add(login, c);

		actionListener b1 = new actionListener();

		textArea.addActionListener(b1);
		passwordField.addActionListener(b1);
		login.addActionListener(b1);
	}

	public class actionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton src = (JButton) e.getSource();
			if (src.equals(login)) {
				System.out.println("login works");
				String TA1 = textArea.getText();
				text1 = Integer.parseInt(TA1);
				@SuppressWarnings("deprecation")
				String PF1 = passwordField.getText();
				pass1 = Integer.parseInt(PF1);
				// System.out.println(t.getId());
				atmRef.authenticateUser(text1, pass1);
			}

		}
	}

}
