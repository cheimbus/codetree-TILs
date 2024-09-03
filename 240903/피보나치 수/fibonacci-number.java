import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static int[] dp;

    public static int fibo(int num) {
        if(dp[num] != -1) {
            return dp[num];
        }
        if(num <= 1) {
            return dp[num];
        }
        else {
            dp[num] = fibo(num - 2) + fibo(num - 1);
            return dp[num];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n];

        for(int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        int answer = fibo(n - 1);

        System.out.print(answer);
    }
}