import java.io.File;
import java.util.Scanner;
public class Question11
{
    public static void main(String[] args)
    {
        System.out.print("Enter a file name and I will ");
        System.out.println("tell you whether it exists."); 
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.next( ); 
        File fileObject = new File(name);
		
        if (fileObject.exists( )) 
        {
            System.out.println("I found the file " + name);
            System.out.println("Delete the file?");
            String ans = keyboard.next( );
            if (ans.equalsIgnoreCase("yes"))
            {
                System.out.println("If you delete the file " +
                                    name);
                System.out.println("all data in the file " +
                                   "will be lost.");
                System.out.println("Delete?");
                ans = keyboard.next( );
                if (ans.equalsIgnoreCase("yes"))
                {
                    if (fileObject.delete( ))
                        System.out.println("File deleted.");
                    else
                         System.out.println("Can’t delete.");
                }
                else
                    System.out.println("File not deleted.");
            }
            else
                System.out.println("File not deleted.");
        }
        else
            System.out.println("I cannot find " + name);
    }
}