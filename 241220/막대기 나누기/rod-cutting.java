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
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j <= n; j ++) {
                if(j >= i) {
                    dp[i][j] = Math.max(dp[i][j - i] + arr[i], dp[i - 1][j]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i ++) {
            ans = Math.max(dp[n][i], ans);
        }

        bw.write(ans + "");
        bw.flush();
    }
}