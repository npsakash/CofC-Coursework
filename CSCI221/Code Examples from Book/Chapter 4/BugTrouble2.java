
import java.util.Scanner;

/**
 Program to calculate how long it will take a population of
 roaches to completely fill a house from floor to ceiling.
*/
public class BugTrouble2
{
    public static final double GROWTH_RATE = 0.95;     //95% per week
    public static final double ONE_BUG_VOLUME = 0.002; //cubic feet
	
    public static void main(String[] args)
    {
        System.out.println("Enter the total volume of your house");
        System.out.print("in cubic feet: ");
        Scanner keyboard = new Scanner(System.in);
        double houseVolume = keyboard.nextDouble( );
		
        System.out.println("Enter the estimated number of");
        System.out.print("roaches in your house: ");
        int startPopulation = keyboard.nextInt( );
        int countWeeks = 0;
        int population = startPopulation;
        double totalBugVolume = population * ONE_BUG_VOLUME;
		
        while (totalBugVolume < houseVolume)
        {
			int newBugs = (int)(population * GROWTH_RATE);
			double newBugVolume = newBugs * ONE_BUG_VOLUME;
			population = population + newBugs;
			totalBugVolume = totalBugVolume + newBugVolume;
            countWeeks++;
        }
		
        System.out.println("Starting with a roach population of "
                                             + startPopulation);
        System.out.println("and a house with a volume of "
                                + houseVolume + " cubic feet,");
        System.out.println("after " + countWeeks + " weeks,");
        System.out.println("the house will be filled with " +
						    population + " roaches.");
        System.out.println("They will fill a volume of " +
                            (int)totalBugVolume + " cubic feet.");

        System.out.println("Better call Debugging Experts Inc.");
    }
}
