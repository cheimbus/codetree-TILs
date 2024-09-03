import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp = new int[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        
        System.out.print(dp[n]);
    }
}