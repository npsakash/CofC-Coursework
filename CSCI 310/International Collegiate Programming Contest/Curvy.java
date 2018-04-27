import java.util.ArrayList;
import java.util.Scanner;

public class Curvy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*String line = in.nextLine();
        while (!line.equals("0 0")) {

        }*/
        //System.out.println("Enter n");
        //getting an error after inputting "n"
        //int n = in.nextInt();
        int n = 3;
        //System.out.println("Enter mu, sd");
        String line = in.nextLine();
        String[] lineSp = line.split(" ");
        float mu = Float.parseFloat(lineSp[0]);
        float sd = Float.parseFloat(lineSp[1]);

        ArrayList newScores = new ArrayList();
        float x;
        for(int i=0; i < n; i++) {
            x = in.nextInt();
            //having trouble with this formula
            x = x + Math.abs(((x - mu) / sd));
            //Math.floor(x);
            newScores.add(x);
            //System.out.println(x);
        }

        System.out.println(newScores);


    }
}
