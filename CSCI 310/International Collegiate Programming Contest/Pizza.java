/**
 * Two Gigs and a Byte
 * CSCI 310
 * ICPC 8 - Pizza
 */

import java.util.Scanner;


public class Pizza {
    public static double calculateCheesy (int diameter, int thickness, int slices){
        double radius = diameter/2;
        double number = Math.pow(radius-thickness,2);
        double answer = (Math.PI*(number))/slices;
        return answer;
    }

    public static double calculateCrust (int diameter, int thickness, int slices){
        double radius = diameter/2;
        double number = Math.pow(radius,2);
        double area = Math.PI*number;
        return area/slices - calculateCheesy(diameter, thickness, slices);
    }

    public static String outputGenerator (double cheesy, double crust){
        String cheese = String.format("%.1f",cheesy);
        String crus = String.format("%.1f",crust);
        String output = "Cheesy area is "+ cheese + " and Crust area is "+crus;
        return output;
    }

    public static int[] takeInput (String line){
        int[] result = new int[line.length()];
        String[] lineSp = line.split(" ");
        for (int i=0; i<lineSp.length; i++){
            result[i] = Integer.parseInt(lineSp[i]);
            //System.out.println(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner (System.in);
		int number = in.nextInt();
        String line = in.nextLine();

//		System.out.println(calculateCrust(18,1,8));
        //takeInput(line);

	for (int i=0; i<number; i++){
		line = in.nextLine();
		int[] lines = takeInput(line);
		String output = outputGenerator(calculateCheesy(lines[0], lines[1], lines[2]),calculateCrust(lines[0], lines[1], lines[2]));
		System.out.println(output);
	}


    }

}