 /**
 * 
 * @author Lab 8 Person class
 * 
 * This class simply models a person that only 
 * has a name. Not a very realistic person - but 
 * good enough for this example :)
 *
 */
public class Person {
    
    // instance variable
    private String name = "Unknown";

 
    /**
     * Constructor
     * 
     * @param initialName
     */
    public Person(String initialName) {
        
        setName( initialName );
        
    } // end constructor

    /**
     * Sets the name of the Person
     * @param newName
     */
    public void setName(String newName) {
        
        if ( newName != null ) {
        
            name = newName;
        
        }
        
    } // end setName() method

    /**
     * Returns the name of the Person
     * @return
     */
    public String getName() {
        
        return name;
        
    } // end getName() method

    /**
     * Prints out the name of the Person with the label Person Name
     */
    public void display() {
        
        System.out.println("Person Name: " + name);
        
    } // end display() method

    /**
     * Returns true if two Person objects have the same name
     * @param otherPerson
     * @return
     */
    public boolean equals(Person otherPerson) {
        
        return otherPerson.getName().equalsIgnoreCase( getName() );
       
    } // end equals() method

} // end Person class definition