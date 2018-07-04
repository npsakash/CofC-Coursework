/**
 * Two Gigs and a Byte
 * CSCI 310
 * ICPC 6 - Magic Squares
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MagicSquares {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("input tests: ");
        int tests = in.nextInt();
        int runs = 0;
        while (runs != tests) {


            //System.out.println("input dim: ");
            int dim = in.nextInt();
            Integer[][] mainArr = new Integer[dim][dim];

            //magic formula
            //M = n(n^2+1)/2
            int magicNum = (int) (dim * (Math.pow(dim, 2) + 1) / 2);

            //Input
            for (int row = 0; row < dim; row++) {
                //System.out.println("input array by row: ");
                String rowinput = in.next();
                String[] rowInputSp = rowinput.split("");
//                for (int col = 0; col < dim; col++) {
//                    System.out.print(rowInputSp[col]);
//                }

                for (int col = 0; col < dim; col++) {
                    mainArr[row][col] = Integer.valueOf(rowInputSp[col]);
                }
            }

            //Test Output
//            for (int row = 0; row < mainArr.length; row++) {
//                for (int col = 0; col < mainArr[row].length; col++) {
//                    System.out.print(mainArr[row][col] + "\t");
//                }
//                System.out.println();
//            }
//            System.out.println(magicNum);

            //row totals
            //outerloop:
            boolean magic = true;
            outerloop:
            while (magic) {

                for (int i = 0; i < mainArr.length; i++) {
                    int rowAdd = 0;
                    for (int col = 0; col < mainArr.length; col++) {
                        rowAdd += mainArr[i][col];
                    }
                    if (rowAdd != magicNum) {
                        System.out.println("no");
                        magic = false;
                        break outerloop;

                    } else {
                        //magic=false;
                        //System.out.println("row" + (i + 1) + ": " + rowAdd);
                    }
                }


                //col totals
                for (int i = 0; i < mainArr.length; i++) {
                    int colAdd = 0;
                    for (int row = 0; row < mainArr.length; row++) {
                        colAdd += mainArr[row][i];
                    }
                    if (colAdd != magicNum) {
                        System.out.println("no");
                        magic = false;
                        break outerloop;

                    }
//                     else {
//                        System.out.println("col" + (i + 1) + ": " + colAdd);
//                    }
                }

                //diagonals
                //diaOne
                int diaOne = 0;
                for (int i=mainArr.length-1; i>=0; i--){
                    diaOne += mainArr[i][i];
                    //System.out.println(mainArr[i][i]);
                }
                if (diaOne != magicNum) {
                    System.out.println("no");
                    magic = false;
                    break outerloop;
                }
//                else {
//                    System.out.println("diaOne: " + diaOne);
//                }

                //diaOne
                int diaTwo = 0;
                for (int i=0; i<mainArr.length; i++){
                    diaTwo += mainArr[i][i];
                    //System.out.println(mainArr[i][i]);
                }
                if (diaTwo != magicNum) {
                    System.out.println("no");
                    magic = false;
                    break outerloop;
                }
//                else {
//                    System.out.println("diaTwo: " + diaTwo);
//                }


                //if magic square
                if (magic == true) {
                    System.out.println("yes");
                    break outerloop;
                }

            }
            runs += 1;
        }
    }
}
