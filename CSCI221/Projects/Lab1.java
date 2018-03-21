/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogram;

/**
 *
 * @author Neal Sakash
 * @since September 5, 2016
 * @version 1
 * Java class that computes the area and circumference of a circle and prints
 * the results
 */
import java.util.Scanner;
public class Lab1 
{
    public static void main(String[] args)
    {
    double radius,circumfernce, area;
    System.out.println("Please enter a radius value: ");
    Scanner keyboard = new Scanner(System.in);
    
    radius = keyboard.nextDouble();
    
    if (radius > 0)
    {
        area = Math.PI * Math.pow(radius, 2);
        circumfernce = 2 * Math.PI * radius;
        System.out.println("Area = " + area + "\n" + "Circumference = " + circumfernce);
    }
    else  System.out.println("The entered radius is <= 0... exiting program"); 
    }
    
}
