package atmg;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Threading implements Runnable {
	   public Thread t;
	   private int text1;
	   private int pass1;
	   private ATM atmref;
	   StringBuilder build = new StringBuilder("");
	   //StringBuilder buildexit = new StringBuilder("");
	   public static ArrayList<Long> Threadlist = new ArrayList<Long>();
	  

	   public void run() {
	      
	        // for(int i = 10; i > 0; i--) {
		  // build.append("Thread: " + text1 +"'" + " Thread ID: "+ t.getId());
		 // System.out.println("Thread: " + text1 +"," + " Thread ID: "+ t.getId());
	            // Let the thread sleep for a while.
	      	
		 	//System.out.println("Thread: "+ text1+" sleeps"+","+ " Thread ID: "+ t.getId());
		 	//System.out.println("Thread: "+ text1+" Service time: "+count+","+ " Thread ID: "+ t.getId()+"\n\n");
		 	//build.append("Thread: "+ text1+" sleeps"+","+ " Thread ID: "+ t.getId());
		 	//build.append("Thread: "+ text1+" Service time: "+count+","+ " Thread ID: "+ t.getId());
	           
	       //  }
		  // Threadlist.add(Thread.currentThread().getId());
		   //build.append("Running " + Thread.currentThread().getId() );
	      ATM theATM = new ATM();
	      //JOptionPane.showMessageDialog(null,build );
	      theATM.setbuild(build,Threadlist);
	      theATM.run();
	      
	     
	      
	     // TransGUI trans = new TransGUI(null, null);
	     // trans.setThread(t);

	      }
	 	//atmref.authenticateUser(text1, pass1);
	 	//System.out.println("Exiting Thread: "+ text1+ ","+" Thread ID: "+ t.getId()  );
	 	//buildexit.append("Exiting Thread: "+ text1+ ","+" Thread ID: "+ t.getId());
	 	//JOptionPane.showMessageDialog(null,buildexit );
	   
	   
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
