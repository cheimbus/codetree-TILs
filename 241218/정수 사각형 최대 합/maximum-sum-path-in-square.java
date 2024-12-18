import java.io.*;
import java.util.*;

public class Main {
    public static int n, cnt;
    public static int[][] grid;
    public static int[][] dp;
    public static void find() {
        dp[0][0] = grid[0][0];

        for(int i = 1; i < n; i ++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < n; j ++) {
                dp[i][j] = Math.max(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
            }
        }

        for(int i = 0; i < n; i ++) {
            cnt = Math.max(dp[n - 1][i], cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        find();

        bw.write(cnt + "");
        bw.flush();
    }
}