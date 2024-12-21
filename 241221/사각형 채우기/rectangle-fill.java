import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i ++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        bw.write(dp[n] + "");
        bw.flush();
    }
}