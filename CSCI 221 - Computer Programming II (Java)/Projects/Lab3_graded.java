/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import java.util.Scanner;

/**
 *
 * @author Neal
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    System.out.println("The Riddler is planning a caper somewhere on"
            + "Pennsylvania Ave");
    System.out.println("Run the decoder to find the exact address!");
    System.out.println("Run decoder? y/n : ");
    
    
    Scanner keyboard = new Scanner(System.in);
    String decoder = keyboard.next();
    
    if(decoder.equals("y"))
    {
        int digit1, digit2, digit3, digit4;
        for (int index = 1000; index <= 9999; index++)
        {

            digit1 = index/1000%10;
            digit2 = (index/100)%10;
            digit3 = (index/10)%10;
            digit4 = index%10;

            if(digit1 != digit2 && digit1 != digit3 && digit1 !=digit4 & digit2 
                    != digit3 && digit2 != digit4 && digit3 != digit4)
                if(digit1 == digit3*3)
                    if(index%2 != 0)
                        if(digit1+digit2+digit3+digit4 == 27)
                            System.out.println("Excellent! The address is "
                                    + index +" Pennsylvania Ave.");


        }
//    System.out.println(index);
    }
    }

    private static String decoder(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
