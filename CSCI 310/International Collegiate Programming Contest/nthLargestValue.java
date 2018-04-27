import java.util.*;
public class nthLargestValue {

        public static int findit(String s){
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            int inputLine = Integer.parseInt(s.split(" ")[0]);


            for(int i=0;i<10;i++){
                numbers.add(Integer.parseInt(s.split(" ")[i+1]));
            }

            Collections.sort(numbers,Collections.<Integer>reverseOrder());
            return numbers.get(2);

        }


        public static void main(String[] args) {

            Scanner myScan = new Scanner(System.in);
            int numCases = Integer.parseInt(myScan.nextLine());

            for(int i=0;i<numCases;i++){
                String string = myScan.nextLine();

                int nthLargest = findit(string);
                int line = i+1;
                System.out.println(line + " "+ nthLargest);
            }


        }

}
