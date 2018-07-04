
import java.io.*;
import java.util.*;

public class junk
{
    public static void main(String[] args)
    {
       try
       {
           BufferedReader inputStream =
               new BufferedReader(new FileReader("data.txt"));

           String line = null;
           line = inputStream.readLine( );
           System.out.println("The first line in data.txt is:");

           System.out.println(line);
           line = inputStream.readLine( );
           System.out.println("The second line in data.txt is:");
           System.out.println(line);
           inputStream.close( );
       }
       catch(FileNotFoundException e)
       {
           System.out.println("File data.txt was not found");
           System.out.println("or could not be opened.");
       }
       catch(IOException e)
       {
           System.out.println("Error reading from file data.txt.");
       }
    }

    //This method does do not what we want it to do.
	public static void openFile(ObjectOutputStream streamName)
	                                          throws IOException
	{
	    System.out.println("Enter file name:");
	    Scanner keyboard = Scanner.create(System.in);
	    String fileName = keyboard.next( );
	    streamName =
	          new ObjectOutputStream(
	                 new FileOutputStream(fileName));
}
}
