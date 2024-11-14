import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int MAX_N = 15;
    public static int n, cnt;
    public static Pair[] segments = new Pair[MAX_N];
    public static ArrayList<Pair> addSegment = new ArrayList<>();

    public static boolean overlapped(Pair x, Pair y) {
        int x1 = x.x;
        int x2 = x.y;
        int y1 = y.x;
        int y2 = y.y;

        return (x1 <= y1 && y1 <= x2) || (x1 <= y2 && y2 <= x2) ||
                (y1 <= x1 && x1 <= y1) || (y1 <= x2 && x2 <= y2);
    }

    public static boolean possible() {
        for(int i = 0; i < addSegment.size(); i ++) {
            for(int j = i + 1; j < addSegment.size(); j ++) {
                if(overlapped(addSegment.get(i), addSegment.get(j))) return false;
            }
        }
        return true;
    }

    public static void recursion(int currNum) {
        if(currNum == n) {
            if(possible()) {
                cnt = Math.max(cnt, addSegment.size());
            }
            return;
        }

        addSegment.add(segments[currNum]);
        recursion(currNum + 1);
        addSegment.remove(addSegment.size() - 1);
        recursion(currNum + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            segments[i] = new Pair(x, y);
        }

        recursion(0);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}