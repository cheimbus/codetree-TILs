import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        dp = new int[2][m + 1];

        dp[0][0] = 1;

        for(int i = 0; i < n; i ++) {
            stk = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            for(int j = m; j >= 0; j --) {
                if(j >= w) {
                    if(dp[0][j - w] == 0) continue;
                    else {
                        dp[0][j] += dp[0][j - w];
                        dp[1][j] = Math.max(dp[1][j], dp[1][j - w] + v);
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i <= m; i ++) {
            ans = Math.max(ans, dp[1][i]);
        }
        bw.write(ans + "");
        bw.flush();
    }
}