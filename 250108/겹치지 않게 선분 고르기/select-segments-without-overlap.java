import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, cnt;
    public static ArrayList<Pair> arr = new ArrayList<>();
    public static Pair[] tmp;

    public static boolean overlap(Pair a, Pair b) {
        int ax = a.x;
        int ay = a.y;
        int bx = b.x;
        int by = b.y;

        return (ax <= bx && bx <= ay) || (ax <= by && by <= ay) ||
                (bx <= ax && ax <= by) || (bx <= ay && ay <= by);
    }

    public static boolean possible() {
        for(int i = 0; i < arr.size() - 1; i ++) {
            for(int j = i + 1; j < arr.size(); j ++) {
                if(overlap(arr.get(i), arr.get(j))) return false;
            }
        }
        return true;
    }

    public static void dfs(int val) {
        if(val == n) {
            if(possible()) {
                cnt = Math.max(cnt, arr.size());
            }
            return;
        }

        arr.add(tmp[val]);
        dfs(val + 1);
        arr.remove(arr.size() - 1);
        dfs(val + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        tmp = new Pair[n];

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            tmp[i] = new Pair(x, y);
        }

        dfs(0);

        bw.write(cnt + "");
        bw.flush();
    }
}