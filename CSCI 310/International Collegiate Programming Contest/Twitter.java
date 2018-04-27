import java.util.ArrayList;
import java.util.Scanner;

public class Twitter {

//    public static ArrayList parseTweet(String tweet){
//        ArrayList result = new ArrayList();
//        //String[] result = new String[tweet.length()];
//        String[] lineSp = tweet.split(" ");
//        for (int i=0; i<lineSp.length; i++) {
//            //result[i]=(lineSp[i]);
//            result.add(lineSp[i]);
//        }
//
//        return result;
//    }
    public static String[] parseTweet(String tweet){
        //ArrayList result = new ArrayList();
        String[] result = new String[tweet.length()];
        String[] lineSp = tweet.split(" ");
        for (int i=0; i<lineSp.length; i++) {
            result[i]=(lineSp[i]);
            //result.add(lineSp[i]);
        }

        return result;
    }

    public static boolean containsVan(String tweet){
        String[] tweetList = parseTweet(tweet);
        for(int i=0; i<tweetList.length; i++){
            if (tweetList[i].equals("@vandeldensa"))
                return true;
        }
        return false;
    }

    public static String processTweet(String tweet){
        String[] tweetList = parseTweet(tweet);
        String inNetwork = "";

        if(containsVan(tweet)){
            String handle = (String) tweetList[0];
            //inNetwork.add(handle);
            for(int i=1; i<tweetList.length; i++){
                if (tweetList[i].startsWith("@")){
                    inNetwork = tweetList[i];
                }
            }
      }
        return inNetwork;
    }

    public static void toPrint(ArrayList network){

        for(int i=0; i<network.size(); i++){
            System.out.println(network.get(i));
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of tweets: ");
        int number = in.nextInt();
        ArrayList extendednetwork = new ArrayList();
        for (int i = 0; i <= number; i++) {
                System.out.println("Enter tweet: "+ i);
                String tweet = in.next();
                extendednetwork.add(processTweet(tweet));
            }
            toPrint(extendednetwork);


    }
}
