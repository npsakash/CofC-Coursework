import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileClassDemo
{
    public static void main(String[] args)
    {
        System.out.print("Enter file name: ");
        Scanner keyboard = new Scanner(System.in);
        String fileName = keyboard.next( );

        File fileObject = new File(fileName);
		boolean fileOK = false;
        while (!fileOK)
        {
            if  (!fileObject.exists( ))
                System.out.println("No such file");
            else if (!fileObject.canRead( ))
                System.out.println("That file is not readable.");
		    else
			    fileOK = true;
			   
		    if (!fileOK)
		    {
                System.out.println("Enter file name again:");
                fileName = keyboard.next( );
                fileObject = new File(fileName);
		    }	
        }

		Scanner inputStream = null;
		System.out.println("The file " + fileName + 
						   "\ncontains the following lines\n");
		try
		{
		    inputStream = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e)
		{
		    System.out.println("Error opening the file " + fileName);
		    System.exit(0);
		}                
		
		while (inputStream.hasNextLine())
		{
			String line = inputStream.nextLine();
			System.out.println(line);
		}

		inputStream.close();
    }
}
