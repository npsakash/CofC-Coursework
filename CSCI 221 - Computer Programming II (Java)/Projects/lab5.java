import java.util.Scanner;

//Constant
public static final int N = 10;

public class Lab5
{
	//Constant
public static final int N = 10;

    public static void main(String[] args)
    {
    	double[] x = new double[N];

    	//Variables
    	double min = 0;
    	double max = 0;
    	double mean = 0;
    	double variance = 0;

    	//Enter values
    	Scanner keyboard = new Scanner(System.in);	
    	System.out.println("Enter 10 double values: ");
        double sum = 0;
        for (int index = 0; index < N; index++)
        {
			x[index] = keyboard.nextDouble( );

        }
        
        //Sorts to min
        min = x[0];
        for (int index = 0, index < N; index++)
        {
        	if (x[index] > x[0]){
        		min = x[index];
        	}
        	System.out.println(min);

        }


    }
}



