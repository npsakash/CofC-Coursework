/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author Neal Sakash
 * @since September 10, 2016
 * @version 1
 * Java class that computes the heat index given outside temperature and
 * humidity, with corresponding caution statements
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    //Declaration of variables
    double temperature, humidity, heatindex;
    
    //user input of temperature and humidity
    System.out.println("Enter a temperature value (in Fahrenheit): ");
    Scanner keyboard = new Scanner(System.in);
    temperature = keyboard.nextDouble();
    
    System.out.println("Enter a humidity value: ");
    humidity = keyboard.nextDouble();
    
    //formula for computing heat index
    if (temperature >= 80 && humidity >= 40)
    {
        heatindex = -42.379 + 2.04901523 * temperature + 10.14333127 * humidity 
                - 0.22475541 * temperature * humidity - 6.83783e-3 * 
                Math.pow(temperature, 2) - 5.481717e-2  * Math.pow(humidity, 2) 
                + 1.22874e-3 * Math.pow(temperature, 2) * humidity  + 8.5282e-4 
                * temperature * Math.pow(humidity, 2) - 1.99e-6 * 
                Math.pow(temperature, 2) * Math.pow(humidity, 2); 
        
        //output of heat index and coordinating warning statement
        heatindex = Math.round(100*heatindex)/100;
        System.out.println("Heat Index is: " + heatindex);
        if (heatindex >= 80 && heatindex < 90)
            System.out.println("Caution: Fatigue is possible with prolonged "
                    + "exposure and activity");
        else if (heatindex >= 90 && heatindex < 105)
            System.out.println("Extreme Caution: Sunstroke, heat cramps, and "
                    + "heat exhaustion are possible");
        else if (heatindex >= 105 && heatindex <= 130)
            System.out.println("Danger: Sunstroke, heat cramps, and heat "
                    + "exhaustion likely; Heat stroke is possible");
        else if (heatindex > 130)
            System.out.println("Extreme Danger: Heat stroke or sunstroke "
                    + "likely with continued exposure");
    }
    //output when heat index cannot be calculated
    else
    {
        System.out.println("Heat index cannot be computed");
    }
    }
    
}
