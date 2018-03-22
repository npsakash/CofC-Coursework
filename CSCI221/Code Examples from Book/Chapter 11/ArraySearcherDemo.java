
import java.util.Scanner;

public class ArraySearcherDemo
{
    public static void main(String[] args)
    {
        int [] anArray = new int[10];
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter 10 integers in increasing order,");
        System.out.println("one per line.");

        for (int i = 0; i < 10; i++)
            anArray[i] = keyboard.nextInt( );
        System.out.println( );
		
        for (int i = 0; i < 10; i++)
           System.out.print("a[" + i + "]=" + anArray[i] + " ");
        System.out.println( );
        System.out.println( );

        ArraySearcher finder = new ArraySearcher(anArray);

        String ans;
        do
        {
            System.out.println("Enter a value to search for:");
            int target = keyboard.nextInt( );
            int result = finder.find(target);

            if (result < 0)
                System.out.println(target + " is not in the array.");
            else
                System.out.println(target + " is at index " + result);

            System.out.println("Again?");
            ans = keyboard.next( );
        } while (ans.equalsIgnoreCase("yes"));

        System.out.println("May you find what you're searching for.");
    }
}
