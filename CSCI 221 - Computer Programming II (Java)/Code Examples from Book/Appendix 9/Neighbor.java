
public class Neighbor implements Cloneable
{
    private String name;
    private int    numberOfChildren;
    private Pet    familyPet;
	
    public Object clone( )
    {
        try
        {
            Neighbor copy = (Neighbor)super.clone( );
            copy.familyPet = (Pet)familyPet.clone( );
            return copy;
        }
        catch(CloneNotSupportedException e)
        {//This should not happen.
            return null; //To keep the compiler happy.
        }
    }
	
    public Pet getPet( )
    {
        return (Pet)familyPet.clone( );
    }
	
	//Other methods
	public void setName(String newName)
	{
		name = newName;
	}
	
	public void setChildren(int howMany)
	{
		numberOfChildren = howMany;
	}
	
	public void setPet(Pet thePet)
	{
		familyPet = thePet;
	}
	
	public void setNeighbor(String newName, int children, Pet thePet)
	{
		setName(newName);
		setChildren(children);
		setPet(thePet);
	}
	
	public int getNumberOfChildren()
	{
		return numberOfChildren;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPetName()
	{
		return familyPet.getName();
	}

	public int getPetAge()
	{
		return familyPet.getAge();
	}

	public double getPetWeight()
	{
		return familyPet.getWeight();
	}

    public void writeOutput( )
    {
        System.out.println("Neighbor " + name + " has " +
			                numberOfChildren + 
							" children and this pet:");
		familyPet.writeOutput();
	}
}
