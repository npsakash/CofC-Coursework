
/**
 Displays a two-dimensional table showing how interest
 rates affect bank balances.
*/
public class InterestTable3
{
	public static final int ROWS = 10;
	public static final int COLUMNS = 6;

	public static void main(String[] args)
	{
		int[][] table = new int[ROWS][COLUMNS];
		for (int row = 0; row < ROWS; row++)
			for (int column = 0; column < COLUMNS; column++)
			    table[row][column] =
				     getBalance(1000.00, row + 1, (5 + 0.5*column));
		System.out.println("Balances for Various Interest Rates");
		System.out.println("Compounded Annually");
		System.out.println("(Rounded to Whole Dollar Amounts)");
		System.out.println( );
		System.out.println("Years  5.00%  5.50%  6.00%  6.50%  7.00%  7.50%");
		showTable(table);
	}

    /**
	 The array anArray can have any values for its two dimensions.
	 Postcondition: The array contents are displayed with dollar signs.
	*/
	public static void showTable(int[][] anArray)
	{
	   for (int row = 0; row < anArray.length; row++)
	   {
			System.out.print((row + 1) + "      ");
			for (int column = 0; column < anArray[row].length; column++)
				System.out.print("$" + anArray[row][column] + "  ");
			System.out.println( );
	   }
    }

   public static int getBalance(double startBalance, int years, double rate)
   {
      double runningBalance = startBalance;
      for (int count = 1; count <= years; count++)
         runningBalance = runningBalance*(1 + rate/100);
      return (int)(Math.round(runningBalance));
   }
}
