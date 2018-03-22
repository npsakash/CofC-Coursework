public class IntException extends Exception
{
    private int intMessage;
    public IntException( )
    {
        super("IntException thrown!");
    }
    public IntException(String message)
    {
        super(message + " " + message);
    }
    public IntException(int number)
    {
        super("IntException thrown!");
        intMessage = number;
    }
    public int getNumber( )
    {
        return intMessage;
    }
}