import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k, cnt;
    public static int[] tmp;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static int calc() {
        int val = 0;
        for(int i = 0; i < k; i ++) {
            if(arr[i] >= m) val ++;
        }
        return val;
    }

    public static void dfs(int depth) {
        cnt = Math.max(cnt, calc());

        if(depth == n) return;

        for(int i = 0; i < k; i ++) {
            if(arr[i] >= m) continue;

            arr[i] += tmp[depth];
            dfs(depth + 1);
            arr[i] -= tmp[depth];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        tmp = new int[n];
        arr = new int[k];

        for(int i = 0; i < k; i ++) {
            arr[i] = 1;
        }
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            tmp[i] = Integer.parseInt(stk.nextToken());
        }


        dfs(0);

        bw.write(cnt + "");
        bw.flush();
    }
}