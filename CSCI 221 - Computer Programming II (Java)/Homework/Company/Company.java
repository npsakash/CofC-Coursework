import java.util.Scanner;

public class Company{

	// --------------------------
	// Instance variables - Do not modify
	// --------------------------

	private String name; //Name of the company
	private char type; //The type of company, either 'D' or 'O' or 'I'
	private int yearFounded; //Year the company was founded
	private int numberOfEmployees; //number of company employees
	private Company parent;
	private int id; //The company's unique identifier in the database

            /*
             * Constructors for Company objects - copies parameter value to instance 
             *   variables
             * @param name
             * @param type
             * @param yearFounded
             * @param numberOfEmployees
             * @param parent
             * @param id
             */
            public Company(String initialName, char initialType, int initialYearFounded, int initialNumberOfEmployees){
                    set(initialName, initialType, initialYearFounded, initialNumberOfEmployees);
                //setParent(parent);
            }

	public Company(String initialName, char initialType, int initialYearFounded, int initialNumberOfEmployees, int initialId )
        {
            set(initialName, initialType, initialYearFounded, initialNumberOfEmployees, initialId);
		
	}


	
	/* Beginning of the setName() method
	*Name of the company. Accepts a string
	* @param name
	*/
	public void setName(String newName){
		set(newName, type, yearFounded, numberOfEmployees, id);
	}
	// end setName() method

	/* Beginning of the setType() method
	*Type of company. Accepts a char that meets the precondition: t is one
	*of 'D', 'O', and 'I'
	* @param type
	*/
	public void setType(char newType){

		if ( newType == 'D' || newType == 'O' || newType == 'I'){
			type = newType;
		} 
                else {

			System.out.printf("Provided Type [%s] is not valid\n", newType );

		}
        }
	// end setType() method

	/* Beginning of the setYearFounded() method
	*Year company was founded. Accepts an int
	* @param int
	*/

	public void setYearFounded(int newYear){

		yearFounded = newYear;
		 	
		 }

	
	// end setYear() method

	/* Beginning of the setNumberOfEmployees() method
	*Number of employees in this company. Accepts an int that meets the precondition e.
	* @param int
	*/
	public void setNumberOfEmployees(int newEmployees)
        {
            if ( newEmployees > 0 ) {
		numberOfEmployees = newEmployees;
	    } 
            else {
		System.out.printf( "The provided number [ %d ] is not a valid value!\n", newEmployees );
            }
	}
	// end setNumberOfEmployees

	/* Beginning of the setParent() method
	*The parent company. Accepts a Company that meets the precondition: p is not null.
	* @param Company
	*/

	//public void setParent(Company p){

	//}

	//end of setParent() method

	/* Beginning of the setId() method
	*Id number of company. Accepts an int that meets the precondition: i >= 0,
	*if not the id number is -1.
	* @param Company
	*/		

	public void setId(int newId){
		if (newId >= 0){
                    id = newId;
		}
		else{
                    id = -1;
		}
	}
	//end of setId
/******************************************************************************/
//Read Input
        public void readInput()
        {
            Scanner input = new Scanner(System.in);
            
            System.out.println("Enter in the company name: ");
            name = input.next();
        
            System.out.println("Enter the year the company was founded: ");
            yearFounded = input.nextInt();
        
            System.out.println("Enter the amount of company employees: ");
            numberOfEmployees = input.nextInt();
            while(numberOfEmployees < 0){
                System.out.println("Number must be positive. Try again");
                System.out.println("Enter the amount of company employees: ");
                numberOfEmployees = input.nextInt();
            }
            
            System.out.println("Enter the type of company (D for Domestic,"
                + "O for overseas, or I for International");
            type = input.next().charAt(0);
            while(type != 'D' || type !='O' || type != 'I'){
                System.out.println("Invalid company type");
            System.out.println("Enter the type of company (D for Domestic,"
                + "O for overseas, or I for International");
                type = input.next().charAt(0);
            }    
            
            System.out.println("Enter the company's ID: ");
            id = input.nextInt();
            
        }
	//end of readInput
        
        //beginning of writeOutput
        public void getDescription()
        {
            System.out.println(type + " company" + name + ". ID " + id + 
                    ". Founded" + yearFounded + ". Has " + numberOfEmployees);
        }

	






/////////////////////////////////////////////////////	
	public String getName()
	{
		return name;
	}

	public char getType()
	{
		return type;
	}	
	
	public int getYearFounded()
	{
		return yearFounded;
	}	

	public int getNumberOfEmployees()
	{
		return numberOfEmployees;
	}

	/*public Company getParent()
	{
		return parent;
	}*/

	public int getId()
	{
		return id;
	}

	/*public String getDescription()
	{
            String description = type + " company " + name + ". ID " + id + ". Founded " + year + ". Has " employees " employees.";
            return description;
	}*/	



/*********************************************************************/

/**
 * 
 * @param args
 */

/*        
public static void main(String[] args)
    {
        Company oneCompany = new Company( );
        oneCompany.readInput();
        oneCompany.getDescription();
        
    }
*/

    
}
		