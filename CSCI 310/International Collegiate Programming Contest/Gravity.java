/**
 * Two Gigs and a Byte
 * CSCI 310
 * ICPC 5 - Gravity
 *
 */

import java.util.ArrayList;
import java.util.Scanner;
public class Gravity {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter NxN");
        String array = in.nextLine();
        String[] lineSp = array.split("");
        int rows = Integer.parseInt(lineSp[0]);
        int cols = Integer.parseInt(lineSp[1]);
        //double col = Double.parseDouble(lineSp[0]);
        // 2D Array
        String [][] mainArr = new String [rows][cols];

        //Input data by row
        for (int row = 0; row<rows; row++) {
            System.out.println("input array by row: ");
            String rowinput = in.nextLine();
            String[] rowInputSp = rowinput.split("");
            for(int col = 0; col<cols; col++){
                mainArr[row][col] = rowInputSp[col];
            }
        }

        //Test Output
        for (int row = 0; row < mainArr.length; row++){
            for (int col = 0; col < mainArr[row].length; col++){
                System.out.print(mainArr[row][col] + "\t");
            }
            System.out.println();
        }
        //System.out.print(mainArr[0][0] + "\t");
        //System.out.print(mainArr[1][0] + "\t");
        System.out.println();

        //Conditionals
        for(int col=0; col<cols; col++){
            for(int row=0; row<rows-1; row++){
                String apple = mainArr[row][col];
                if (mainArr[row+1][col].equals(".") && !mainArr[row][col].equals("#")){
                    String temp = ".";
                    mainArr[row+1][col] = apple;
                    mainArr[row][col] = temp;
                }
            }
        }
        //test output Final
        for (int row = 0; row < mainArr.length; row++){
            for (int col = 0; col < mainArr[row].length; col++){
                System.out.print(mainArr[row][col] + "\t");
            }
            System.out.println();
        }
    }
}

