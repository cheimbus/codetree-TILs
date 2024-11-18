import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, k, cnt;
    public static int[] target;
    public static int[] turn;

    public static int calc() {
        int val = 0;
        for(int i = 0; i < k; i ++) {
            if(target[i] >= m) val ++;
        }
        return val;
    }

    public static void recursion(int currNum) {

        cnt = Math.max(cnt, calc());

        if(currNum == n) return;

        for(int i = 0; i < k; i ++) {
            if(target[i] >= m) continue;

            target[i] += turn[currNum];
            recursion(currNum + 1);
            target[i] -= turn[currNum];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        target = new int[k];
        turn = new int[n];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            turn[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 0; i < k; i ++) {
            target[i] = 1;
        }

        recursion(0);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}