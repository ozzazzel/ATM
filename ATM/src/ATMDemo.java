import javax.swing.JFrame;

public class ATMDemo {
	 public static void main(String[] args)
	   {
	       ATM atm=new ATM();
	       //Set frame size 
	           atm.setSize(250, 250);
	           //set frame to center of screen
	           atm.setLocationRelativeTo(null);
	           atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	           atm.setVisible(true);  
	   }
	}

