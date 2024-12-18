import java.io.*;
import java.util.*;

public class Main {
    public static int n, cnt;
    public static int[][] grid;
    public static int[][] dp;

    public static void find() {
        dp[0][n - 1] = grid[0][n - 1];

        for(int i = n - 2; i >= 0; i --) {
            dp[0][i] = dp[0][i + 1] + grid[0][i];
        }
        for(int i = 1; i < n; i ++) {
            dp[i][n - 1] = dp[i - 1][n - 1] + grid[i][n - 1];
        }
        for(int i = 1; i < n; i ++) {
            for(int j = n - 2; j >= 0; j --) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j + 1] + grid[i][j]);
            }
        }

        cnt = dp[n - 1][0];
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