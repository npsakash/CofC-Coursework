public class SpeciesTest
{
	public static void main(String[] args)
	{
		Species testSpecies = new Species();

		// Test the setSpecies method
		testSpecies.setSpecies("Tribbles", 100, 50);
		if (testSpecies.getName().equals("Tribbles") &&
		    (testSpecies.getPopulation() == 100) &&
		    (testSpecies.getGrowthRate() >= 49.99) &&
		    (testSpecies.getGrowthRate() <= 50.01))
		{
			System.out.println("Pass: setSpecies test.");
		}
		else
		{
			System.out.println("FAIL: setSpecies test.");
		}


		// Test the predictPopulation method
		if ((testSpecies.predictPopulation(-1) == 100) &&
		    (testSpecies.predictPopulation(1) == 150) &&
		    (testSpecies.predictPopulation(5) == 759))

		{
			System.out.println("Pass: predictPopulation test.");
		}
		else
		{
			System.out.println("FAIL: predictPopulation test.");
		}
	}
}