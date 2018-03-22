
import java.util.ArrayList;

public class LinkedListDemo
{
   public static void main(String[] args)
   {
       LinkedList<String> stringList = new LinkedList<String>( );
       stringList.addANodeToStart("Hello");
       stringList.addANodeToStart("Good-bye");
       stringList.showList( );
  
       LinkedList<Integer> numberList = new LinkedList<Integer>( );
       for (int i = 0; i < 10; i++)
           numberList.addANodeToStart(i);
		   
	   numberList.deleteHeadNode();
       ArrayList<Integer> list = numberList.toArrayList( );
       int listSize = list.size( );
       for (int position = 0; position < listSize; position++)
           System.out.print(list.get(position) + " ");
	   System.out.println();
    }
}
