import java.util.*;
import java.io.*;

class Tuple implements Comparable<Tuple> {
    int x;
    int y;
    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Tuple t) {
        if(x != t.x) return x - t.x;
        return y - t.y;
    }
}

public class Main {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        TreeSet<Tuple> ts = new TreeSet<>();

        while(n -- > 0) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            ts.add(new Tuple(a, b));
        }

        StringBuilder sb = new StringBuilder();
        while(m -- > 0) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if(ts.higher(new Tuple(a, b)) != null) {
                Tuple t = ts.higher(new Tuple(a, b));
                sb.append(t.x + " ").append(t.y).append("\n");
            }
            else {
                if(ts.ceiling(new Tuple(a, b)) != null) {
                    Tuple t = ts.ceiling(new Tuple(a, b));
                    sb.append(t.x + " ").append(t.y).append("\n");
                }
                else {
                    sb.append(-1 + " ").append(-1).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}