/**
 Class with static methods to perform calculations on circles.
*/
public class CircleCalculator
{
    public static double getArea(double radius)
    {
        return Math.PI * radius * radius;
    }
	
    public static double getCircumference(double radius)
    {
        return Math.PI * (radius + radius);
    }
}
