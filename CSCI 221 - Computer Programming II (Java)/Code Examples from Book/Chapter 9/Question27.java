public class Question27
{
    public static void main(String[] args)
    {
		try
		{
			int n = 7;
			if (n > 0)
				throw new Exception( );
			else if (n < 0)
				throw new NegativeNumberException( );
			else
				System.out.println("Hello!");
		}
		catch(NegativeNumberException e)
		{
			System.out.println("First catch.");
		}
		catch(Exception e)
		{
			System.out.println("Second catch");
		}
		System.out.println("End of code"); 
    }
}