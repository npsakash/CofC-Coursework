
 

/**
 *  This class demonstrates how one might store Company objects in
 *    an array and manipulate them through array indices.
 * 
 * @author mccauleyr
 */
public class CompanyRoster {

    // Expect to store 10 or fewer Company objects
    public static final int SIZE = 10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        
        // declare and create array
        Company [] roster = new Company[SIZE];
        int numberOfCompanies = 0;
        
        // Put some sample data in - most of it madeup
        roster[numberOfCompanies] = new Company("Barnes and Noble", 'D', null, 1995, 20000, 1234);
        numberOfCompanies++;
        roster[numberOfCompanies] = new Company("CofC Bookstore", 'D', roster[numberOfCompanies-1], 2005, 15, 2234);
        numberOfCompanies++;
        roster[numberOfCompanies] = new Company("Apple", 1974, 10000, 'D' );
        numberOfCompanies++;
        roster[numberOfCompanies] =new Company( "Dell", 1980, 15000, 'I' );
        numberOfCompanies++;  
        
        // Print contents
        CompanyRoster.printList(roster, numberOfCompanies);
        
        // Set the parent of the at roster[3] to be the company at roster[2]
        roster[3].setParent(roster[2]);
        
         // Print contents
        CompanyRoster.printList(roster, numberOfCompanies);
        
        // Print the first three letters of the name of the 2nd company
        System.out.println("The first three letters of the name of the second company are: "+ roster[1].getName().substring(0, 3));
    }
    
    /**
     * Prints a list of Company objects in the order they are stored, starting at index 0
     * @param list ofCompany objects
     * @param howMany companies currently stored in list
     */
    public static void printList ( Company [] list, int howMany){
        
        System.out.println("The current list of known companies is: ");
        for (int index = 0; index < howMany; index++){
            System.out.println("\t["+index+"]"+list[index].getDescription());
        }
        System.out.println("\n\n");
        
    }
    
}
