import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][] dp;

    public static void find() {
        dp[0][0] = grid[0][0];

        for(int i = 1; i < n; i ++) {
            dp[0][i] = Math.min(dp[0][i - 1], grid[0][i]);
            dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
        }

        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < n; j ++) {
                dp[i][j] = Math.min(Math.max(dp[i - 1][j], dp[i][j - 1]), grid[i][j]);
            }
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

        bw.write(dp[n - 1][n - 1] + "");
        bw.flush();
    }
}