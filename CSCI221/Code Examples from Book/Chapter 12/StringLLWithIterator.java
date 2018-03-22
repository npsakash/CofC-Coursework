
/**
 Linked list with a notion of "current node." The current node
 can be changed to the next node with the method goToNext. At any
 time after the iteration is initialized, one node is the current
 node, until the iteration has moved beyond the end of the list.
*/
public class StringLLWithIterator
{
    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public StringLLWithIterator( )
    {
        head = null;
        current = null;
        previous = null;
    }

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

    public void addANodeToStart(String addData)
    {
        head = new ListNode(addData, head);
        if ((current == head.link) && (current != null))
        //if current is at old start node
            previous = head;
    }

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
	
    public String[] toArray( )
    {
        String[] a = new String[length( )];

        ListNode position = head;
        int i = 0;
        while (position != null)
        {
            a[i] = position.data;
            i++;
            position = position.link;
        }

        return a;
    }

     public void resetIteration( )
     {
         current = head;
         previous = null;
     }

     public void goToNext( )
     {
         if (current != null)
         {
             previous = current;
             current = current.link;
         }
         else if (head != null)
         {
             System.out.println(
                "Iterated too many times or uninitialized iteration.");
             System.exit(0);
         }
         else
         {
             System.out.println("Iterating with an empty list.");
             System.exit(0);
         }
     }

     public boolean moreToIterate( )
     {
         return current != null;
     }

     public String getDataAtCurrent( )
     {
        String result = null;
        if (current != null)
            result = current.data;
        else
        {
            System.out.println(
                    "Getting data when current is not at any node.");
            System.exit(0);
        }
        return result;
	}

    public void setDataAtCurrent(String newData)
    {
        if (current != null)
        {
            current.data = newData;
        }
        else
        {
            System.out.println(
                 "Setting data when current is not at any node.");
            System.exit(0);
        }
    }

    /**
     Inserts node with newData after the current node. The current
     node is the same after invocation as it is before invocation.
     Should not be used with an empty list. Should not be
     used when the current node has iterated past the entire list.
    */
    public void insertNodeAfterCurrent(String newData)
    {
        ListNode newNode = new ListNode( );
        newNode.data = newData;
        if (current != null)
        {
            newNode.link = current.link;
            current.link = newNode;
        }
        else if (head != null)
        {
            System.out.println(
                        "Inserting when iterator is past all " +
                        "nodes or is not initialized.");
            System.exit(0);
        }
        else
        {
            System.out.println(
                  "Using insertNodeAfterCurrent with empty list.");
            System.exit(0);
        }
    }

    /**
     Deletes the current node. After the invocation,
     the current node is the node after the
     deleted node or null if there is no next node.
    */
    public void deleteCurrentNode( )
    {
        if ((current != null) && (previous != null))
        {
            previous.link = current.link;
            current = current.link;
        }
        else if ((current != null) && (previous == null))
        {   //At head node
            head = current.link;
            current = head;
        }
        else //current == null
        {
            System.out.println(
             "Deleting with uninitialized current or an empty list.");
            System.exit(0);
        }
    }

    private class ListNode
    {
        private String data;
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
