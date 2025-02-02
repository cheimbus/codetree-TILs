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

        for(int i = 1; i <= m; i ++) {
            ts.add(i);
        }

        StringBuilder sb = new StringBuilder();
        stk = new StringTokenizer(br.readLine());
        while(n -- > 0) {
            int a = Integer.parseInt(stk.nextToken());
            ts.remove(a);
            int b = ts.last();
            sb.append(b + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}