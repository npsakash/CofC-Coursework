import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo2
{
   public static void main(String[] args)
   {
      ArrayList<Integer> toDoList = new ArrayList<>(3);
      System.out.println("Enter items for the list, when prompted.");
      boolean done = false;
      Scanner keyboard = new Scanner(System.in);

      while (!done)
      {
          System.out.println("Type an entry:");
          int entry = keyboard.nextInt( );
          keyboard.nextLine();  // flush the newline character
          toDoList.add(entry);
          System.out.print("More items for the list? ");

          String ans = keyboard.nextLine( );
          if (!ans.equalsIgnoreCase("yes"))
              done = true;
      }

      System.out.println("The list contains:");
      int listSize = toDoList.size( );
      for (int position = 0; position < listSize; position++)
          System.out.println(toDoList.get(position));

/* Alternate code for displaying the list
      System.out.println("The list contains:");
      for (String element : toDoList)
          System.out.println(element);
*/
   }
}
