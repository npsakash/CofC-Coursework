
import java.util.Scanner;

public class DollarFormatDriver
{
    public static void main(String[] args)
    {
        double amount;
        String ans;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Testing DollarFormat.write:");
        do
        {
            System.out.println("Enter a value of type double:");
            amount = keyboard.nextDouble( );
            DollarFormat.write(amount);
            System.out.println( );
            System.out.println("Test again?");
            ans = keyboard.next( );
        } while (ans.equalsIgnoreCase("yes"));
        System.out.println("End of test.");
    }
}
