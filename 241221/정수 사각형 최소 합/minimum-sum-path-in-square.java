import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dp[0][n - 1] = arr[0][n -1];

        for(int i = n - 2; i >= 0; i --) {
            dp[0][i] = dp[0][i + 1] + arr[0][i];
        }
        for(int i = 1; i < n; i ++) {
            dp[i][n - 1] = dp[i - 1][n - 1] + arr[i][n - 1];
        }

        for(int i = 1; i < n; i ++) {
            for(int j = n - 2; j >= 0; j --) {
                dp[i][j] = Math.min(dp[i - 1][j] + arr[i][j], dp[i][j + 1] + arr[i][j]);
            }
        }

        int ans = dp[n - 1][0];
        bw.write(ans + "");
        bw.flush();
    }
}