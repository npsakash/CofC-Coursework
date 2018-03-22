public class CrazyException extends Exception
{
    public CrazyException( )
    {
        super("Crazy exception thrown!");
        System.out.println("Wow, Crazy exception thrown!!");
    }
    public CrazyException(String message)
    {
        super(message);
        System.out.println(
           "Wow, Crazy exception thrown with an argument!");
    }
    public void crazyMethod( )
    {
        System.out.println("Message is " + getMessage( ));
    }
}