import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 10;
    public static int n, cnt = Integer.MAX_VALUE;
    public static int[] arr = new int[MAX_N];

    public static void recursion(int currNum, int pos) {
        if(pos >= n) return;
        if(pos == n - 1) {
            cnt = Math.min(cnt, currNum);
            return;
        }

        for(int i = 1; i <= arr[pos]; i ++) {
            recursion(currNum + 1, pos + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        recursion(0, 0);

        if(cnt == Integer.MAX_VALUE) cnt = -1;

        bw.write(cnt + "");
        bw.flush();
    }
}