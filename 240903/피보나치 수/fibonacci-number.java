import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static int[] dp = new int[45];

    public static int fibo(int num) {
        if(dp[num] != -1) {
            return dp[num];
        }
        if(num >= 2) {
            return dp[num];
        }
        else {
            dp[num] = fibo(num - 2) + fibo(num = 1);
            return dp[num];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < 45; i++) {
            dp[i] = -1;
        }
        dp[1] = 1;
        dp[2] = 1;
        int answer = fibo(n);

        System.out.print(answer);
    }
}