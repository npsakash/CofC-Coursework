public class ToArrayDemo
{
   public static void main(String[] args)
   {
      StringLinkedListSelf myList = new StringLinkedListSelf();
	  myList.addANodeToStart("Summer");
	  myList.addANodeToStart("Fall");
	  myList.addANodeToStart("Winter");
	  myList.addANodeToStart("Spring");
	  
      System.out.println("The list contains:");
      myList.showList();
	  System.out.println();
	  
      System.out.println("The array contains:");
	  String[] array = myList.toArray();
      for (String element : array)
          System.out.println(element);
   }
}
