import sun.font.TrueTypeFont;

import java.util.Scanner;

public class CongruentNumbers {

    public static boolean isInt(double d){
        if(d%1==0){
            return true;
        }
        else
            return false;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //System.out.println("Enter number");
        String legs = in.nextLine();
        String[] lineSp = legs.split(" ");

        double p1 = Double.parseDouble(lineSp[0]);
        double q1 = Double.parseDouble(lineSp[1]);
        double p2 = Double.parseDouble(lineSp[2]);
        double q2 = Double.parseDouble(lineSp[3]);

        double legA = p1/q1;
        double legB = p2/q2;

        double area = (legA*legB)/2;

        if (isInt(area)){
            System.out.println("1");
        }
        else
            System.out.println("0");
    }
}
