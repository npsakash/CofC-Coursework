
/**
 Toy program to demonstrate how a programmer can access and
 change private data in an object of the class PetPair.
*/
public class Hacker
{
    public static void main(String[] args)
    {
		Pet goodDog = new Pet("Faithful Guard Dog", 5, 75.0);
		Pet buddy = new Pet("Loyal Companion", 4, 60.5);
		
        PetPair pair = new PetPair(goodDog, buddy);
        System.out.println("Our pair:");
		pair.writeOutput( );
		
        Pet badGuy = pair.getFirst();
        badGuy.setPet("Dominion Spy", 1200, 500);

        System.out.println("\nOur pair now:");
        pair.writeOutput( );
		
        System.out.println("The pet wasn't so private!");
        System.out.println("Looks like a security breach.");
    }
}
