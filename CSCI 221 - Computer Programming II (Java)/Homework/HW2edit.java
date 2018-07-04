package hw1.csci221;

/**
 * 
 * HW 1 - CSCI 221 Fall 2016
 * 
 * Company class developed for hypothetical LinkedIn application.
 * Programming Project 1 - CSCI 221, Fall 2016
 *
 * @ 221 teaching staff
 */
public class Company {
	
	// ---------------------------
	// Private instance variables
	// ---------------------------
	private String name = "";
	private char type;			
	private int year;
	private int employees = 0;
	private int id = -1;
	private Company parent = null;
	
	/**
	 * Overloaded Constructor
	 * 4-parameters
	 * 
	 * @param name
	 * @param year
	 * @param employee
	 * @param type
	 */
	public Company( String name, int year, int employees, char type ) {
		
		// call 6-parameter constructor
		// pass in arguments
		
		this( name, type, null, year, employees, -1 );
		
	} // end 4-parameter overloaded constructor
	
	/**
	 * 
	 * * Overloaded Constructor
	 * 6-parameters
	 * 
	 * @param name
	 * @param type
	 * @param parent
	 * @param year
	 * @param employees
	 * @param id
	 */
	public Company( String name, char type, Company parent, int year, int employees, int id ) {
		
		setName( name );
		setType( type );
		setParent( parent );
		setYearFounded( year );
		setNumberOfEmployees( employees );
		setId( id );
		
	} // end 6-parameter overloaded constructor
	
	/**
	 * Sets the name of the company
	 * Pre-Condition: name argument passed into method
	 * Post-Condition: name instance variable value set 
	 *                 equal to argument value
	 * 
	 * @param name of a Company instance
	 */
	public void setName( String name ) {
		
		// This is only for debug purposes
		assert( name.isEmpty() || name == null ) : "name argument not valid";
		
		if ( !name.isEmpty() && name != null ) {
			
			this.name = name;
			
		}
		
	} // end setName() method
	
	/**
	 * Retrieves name of the company
	 * Pre-Condition: none
	 * Post-Condition: value in name instance variable returned
	 * 
	 * @return the name of the Company it is called on
	 */
	public String getName() {
		
		// This is only for debug purposes
		assert( name.isEmpty() || name == null ) : "name return value not valid";
		
		return name;
		
	} // end getName() method
	
	
	/**
	 * Sets the type of a company
	 * Pre-Conditions: type argument passed into method.
	 *                 value one of 3 characters (O,D,I)
	 * Post-Condition: type instance variable value set 
	 *                 equal to argument value only if 
	 *                 one of 'O', 'D', or 'I' 
	 * 
	 * @param type the type indicator
	 */
	public void setType( char type ) {
		
		// This is only for debug purposes
		assert( type != 'O' && type != 'D' && type != 'I' ) : "type argument not valid";
		
		if ( type == 'O' || type == 'D' || type == 'I' ) {
			
			this.type = type;
			
		}
		
	} // end setType() method
	
	/**
	 * Retrieves the type of a Company
	 * Pre-Conditions: none
	 * Post-Condition: type instance variable returned
	 * 
	 * @return returns the type indicator
	 */
	public char getType() {
		
		// This is only for debug purposes
		assert( type != 'O' && type != 'D' && type != 'I' ) : "type return value not valid";
		
		return type;
		
	} // end getType() method
	
	/**
	 * Stores the parent company
	 * Pre-Conditions: parent argument passed into method.
	 * 			       parent not equal to null
	 * Post-Condition: parent instance variable value set 
	 *                 equal to argument value only if 
	 *                 not equal to null. 
	 * @param parent
	 */
	public void setParent( Company parent ) {
		
		// This is only for debug purposes
		assert( parent == null ) : "parent argument not valid";
		
		if ( parent != null ) {
			
			this.parent = parent;
			
		}
		
	} // end setParent() method
	
