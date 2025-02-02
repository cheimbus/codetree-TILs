import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        TreeSet<Integer> ts = new TreeSet<>();

        stk = new StringTokenizer(br.readLine());
        while(n -- > 0) {
            int a = Integer.parseInt(stk.nextToken());
            ts.add(a);
        }

        StringBuilder sb = new StringBuilder();
        while(m -- > 0) {
            int val = ts.pollLast();
            sb.append(val + " ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}