
/**
 * Models an employee who is a Person, and has
 *   an employee number
 * @author mccauleyr
 */
public class Employee extends Person {

    int empNumber;
    
    /**
     * Initialize instance variables
     * @param initialName for name
     * @param number for employeeNumber
     * @param year for empNumber
     */
    public Employee(String initialName, int number) {
        super(initialName);
        empNumber = number;
    }
    
    /**
     * Display all information for an Employee
     */
    public void display(){
        System.out.print("Employee ");
        super.display();
        System.out.println("Number: " + empNumber);
    }
    
    /**
     * return true if two objects store same data
     * @param e the Employee object to be compared to this one
     * @return true if two Employee objects store same data
     */
    public boolean equals(Object e){
        boolean isEqual = false;
        if (e != null & e instanceof Employee)
           isEqual = super.equals(e) && 
                   ((Employee)e).empNumber == empNumber;
        return isEqual;
    }
    
}
