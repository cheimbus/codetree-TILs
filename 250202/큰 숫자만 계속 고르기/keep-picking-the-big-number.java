import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        stk = new StringTokenizer(br.readLine());
        while(n -- > 0) {
            int a = Integer.parseInt(stk.nextToken());
            pq.add(-a);
        }

        while(m -- > 0) {
            int val = -pq.poll();
            val --;
            pq.add(-val);
        }

        int ans = -pq.peek();

        bw.write(ans + "");
        bw.flush();
    }
}