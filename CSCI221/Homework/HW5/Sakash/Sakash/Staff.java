package HW5;

/**
 * @author Neal Sakash
 * @since November 3, 2016
 * @version 1
 * HW 5 - CSCI 221 Fall 2016
 * Staff class where a name and employee class is inherited from 
 * the Person and Employee classes, and a years as a staff member is assigned
 */

public class Staff extends Employee{
    //  instance variable
    private int years; 
                       
    /**
     * Constructor
     * @param initialName
     * @param initialEmployeeNumber
     * @param initialYears 
     */    
    public Staff(String initialName, int initialEmployeeNumber, int initialYears)
    {
        super(initialName, initialEmployeeNumber);
        setYears(initialYears); 
    }   //  end constructor
    
    /**
     * Gets the years worked by the staff member
     * @return 
     */
    public int getYears( )
    {
        return years;
    }   //  end getYears() method
    
    /**
     * Sets the years worked by the staff member
     * @param newYears 
     */
    public void setYears(int newYears)
    {
        if (0 <= newYears)
            years = newYears;
        else
        {
            System.out.println("invalid years");
            System.exit(0);
        }
    }   //  end of setYears() method
    
    /**
     * Prints out the name of the person, their employee number, 
     * and the amount of years they have been a staff member
     */
    public void display()
    {
        super.display();
        System.out.println("Years: " + years);
    }   //  end display() method
 
    /**
     * Returns true if two Staff objects have the same name, same employee
     * number, and the same years worked
     * @param otherStaff
     * @return 
     */
    public boolean equals(Staff otherStaff)
    {
        return super.equals(otherStaff) &&
               (this.years == otherStaff.years);
    }   //  end equals() method}
}   //  end Staff class definition
