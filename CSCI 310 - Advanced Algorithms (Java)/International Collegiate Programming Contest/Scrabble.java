import java.util.Scanner;

public class Scrabble {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        line = line.toUpperCase();
        int n = line.length();
        int r = 0;
        

        int nFact = 1;
        for (int i = 1; i <= n; i++) {
            nFact = nFact * i;
        }
//        System.out.println(nFact);

        int rFact = 1;
        for (int j = 1; j <= n; j++) {
            rFact = rFact * j;
        }
//        System.out.println(rFact);

        int nR = n-r;
        int nRFact = 1;
        for (int i = 1; i <= nR; i++) {
            nRFact = nRFact * i;
        }
//        System.out.println(nRFact);


        //double combo1 = Math.pow(n,r);
        //System.out.println("1: "+combo1);

        int combo2 = nFact;
        //System.out.println("2: "+combo2);

        int combo3 = nFact/(nRFact);
        //System.out.println("3: "+combo3);

        int combo4 = nFact/(nRFact*rFact);
        //System.out.println("4: "+combo4);

        int combo5 = nFact/(nRFact*rFact);
        //System.out.println("5: "+combo5);

        int combo6

        System.out.println(combo4);

    }
}