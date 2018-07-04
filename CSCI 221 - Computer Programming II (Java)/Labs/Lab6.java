package Lab6;

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
               

  
        
    }
}
