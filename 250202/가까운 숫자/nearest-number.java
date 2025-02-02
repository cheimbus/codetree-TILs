import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);

        int val = Integer.MAX_VALUE;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(n -- > 0) {
            int a = Integer.parseInt(stk.nextToken());
            ts.add(a);
            val = Math.min(val, a - ts.lower(a));
            if(ts.higher(a) != null) {
                val = Math.min(val, ts.higher(a) - a);
            }
            sb.append(val + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}