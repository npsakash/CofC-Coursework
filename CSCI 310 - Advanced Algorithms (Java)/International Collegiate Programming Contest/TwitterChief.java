import java.util.Scanner;

public class TwitterChief {

    public static double calculateAverage(int tweets, int days) {
        double tweet = tweets;
        double average = tweet / days;
        return average;
    }

    public static String outputGenerator(double average) {
        String toPrint = String.format("%.1f", average);
        //double toPrint = average;
        String output = "The Average Number of Tweets is " + toPrint + " per Day!";
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tweets = in.nextInt();
        int days = in.nextInt();

            String output = outputGenerator(calculateAverage(tweets, days));
            System.out.println(output);
    }
}
