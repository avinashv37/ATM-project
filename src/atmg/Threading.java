package atmg;

import java.util.ArrayList;

public class Threading implements Runnable {
	   public Thread t;
	   StringBuilder build = new StringBuilder("");
	   //StringBuilder buildexit = new StringBuilder("");
	   public static ArrayList<Long> Threadlist = new ArrayList<Long>();
	   private newgui gui;
	  

	   public void setnewgui(newgui gui){
		   this.gui = gui;
	   }
	   public void run() {
	      
		  System.out.println("Threading in Thread "+t.getId());
	      ATM theATM = new ATM();
	      theATM.setgui(gui,t);
	      theATM.setbuild(build,Threadlist);
	      theATM.run();
	      
	     
	    
	      }
	   
	   public void start ()
	   {
	      {
	         t = new Thread (this);
	         t.start ();
	      }
	   }

	

	}
