import java.util.Scanner;
public class Question6
{
    public static void main(String[] args)
    {
        double[] array = new double[20];
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter 20 numbers:");
        for (int index = 0; index < array.length; index++)
            array[index] = keyboard.nextDouble( );
        double lastNumber = array[array.length - 1];
        System.out.println("The last number read is " + 
                            lastNumber + ".");
        System.out.println("The numbers read and their " +
                            "differences from last number are:");
        for (int index = 0; index < array.length; index++)
            System.out.println(array[index] +
                       " differs from the last number by " +
                       (array[index] - lastNumber));
    }
}