// package Lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mccauleyr
 */
public class Lab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        // Input array contents from filename specified
        //creating File instance to reference text file in Java, that is located
        // in same folder as this file
        File text = new File("/Users/mccauleyr/Desktop/input.txt");
        
        //Creating Scanner instnace to read File in Java
        Scanner scan = new Scanner(text);
        
        // Read 2-D array parameters, # of rows, # of cols
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        
        // Declare and allocate array of size rowsxcols that stores integers
        int [][] arr = new int [rows][cols];
        
        // Input values into array by rows
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                arr[row][col] = scan.nextInt();
            }
        }
        
        // Compute average of each row
        double [] averageOfRow = new double[rows];
        double sum;
         for (int row = 0; row < rows; row++){ 
             sum = 0; // must start sum over for each row 
             for (int col = 0; col < cols; col++)
                sum += arr[row][col];
             averageOfRow[row] = sum / cols;  // compute average of current row
         } 
         
         // Compute min and max of each col
        int min []  = new int[cols];
        int max[]  = new int[cols];
         for (int col = 0; col < cols; col++){
            min[col] = arr[0][col];
            max[col] = arr[0][col];
            for (int row = 1; row < rows; row++)
                if (min[col] > arr[row][col])
                    min[col] = arr[row][col];
                else if (max[col] < arr[row][col])
                    max[col] = arr[row][col];
         } 
           
         // Generate output table
         System.out.print("\t\t");
         for (int i = 1; i <=cols; i++)
             System.out.printf("Lab%-1d\t", i);
         System.out.println("Average");
               
        for (int row = 0; row < rows; row++){
            System.out.printf("Student%-1d\t", (row+1));
            for (int col = 0; col < cols; col++){
                System.out.printf("%-5d\t", arr[row][col]);
            }
            System.out.println(averageOfRow[row]);
        }
        
        // Display minimum values for each column
        System.out.print("Minimum\t\t");
        for (int col = 0; col < cols; col++)
            System.out.printf("%-1d\t", min[col]);
        System.out.println();
        
        // Display minimum values for each column
        System.out.print("Maximum\t\t");
        for (int col = 0; col < cols; col++)
            System.out.printf("%-1d\t", max[col]);  
        System.out.println();
    }
}
