
import java.util.Scanner;

/**
 Program to generate a sales report.
*/
public class SalesReporter
{
	private double highestSales;
	private double averageSales;
    private SalesAssociate[] team;  //The array object is
                                    //created in getData.
    private int numberOfAssociates; //Same as team.length

    /**
     Reads the number of sales associates and data for each one.
    */
    public void getData( )
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number of sales associates:");
        numberOfAssociates = keyboard.nextInt( );
        team = new SalesAssociate[numberOfAssociates + 1];//We won't use team[0]
        for (int i = 1; i <= numberOfAssociates; i++)
        {
            team[i] = new SalesAssociate( );
            System.out.println("Enter data for associate " + i);
            team[i].readInput( );
            System.out.println( );
        }
    }

    /**
     Computes the average and highest sales figures.
     Precondition: There is at least one salesAssociate.
    */
    public void computeStats( )
    {
        double nextSales = team[1].getSales( );
        highestSales = nextSales;
        double sum = nextSales;
        for (int i = 2; i <= numberOfAssociates; i++)
        {
             nextSales = team[i].getSales( );
             sum = sum + nextSales;
             if (nextSales > highestSales)
                 highestSales = nextSales; //highest sales so far.
        }
        averageSales = sum / numberOfAssociates;
    }

    /**
     Displays sales report on the screen.
    */
    public void displayResults( )
    {
        System.out.println("Average sales per associate is $" + averageSales);
        System.out.println("The highest sales figure is $" + highestSales);
        System.out.println( );
        System.out.println("The following had the highest sales:");
        for (int i = 1; i <= numberOfAssociates; i++)
        {
            double nextSales = team[i].getSales( );
            if (nextSales == highestSales)
            {
                team[i].writeOutput( );
                System.out.println("$" + (nextSales - averageSales) +
								   " above the average.");
                System.out.println( );
            }
        }
		
        System.out.println("The rest performed as follows:");
        for (int i = 1; i <= numberOfAssociates; i++)
        {
            double nextSales = team[i].getSales( );
            if (team[i].getSales( ) != highestSales)
            {
                team[i].writeOutput( );
                if (nextSales >= averageSales)
                    System.out.println("$" + (nextSales - averageSales) +
                                       " above the average.");
                else
                    System.out.println("$" + (averageSales - nextSales) +
                                       " below the average.");
                System.out.println( );
            }
        }
    }

    public static void main(String[] args)
    {
        SalesReporter clerk = new SalesReporter( );
        clerk.getData( );
        clerk.computeStats( );
        clerk.displayResults( );
    }
}