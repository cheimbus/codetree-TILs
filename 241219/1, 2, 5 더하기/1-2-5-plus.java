import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr = new int[]{1, 2, 5};
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 6];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 9;

        for(int i = 6; i <= n; i ++) {
            for(int j = 0; j < 3; j ++) {
                if(i >= arr[j]) {
                    dp[i] += dp[i - arr[j]];
                }
            }
        }

        int ans = dp[n];
        if(ans == 0) ans = -1;
        bw.write(ans + "");
        bw.flush();
    }
}