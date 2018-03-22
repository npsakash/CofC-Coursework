import java.util.ArrayList;

public class ToArrayListDemo
{
   public static void main(String[] args)
   {
      LinkedList<String> myList = new LinkedList<String>();
	  myList.addANodeToStart("Summer");
	  myList.addANodeToStart("Fall");
	  myList.addANodeToStart("Winter");
	  myList.addANodeToStart("Spring");
	  
      System.out.println("The list contains:");
      myList.showList();
	  System.out.println();
	  
      System.out.println("The ArrayList contains:");
	  ArrayList<String> arrayList = myList.toArrayList();
      for (String element : arrayList)
          System.out.println(element);
   }
}
