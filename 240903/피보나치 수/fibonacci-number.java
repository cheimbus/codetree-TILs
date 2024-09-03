import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp = new int[45];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.print(dp[n - 1]);
    }
}