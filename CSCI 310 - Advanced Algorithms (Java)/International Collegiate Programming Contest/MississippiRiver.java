import java.util.Scanner;

public class MississippiRiver {

        public static int findCoast (String state){
            if (state.equals("MN")||state.equals("IA")||state.equals("MO")||state.equals("AR")||state.equals("LA")){
                return 0;
            }
            else {
                return 1;
            }
        }

        public static int countTrips (String line){
            String[] lineSp = line.split(" ");
            return Integer.parseInt(lineSp[0]);
        }

        public static int countCities (String line){
            String[] lineSp = line.split(" ");
            return Integer.parseInt(lineSp[3]);
        }

        public static String stateName (String line){
            String[] lineSp = line.split(", ");
            return lineSp[1];
        }

        public static int countCrossings (int[] places){
            int result = 0;
            for (int i=0; i<places.length-1; i++){
                if(places[i]==places[i+1]){
                    continue;
                }
                else {
                    result++;
                }
            }
            return result;
        }

        public static String outputGenerator (int trip, int times){
            String answer = "";
            if (times==1){
                answer = "Trip "+trip+" crosses the Mississippi "+times+" time";
            }
            else {
                answer = "Trip "+trip+" crosses the Mississippi "+times+" times";
            }
            return answer;
        }


        public static void main(String[] args) {
            Scanner in = new Scanner (System.in);
            String line = in.nextLine();
            int number = countTrips(line);
            for (int i=0; i<number; i++){
                String city = in.nextLine();
                int numberOfCities = countCities(city);
                int[] cities = new int[numberOfCities];
                for (int j=0; j<numberOfCities; j++){
                    cities[j]=findCoast(stateName(in.nextLine()));
                }
                System.out.println(outputGenerator(i+1, countCrossings(cities)));
            }

        }

    }

