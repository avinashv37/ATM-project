package atmg;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class newgui extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel clickfn= new JPanel(),gui= new JPanel(),trasgui= new JPanel(),contentpanel = new JPanel(),topane = new JPanel();
	public static JTabbedPane Tabs = new JTabbedPane(JTabbedPane.TOP);
	JLayeredPane layeredPane = new JLayeredPane();
	public JButton loginpage, filloginfo,createlogin,weather ;
	public JTextArea textArea;
	public JLabel label1 ,label2;
	private CardLayout cardlayout = new CardLayout();
	//static JPanel panel1 = new JPanel();
	newguilogin nw;
	clickfunction click=new clickfunction();
	create cr= new create();
	Threading threader ;
	TitledBorder title;
	actionListener action;
	ATM atm;
	public static void main(String[] args) {
		newgui tf = new newgui();
		tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tf.setSize(700,700);
		tf.setVisible(true);
		tf.setLocation(400,20);
	}
	
	public newgui(int a)
	{
		System.out.println(a);
	}
	
	
	
	public newgui() {
		super("ATM");
		Initialize();
	}
	

	public void Initialize()
	{

		nw= new newguilogin();
		//nw.setgui(this);
		loginpage = new JButton("Go to loginpage");
		filloginfo = new JButton("go to fill log info");
		createlogin = new JButton("create a new user");
		textArea = new JTextArea(10,20);
		weather = new JButton("Weather");
		
		// TODO Auto-generated constructor stub
		
	
		
		actionListener a1 = new actionListener(); 
		a1.setaction(this);
		loginpage.addActionListener(a1);
		filloginfo.addActionListener(a1);
		createlogin.addActionListener(a1);
		weather.addActionListener(a1);
		
		clickfn.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,200,0,200);
		clickfn.add(loginpage,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(75,200,0,200);
		clickfn.add(filloginfo,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(75,200,0,200);
		clickfn.add(createlogin,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=1;
		c.gridwidth=10;
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(75,200,0,200);
		textArea.setEditable(false);
		title= BorderFactory.createTitledBorder("Output");
		title.setTitleJustification(TitledBorder.CENTER);
		//scrollPane.setViewportView(textArea);
		textArea.setBorder(title);
		textArea.setAutoscrolls(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setAutoscrolls(true);
		clickfn.add(scrollPane,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridwidth=1;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(75,200,0,200);
		clickfn.add(weather,c);
		
		
		contentpanel.setLayout(cardlayout);
		
		
		contentpanel.add(layeredPane, "layered");
		Tabs.add(clickfn,"panel1");
		layeredPane.add(topane, "topane");
		
		contentpanel.add(Tabs, "tab");
		Tabs.setBounds(75, 100, 424, 166);
		
		
		
		//Tabs.add(trasgui,"panel3");
		
		this.setContentPane(contentpanel);
		
		cardlayout.show(contentpanel, "tab");
	}
	public class actionListener implements ActionListener
	{

		newgui gui;

		public void setaction(newgui gui)
		{
			this.gui = gui;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton src = (JButton)e.getSource();
			if(src.equals(loginpage))
			{
				threader = new Threading();
				threader.setnewgui(gui);
				threader.setatm(atm);
				threader.start();
				//Tabs.addTab("panel2", gui);
				//nw = new newguilogin();
				//nw.initialize();
				int selectedIndex = Tabs.getSelectedIndex();
	            int nextIndex = selectedIndex == Tabs.getTabCount()-1 ? 0 : selectedIndex+1;
	            System.out.println(nextIndex);
	            //Tabs.setSelectedIndex(nextIndex);
				// Tabs.setSelectedIndex(Tabs.getSelectedIndex());
			}
			if(src.equals(filloginfo))
			{
				click.setlogin();
			}
			if(src.equals(createlogin))
			{
				//cr.setatm(atm);
				cr.setatm(atm);
				cr.setVisible(true);
				cr.setcreate(cr);
				cr.setclick(click);
				cr.setLocation(500, 200);
			}
			if(src.equals(weather))
			{
				weathergui frame = new weathergui();
				frame.setLocation(500,200);
				frame.setVisible(true);
			}
			
		}
	}
}
