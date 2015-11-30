package atmg;

import java.util.ArrayList;

public class threadinglogin implements Runnable {
	   public Thread t;
	   private Table data;
	   public Thread st;
	   private ATM atmref;
	   StringBuilder build = new StringBuilder("");
	   //StringBuilder buildexit = new StringBuilder("");
	   public static ArrayList<Long> Threadlist = new ArrayList<Long>();
	   public newguimenu windowmenu = new newguimenu();
	   private newguilogin login;
	   private newgui window;
	  
	   public void setatm(ATM obj, Table table)
		{
			this.atmref=obj;
			this.data = table;
		}
		public void setlogin(newgui window,Thread t,newguilogin login )
		{
			this.login = login;
			//this.i=i;
			this.t=t;
			this.window =window;
		}

	   public void run() {  
		   Thread customer = Thread.currentThread();
		   windowmenu.setatm(atmref, data);
		   windowmenu.setlogin( window, t, customer, login);
		   windowmenu.initialize();
	   }
	    public void start ()
	   {
		 // System.out.println("Starting Thread:" +  text1 + "\n" );
	      //build.append("Starting Thread: " +  text1 + "," );
	     // if (t == null)
	      {
	         t = new Thread (this);
	         t.start ();
	      }
	   }

}
