

import javax.swing.JOptionPane;

public class Question23
{
   public static void main(String[] args)
   {
      boolean adult = false;
      //Initialized to keep the compiler happy.

      int answer = JOptionPane.showConfirmDialog(null,
                   "Are you 18 years old or older?",
                   "Age Check", JOptionPane.YES_NO_OPTION);
				   
      if (answer == JOptionPane.YES_OPTION)
         adult = true;
      else if (answer == JOptionPane.NO_OPTION)
         adult = false;
      else
         System.out.println("Error");

      if (adult)
          JOptionPane.showMessageDialog(null, "You are old enough.");
      else
          JOptionPane.showMessageDialog(null, "Sorry. you must be 18.");
      System.exit(0);
   }
}
