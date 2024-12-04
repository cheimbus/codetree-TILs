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
    public static int[] tmp;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static int calc() {
        return tmp[0] - tmp[1];
    }

    public static void dfs(int depth, int at) {
        if(depth == 2) {
            ans = Math.min(ans, calc());
            return;
        }

        for(int i = at; i < arr.length; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[2 * n];
        tmp = new int[2];
        visited = new boolean[2 * n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length / 2; i ++) {
            int val = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = val;
        }

        dfs(0, 0);

        bw.write(ans + "");
        bw.flush();
    }
}