import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] dp;
    public static int MIN_VAL = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            dp[i] = MIN_VAL;
        }

        dp[1] = arr[1];

        for(int i = 2; i <= n; i ++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int ans = MIN_VAL;
        for(int i = 1; i <= n; i ++) {
            ans = Math.max(ans, dp[i]);
        }

        bw.write(ans + "");
        bw.flush();
    }
}