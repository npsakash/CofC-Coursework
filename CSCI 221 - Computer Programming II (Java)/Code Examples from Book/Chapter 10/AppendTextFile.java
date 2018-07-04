
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class AppendTextFile
{
    public static void main(String[] args)
    {

		System.out.println("Sending output to out.txt.");

        PrintWriter outputStream = null;
        try
        {
         	System.out.println("Enter Append for append or New for a new file:");
		 	Scanner keyboard = new Scanner(System.in);
		 	String ans = keyboard.next( );
		 	boolean append = ans.equalsIgnoreCase("append");// true if append, false if new
			outputStream = new PrintWriter(new FileOutputStream("out.txt", append));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file out.txt.");
            System.exit(0);
        }

        System.out.println("Enter three lines of text:");
        String line = null;
        Scanner keyboard = new Scanner(System.in);
        for ( int count = 1; count <= 3; count++)
        {
            line = keyboard.nextLine( );
            outputStream.println(count + " " + line);
        }
        outputStream.close( );
        System.out.println("Those lines were written to out.txt.");
    }
}


