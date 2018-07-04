/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogram;


import java.util.Scanner;

public class FirstProgram
{
    public static void main(String[] args)
    {
        System.out.println("Hello out there.");
        System.out.println("I will add three numbers for you.");
        System.out.println("Enter three whole numbers on a line:");

        int n1, n2, n3;

        Scanner keyboard = new Scanner(System.in);
        n1 = keyboard.nextInt( );
        n2 = keyboard.nextInt( );
        n3 = keyboard.nextInt( );

        System.out.println("The sum of these three numbers is");
        System.out.println(n1 + n2 + n3);       
        
    }
}
