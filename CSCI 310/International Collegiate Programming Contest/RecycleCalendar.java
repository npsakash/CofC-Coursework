/**
 * Two Gigs and a Byte
 * CSCI 310
 * ICPC 8 - RecycleCalendar
 */

import java.util.Scanner;

public class RecycleCalendar {

    //input
    public static String processInput (int year) {
        int y = year;
        int z = calculateNext(year);
        String output = "Calendar for "+y+" can be reused in "+z+".";
        return output;
    }

    public static boolean isLeap(int year){
        if (year%4 == 0) {
            if( year % 100 != 0 || year%400 == 0){
                return true;
            }
        else
            return false;
        }
    else
        return false;
    }

    public static  int calculateNext(int year){
        if(isLeap(year)){
            return year +28;
        }
        else if (isLeap(year-1)) {
            return year + 6;
        }
        else
            return year + 11;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of calendars: ");
        int number = in.nextInt();
        if(number>=1 && number<=1000) {

            for (int i = 0; i < number; i++) {
                System.out.println("Enter calendar year: ");
                int year = in.nextInt();
                if (year >= 1776 && year <= 2776) {
                    String toPrint = processInput(year);
                    System.out.println(toPrint + "\n");
                }
                else
                    System.out.println("Enter year between 1776 and 2776 \n");
            }
        }
        else
            System.out.println("Try again and enter number between 1 and 1000");
    }
}
