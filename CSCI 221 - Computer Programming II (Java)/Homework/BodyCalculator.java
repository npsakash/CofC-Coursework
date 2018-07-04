/**
 * Body Calculator class
 * @author CSCI 221 Lab 4 Template
 * @since Sept. 22nd 2016
 * @author <your name goes here>
 *
 * Body Calculator Application
 *
 */
import java.util.Scanner;
public class BodyCalculator {
	
	// --------------------------
	// Instance variables - Do not modify
	// --------------------------
	
	private char gender = ' ';
	private int height = 0;
	private int weight = 0;
	
	/**
	 * Constructor for BodyCalculator objects - copies parameter value to instance 
	 *   variables
	 * @param gender
	 * @param height
	 * @param weight
	 */
	public BodyCalculator( char c_gender, int c_height, int c_weight ) {
		
	        // ---------------------------------
		// Your implementation goes here
		// ---------------------------------
		// If the following condition is satisfied set the instance 
		// variable value to its respective constructor parameter value
		// - [Condition 1] if value in c_gender is 'M' or 'F'
		// - [Condition 2] if value in c_height is > 0 inches
		// - [Condition 3] if value in c_weight is > 0 lbs
		//
		// Hint: You may use the provided setter methods
                setGender(gender);
                setHeight(height);
                setWeight(weight);
	}
	
	/**
	 * Computes and returns the body mass index for an object
	 * @return
	 */
	public double getBMI() {
		
		double bmi = 0.0;
		
		// ---------------------------------
		// Your implementation goes here
		// ---------------------------------
		// Using the values in the height and weight instances variables
		// calculate the BMI using the formula provided in the lab work-sheet.
		// Hints:
		//		- The formula converts inches to m, by multiplying by 0.025
		//		- The formula converts from lbs to kg, by multiplying by 0.45
		//		- You may use the pow method in the Math class (http://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)
		bmi = (weight*0.15)/Math.pow(height*0.025,2);
		
		return bmi;
		
	} // end getBMI() method
	
	
	/**
	 * 
	 * @return
	 */
	public double getIdealBodyWeight() {
		
		double ibw = 0.0;
		
		// ---------------------------------
		// Your implementation goes here
		// ---------------------------------
		// Using the values in the height, weight, and gender instances variables
		// calculate the ideal body weight using the formulas provided in the lab work-sheet.
		// Hints:
		//		- You will need a branching statement 
                if(gender == 'M'){
                    ibw = 106 + (6 * (height-6));
                if(gender == 'F'){
                    ibw = 100 + (5*(height-60));
                }
                }
		
		return ibw;
		
	} // end getIdealBodyWeight() method
	
	/**
	 * equals method to determine if two objects have same values
	 * @param BodyCalculator object
	 * @return true if parameter otherObject stores same instance variable values as this object, false otherwise
	 */
	 public boolean equals(BodyCalculator otherObject){
	 	
	    // must compare gender, height and weight values in both objects to determine equality
             boolean returnValue;
             
             returnValue = (gender==(otherObject.gender) && height==(otherObject.height)
                            && weight==(otherObject.weight));
	    return returnValue;	
	 }
	
	/**
	 * 
	 * @param gender
	 */
	public void setGender( char gender ) {
		
		if ( gender == 'M' || gender == 'F' ) {
			
			this.gender = gender;
			
		} else {
			
			System.out.printf("Provided Gender [%s] is not valid\n", gender );
			
		}
		
	} // end setGender() method
	
	/**
	 * The units for the height parameter is inches
	 * 
	 * @param height
	 */
	public void setHeight( int height ) {
		
		if ( height > 0 ) {
			
			this.height = height;
			
		} else {
			
			System.out.printf( "The provided height [ %d ] is not a valid inch value!\n", height );
	
		}
		
	} // end setHeight() method
	
	/**
	 * The units for the weight parameter is lbs
	 * 
	 * @param weight
	 */
	public void setWeight( int weight ) {
		
		if ( weight > 0 ) {
			
			this.weight = weight;
			
		} else {
			
			System.out.printf( "The provided weight [ %d ] is not a valid lbs value!\n", weight );
			
		}
		
	} // end setWeight() method
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
           // Code for step 1
	   int weight;
           int height;
           char gender;
	   // Code for step 2
	   Scanner input = new Scanner(System.in);
           System.out.println("Enter weight in pounds: ");
           weight = input.nextInt();
           
	   // Code for step 3
           System.out.println("Enter height in inches: ");
	   height = input.nextInt();
	   // Code for step 4
	   System.out.println("Enter gender (M or F): ");
           gender = input.next().charAt(0);
	   // Code for step 5 to create bc1
	   BodyCalculator bc1 = new BodyCalculator(gender, height, weight);
	   // Step 6: Repeat of steps 2 through 5 to create bc2
	   BodyCalculator bc2 = new BodyCalculator(gender, height, weight);
	   // Step 6: Repeat of steps 2 through 5 to create bc3
	   BodyCalculator bc3 = new BodyCalculator(gender, height, weight);
	   // Code for step 8 (requires completion of step 7)
	   System.out.println("BMI1 = " + bc1.getBMI() + "IBW1 = " + bc1.getIdealBodyWeight());
           System.out.println("BMI2 = " + bc2.getBMI() + "IBW2 = " + bc2.getIdealBodyWeight());
           System.out.println("BMI3 = " + bc3.getBMI() + "IBW3 = " + bc3.getIdealBodyWeight());
	   //Code for step 9 provided
	   //uncomment when ready
	   System.out.println("bc1 and bc2 are equal: " +  (bc1.equals(bc2)));
	   System.out.println("bc2 and bc3 are equal: " +  (bc2.equals(bc3)));
	   System.out.println("bc1 and bc3 are equal: " +  (bc1.equals(bc3))); 
	   
				
	} // end main method

} // end BodyCalculator class definition
