import java.util.Scanner;

public class Ping {
    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        String in = myScan.nextLine();

        int[][] dp = new int[in.length()][in.length()];


        for(int i = 1;i<in.length();++i){
            for(int j = i;j < in.length();++j){
                dp[i][j] = dp[i-1][j];
                if(dp[i-1][i] % 2 != val(in.charAt(i))){
                    if(j%i == 0){
                        ++dp[i][j];
                    }
                }
            }
        }
        for(int i = 1;i<in.length();++i){
            if(dp[i][i] > dp[i-1][i]){
                System.out.print(i + " ");
            }
        }

    }

    public static int val(char ch){
        if(ch == '1')
            return 1;
        else
            return 0;
    }

}
