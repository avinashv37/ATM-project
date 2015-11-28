package atmg;

import java.awt.CardLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class threadclicknf extends JFrame {
	
	public JPanel clickfn= new JPanel(),gui= new JPanel(),trasgui= new JPanel(),contentpanel = new JPanel();
	public JTabbedPane Tabs = new JTabbedPane();
	public JButton loginpage, filloginfo,createlogin ;
	public JLabel label1 ,label2;
	private CardLayout cardlayout = new CardLayout();
	//static JPanel panel1 = new JPanel();
	
	
	// function variables
	private Threading threader;

	public static void main(String[] args) {
		threadclicknf tf = new threadclicknf();
		tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tf.setSize(700,700);
		tf.setVisible(true);
		tf.setLocation(400,20);
	}
	
	public threadclicknf(int a)
	{
		System.out.println(a);
	}
	public threadclicknf() {
		super("ATM");
		Initialize();
	}
	
	public void Initialize()
	{
		
		loginpage = new JButton("Go to loginpage");
		filloginfo = new JButton("go to fill log info");
		createlogin = new JButton("create a new user");
		// TODO Auto-generated constructor stub
		
		actionListener a1 = new actionListener(); 
		
		loginpage.addActionListener(a1);
		filloginfo.addActionListener(a1);
		createlogin.addActionListener(a1);
		

		clickfn.add(loginpage);
		clickfn.add(filloginfo);
		
		
		contentpanel.setLayout(cardlayout);
		
		
		contentpanel.add(Tabs, "tab");
		Tabs.add(clickfn,"panel1");
		Tabs.add(trasgui,"panel3");
		
		this.setContentPane(contentpanel);
		
		cardlayout.show(contentpanel, "tab");
	}
	public class actionListener implements ActionListener
	{


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton src = (JButton)e.getSource();
			if(src.equals(loginpage))
				//threader = new Threading();
				//threader.start();
				Tabs.addTab("panel2", gui);
			
			
			
		}
	}
}
