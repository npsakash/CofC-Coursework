
import java.util.Scanner;

public class Question30
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        String word1, word2, word3;

        System.out.println("Type three words on one line:");
        word1 = keyboard.next( );
        word2 = keyboard.next( );
        word3 = keyboard.next( );

        System.out.println("You typed the words");
        System.out.println(word1 + "  " + word2 +
                                   "  " + word3);
	}
}