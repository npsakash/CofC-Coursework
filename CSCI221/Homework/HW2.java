/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.csci221;

/**
 * Company class
 * @author CSCI 221 HW2
 * @since Sept. 28nd 2016
 * @author <Neal Sakash>
 *
 * Body Calculator Application
 *
 */

import java.util.Scanner;

public class Company{

	// --------------------------
	// Instance variables - Do not modify
	// --------------------------

	private String name = " ";
	private char type = ' ';
	private int year = 1900;
	private int employees = 0;
	private Company parent = null;
	private int id = -1;

	/*
	 * Constructors for Company objects - copies parameter value to instance 
	 *   variables
	 * @param name
	 * @param type
	 * @param year
	 * @param employees
	 * @param parent
	 * @param id
	 */
	public Company(String name, char type, int year, int employees ){
		setName(name);
		setType(type);
		setYearFounded(year);
		setNumberOfEmployees(employees);
		//setParent(parent);
		//setId(id);
	}

	public Company(String name, char type, Company parent, int year, int employees, int id ){
		setName(name);
		setType(type);
		setYearFounded(year);
		setNumberOfEmployees(employees);
		setParent(parent);
		setId(id);
	}


	
	/* Beginning of the setName() method
	*Name of the company. Accepts a string
	* @param name
	*/
	public void setName(String s){
		name = s;
	}
	// end setName() method

	/* Beginning of the setType() method
	*Type of company. Accepts a char that meets the precondition: t is one
	*of 'D', 'O', and 'I'
	* @param type
	*/
	public void setType(char t){

		if ( t == 'D' || t == 'O' || t == 'I'){
			type = t;
		} 
                else {

			System.out.printf("Provided Type [%s] is not valid\n", t );

		}
        }
	// end setType() method

	/* Beginning of the setYearFounded() method
	*Year company was founded. Accepts an int
	* @param int
	*/

	public void setYearFounded(int y){

		if (y >= 1900) {
			year = y;
		 	
		 }
		 else{

		 	System.out.printf("The provided year [ %d ] is not a valid value!\n", y );
		 }

	}
	// end setYear() method

	/* Beginning of the setNumberOfEmployees() method
	*Number of employees in this company. Accepts an int that meets the precondition e.
	* @param int
	*/
	public void setNumberOfEmployees(int e){

		if ( e > 0 ) {
			
			employees = e;
			
		} else {
			
			System.out.printf( "The provided number [ %d ] is not a valid value!\n", e );
	
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

	public void setId(int i){
		if (i >= 0){
			id = ++i;
		}
		else{
			id = -1;
		}
	}
	//end of setId
		

	






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
		return year;
	}	

	public int getNumberOfEmployees()
	{
		return employees;
	}

	public Company getParent()
	{
		return parent;
	}

	public int getId()
	{
		return id;
	}

	public String getDescription()
	{
            String description = type + " company " + name + ". ID " + id + ". Founded " + year + ". Has " employees " employees.";
            return description;
	}	



/*********************************************************************/

/**
 * 
 * @param args
 */

public static void main( String[] args ) {
    String name;
    int year;
    int employees;
    char type;
    Company parent;
    int id;
    
    Scanner input = new Scanner(System.in);
        System.out.println("Enter in the company name: ");
        name = input.next();
        
        System.out.println("Enter the year the company was founded: ");
        year = input.nextInt();
        
        System.out.println("Enter the amount of company employees: ");
        employees = input.nextInt();
        
        System.out.println("Enter the type of company (D for Domestic,"
                + "O for overseas, or I for International");
        type = input.next().charAt(0);
        
        System.out.println("Enter in the parent company's name: ");
        parent = input.next();
        
        System.out.println("Enter the company's ID: ");
        year = input.nextInt();

        Company linkedIn1 = new Company(name, year, employees, type, parent, id);
        
}

   
    

    

}
		