
import java.util.Scanner;

public class ListDemo
{
	public static final int MAX_SIZE = 3; //Assumed > 0

    public static void main(String[] args)
    {
        OneWayNoRepeatsList toDoList =
                            new OneWayNoRepeatsList(MAX_SIZE);
							
        System.out.println("Enter items for the list, when prompted.");
        boolean moreEntries = true;
        String next = null;
        Scanner keyboard = new Scanner(System.in);

        while (moreEntries && !toDoList.isFull())
        {
            System.out.println("Enter an item:");
            next = keyboard.nextLine( );
            toDoList.addItem(next);
            if (toDoList.isFull( ))
            {
                System.out.println("List is now full.");
            }
            else
            {
                System.out.print("More items for the list? ");
                String ans = keyboard.nextLine( );
                if (ans.trim().equalsIgnoreCase("no"))
                    moreEntries = false; //User says no more
            }
        }

        System.out.println("The list contains:");
        int position = toDoList.START_POSITION;
        next = toDoList.getEntryAt(position);
        while (next != null) //null indicates end of list
        {
            System.out.println(next);
            position++;
            next = toDoList.getEntryAt(position);
        }
    }
}
