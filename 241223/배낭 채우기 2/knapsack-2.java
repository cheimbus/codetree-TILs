import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] w;
    public static int[] v;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        w = new int[n + 1];
        v = new int[n + 1];
        dp = new int[m + 1];

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(stk.nextToken());
            v[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(i >= w[j]) {
                    dp[i] = Math.max(dp[i], dp[i - w[j]] + v[j]);
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= m; i ++) {
            ans = Math.max(ans, dp[i]);
        }

        bw.write(ans + "");
        bw.flush();
    }
}