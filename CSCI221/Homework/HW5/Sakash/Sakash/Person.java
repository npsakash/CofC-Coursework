package HW5;
/**
 * @author Neal Sakash
 * @since November 3, 2016
 * @version 1
 * HW 5 - CSCI 221 Fall 2016
 * Code has been modified from 221 teaching staff's Person class
 *
 * @ 221 teaching staff
 */
public class Person {
    
    // instance variable
    String name = "Unknown";

 
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