import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo
{
   public static void main(String[] args)
   {
      ArrayList<String> toDoList = new ArrayList<String>();
      System.out.println("Enter items for the list, when prompted.");
      boolean done = false;
      Scanner keyboard = new Scanner(System.in);

      while (!done)
      {
          System.out.println("Type an entry:");
          String entry = keyboard.nextLine( );
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
      System.out.println("---");
      /*
      toDoList.add("99");
      
      System.out.println("\n\nThe list contains:");
      listSize = toDoList.size( );
      for (int position = 0; position < listSize; position++)
          System.out.println(toDoList.get(position));   
      System.out.println("---");
      
      toDoList.add(4,"hello");
      */
      System.out.println("About to call toString()");

      System.out.println(toDoList);
      /*
      System.out.println("\n\nThe list contains:");
      listSize = toDoList.size( );
      for (int position = 0; position < listSize; position++)
          System.out.println(toDoList.get(position));   
      System.out.println("---");
      
      toDoList.remove(0);
              */
// Alternate code for displaying the list
/*
      System.out.println("The list contains:");
      for (String element : toDoList)
          System.out.println(element);
*/
   }
}
