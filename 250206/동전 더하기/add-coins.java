import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] dp = new int[m + 1];
        int[] arr = new int[n];

        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= m; i ++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(i - arr[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        int val = dp[m];

        bw.write(val + "");
        bw.flush();
        br.close();
    }
}
