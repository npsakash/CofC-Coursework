import java.util.ArrayList;
import java.util.Scanner;
public class WackAMole {

     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);

         String line = in.nextLine();
         String[] lineSp = line.split(" ");
         int rows = Integer.parseInt(lineSp[0]);
         int cols = Integer.parseInt(lineSp[1]);



         // 2D Array
         String [][] arr = new String [rows][cols];

         // Input data into array
         for (int row = 0; row < rows; row++){
             for (int col = 0; col < cols; col++){
                 arr[row][col] = in.next();

             }
         }

         //Output
         int  mTotal = 0;
         for (int row = 0; row < arr.length; row++){

             for (int col = 0; col < arr[row].length; col++){
                 if(arr[row][col].equals("M")){
                     mTotal  ++;
                 }
                 System.out.print(arr[row][col] + "\t");
             }
             //System.out.println();
         }
         //System.out.println(mTotal);
         double length = mTotal;
         System.out.println(length);
     }
}
