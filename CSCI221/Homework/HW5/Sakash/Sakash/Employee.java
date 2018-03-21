package HW5;

/**
 * @author Neal Sakash
 * @since November 3, 2016
 * @version 1
 * HW 5 - CSCI 221 Fall 2016
 * Employee class where a name is inherited from the Person class
 * and is assigned an employee number
 */

public class Employee extends Person{
    //instance variable
    private int employeeNumber;

    /**
     * Constructor
     * 
     * @param initialName, 
     * @param initialEmployeeNumber
     */    
    public Employee(String initialName, int initialEmployeeNumber)
    {
        
        super(initialName);
        employeeNumber = initialEmployeeNumber;
    }   //  end constructor

    /**
     * Gets the employee number of the person
     * @return
     */
    public int getEmployeeNumber( )
    {
        return employeeNumber;
    }   //  end of getEmployeeNumber() method

    /**
     * Sets the employee number
     * @param newEmployeeNumber 
     */
    public void setEmployeeNumber(int newEmployeeNumber)
    {
        employeeNumber = newEmployeeNumber;
    }   //  end of setEmployeeNumber() method

    /**
     * Print out the name of the person and their employee number
     */
    public void display( )
    {
        super.display();
        System.out.println("Employee Number: " + employeeNumber);
    }   //  end of display() method

    /**
     * Returns true if two Employee objects have the same name 
     * and same employee number
     * @param otherObject
     * @return 
     */
    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (!(otherObject instanceof Employee))
            return false;
        else
        {
            Employee otherEmployee = (Employee)otherObject;
            return (this.equals(otherEmployee)
                    
                && (this.employeeNumber ==
                                otherEmployee.employeeNumber));
        }
    }   //  end of equals() method
}   //  end Employee class definition
    
   