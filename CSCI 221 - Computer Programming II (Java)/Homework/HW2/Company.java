/**
 * Company Class
 * @author CSCI 221 HW2
 * @since Sept. 28nd 2016
 * @author <Neal Sakash>
 */
package hw2.csci221;





public class Company
{

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
            public Company(String initialName, int initialYearFounded, int initialNumberOfEmployees, char initialType){
                
                setName(initialName);
                setType(initialType);
                setYearFounded(initialYearFounded);
                setNumberOfEmployees(initialNumberOfEmployees);
                
            }

            public Company(String initialName, char initialType, Company initialParent, int initialYearFounded,  int initialNumberOfEmployees , int initialId )
            {
                setName(initialName);
                setType(initialType);
                setYearFounded(initialYearFounded);
                setNumberOfEmployees(initialNumberOfEmployees);
                setParent(initialParent);
                setId(initialId);

            }


	
	/* Beginning of the setName() method
	*Name of the company. Accepts a string
	* @param name
	*/
	public void setName(String name){
		this.name = name;
	}
	// end setName() method

	/* Beginning of the setType() method
	*Type of company. Accepts a char that meets the precondition: type is one
	*of 'D', 'O', and 'I'
	* @param type
	*/
	public void setType(char type){

		if ( type == 'D' || type == 'O' || type == 'I'){
			this.type = type;
		} 
                else {

			System.out.printf("Provided Type [%s] is not valid\n", type );

		}
        }
	// end setType() method

	/* Beginning of the setYearFounded() method
	*Year company was founded. Accepts an int
	* @param int
	*/

	public void setYearFounded(int yearFounded){

		this.yearFounded = yearFounded;
		 	
		 }

	
	// end setYear() method

	/* Beginning of the setNumberOfEmployees() method
	*Number of employees in this company. Accepts an int that meets the 
        *precondition numberOfEmployees.
	* @param int
	*/
	public void setNumberOfEmployees(int numberOfEmployees)
        {
            if ( numberOfEmployees > 0 ) {
		this.numberOfEmployees = numberOfEmployees;
	    } 
            else {
		System.out.printf( "The provided number [ %d ] is not a valid value!\n", numberOfEmployees );
            }
	}
	// end setNumberOfEmployees

	/* Beginning of the setParent() method
	*The parent company. Accepts a Company that meets the precondition: 
        *parent is not null.
	* @param Company
	*/

	public void setParent(Company parent){
            this.parent = parent;
	}

	//end of setParent() method

	/* Beginning of the setId() method
	*Id number of company. 
        *Accepts an int that meets the precondition: i >= 0,
	*if not the id number is -1.
	* @param Company
	*/		

	public void setId(int id){
		if (id >= 0){
                    this.id = id;
		}
		else{
                    id = -1;
		}
	}
	//end of setId
        
        //beginning of writeOutput
        /* Beginning of the getDescription() method
        * A string representation of this company. 
        */
        public String getDescription()
        {
            String description = type + " company " + name + ". ID " + id + 
                    ". Founded " + yearFounded + ". Has " + numberOfEmployees 
                    + " employees.";
            return description;
        }            
        //end of getDescription() method
        
        //Comparison methods()
        /*c is not null, and this company has more employees than c has.
        * Returns a boolean
        */
        
        /*public boolean isBigger(company c)
        {
            
            
        }
        /*
        *Static method, c1 and c2 are not null, and c1 has more employees than
        *c2 has. Returns a boolean
        /
        public boolean isBigger(company c1, company c2)
        {
            
        }
        */
        
        /* Beginning of the getName() method
	*Name of the company. Returns a string
	* @param name
	*/
	public String getName()
	{
		return name;
	}
        
        // end getName() method

	/* Beginning of the getType() method
	*Type of company. returns an int
	* @param type
	*/
	public char getType()
	{
		return type;
	}	
	// end getType() method

	/* Beginning of the getYearFounded() method
	*Year company was founded. Returns an int
	* @param int
	*/
	public int getYearFounded()
	{
		return yearFounded;
	}	
        // end getYear() method

	/* Beginning of the getNumberOfEmployees() method
	*Number of employees in this company. Returns an int.
	* @param int
	*/
        public int getNumberOfEmployees()
	{
		return numberOfEmployees;
	}
        // end getNumberOfEmployees

	/* Beginning of the getParent() method
	*The parent company. Returns a company
	* @param Company
	*/
	public Company getParent()
	{
		return parent;
	}
        //end of getParent() method

	/* Beginning of the getId() method
	*Id number of company. Returns an int
	* @param Company
	*/
	public int getId()
	{
		return id;
	}
        //end of getParent() method

    

    
	
    


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
		