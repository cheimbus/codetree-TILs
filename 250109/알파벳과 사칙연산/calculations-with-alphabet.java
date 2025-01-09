import java.io.*;
import java.util.*;

public class Main {
    public static String s;
    public static int n, ans;
    public static int[] arr = new int[6];

    public static int find(int val) {
        return arr[s.charAt(val) - 'a'];
    }

    public static int calc() {
        int val = find(0);

        for(int i = 2; i < n; i += 2) {
            if(s.charAt(i - 1) == '+') val += find(i);
            else if(s.charAt(i - 1) == '-') val -= find(i);
            else val *= find(i);
        }
        return val;
    }

    public static void dfs(int val) {
        if(val == 6) {
            ans = Math.max(ans, calc());
            return;
        }

        for(int i = 1; i <= 4; i ++) {
            arr[val] = i;
            dfs(val + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();
        n = s.length();

        dfs(0);

        bw.write(ans + "");
        bw.flush();
    }
}