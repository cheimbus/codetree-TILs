import java.util.*;
import java.io.*;

class Tuple implements Comparable<Tuple> {
    int x, y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Tuple t) {
        if (x + y != t.x + t.y) return (x + y) - (t.x + t.y);
        if (x != t.x) return x - t.x;
        return y - t.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        while (n-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            pq.add(new Tuple(a, b));
        }

        while (m-- > 0 && !pq.isEmpty()) {
            Tuple t = pq.poll();
            pq.add(new Tuple(t.x + 2, t.y + 2));
        }

        if (pq.isEmpty()) {
            bw.write("0 0\n");
        } else {
            Tuple at = pq.peek();
            bw.write(at.x + " " + at.y + "\n");
        }

        bw.flush();
    }
}
