public class ListNode2<E>
{
    private E data;
    private ListNode2<E> link;
	
    public ListNode2( )
    {
        link = null;
        data = null;
    }
	
    public ListNode2(E newData, ListNode2<E> linkValue)
    {
        data = newData;
        link = linkValue;
    }
	
    public void setData(E newData)
    {
        data = newData;
    }
	
    public E getData( )
    {
        return data;
    }
	
    public void setLink(ListNode2<E> newLink)
    {
        link = newLink;
    }
	
    public ListNode2<E> getLink( )
    {
        return link;
    }
}