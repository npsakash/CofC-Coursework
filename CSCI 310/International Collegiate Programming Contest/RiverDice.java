import java.util.ArrayList;
import java.util.Scanner;

public class RiverDice {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //River Dice
        Scanner kb = new Scanner(System.in);
        int nrow = kb.nextInt();

        for (int i = 0; i < nrow; i++) {
            //Get n & k
            int numDice = kb.nextInt();
            int numSides = kb.nextInt();

            //Calculate Numerator
            int numerator = 0;
            for (int j = numSides; j > 0; j--) {
                numerator += j;
            }

            //Calculate Denominator
            int denom = (int) Math.pow(numSides, numDice);


            //Find GCF

            for(int k=1; k<=numerator && k<=denom; k++) {
                if (numerator % k == 0 && denom % k == 0) {
                    numerator = numerator / k;
                    denom = denom / k;
                }
            }
            System.out.println(numerator+"/"+denom);
        }
    }

}
