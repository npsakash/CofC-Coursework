
public class StringLLWithIteratorDemo
{
    public static void main(String[] args)
    {
        StringLLWithIterator list = new StringLLWithIterator( );
        list.addANodeToStart("Spring");
        list.addANodeToStart("Winter");
        list.addANodeToStart("Fall");
        list.addANodeToStart("Summer");
        System.out.println("List has " + list.length( ) +
                           " entries.");
        list.showList( );
        System.out.println();
		
        System.out.println("Start of list:");
		list.resetIteration();
		while (list.moreToIterate())
		{
			System.out.println(list.getDataAtCurrent() + " ");
			list.goToNext();
		}
        System.out.println("End of list.");
        System.out.println();

		list.resetIteration();
		list.resetDataAtCurrent("New first item");
		list.insertNodeAfterCurrent("New second item");
		list.goToNext();
		list.goToNext();
        System.out.println("List after changing first item and ");
        System.out.println("inserting new second item:");
        list.showList( );
        System.out.println();

		list.deleteCurrentNode();
        System.out.println("List after deleting third item:");
        list.showList( );
	}
}