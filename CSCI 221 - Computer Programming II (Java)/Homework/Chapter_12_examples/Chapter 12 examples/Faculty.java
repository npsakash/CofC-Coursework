
/**
 * Models a faculty member who is a Person and 
 *   an Employee, plus adds a department
 * @author mccauleyr
 */
public class Faculty extends Employee
{
    String department;
    
    /**
     * Initialize instance variables
     * @param initialName
     * @param number
     * @param dept 
     */
    public Faculty(String initialName, int number, String dept) {
        super(initialName, number);
        department = dept;
    }
    
    /**
     * Display all information stored for this Faculty Employee
     */
    public void display(){ 
        System.out.print("Faculty ");
        super.display();
        System.out.println("Department " + department);
        System.out.println("---");
    }
    
     /**
     * return true if two objects store same data
     * @param f the Faculty object to be compared to this one
     * @return true if two Faculty objects store same data
     */
    public boolean equals(Object f){
        boolean isEqual = false;
        
        if (f != null & f instanceof Faculty)
           isEqual = super.equals(f) && 
                   ((Faculty)f).department.equals(department);
        return isEqual;
    }
    
}
