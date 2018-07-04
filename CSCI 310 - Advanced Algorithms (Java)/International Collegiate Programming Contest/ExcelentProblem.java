import java.util.Scanner;

public class ExcelentProblem {

    public static String cellLocation(String colLoc, String rowLoc){
        //row location - DONE
        String rowString = rowLoc;

        //column location
        //Build empty String
        StringBuilder colVal = new StringBuilder();

        //convert string to int
        int col = Integer.valueOf(colLoc)-1;

        while (col >=  0) {
            int asciiVal = (col % 26)  + 65;
            colVal.append((char)asciiVal);
            col = (col  / 26) - 1;
        }

        //order column values
        String colString = colVal.reverse().toString();

        //concatenate column and row
        return colString.concat(rowString);

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String cell = in.nextLine();
        cell = cell.toUpperCase();
        String[] lineSp = cell.split("C");
        String row = lineSp[0];
        String col = lineSp[1];

        //System.out.println(row);
        //System.out.println(col);

        String rowVal = row.substring(1);
        String colVal = col;

        System.out.println(cellLocation(colVal,rowVal));

    }
}
