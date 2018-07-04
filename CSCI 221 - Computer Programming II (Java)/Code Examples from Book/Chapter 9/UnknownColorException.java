
public class UnknownColorException extends Exception
{
    public UnknownColorException( )
    {
        super("Unknown Color!");
    }

    public UnknownColorException(String message)
    {
        super(message);
    }
}
