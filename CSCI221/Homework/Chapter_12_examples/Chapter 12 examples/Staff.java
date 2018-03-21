
/**
 * Models a staff member who is a Person and Employee,
 *   who also stores a number of years employed
 * @author mccauleyr
 */
public class Staff extends Employee {

    int yearsEmployed;
    
    public Staff(String initialName, int number, int years) {
        super(initialName, number);
        yearsEmployed = years;
    }
        
    /**
     * Display all information stored for this Faculty Employee
     */
    public void display(){ 
        System.out.print("Staff ");
        super.display();
        System.out.println("Years employed " + yearsEmployed);
    }
      
    /**
     * return true if two objects store same data
     * @param s the Staff object to be compared to this one
     * @return true if two Staff objects store same data
     */
    public boolean equals(Staff s){
        boolean isEqual = false;
        if (s != null & s instanceof Staff)
           isEqual = super.equals(s) && 
                   ((Staff)s).yearsEmployed == yearsEmployed;
        return isEqual;
    }
    
    
}
