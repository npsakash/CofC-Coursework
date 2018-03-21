
/**
 Demonstrates a classhaving private instance variables.
*/
public class SpeciesThirdTryDemo
{
    public static void main(String[] args)
    {
        SpeciesThirdTry speciesOfTheMonth = new SpeciesThirdTry( );
       
        System.out.println("Enter data on the Species of the Month:");
        speciesOfTheMonth.readInput( );
        speciesOfTheMonth.writeOutput( ); 
        int futurePopulation = speciesOfTheMonth.predictPopulation(10);
        System.out.println("In ten years the population will be " +
                            futurePopulation);
        
//		speciesOfTheMonth.name = "Klingon ox"; //ILLEGAL
//      speciesOfTheMonth.population = 10;     //ILLEGAL
//      speciesOfTheMonth.growthRate = 15;     //ILLEGAL
        System.out.println("The new Species of the Month:");
        speciesOfTheMonth.writeOutput( ); 
        System.out.println("In ten years the population will be " + 
                            speciesOfTheMonth.predictPopulation(10));
    }
}
