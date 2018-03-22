package HW1;

import java.util.Scanner;

/**
 * @author Neal Sakash
 * @since January 17, 2017
 * @version 1
 * HW 1 - CSCI 230 Spring 2017
 * 
 * Pangram.java
 */


public class Pangram {
    
    private static final int ALPHABET_LENGTH = 26;
    
    /**
     * Method that loops through a string and determines the occurrence of each
     * letter in the alphabet
     * 
     * @param input
     * @return boolean
     * 
     * Precondition: input is not-null
     */
    public static boolean pangram(String input){
        if(input.length() < ALPHABET_LENGTH){
            return false;}
        else{
            for (char c = 'A'; c <= 'Z'; c++){
                if((input.indexOf(c) < 0) && (input.indexOf((char)(c + 32))) < 0){
                    return false;
                }
            }
        }
        return true;
    }// END pangram() method
    
    /**
     * Method that outputs whether a sting is a pangram or not
     * 
     * @param c
     * @return String
     * 
     * Precondition: none
     */
    public static String testOutput(boolean c){
        if (c){
            return "IS";
        }
        else
            return "IS NOT";
    }// END parityOutput() method    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // user input of string
        System.out.println("Enter a string for pangram testing");
        String inputString = input.nextLine();
        System.out.println();
        
        // adjust case
        inputString = inputString.toUpperCase();
        
        // call pangram testing method
        boolean isPangram = pangram(inputString);
        
        // display results
        System.out.println("This sentence " + testOutput(isPangram) + " a pangram " );
    }// END main() method    
}// END Pangram Class