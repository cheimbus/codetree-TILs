import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int ans = Integer.MAX_VALUE;
    public static int[] arr;
    public static boolean[] visited;

    public static int calc() {
        int diff = 0;
        for(int i = 0; i < 2 * n; i ++) {
            diff = (visited[i] ? (diff + arr[i]) : (diff - arr[i]));
        }
        return Math.abs(diff);
    }

    public static void dfs(int depth, int at) {
        if(at == n) {
            ans = Math.min(ans, calc());
            return;
        }

        if(depth == 2 * n) {
            return;
        }

        visited[depth] = true;
        dfs(depth + 1, at + 1);
        visited[depth] = false;
        dfs(depth + 1, at);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[2 * n];
        visited = new boolean[2 * n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dfs(0, 0);

        bw.write(ans + "");
        bw.flush();
    }
}