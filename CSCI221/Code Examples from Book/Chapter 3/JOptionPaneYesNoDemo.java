
import javax.swing.*;

public class JOptionPaneYesNoDemo
{
   public static void main(String[] args)
   {
      int answer =
	       JOptionPane.showConfirmDialog(null, "End program?",
	                     "Click Yes or No:", JOptionPane.YES_NO_OPTION);

	  if (answer == JOptionPane.YES_OPTION)
	      System.exit(0);
	  else if (answer == JOptionPane.NO_OPTION)
	      System.out.println("One more time");
	  else
          System.out.println("This is impossible");

      System.exit(0);
   }
}
