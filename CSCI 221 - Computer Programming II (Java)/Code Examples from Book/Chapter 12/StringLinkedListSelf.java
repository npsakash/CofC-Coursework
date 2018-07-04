
//public class StringLinkedListSelfContained
public class StringLinkedListSelf
{
    private ListNode head;

//    public StringLinkedListSelfContained( )
    public StringLinkedListSelf( )
    {
        head = null;
    }

    /**
     Displays the data on the list.
    */
    public void showList( )
    {
        ListNode position = head;
        while (position != null)
        {
            System.out.println(position.data);
            position = position.link;
        }
    }

    /**
     Returns the number of nodes on the list.
    */
    public int length( )
    {
        int count = 0;
        ListNode position = head;
        while (position != null)
        {
            count++;
            position = position.link;
        }
        return count;
    }

    /**
     Adds a node containing the data addData at the 
     start of the list.
	*/
    public void addANodeToStart(String addData)
    {
        head = new ListNode(addData, head);
    }

    /**
     Deletes the first node on the list.
    */
    public void deleteHeadNode( )
    {
        if (head != null)
            head = head.link;
        else
        {
            System.out.println("Deleting from an empty list.");
            System.exit(0);
        }
    }

    /**
     Sees whether target is on the list.
    */
    public boolean onList(String target)
    {
        return find(target) != null;
    }

    // Returns a reference to the first node containing the
    // target data. If target is not on the list, returns null.
	private ListNode find(String target)
    {
		boolean found = false;
        ListNode position = head;
        while ((position != null) && !found)
        {
            String dataAtPosition = position.data;
            if (dataAtPosition.equals(target))
				found = true;
			else
				position = position.link;
        }

        return position;
    }

    /**
     Returns an array of the elements on the list.
    */
    public String[] toArray( )
    {
        String[] anArray = new String[length( )];

        ListNode position = head;
        int i = 0;
        while (position != null)
        {
            anArray[i] = position.data;
            i++;
            position = position.link;
        }

        return anArray;
    }

    private class ListNode
    {
        private String   data;
        private ListNode link;
		
        public ListNode( )
        {
            link = null;
            data = null;
        }
		
        public ListNode(String newData, ListNode linkValue)
        {
            data = newData;
            link = linkValue;
        }
    }
}
