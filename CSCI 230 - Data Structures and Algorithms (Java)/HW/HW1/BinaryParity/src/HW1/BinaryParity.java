package HW1;

import static java.lang.Integer.toBinaryString;
import java.util.Scanner;

/**
 * @author Neal Sakash
 * @since January 17, 2017
 * @version 1
 * HW 1 - CSCI 230 Spring 2017
 * 
 * BinaryParity.java
 */


public class BinaryParity {
    
    /**
     * Method that counts occurrences of '1' in a binary formated integer and 
     * returns the total.
     * 
     * @param test
     * @param i
     * @return count
     * Precondition: test is not-null
     */
    public static int binaryCount( char[] test, int i) {
            
            int count = 0;
            
            if(i < test.length && test[i] == '0')
                count = count + binaryCount(test, i+1);
                
            else if(i < test.length && test[i] == '1'){
                count ++;
                count = count + binaryCount(test, i+1);
            }
        return count;
    }//END binaryCount() method
    
    /**
     * Method for determining and outputting the parity of a binary integer from
     * binaryCount.
     * 
     * @param c
     * @return String
     * Precondition: c is non-negative
     */
    public static String parityOutput(int c){
        if (c >= 0 && c%2 == 0){
            return "EVEN";
        }
        else
            return "ODD";
    }// END parityOutput() method
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int inputInt = -1;
        while(inputInt < 0){
            System.out.println("Please enter a number: ");
            inputInt = input.nextInt();}
            
            // Convert the integer into a binary String
            String inputString = toBinaryString(inputInt);

            // Output the integer in binary format    
            System.out.println("The number in binary format: " 
            + inputString);
            
            // Convert String to an array of char
            char [] test = inputString.toCharArray();
            
            // Call recursive method and set i=0 (index position of the first 
            // element in the character array) 
            int num = binaryCount(test,0);
            System.out.println(num);

            // Display the results    
            System.out.println("The number " + inputInt + " has " 
                    + parityOutput(num) + " parity");
    }// END main() method
}// END BinaryParity Class
