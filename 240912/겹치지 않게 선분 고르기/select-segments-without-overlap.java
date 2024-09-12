import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int n;
    public static ArrayList<Pair> segment = new ArrayList<>();
    public static ArrayList<Pair> selectedSeg = new ArrayList<>();
    public static int ans;

    public static boolean inRange(Pair seg1, Pair seg2) {
        int ax1 = seg1.x;
        int ax2 = seg1.y;
        int bx1 = seg2.x;
        int bx2 = seg2.y;
        return (ax1 <= bx1 && bx1 <= ax2) || (ax1 <= bx2 && bx2 <= ax2) ||
        (bx1 <= ax1 && ax1 <= bx2) || (bx1 <= ax2 && ax2 <= bx2);
    }

    public static boolean possible() {
        for(int i = 0; i < selectedSeg.size(); i++) {
            for(int j = i+1; j < selectedSeg.size(); j++) {
                if(inRange(selectedSeg.get(i), selectedSeg.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void findMaxSegment(int cnt) {
        if(cnt == n) {
            if(possible()) {
                ans = Math.max(ans, selectedSeg.size());
            }
            return;
        }

        selectedSeg.add(segment.get(cnt));
        findMaxSegment(cnt + 1);
        selectedSeg.remove(selectedSeg.size() -1);

        findMaxSegment(cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            segment.add(new Pair(x, y));
        }

        findMaxSegment(0);

        System.out.print(ans);
    }
}