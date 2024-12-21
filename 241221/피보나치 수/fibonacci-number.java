import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] dp;
    public static int find(int val) {
        if(dp[val] != 0) return dp[val];

        if(val == 1 || val == 2) return dp[val] = 1;

        return dp[val] = find(val - 1) + find(val - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        int ans = find(n);

        bw.write(ans + "");
        bw.flush();
    }
}