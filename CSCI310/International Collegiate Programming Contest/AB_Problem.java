import java.util.Scanner;

public class AB_Problem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (!line.equals("0 0")) {
            String[] lineSp = line.split(" ");
            int change = Integer.parseInt(lineSp[1]) - Integer.parseInt(lineSp[0]);
            char[] changeSt = Integer.toString(change).toCharArray();
            char[] newSt = new char[changeSt.length];
            int i = 0;
            boolean changed = false;
            for(char ch : changeSt) {
                if(changed == false) {
                    if(ch != '9') {
                        newSt[i] = '9';
                        changed = true;
                    } else {
                        newSt[i] = ch;
                    }
                } else {
                    newSt[i] = ch;
                }

                ++i;
            }
            int wrongChange = Integer.parseInt(new String(newSt));
            int difference = wrongChange - change;
            System.out.println(difference);


            line =in.nextLine();
        }
    }
}