	/**
	 * Retrieves the parent company
	 * Pre-Conditions: none
	 * Post-Condition: parent instance variable returned
	 * 
	 * @return a reference to the parent company
	 */
	public Company getParent() {
		
		// This is only for debug purposes
		assert( parent == null ) : "parent return value not valid";
		
		return parent;
		
	} // end getParent() method
	
	/**
	 * Stores the year the company was founded
         * Pre-Conditions: year argument passed into method
	 * Post-Condition: year instance variable value set 
	 *                 equal to argument value (no check
	 *                 required)
	 * @param year the company was founded
	 */
	public void setYearFounded( int year ) {
		
		// This is only for debug purposes
		assert ( year < 1000 ) : "year argument not valid";
		
		// Don't worry about invalid dates
		this.year = year;
		
	} // end setYearFounded() method
	
	/**
	 * Retrieves the year the company was founded
	 * Pre-Conditions: none
	 * Post-Condition: year instance variable returned
	 * @return the year the company founded
	 */
	public int getYearFounded() {
		
		// This is only for debug purposes
		assert ( year < 1000 ) : "year return value not valid";
		
		return year;
		
	} // end getYearFounded() method
	
	/**
	 * Store number of employees in this company
         * Pre-Conditions: employee argument passed into method
	 *                 expecting value to be > 0
	 * Post-Condition: employee instance variable value set 
	 *                 equal to argument value if > 0
	 *                 
	 * @param employees the number of employees
	 */
	public void setNumberOfEmployees( int employees ) {
		
		// This is only for debug purposes
		assert( employees < 1 ) : "employee argument not valid";
		
		if ( employees > 0 ) {
			
			this.employees = employees;
			
		}
		
	} // end setNumberOfEmployees() method
	
	/**
	 * Accesses number of employees of this company
	 * Pre-Conditions: none
	 * Post-Condition: year instance variable returned
	 * 
	 * @return number of employees of this company
	 */
	public int getNumberOfEmployees() {
		
		// This is only for debug purposes
		assert( employees < 1 ) : "employee return value not valid";
		
		return employees;
		
	} // end getNumberOfEmployees() method
	
	/**
	 * Store a company id
	 * Pre-Conditions: id argument passed into method
	 * 		           expecting value >= 0
	 * Post-Condition: id instance variable value set 
	 *                 equal to argument value if >= 0
	 *                 
	 * @param id the id number of a company
	 */
	public void setId( int id ) {
		
		// This is only for debug purposes
		assert( id < 0 ) : "id argument not valid";
		
		if ( id >= 0 ) {
			
			this.id = id;
			
		}
		
	} // end setId() method
	
	/**
	 * Returns a company's id
	 * Pre-Conditions: none
	 * Post-Condition: id instance variable returned
	 * 
	 * @return the id number of a company
	 */
	public int getId() {
		
		// This is only for debug purposes
		assert( id < 0 ) : "id return value not valid";
		
		return id;
		
	} // end getId() method
	
	/**
	 * Determines if this company has more employees than another company
	 * Pre-Conditions: Company object passed into method, argument 
	 * 				   is not null
	 * Post-Condition: this company number of employees instance variable 
	 * 				   value compared to argument company number of employees. 
	 * 				   if argument is not null, and this company has more
	 * 				   employees return true;
	 *                 
	 * @param c the name of a company to compare to
	 * @return true if this company bigger than parameter company
	 */
	public boolean isBigger( Company c ) {
		
		// This is only for debug purposes
		assert( c == null ) : "company argument not valid";
		
		boolean isBigger = false;
		
		if ( c != null ) {
			
			if ( this.getNumberOfEmployees() > c.getNumberOfEmployees() ) {
				
				isBigger = true;
				
			}
			
		}
		
		return isBigger;
		
	} // end isBigger() method
	
