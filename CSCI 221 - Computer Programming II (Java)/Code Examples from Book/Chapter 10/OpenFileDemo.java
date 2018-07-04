import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OpenFileDemo
{
	public static void main(String[] args)
	{
		System.out.println("Enter file name:");
		Scanner keyboard = new Scanner(System.in);
		String fileName = keyboard.next( );
		
		PrintWriter outputStream = null;
		try
		{
			outputStream = openOutputTextFile(fileName);
        }
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		System.out.println("Enter nonnegative integers.");
		System.out.println("Place a negative number at the end.");
		keyboard = new Scanner(System.in);

		int integer;
		do
		{
			 integer = keyboard.nextInt();
			 outputStream.println(integer);
		 } while (integer >= 0);

		 System.out.print("Numbers and sentinel value ");
		 System.out.println("written to the file.");
		 outputStream.close();
    }

	public static PrintWriter openOutputTextFile(String fileName) 
                              throws FileNotFoundException
	{
		PrintWriter toFile = new PrintWriter(fileName);
		return toFile;
    }
}
