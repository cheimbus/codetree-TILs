import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1][4];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp[1][1] = arr[1];
        dp[2][0] = arr[2];
        dp[2][2] = arr[1] + arr[2];

        for(int i = 3; i <= n; i ++) {
            for(int j = 0; j < 4; j ++) {
                if(dp[i - 2][j] != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + arr[i]);
                if(j > 0 && dp[i - 1][j - 1] != 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + arr[i]);
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i ++) {
            ans = Math.max(ans, dp[n][i]);
        }

        bw.write(ans + "");
        bw.flush();
    }
}