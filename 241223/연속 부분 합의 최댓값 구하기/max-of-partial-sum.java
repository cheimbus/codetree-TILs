import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        int ans = arr[0];

        dp[0] = arr[0];

        for(int i = 1;i<n;i++){
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            ans = Math.max(ans, dp[i]); // 답은 dp중 가장 큰 값
        }

        System.out.println(ans);

    }
}