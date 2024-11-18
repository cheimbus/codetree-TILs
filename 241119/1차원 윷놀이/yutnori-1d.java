import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 12;
    public static final int MAX_K = 4;
    public static int n, m, k, cnt;
    public static int[] turns = new int[MAX_N];
    public static int[] arr = new int[MAX_K];

    public static int calc() {
        int c = 0;
        for(int i = 0; i < k; i ++) {
            if(arr[i] >= m) c ++;
        }

        return c;
    }

    public static void recursion(int currNum) {

        cnt = Math.max(cnt, calc());

        if(currNum == n) {
            return;
        }

        for(int i = 0; i < k; i ++) {
            if(arr[i] >= m) {
                continue;
            }

            arr[i] += turns[currNum];
            recursion(currNum + 1);
            arr[i] -= turns[currNum];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            turns[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 0; i < k; i ++) {
            arr[i] = 1;
        }

        recursion(0);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}