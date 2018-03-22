/** Solution to Self-Test Question 30. */
public class OutputFormat
{
    /**
     Displays a number with digitsAfterPoint digits after
     the decimal point. Rounds any extra digits.
     Does not advance to the next line after output.
	*/
    public static void write(double number, int digitsAfterPoint)
    {
        if (number >= 0)
            writePositive(number, digitsAfterPoint);
        else
        {
            double positiveNumber = -number; 
            System.out.print('-');
            writePositive(positiveNumber, digitsAfterPoint);
        }
    }
	
    /**
     Displays a number with digitsAfterPoint digits after
     the decimal point. Rounds any extra digits.
     Advances to the next line after output.
    */
	public static void writeln(double number, int digitsAfterPoint)
    {
       write(number, digitsAfterPoint);
       System.out.println( );
    }
	
    //Precondition: number >= 0
    //Displays a number with digitsAfterPoint digits after 
    //the decimal point. Rounds any extra digits.
	private static void writePositive(double number, int digitsAfterPoint)
    {
        int mover = (int)(Math.pow(10, digitsAfterPoint));
                      //1 followed by digitsAfterPoint zeros
        int allWhole; //number with the decimal point
                      //moved digitsAfterPoint places
        allWhole = (int)(Math.round(number * mover)); 
        int beforePoint = allWhole / mover;
        int afterPoint = allWhole % mover; 
        System.out.print(beforePoint);
        System.out.print('.');
        writeFraction(afterPoint, digitsAfterPoint); 
    }
	
    //Displays the integer afterPoint with enough zeros
    //in front to make it digitsAfterPoint digits long.
	private static void writeFraction(int afterPoint, int digitsAfterPoint)
    {
        int n = 1; 
        while (n < digitsAfterPoint)
        {
            if (afterPoint < Math.pow(10, n))
                System.out.print('0');
            n = n + 1;
        }
        System.out.print(afterPoint);
    }
	
	public static void main(String[] args)
	{
		double number = 123.456789;
        System.out.println("Testing with the number 123.456789:");
		writeln(number, 0);
		writeln(number, 1);
		writeln(number, 2);
		writeln(number, 3);
		writeln(number, 4);
		writeln(number, 5);
		writeln(number, 6);
		writeln(number, 7);
	}
}