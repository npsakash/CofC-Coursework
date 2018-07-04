public class Question30
{
    public static void main(String[] args)
    {
        Question30 object = new Question30( );
        try
        {
            System.out.println("Trying");
            object.sampleMethod( );
            System.out.println("Trying after call.");
        }
        catch(Exception e)
        {
            System.out.println("Catching");
            System.out.println(e.getMessage( ));
        }
    }
    public void sampleMethod( ) throws Exception
    {
        System.out.println("Starting sampleMethod.");
        throw new Exception("From sampleMethod with love.");
    }
}