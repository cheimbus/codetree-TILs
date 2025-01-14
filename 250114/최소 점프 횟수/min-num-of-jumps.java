import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 2; i <= n; i ++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 2; i <= n; i ++) {
            for(int j = i - 1; j >= 1; j --) {
                if(i <= j + arr[j]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = dp[n];
        if(ans == Integer.MAX_VALUE) ans = -1;

        bw.write(ans + "");
        bw.flush();
    }
}