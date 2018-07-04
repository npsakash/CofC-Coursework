

import java.io.Serializable;
import java.util.Scanner;

/**
 Serialized class for data on endangered species.
 Includes a main method.
*/
public class Species implements Serializable
{
    private String name;
    private int population;
    private double growthRate;

    public Species( )
    {
        name = null;
        population = 0;
        growthRate = 0;
    }

    public Species(String initialName, int initialPopulation,
                                   double initialGrowthRate)
    {
        name = initialName;
        if (initialPopulation >= 0)
            population = initialPopulation;
        else
        {
            System.out.println("ERROR: Negative population.");
            System.exit(0);
        }
        growthRate = initialGrowthRate;
    }

    public String toString()
    {
        return ("Name = " + name + "\n"
              + "Population = " + population + "\n"
              + "Growth rate = " + growthRate + "%");
    }

    public void readInput( )
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the species' name?");
        name = keyboard.nextLine( );

        System.out.println(
                      "What is the population of the species?");
        population = keyboard.nextInt( );
        while (population < 0)
        {
            System.out.println("Population cannot be negative.");
            System.out.println("Reenter population:");
            population = keyboard.nextInt( );
        }

        System.out.println("Enter growth rate (% increase per year):");
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

    public boolean equals(Species otherObject)
    {
        return (name.equalsIgnoreCase(otherObject.name)) &&
               (population == otherObject.population) &&
               (growthRate == otherObject.growthRate);
    }
}
