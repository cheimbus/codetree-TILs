import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Pos {
    int x, y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int MAX_N = 20;
    public static Pos OUT_OF_RANGE = new Pos(-1, -1);
    public static int n, m;
    public static ArrayList<Integer>[][] grid = new ArrayList[MAX_N][MAX_N];
    public static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static Pos findCurrPos(int currVal) {
        Pos currPos = new Pos(0, 0);
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++) {
                for(int k = 0; k < grid[i][j].size(); k ++) {
                    if(grid[i][j].get(k) == currVal) currPos = new Pos(i, j);
                }
            }
        return currPos;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static Pos findNextPos(Pos currPos) {
        int x = currPos.x;
        int y = currPos.y;
        Pos nextPos = OUT_OF_RANGE;
        int maxVal = -1;
        for(int i = 0; i < 8; i ++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(inRange(nx, ny)) {
                for(int j = 0; j < grid[nx][ny].size(); j ++) {
                    if(maxVal < grid[nx][ny].get(j)) {
                        maxVal = grid[nx][ny].get(j);
                        nextPos = new Pos(nx, ny);
                    }
                }
            }
        }
        return nextPos;
    }

    public static void move(Pos currPos, Pos nextPos, int currVal) {
        int cx = currPos.x, cy = currPos.y;
        int nx = nextPos.x, ny = nextPos.y;

        boolean isCurrVal = false;
        for(int i = 0; i < grid[cx][cy].size(); i ++) {
            if(grid[cx][cy].get(i) == currVal) isCurrVal = true;
            if(isCurrVal) grid[nx][ny].add(grid[cx][cy].get(i));
        }

        while(grid[cx][cy].get(grid[cx][cy].size() - 1) != currVal) {
            grid[cx][cy].remove(grid[cx][cy].size() - 1);
        }
        grid[cx][cy].remove(grid[cx][cy].size() - 1);
    }

    public static void simulate(int currVal) {
        Pos currPos = findCurrPos(currVal);
        Pos nextPos = findNextPos(currPos);
        if(nextPos != OUT_OF_RANGE) {
            move(currPos, nextPos, currVal);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        for(int i = 0 ; i < n; i ++)
            for(int j = 0; j < n; j ++) {
                grid[i][j] = new ArrayList<>();
            }

        for(int i = 0 ; i < n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j].add(num);
            }
        }

        stk = new StringTokenizer(br.readLine());
        while(m -- > 0) {
            int n = Integer.parseInt(stk.nextToken());
            simulate(n);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++) {
                if(grid[i][j].isEmpty()) sb.append("None");
                for(int k = grid[i][j].size() - 1; k >= 0 ; k --) {
                    sb.append(grid[i][j].get(k)).append(" ");
                }
                sb.append("\n");
            }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}