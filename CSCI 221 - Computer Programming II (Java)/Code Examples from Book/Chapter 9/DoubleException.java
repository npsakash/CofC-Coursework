public class DoubleException extends Exception
{
    public DoubleException( )
    {
        super("Double exception thrown!");
    }
    public DoubleException(String message)
    {
        super(message + " " + message);
    }
}