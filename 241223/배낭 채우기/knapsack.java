import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] w;
    public static int[] v;
    public static int[] dp;
    public static int MAX_VAL = Integer.MAX_VALUE;
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
            dp[i] = Integer.MIN_VALUE;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = m; j >= 0; j --) {
                if(j - w[i] >= 0) {
                    if(dp[j - w[i]] == Integer.MIN_VALUE) continue;
                    else {
                        dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                    }
                }
            }
        }

        int ans = dp[m];

        bw.write(ans + "");
        bw.flush();
    }
}