//Please find the ATM Class For Handling ATM Pin Authentication
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
//class named Atm extends JFrame
public class ATM extends JFrame
{
//Create user interface using JPanels, JButtons, JPasswordField
   public JPasswordField jpf;
   public JPanel buttonPanel;
   //Declare an integer variable named correctPin and assign 1234 as a class variable.
   public static int correctPin=1234;
   //maximum no of trials after first trail
   public int numberOfTrails=3;
   ATM()
   {
       buttonPanel=new JPanel();
       GridLayout grid=new GridLayout(4,3);
       buttonPanel.setLayout(grid);
       JButton buttonOne=new JButton("1");  
       JButton buttonTwo=new JButton("2");  
       JButton buttonThree=new JButton("3");  
       JButton buttonFour=new JButton("4");  
       JButton buttonFive=new JButton("5");  
       JButton buttonSix=new JButton("6");  
       JButton buttonSeven=new JButton("7");  
       JButton buttonEight=new JButton("8");  
       JButton buttonNine=new JButton("9");
       JButton buttonZero=new JButton("0");  
       JButton buttonEnter=new JButton("Enter");
       JButton buttonClear=new JButton("Clear");
       //Add the instances of JButtons using GridLayout to JPanel named buttonPanel
       buttonPanel.add(buttonOne);
       buttonPanel.add(buttonTwo);
       buttonPanel.add(buttonThree);
       buttonPanel.add(buttonFour);
       buttonPanel.add(buttonFive);
       buttonPanel.add(buttonSix);
       buttonPanel.add(buttonSeven);
       buttonPanel.add(buttonEight);
       buttonPanel.add(buttonNine);
       buttonPanel.add(buttonClear);
       buttonPanel.add(buttonZero);
       buttonPanel.add(buttonEnter);
       //Add buttonPanel to the bottom(or south)of JFrame using BorderLayout
       BorderLayout border=new BorderLayout();
       //border.setHgap();
       //border.setVgap(10);
       setLayout(border);
       add(buttonPanel,border.CENTER);
       //set frame title to ATM PIN AUTHENTICATION
       setTitle("ATM PIN AUTHENTICATION");
       //Add an instance of JPasswordField to the north of JFrame.
       jpf=new JPasswordField(4);
       jpf.setEditable(false);
       add(jpf,border.NORTH);
       ActionListener buttonActionListener = new ButtonAction();
       buttonOne.addActionListener(buttonActionListener);
       buttonTwo.addActionListener(buttonActionListener);
       buttonThree.addActionListener(buttonActionListener);
       buttonFour.addActionListener(buttonActionListener);
       buttonFive.addActionListener(buttonActionListener);
       buttonSix.addActionListener(buttonActionListener);
       buttonSeven.addActionListener(buttonActionListener);
       buttonEight.addActionListener(buttonActionListener);
       buttonNine.addActionListener(buttonActionListener);
       buttonZero.addActionListener(buttonActionListener);
       ActionListener clearActionListener = new ClearAction();
       buttonClear.addActionListener(clearActionListener);
       ActionListener enterActionListener = new EnterAction();
       buttonEnter.addActionListener(enterActionListener);
      
   }
   //Create an inner listener class named buttonAction to register action to each number button.
   private class ButtonAction implements ActionListener {
   public void actionPerformed(ActionEvent e)
   {
       String pwd=new String(jpf.getPassword());
       if(pwd.length()<4)
           {
               jpf.setText(pwd+e.getActionCommand());
           }
   }
   }
   //Create an inner listener class named clearAction to register action to clear button.
   private class ClearAction implements ActionListener
   {
   public void actionPerformed(ActionEvent e)
   {
       jpf.setText("");
   }
   }
   //Create an inner listener class named enterAction to register action to enter button.
   private class EnterAction implements ActionListener
   {
   public void actionPerformed(ActionEvent e)
   {
       String pwd=new String(jpf.getPassword());
       if(!pwd.equals(""))
       {
       int enterdpin=Integer.parseInt(pwd);
       if(correctPin==enterdpin)
           {
               //If the PIN is correct, a JOPtionPane dialog box will pop up with a welcome screen message
               JOptionPane.showMessageDialog(null, "Correct pin");
               buttonPanel.setVisible(false);
               jpf.setVisible(false);
               JLabel welcomeMessage=new JLabel("Welcome! ");
               add(welcomeMessage,BorderLayout.CENTER);
           }
       else
           {
               if(numberOfTrails>0)
               {
                   //If the PIN is incorrect, a JOPtionPane dialog box will pop up with the number of trial left. 
                   JOptionPane.showMessageDialog(null, "Incorrect Pin.You have "+numberOfTrails+" trails left");
                   numberOfTrails--;
               }
               else
                   {
                     //After reaching maximum number of trails a message will say: Please contact the addministrator
                       JOptionPane.showMessageDialog(null, "Please Contact Administartor");
                       buttonPanel.setVisible(false);
                   jpf.setVisible(false);
                   JLabel IncorrectPassMessage=new JLabel("Please Contact Administartor");
                   add(IncorrectPassMessage,BorderLayout.NORTH);
                   }
           }
       }
   }
   }

}
