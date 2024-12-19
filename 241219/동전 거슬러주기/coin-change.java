import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int MAX_VAL = Integer.MAX_VALUE;
    public static int[] arr;
    public static int[] dp;
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

        for(int i = 0; i <= m; i ++) {
            dp[i] = MAX_VAL;
        }

        dp[0] = 0;

        for(int i = 1; i <= m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(i >= arr[j]) {
                    if(dp[i - arr[j]] == -1) continue;
                    else {
                        dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                    }
                }
            }
        }

        int ans = dp[m];
        bw.write(ans + "");
        bw.flush();
    }
}