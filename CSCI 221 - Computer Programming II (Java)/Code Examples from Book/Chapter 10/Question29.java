import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Question29
{
   public static final String FILE_NAME = "temperatures.dat";
   public static void main(String[] args)
   {
      try
      {
         ObjectInputStream inputStream = 
                        new ObjectInputStream(
                               new FileInputStream(FILE_NAME));
         System.out.println("Numbers from the file " + 
                             FILE_NAME + ":");
         try
         {
            while (true)
            {
               double number = inputStream.readDouble( );
               System.out.println(number); 
            }
         }
         catch(EOFException e)
         {
            //Do nothing
         }
         System.out.println("End of reading from file.");
         inputStream.close( );
      }
      catch(IOException e)
      {
          System.out.println("Problem reading from file.");
      }
   }
}
