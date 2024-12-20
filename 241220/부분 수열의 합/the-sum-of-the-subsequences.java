import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
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

        dp[0] = 1;
        for(int i = 0; i < n; i ++) {
            for(int j = m; j >= 0; j --) {
                if(j >= arr[i]) {
                    if(dp[j - arr[i]] == 0) continue;
                    else {
                        dp[j] += dp[j - arr[i]];
                    }
                }
            }
        }

        boolean ez = false;
        if(dp[m] > 0) ez = true;

        StringBuilder sb = new StringBuilder();
        if(ez) sb.append("Yes");
        else sb.append("No");
        bw.write(sb.toString());
        bw.flush();
    }
}