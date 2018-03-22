
import java.util.Scanner;
public class CountDown
{
    private int count;

    public static void main(String[] args)
    {
         CountDown countDowner = new CountDown( );
         countDowner.getCount( );
         countDowner.showCountDown( );
    }

    public void getCount( )
    {
        System.out.println("Enter a positive integer:");
        Scanner keyboard = new Scanner(System.in);
        count = keyboard.nextInt( );
        if (count <= 0)
        {
            System.out.println("Input must be positive.");
            System.out.println("Try again.");
            getCount( );//start over
        }
    }

    public void showCountDown( )
    {
        System.out.println("Counting down:");
        for (int left = count; left >= 0; left--)
            System.out.print(left + ", ");
        System.out.println("Blast Off!");
     }
}






