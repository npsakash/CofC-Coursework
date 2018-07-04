import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Question21
{
   public static void main(String[] args)
   {
      //To use fileName in a catch block, 
      //declare it outside of the try block
      String fileName = null;
      try
      {
         System.out.println("Enter file name:");
         Scanner keyboard = new Scanner(System.in);
         fileName = keyboard.next( );
         ObjectInputStream inputStream =
                        new ObjectInputStream(
                            new FileInputStream(fileName));
         System.out.println("The first thing in the file");
         System.out.println(fileName + " is");
         String first = inputStream.readUTF( );
         System.out.println(first); 
         inputStream.close( );
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Problem opening the file " + 
                             fileName);
      }
      catch(EOFException e)
      {
         System.out.println("Unexpected end of file.");
      }
      catch(IOException e)
      {
         System.out.println("Problem with input from file " +
                             fileName);
      }
    }
}
