import java.util.Scanner;

public class CircleCalculatorDemo2
{
    public static void main(String[] args)
    {
        double radius;
        System.out.println("Enter the radius of a circle in inches:");
        Scanner keyboard = new Scanner(System.in);
        radius = keyboard.nextDouble( );
        System.out.println("A circle of radius " +
                            radius + " inches");
        System.out.println("has an area of " + CircleCalculator.getArea(radius) + 
		                   " square inches,");
        System.out.println("and a circumference of " +
                            CircleCalculator.getCircumference(radius) + " inches.");
    }
}
