public class Question33
{
    public static void main(String[] args)
    {
        try
        {
//            sampleMethod(99);  //Part a
//          sampleMethod(-99); //Part b
          sampleMethod(0);   //Part c
        }
        catch(Exception e)
        {
            System.out.println("Caught in main.");
        }
    }
    public static void sampleMethod(int n) throws Exception
    {
        try
        {
            if (n > 0) 
                throw new Exception( );
            else if (n < 0)
                throw new NegativeNumberException( );
            else 
                System.out.println("No Exception.");
            System.out.println("Still in sampleMethod.");
        }
        catch(NegativeNumberException e)
        {
            System.out.println("Caught in sampleMethod.");
        }
        finally
        {
            System.out.println("In finally block.");
        }
        System.out.println("After finally block.");
    }
}