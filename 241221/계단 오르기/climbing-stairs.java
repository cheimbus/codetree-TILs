import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[]{2, 3};
        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;

        for(int i = 5; i <= n; i ++) {
            for(int j = 0; j < 2; j ++) {
                if(i >= arr[j]) {
                    dp[i] = (dp[i] + dp[i - arr[j]]) % 10007;
                }
            }
        }

        int ans = dp[n];
        if(ans == 0) ans = -1;
        bw.write(ans + "");
        bw.flush();
    }
}