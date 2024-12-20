import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] w;
    public static int[] v;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        w = new int[n + 1];
        v = new int[n + 1];
        dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(stk.nextToken());
            v[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = m; j >= 0; j --) {
                if(j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int ans = 0;
        for(int i = 0; i <= m; i ++) {
            ans = Math.max(ans, dp[n][i]);
        }
        bw.write(ans + "");
        bw.flush();
    }
}