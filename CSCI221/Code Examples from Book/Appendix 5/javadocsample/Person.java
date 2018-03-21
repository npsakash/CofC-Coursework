package javadocsample;

/**
 Class for a person
*/

public class Person
{
    private String name;


    public Person( )
    {
        name = "No name yet.";
    }

    /**
     @param initialName the person's name
    */
    public Person(String initialName)
    {
        name = initialName;
    }

    /**
     @param newName the person's name is changed to newName
    */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     @return the person's name
    */
    public String getName( )
    {
        return name;
    }

    public void writeOutput( )
    {
        System.out.println("Name: " + name);
    }

    /**
     @return true if calling object and otherPerson have the same name.
    */
    public boolean sameName(Person otherPerson)
    {
        return (this.name.equalsIgnoreCase(otherPerson.name));
    }

}
