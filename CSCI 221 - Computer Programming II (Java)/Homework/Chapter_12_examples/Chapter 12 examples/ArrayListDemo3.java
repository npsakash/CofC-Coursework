import java.util.ArrayList;
import java.util.Scanner;
import java.util.ListIterator;

public class ArrayListDemo3
{
   public static void main(String[] args)
   {
      ArrayList<Person> list = new ArrayList<>();
      list.add(new Faculty("Sebastian van Delden", 11000, "Computer Science"));
      list.add(new Faculty("Sebastian van Delden", 23000, "Sociology"));
      list.add(new Faculty("Vince Lombardi", 90000, "Sociology"));
      list.add(new Faculty("Vince Lombardi", 10000, "Sociology"));
      list.add(new Staff("Marilee Smith", 11111, 4));

      System.out.println("The original list contains:");
      int listSize = list.size( );
      for (int position = 0; position < listSize; position++){
          System.out.println("At index "+position+":");
          list.get(position).display();
      }
      System.out.println();
      // Try some ArrayList methods
      System.out.println("Is Sociology prof van Delden in list? "+ list.contains(new Faculty("Sebastian van Delden", 23000, "Sociology")));
      System.out.println("Is Staff member Stephanie in list? "+ list.contains(new Staff("Stephanie", 1111, 4)));
      
      System.out.println("\n\nList iterator used below");
      
      // Create a listiterator -so that we can move forward or backward in the ArrayList
      ListIterator<Person> p = list.listIterator();
      p.next().display();
      p.next().display();
      p.next().display();
      p.previous().display();
      System.out.println("How many more?");
      while (p.hasPrevious())
          p.previous().display();
      
     
      
/* Alternate code for displaying the list
      System.out.println("The list contains:");
      for (Person element : list)
          element.display();
*/
   }
}
