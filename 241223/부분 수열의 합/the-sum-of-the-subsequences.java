import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arr;
    public static int[] dp;
    public static int MAX_VAL = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        arr = new int[n];
        dp = new int[m + 1];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 1; i <= m; i ++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for(int i = 0; i < n; i ++) {
            for(int j = m; j >= 0; j --) {
                if(j >= arr[i]) {
                    if(dp[j - arr[i]] == Integer.MIN_VALUE) continue;
                    else {
                        dp[j] += dp[j - arr[i]] + 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int ans = dp[m];
        if(ans == Integer.MIN_VALUE) sb.append("No");
        else sb.append("Yes");

        bw.write(sb.toString() + "");
        bw.flush();
    }
}