	/**
	 * Static method to compare any two companies
	 * Pre-Conditions: Company objects passed into method and are not null
	 * Post-Condition: c1 company number of employees instance variable 
	 * 				   value compared to c2 company number of employees 
	 * 				   instance variable value. If argument both are 
	 * 				   not null, and c1 company has more employees than 
	 * 				   c2 return true;
	 * 
	 * @param c1 one company to be compared to second company
	 * @param c2 secomd company
	 * @return true if c1 has more employees than c2, else false
	 */
	public static boolean isBigger( Company c1, Company c2 ) {
		
		// This is only for debug purposes
		assert( c1 == null || c2 == null ) : "company argument(s) not valid";
		
		boolean isBigger = false;
		
		if ( c1 != null && c2 != null ) {
			
			if ( c1.getNumberOfEmployees() > c2.getNumberOfEmployees() ) {
				
				isBigger = true;
				
			}
			
		}
		
		return isBigger;
		
	} // end isBigger() method
	
	/**
	 * Returns a String representation for the current company
	 * Pre-Conditions: none
	 * Post-Condition: Return formatted information in String
	 * 				   if id >= 0 include id, else do not.
	 * 				   Example,
	 *                 "D company SuperMaster. Id 34. Founded 2005. Has 1000 employees"
	 * 
	 * @return a string describing this company
	 */
	public String getDescription() {
		
		// This is only for debug purposes
		assert( getId() < 0 ) : "Id not included in description";
		
		String description;
		
		if ( getId() >= 0 ) {
			
			description = getType() + " company " +  getName() + ". Id "+ getId() +". Founded " + getYearFounded() +". Has "+getNumberOfEmployees() +"  employees";
		
		} else {
			
			description = getType() + " company " +  getName() + ". Founded " + getYearFounded() +". Has "+getNumberOfEmployees() +"  employees";
			
		}
                
                // Optional, print parent if it exists
                if (getParent() != null)
                    description += ". Parent: " + getParent().getName();
		
		return description;
		
	} // end getDescription() method

} // end Company class definition


//start of CompanyClass definition
public class CompanyRoster{
	/**
	 * Constructor
	 * 1-parameter
	 * 
	 * @param Company c
	 */
	public Company( Company c ) {
		
		// call 1-parameter constructor
		// pass in arguments
		
		this( Company c );
		
	} // end 1-parameter constructor


	/**
	 * 
	 * Accesses number of international companies that exist.
	 * Pre-Conditions: none
	 * 
	 * 
	 */
	public int numberOfInternationalCompanies(){
		int counter;
		for()

	}
	//end numberOfInternationalCompanies method

	/**
	 * 
	 * Accesses number of overseas companies that exist.
	 * Pre-Conditions: none
	 * 
	 * 
	 */
	public int numberOfOverseasCompanies(){

	}
	//end of numberOfOverseasCompanies

	/**
	 * 
	 * Accesses number of domestic companies that exist.
	 * Pre-Conditions: none
	 * 
	 * 
	 */
	public int numberOfDomesticCompanies(){

	}
	//end of numberOfDomesticCompanies

	/**
	 * 
	 * Accesses number of domestic companies that exist.
	 * Pre-Conditions: none
	 * 
	 * 
	 */
	public int numberOfDomesticCompanies(){

	}
	//end of numberOfDomesticCompanies

	/**
	 * 
	 * Returns true if this company stores same data as
	 * company c, returns false otherwise.
	 * Pre-Conditions: c is an existing company
	 * 
	 * 
	 */
	public boolean equals( Company c){

	}
	//end equals instance method

	/**
	 * 
	 * Returns true if this company has the same ID as
	 * company c, returns false otherwise.
	 * Pre-Conditions: c is an existing company
	 * 
	 * 
	 */
	public boolean equalsID( Company c){

	}
	//end equalsID instance method

	/**
	 * 
	 * Returns true if this company has the same name
	 * as company c, returns false otherwise.
	 * Pre-Conditions: c is an existing company
	 * 
	 * 
	 */
	public boolean equalsName( Company c){

	}
	//end equalsName instance method

	/**
	 * 
	 * Returns a new object that is a copy of this company.
	 * Pre-Conditions: c is an existing company
	 * 
	 * 
	 */
	public Company copy(){

	}
	//end copy instance method

	//begin main 
	public static void main(String[] args)
}
