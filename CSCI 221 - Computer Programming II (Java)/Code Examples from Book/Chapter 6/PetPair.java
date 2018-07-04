/**
 Class whose privacy can be breached.
*/
public class PetPair
{
  private Pet first, second;
  
  public PetPair(Pet firstPet, Pet secondPet)
  {
    first = firstPet;
    second = secondPet;
  }
  
  public Pet getFirst()
  {
    return first;
  }
  
  public Pet getSecond()
  {
    return second;
  }
  
  public void writeOutput()
  {
    System.out.println("First pet in the pair:");
	first.writeOutput();
    System.out.println("\nSecond pet in the pair:");
	second.writeOutput();
  }
}