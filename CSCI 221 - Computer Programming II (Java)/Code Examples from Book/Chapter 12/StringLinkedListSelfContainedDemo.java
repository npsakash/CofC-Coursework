//If the file name is too long on your system, see the file StringLinkedListSCDemo.java

public class StringLinkedListSelfContainedDemo
{
    public static void main(String[] args)
    {
        StringLinkedListSelfContained list = new StringLinkedListSelfContained( );
        list.addANodeToStart("One");
        list.addANodeToStart("Two");
        list.addANodeToStart("Three");
        System.out.println("List has " + list.length() +
						   " entries.");
        list.showList( );

        if (list.onList("Three"))
            System.out.println("Three is on list.");
        else
            System.out.println("Three is NOT on list.");
        list.deleteHeadNode( );
        if (list.onList("Three"))
            System.out.println("Three is on list.");
        else
            System.out.println("Three is NOT on list.");

        list.deleteHeadNode( );
        list.deleteHeadNode( );
        System.out.println("Start of list:");
        list.showList( );
        System.out.println("End of list.");
    }
}