
/**
 Class for basic pet data: name, age, and weight.
 This version implements the Cloneable interface.
*/
public class Pet implements Cloneable
{
    private String name;
    private int age;      //in years
    private double weight;//in pounds
    
    public Object clone( )
    {
        try
        {
            return super.clone( );//Invocation of Object's clone
        }
        catch(CloneNotSupportedException e)
        {//This should not happen
           return null; //To keep the compiler happy.
        }
    }

    public Pet(String initialName, int initialAge, 
               double initialWeight)
    {
        name = initialName;
        if ((initialAge < 0) || (initialWeight < 0))
        {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
        else
        {
            age = initialAge;
            weight = initialWeight;
        }
    }
	
    public void setPet(String newName, int newAge, double newWeight)
    {
        name = newName;
        if ((newAge < 0) || (newWeight < 0))
        {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
        else
        {
            age = newAge;
            weight = newWeight;
        }
    }

    public Pet(String initialName)
    {
        name = initialName;
        age = 0;
        weight = 0;
    } 
    
    public void setName(String newName)
    {
        name = newName; //age and weight are unchanged.
    }
    
    public Pet(int initialAge)
    {
        name = "No name yet.";
        weight = 0;
        if (initialAge < 0)
        {
            System.out.println("Error: Negative age.");
            System.exit(0);
        }
        else
            age = initialAge;
    }
    
    public void setAge(int newAge)
    {
        if (newAge < 0)
        {
            System.out.println("Error: Negative age.");
            System.exit(0);
        }
        else
            age = newAge;
        //name and weight are unchanged. 
    }

    public Pet(double initialWeight)
    {
        name = "No name yet";
        age = 0;
        if (initialWeight < 0)
        {
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }
        else
            weight = initialWeight;
    }
	
    public void setWeight(double newWeight)
    {
        if (newWeight < 0)
        {
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }
        else
            weight = newWeight; //name and age are unchanged.
    }
    
    public Pet( )
    {
        name = "No name yet.";
        age = 0;
        weight = 0; 
    }
    
    public String getName( )
    {
        return name;
    }
    
    public int getAge( )
    {
        return age;
    }
    
    public double getWeight( )
    {
        return weight;
    }

    public void writeOutput( )
    {
        System.out.println("Name:   " + name);
        System.out.println("Age:    " + age + " years");
        System.out.println("Weight: " + weight + " pounds");
    }
}
