import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] dp;

    public static int find(int val) {
        if(dp[val] != 0) return dp[val];

        if(val == 2) return dp[val] = 1;
        if(val == 3) return dp[val] = 1;
        if(val == 4) return dp[val] = 2;

        return dp[val] = (find(val - 2) + find(val - 3)) % 10007;
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