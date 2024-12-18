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
        arr = new int[n];
        dp = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            dp[i] = -1;
        }

        dp[0] = 0;
        for(int i = 1; i < n; i ++) {
            for(int j = i - 1; j >= 0; j --) {
                if(dp[j] == -1) continue;
                if(j + arr[j] >= i) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++) {
            ans = Math.max(dp[i], ans);
        }

        bw.write(ans + "");
        bw.flush();
    }
}