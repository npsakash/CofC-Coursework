package HW5;

/**
 * @author Neal Sakash
 * @since November 3, 2016
 * @version 1
 * HW 5 - CSCI 221 Fall 2016
 * Faculty class where a name and employee class is inherited from 
 * the Person and Employee classes, and a department is assigned
 */

public class Faculty extends Employee{
    
    //instance variable
    private String department;
    
    /**
     * Constructor
     * 
     * @param initialName
     * @param initialEmployeeNumber
     * @param initialDepartment 
     */
    public Faculty(String initialName, int initialEmployeeNumber, String initialDepartment) {
        
        super(initialName, initialEmployeeNumber);
        setDepartment(initialDepartment);
    }   //  end of constructor

    /**
     * Gets the faculty department of the employee
     * @return 
     */
    public String getDepartment(){
        return department;
    }   //  end getDepartment() method
    
    /**
     * Sets the faculty department of the employee
     * @param initialDepartment 
     */
    public void setDepartment(String initialDepartment){
        if(initialDepartment != null){
            department = initialDepartment;
        }
        else
            department = "unknown";
    }   //  end setDepartment() method

    /**
     * Prints out the name of the person, their employee number,
     * and their faculty department
     */
    public void display()
    {
        super.display();
        System.out.println("Department: " + department);
    }
    
    /**
     * Returns true if two Faculty objects have the same name, same employee
     * number, and the same faculty department
     * @param otherFaculty
     * @return 
     */
    public boolean equals(Faculty otherFaculty)
    {
        return super.equals(otherFaculty) &&
               (this.department == otherFaculty.department);
    }   //  end of equals() method
}   //  end Faculty class definition