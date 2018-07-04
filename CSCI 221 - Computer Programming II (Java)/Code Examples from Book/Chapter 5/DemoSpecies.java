

import java.util.Scanner;

/**
 This version of the class Species is only a toy example designed
 to demonstrate the difference between parameters of a class type 
 and parameters of a primitive type.
*/
public class DemoSpecies
{
    private String name;
    private int population;
    private double growthRate;

    /**
     Tries to set intVariable equal to the population of the
     calling object. But arguments of a primitive type cannot
     be changed.
	*/
    public void tryToChange(int intVariable)
    {
        intVariable = this.population;
    }

    /**
     Tries to make otherObject reference the calling object.
     But arguments of a class type cannot be replaced.
    */
	public void tryToReplace(DemoSpecies otherObject)
    {
        otherObject = this;
    }

    /**
     Changes the data in otherObject to the data in this object,
	 which is unchanged.
    */
    public void change(DemoSpecies otherObject)
    {
        otherObject.name = this.name;
        otherObject.population = this.population;
        otherObject.growthRate = this.growthRate;
    }

    public void readInput( )
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the species’ name?");
        name = keyboard.nextLine( );
        System.out.println(
                      "What is the population of the species?");
        keyboard = new Scanner(System.in);
        population = keyboard.nextInt( );
        while (population < 0)
        {
            System.out.println("Population cannot be negative.");
            System.out.println("Reenter population:");
            population = keyboard.nextInt( );
        }
        System.out.println(
               "Enter growth rate (percent increase per year):");
       growthRate = keyboard.nextDouble( );
    }

    public void writeOutput( )
    {
         System.out.println("Name = " + name);
         System.out.println("Population = " + population);
         System.out.println("Growth rate = " + growthRate + "%");
    }

    /**
     Precondition: years is a nonnegative number.
     Returns the projected population of the calling object
     after the specified number of years.
    */
    public int predictPopulation(int years)
    {
		int result = 0;
        double populationAmount = population;
        int count = years;
        while ((count > 0) && (populationAmount > 0))
        {
            populationAmount = (populationAmount +
                          (growthRate / 100) * populationAmount);
            count--;
        }
        if (populationAmount > 0)
            result = (int)populationAmount;
	
        return result;
    }

    public void setSpecies(String newName, int newPopulation,
                           double newGrowthRate)
    {
        name = newName;
        if (newPopulation >= 0)
            population = newPopulation;
        else
        {
            System.out.println("ERROR: using a negative population.");
            System.exit(0);
        }
        growthRate = newGrowthRate;
    }

    public String getName( )
    {
        return name;
    }

    public int getPopulation( )
    {
        return population;
    }

    public double getGrowthRate( )
    {
        return growthRate;
    }

    public boolean equals(DemoSpecies otherObject)
    {
        return (name.equalsIgnoreCase(otherObject.name)) &&
               (population == otherObject.population) &&
               (growthRate == otherObject.growthRate);
    }
}
